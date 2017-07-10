/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerView;

import DAO.AreaCorpoDAO;
import DAO.CaracteristicaItemCombateDAO;
import DAO.ItemDAO;
import DAO.ItemPersonagemDAO;
import DAO.PersonagemDAO;
import Model.AreaCorpo;
import Model.CaracteristicaItemCombate;
import Model.Item;
import Model.ItemPersonagem;
import Model.Personagem;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author vitorlofonseca
 */
public class Taverna extends javax.swing.JFrame {
    
    private String caller;
    private static ArrayList<String> carrinho;
    private static float dinheiroDisponivel;
    private static float danoTotalItens;
    private static float fugaTotalItens;
    private static float defesaTotalItens;
    private static float negociacaoTotalItens;

    /**
     * Creates new form Taverna
     */
    public Taverna() throws SQLException, ClassNotFoundException {
        initComponents();
        
        this.carregarSelect();
        
        this.inicializarListeners();
        
        this.carregarItens(null);
        
        Personagem personagem = PersonagemDAO.getPersonagemPorID(MenuIntermediario.idPersonagem);
        
        Taverna.dinheiroDisponivel = personagem.getDinheiro();
        
        atualizarLblDinheiroDisponivel();
        
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;    
        setLocation(dx, dy);
    }
    
    private void inicializarListeners(){
        
        listaItens.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                
                if (evt.getClickCount() == 1) {
                    
                    Item item = null;
                    try {
                        item = ItemDAO.getItemPorNome(listaItens.getSelectedValue());
                        
                        HashMap caracteristicasItemCombate = CaracteristicaItemCombateDAO.getCaracteristicasItemCombatePorItem(item);
                        
                        CaracteristicaItemCombate caracteristicaDano = (CaracteristicaItemCombate)caracteristicasItemCombate.get(3);
                        CaracteristicaItemCombate caracteristicaDefesa = (CaracteristicaItemCombate)caracteristicasItemCombate.get(2);
                        CaracteristicaItemCombate caracteristicaFuga = (CaracteristicaItemCombate)caracteristicasItemCombate.get(4);
                        CaracteristicaItemCombate caracteristicaNegociacao = (CaracteristicaItemCombate)caracteristicasItemCombate.get(1);
                        
                        String html = "<html>"
                                + "         <body>"
                                + "             <table>"
                                + "                 <tr>"
                                + "                     <td>"
                                + "                         Dano +" + caracteristicaDano.getValor()
                                + "                     </td>"
                                + "                 </tr>"
                                + "                 <tr>"
                                + "                     <td>"
                                + "                         Defesa +" + caracteristicaDefesa.getValor()
                                + "                     </td>"
                                + "                 </tr>"
                                + "                 <tr>"
                                + "                     <td>"
                                + "                         Fuga +" + caracteristicaFuga.getValor()
                                + "                     </td>"
                                + "                 </tr>"
                                + "                 <tr>"
                                + "                     <td>"
                                + "                         Negociação +" + caracteristicaNegociacao.getValor()
                                + "                     </td>"
                                + "                 </tr>"
                                + "             </table>"
                                + "         </body>"
                                + "     </html>";
                    
                        lblInfoItem.setText(item.getNome());
                        lblCaracteristicasItem1.setText(html);
                        lblPrecoItem.setText("Preço: ¨"+item.getValor());
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(AdmGerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AdmGerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
                    }                   
                    
                    
                }
                
                
                if (evt.getClickCount() == 2) {    
                    
                    try {
                        
                        Item item = ItemDAO.getItemPorNome(listaItens.getSelectedValue());
                        
                        //se tiver dinheiro pra adicionar, adiciona
                        if(Taverna.dinheiroDisponivel - item.getValor() > 0){
                            
                            HashMap caracteristicasItemCombate = CaracteristicaItemCombateDAO.getCaracteristicasItemCombatePorItem(item);
                            
                            CaracteristicaItemCombate caracteristicaDano = (CaracteristicaItemCombate)caracteristicasItemCombate.get(3);
                            CaracteristicaItemCombate caracteristicaDefesa = (CaracteristicaItemCombate)caracteristicasItemCombate.get(2);
                            CaracteristicaItemCombate caracteristicaFuga = (CaracteristicaItemCombate)caracteristicasItemCombate.get(4);
                            CaracteristicaItemCombate caracteristicaNegociacao = (CaracteristicaItemCombate)caracteristicasItemCombate.get(1);
                            
                            Taverna.danoTotalItens += caracteristicaDano.getValor();
                            Taverna.defesaTotalItens += caracteristicaDefesa.getValor();
                            Taverna.fugaTotalItens += caracteristicaFuga.getValor();
                            Taverna.negociacaoTotalItens += caracteristicaNegociacao.getValor();
                            
                            Taverna.dinheiroDisponivel -= item.getValor();
                            addCarrinho(listaItens.getSelectedValue());
                            
                            atualizarLblDinheiroDisponivel();
                            atualizarLblSomaAtributosItens();
                            
                        } 
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(Taverna.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Taverna.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        
        listaCarrinho.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();               
                
                if (evt.getClickCount() == 2) {    
                    
                    try {
                        
                        Item item;
                        item = ItemDAO.getItemPorNome(listaCarrinho.getSelectedValue());
                        
                        HashMap caracteristicasItemCombate = CaracteristicaItemCombateDAO.getCaracteristicasItemCombatePorItem(item);
                        
                        CaracteristicaItemCombate caracteristicaDano = (CaracteristicaItemCombate)caracteristicasItemCombate.get(3);
                        CaracteristicaItemCombate caracteristicaDefesa = (CaracteristicaItemCombate)caracteristicasItemCombate.get(2);
                        CaracteristicaItemCombate caracteristicaFuga = (CaracteristicaItemCombate)caracteristicasItemCombate.get(4);
                        CaracteristicaItemCombate caracteristicaNegociacao = (CaracteristicaItemCombate)caracteristicasItemCombate.get(1);

                        Taverna.danoTotalItens -= caracteristicaDano.getValor();
                        Taverna.defesaTotalItens -= caracteristicaDefesa.getValor();
                        Taverna.fugaTotalItens -= caracteristicaFuga.getValor();
                        Taverna.negociacaoTotalItens -= caracteristicaNegociacao.getValor();
                        
                        
                        Taverna.dinheiroDisponivel += item.getValor();
                        removerCarrinho(listaCarrinho.getSelectedValue());
                        
                        atualizarLblDinheiroDisponivel();
                        atualizarLblSomaAtributosItens();
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(Taverna.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Taverna.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
            }
        });
        
    }
    
    private void atualizarLblDinheiroDisponivel(){
        String dinheiroFormatado = NumberFormat.getCurrencyInstance().format(Taverna.dinheiroDisponivel);
        dinheiroFormatado = dinheiroFormatado.replaceAll("[^0-9.,]", "");
        
        lblDinheiroDisponivel.setText("¨"+dinheiroFormatado);
    }
    
    
    private void atualizarLblSomaAtributosItens(){
        
        String html = "<html>"
                + "         <body>"
                + "             <table>"
                + "                 <tr>"
                + "                     <td>"
                + "                         Dano +" + String.format("%.0f", Taverna.danoTotalItens)
                + "                     </td>"
                + "                 </tr>"
                + "                 <tr>"
                + "                     <td>"
                + "                         Defesa +" + String.format("%.0f", Taverna.defesaTotalItens)
                + "                     </td>"
                + "                 </tr>"
                + "                 <tr>"
                + "                     <td>"
                + "                         Fuga +" + String.format("%.0f", Taverna.fugaTotalItens)
                + "                     </td>"
                + "                 </tr>"
                + "                 <tr>"
                + "                     <td>"
                + "                         Negociação +" + String.format("%.0f", Taverna.negociacaoTotalItens)
                + "                     </td>"
                + "                 </tr>"
                + "             </table>"
                + "         </body>"
                + "     </html>";

        lblSomaAtributosItens.setText(html);
        
    }
    
    
    private void carregarSelect() throws SQLException, ClassNotFoundException{
        
        HashMap areasCorpo = AreaCorpoDAO.getAreasCorpo();
        
        int i=0;
        String[] areasCorpoString = new String[areasCorpo.size()];
        
        //iterando no mapa de itens
        for (Iterator it = areasCorpo.entrySet().iterator(); it.hasNext();) {
            
            Map.Entry<Integer, AreaCorpo> areaCorpo = (Map.Entry<Integer, AreaCorpo>) it.next();
            
            areasCorpoString[i] = areaCorpo.getValue().getAreaCorpo();
            
            i++;
            
        }
        
        selectAreaCorpo.setModel(new javax.swing.DefaultComboBoxModel<>(areasCorpoString));
        
    }
    
    
    private void carregarItens(AreaCorpo areaCorpo) throws SQLException, ClassNotFoundException{
        
        HashMap itens = null;
        
        //se não tiver filtro, consulta sem filtro
        if(areaCorpo == null){
            itens = ItemDAO.getItens();
        Taverna.carrinho = new ArrayList<String>();
        } else {
            itens = ItemDAO.getItensPorArea(areaCorpo);
        }
        
        String[] itensString = new String[itens.size()];
        
        int i=0;
        
        //iterando no mapa de itens
        for (Iterator it = itens.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Integer, Item> item = (Map.Entry<Integer, Item>) it.next();
            itensString[i] = item.getValue().getNome();
            i++;
        }
        
        //lista de itens
        listaItens.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = itensString;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        
        listaCarrinho.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return carrinho.size(); }
            public String getElementAt(int i) { return carrinho.get(i); }
        });
        
        
    }    
    
    public void removerCarrinho(String stringItem){
        
        Taverna.carrinho.remove(stringItem);
        
        listaCarrinho.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return Taverna.carrinho.size(); }
            public String getElementAt(int i) { return Taverna.carrinho.get(i); }
        });
        
    }
    
    
    public void addCarrinho(String stringItem){
        
        Taverna.carrinho.add(stringItem);
        
        listaCarrinho.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return Taverna.carrinho.size(); }
            public String getElementAt(int i) { return Taverna.carrinho.get(i); }
        });
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaItens = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        lblInfoItemTitulo = new javax.swing.JLabel();
        lblSomaAtributosItens = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblPrecoItem = new javax.swing.JLabel();
        lblInfoItem = new javax.swing.JLabel();
        lblCaracteristicasItem1 = new javax.swing.JLabel();
        btnMenuIntermediario = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaCarrinho = new javax.swing.JList<>();
        jPanel6 = new javax.swing.JPanel();
        lblInfoItemTitulo3 = new javax.swing.JLabel();
        selectAreaCorpo = new javax.swing.JComboBox<>();
        btnFiltrar = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblDinheiroDisponivel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblInfoItemTitulo4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 648));
        setResizable(false);
        getContentPane().setLayout(null);

        listaItens.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaItens);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 230, 420, 340);

        jPanel3.setLayout(null);

        lblInfoItemTitulo.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        lblInfoItemTitulo.setText("Soma Atributos Itens");
        jPanel3.add(lblInfoItemTitulo);
        lblInfoItemTitulo.setBounds(20, 20, 200, 18);

        lblSomaAtributosItens.setText("<html> \t<body> \t\t<table> \t\t\t<tr> \t\t\t\t<td> \t\t\t\t\tDano +0 \t\t\t\t</td> \t\t\t</tr> \t\t\t<tr> \t\t\t\t<td> \t\t\t\t\tDefesa +0 \t\t\t\t</td> \t\t\t</tr> \t\t\t<tr> \t\t\t\t<td> \t\t\t\t\tFuga +0 \t\t\t\t</td> \t\t\t</tr> \t\t\t<tr> \t\t\t\t<td> \t\t\t\t\tNegociação +0 \t\t\t\t</td> \t\t\t</tr> \t\t</table> \t</body> </html>");
        jPanel3.add(lblSomaAtributosItens);
        lblSomaAtributosItens.setBounds(20, 50, 170, 94);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(500, 130, 240, 170);

        jPanel4.setLayout(null);

        lblPrecoItem.setText("Preço:");
        jPanel4.add(lblPrecoItem);
        lblPrecoItem.setBounds(24, 160, 120, 20);

        lblInfoItem.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        lblInfoItem.setText("Item");
        jPanel4.add(lblInfoItem);
        lblInfoItem.setBounds(20, 20, 190, 18);

        lblCaracteristicasItem1.setText("<html> \t<body> \t\t<table> \t\t\t<tr> \t\t\t\t<td> \t\t\t\t\tDano +0 \t\t\t\t</td> \t\t\t</tr> \t\t\t<tr> \t\t\t\t<td> \t\t\t\t\tDefesa +0 \t\t\t\t</td> \t\t\t</tr> \t\t\t<tr> \t\t\t\t<td> \t\t\t\t\tFuga +0 \t\t\t\t</td> \t\t\t</tr> \t\t\t<tr> \t\t\t\t<td> \t\t\t\t\tNegociação +0 \t\t\t\t</td> \t\t\t</tr> \t\t</table> \t</body> </html>");
        jPanel4.add(lblCaracteristicasItem1);
        lblCaracteristicasItem1.setBounds(20, 50, 114, 94);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(500, 310, 240, 200);

        btnMenuIntermediario.setText("Cancelar");
        btnMenuIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuIntermediarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenuIntermediario);
        btnMenuIntermediario.setBounds(630, 530, 110, 40);

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnFinalizar);
        btnFinalizar.setBounds(500, 530, 110, 40);

        listaCarrinho.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaCarrinho);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(780, 200, 170, 370);

        jPanel6.setLayout(null);

        lblInfoItemTitulo3.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        lblInfoItemTitulo3.setText("Filtrar Itens Por");
        jPanel6.add(lblInfoItemTitulo3);
        lblInfoItemTitulo3.setBounds(20, 10, 180, 18);

        selectAreaCorpo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel6.add(selectAreaCorpo);
        selectAreaCorpo.setBounds(20, 40, 150, 24);

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });
        jPanel6.add(btnFiltrar);
        btnFiltrar.setBounds(180, 40, 80, 25);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        jLabel3.setText("<html><body>Clique duas vezes no item <br>para adicioná-lo ao carrinho</body></html>");
        jPanel6.add(jLabel3);
        jLabel3.setBounds(270, 40, 180, 20);

        getContentPane().add(jPanel6);
        jPanel6.setBounds(40, 130, 420, 80);

        jPanel5.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Dinheiro:");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(20, 0, 130, 50);

        lblDinheiroDisponivel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDinheiroDisponivel.setForeground(new java.awt.Color(0, 0, 0));
        lblDinheiroDisponivel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDinheiroDisponivel.setText("¨0");
        jPanel5.add(lblDinheiroDisponivel);
        lblDinheiroDisponivel.setBounds(150, 0, 130, 50);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(660, 40, 290, 50);

        jPanel7.setLayout(null);

        lblInfoItemTitulo4.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        lblInfoItemTitulo4.setText("Carrinho");
        jPanel7.add(lblInfoItemTitulo4);
        lblInfoItemTitulo4.setBounds(10, 10, 140, 18);

        getContentPane().add(jPanel7);
        jPanel7.setBounds(780, 130, 170, 50);

        jPanel8.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Taverna");
        jPanel8.add(jLabel4);
        jLabel4.setBounds(10, 10, 360, 50);

        getContentPane().add(jPanel8);
        jPanel8.setBounds(40, 30, 290, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/taverna.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 1010, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuIntermediarioActionPerformed
        if(this.caller == "MenuIntermediario"){
            MenuIntermediario menuIntermediario = new MenuIntermediario();
            menuIntermediario.setVisible(true);
        } 
        
        else if(this.caller == "NovoJogo"){
            NovoJogo novoJogo = null;
            try {
                novoJogo = new NovoJogo();
            } catch (SQLException ex) {
                Logger.getLogger(Taverna.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Taverna.class.getName()).log(Level.SEVERE, null, ex);
            }
            novoJogo.setVisible(true);
        }
        
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuIntermediarioActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        
        float totalCompra = 0;
        Personagem personagem = null;
        
        try {
            personagem = PersonagemDAO.getPersonagemPorID(MenuIntermediario.idPersonagem);
            
            if(personagem == null){
                throw new Exception("Personagem inválido");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Taverna.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Taverna.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Taverna.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (String stringItem : carrinho) {
            
            try {
                Item item = ItemDAO.getItemPorNome(stringItem);
                
                ItemPersonagem itemPersonagem = new ItemPersonagem();
                itemPersonagem.setPersonagem(personagem);
                itemPersonagem.setItem(item);
                itemPersonagem.setEquipado(0);
                itemPersonagem.setArmaReserva(0);
                
                totalCompra += item.getValor();
                
                ItemPersonagemDAO.incluirItemPersonagem(itemPersonagem);
                
            } catch (SQLException ex) {
                Logger.getLogger(Taverna.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Taverna.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        /*
        //atualizando dinheiro personagem
        personagem.setDinheiro(personagem.getDinheiro() - totalCompra);
        try {
            PersonagemDAO.alterarPersonagem(personagem);
        } catch (SQLException ex) {
            Logger.getLogger(Taverna.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Taverna.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        MenuIntermediario menuIntermediario = new MenuIntermediario();
        menuIntermediario.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        
        try {
            
            AreaCorpo areaCorpo = AreaCorpoDAO.getAreaCorpoPorArea(selectAreaCorpo.getSelectedItem().toString());
            this.carregarItens(areaCorpo);
            
        } catch (SQLException ex) {
            Logger.getLogger(Taverna.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Taverna.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnFiltrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Taverna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Taverna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Taverna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Taverna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Taverna().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Taverna.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Taverna.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public String getCaller() {
        return caller;
    }
    
    public void setCaller(String caller) {
        this.caller = caller;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnFiltrar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnMenuIntermediario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCaracteristicasItem1;
    private javax.swing.JLabel lblDinheiroDisponivel;
    private javax.swing.JLabel lblInfoItem;
    private javax.swing.JLabel lblInfoItemTitulo;
    private javax.swing.JLabel lblInfoItemTitulo3;
    private javax.swing.JLabel lblInfoItemTitulo4;
    private javax.swing.JLabel lblPrecoItem;
    private javax.swing.JLabel lblSomaAtributosItens;
    private javax.swing.JList<String> listaCarrinho;
    private javax.swing.JList<String> listaItens;
    private javax.swing.JComboBox<String> selectAreaCorpo;
    // End of variables declaration//GEN-END:variables
}
