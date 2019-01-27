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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.TreeSelectionEvent;

/**
 *
 * @author vitorlofonseca
 */
public class GerenciaItens extends javax.swing.JFrame{
    
    private int danoTotal = 0;
    private int defesaTotal = 0;
    private int fugaTotal = 0;
    private int negociacaoTotal = 0;

    /**
     * Creates new form gerenciaItens
     */
    public GerenciaItens() throws SQLException, ClassNotFoundException {
        initComponents();
        
        loadInfo();
        
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;    
        setLocation(dx, dy);
    }
    
    public void loadInfo() throws SQLException, ClassNotFoundException{
        Personagem personagem = null;
        
        System.out.println(MenuIntermediario.idPersonagem);
        
        personagem = PersonagemDAO.getPersonagemPorID(MenuIntermediario.idPersonagem);
        HashMap areasCorpo = AreaCorpoDAO.getAreasCorpo();
        
        //CARREGANDO TOTAL DE PONTOS DOS ITENS EQUIPADOS
        carregarTotalPontosEquipamento(personagem);
        
        //CARREGANDO SELECTS
        
        HashMap itensPersonagemPernaDireita = ItemPersonagemDAO.getItensPorPersonagemEArea(personagem, (AreaCorpo)areasCorpo.get(1));
        HashMap itensPersonagemPernaEsquerda = ItemPersonagemDAO.getItensPorPersonagemEArea(personagem, (AreaCorpo)areasCorpo.get(2));
        HashMap itensPersonagemCabeca = ItemPersonagemDAO.getItensPorPersonagemEArea(personagem, (AreaCorpo)areasCorpo.get(3));
        HashMap itensPersonagemPescoco = ItemPersonagemDAO.getItensPorPersonagemEArea(personagem, (AreaCorpo)areasCorpo.get(4));
        HashMap itensPersonagemCinto = ItemPersonagemDAO.getItensPorPersonagemEArea(personagem, (AreaCorpo)areasCorpo.get(5));
        HashMap itensPersonagemArma = ItemPersonagemDAO.getItensPorPersonagemEArea(personagem, (AreaCorpo)areasCorpo.get(6));
        HashMap itensPersonagemAnelDireito = ItemPersonagemDAO.getItensPorPersonagemEArea(personagem, (AreaCorpo)areasCorpo.get(7));
        HashMap itensPersonagemAnelEsquerdo = ItemPersonagemDAO.getItensPorPersonagemEArea(personagem, (AreaCorpo)areasCorpo.get(8));
        HashMap itensPersonagemBracoDireito = ItemPersonagemDAO.getItensPorPersonagemEArea(personagem, (AreaCorpo)areasCorpo.get(9));
        HashMap itensPersonagemBracoEsquerdo = ItemPersonagemDAO.getItensPorPersonagemEArea(personagem, (AreaCorpo)areasCorpo.get(10));
        HashMap itensPersonagemPeitoral = ItemPersonagemDAO.getItensPorPersonagemEArea(personagem, (AreaCorpo)areasCorpo.get(11));
        HashMap itensPersonagemPe = ItemPersonagemDAO.getItensPorPersonagemEArea(personagem, (AreaCorpo)areasCorpo.get(12));
        
        
        // ------------------------------- PERNA DIREITA -------------------------------
        int i=0;
        String[] stringItensPersonagemPernaDireita = new String[itensPersonagemPernaDireita.size()];
        
        //iterando no mapa de itens
        for (Iterator it = itensPersonagemPernaDireita.entrySet().iterator(); it.hasNext();) {
            
            Map.Entry<Integer, ItemPersonagem> itemPersonagem = (Map.Entry<Integer, ItemPersonagem>) it.next();
            
            stringItensPersonagemPernaDireita[i] = itemPersonagem.getValue().getItem().getNome();
            
            i++;
            
        }
        
        selectItemPernaDireita.setModel(new javax.swing.DefaultComboBoxModel<>(stringItensPersonagemPernaDireita));
        // ------------------------------- PERNA DIREITA -------------------------------
        
        
        
        
        
        // ------------------------------- PERNA ESQUERDA -------------------------------
        i=0;
        String[] stringItensPersonagemPernaEsquerda = new String[itensPersonagemPernaEsquerda.size()];
        
        //iterando no mapa de itens
        for (Iterator it = itensPersonagemPernaEsquerda.entrySet().iterator(); it.hasNext();) {
            
            Map.Entry<Integer, ItemPersonagem> itemPersonagem = (Map.Entry<Integer, ItemPersonagem>) it.next();
            
            stringItensPersonagemPernaEsquerda[i] = itemPersonagem.getValue().getItem().getNome();
            
            i++;
            
        }
        
        selectItemPernaEsquerda.setModel(new javax.swing.DefaultComboBoxModel<>(stringItensPersonagemPernaEsquerda));
        // ------------------------------- PERNA ESQUERDA -------------------------------
        
        
        
        // ------------------------------- CABEÇA -------------------------------
        i=0;
        String[] stringItensPersonagemCabeca = new String[itensPersonagemCabeca.size()];
        
        //iterando no mapa de itens
        for (Iterator it = itensPersonagemCabeca.entrySet().iterator(); it.hasNext();) {
            
            Map.Entry<Integer, ItemPersonagem> itemPersonagem = (Map.Entry<Integer, ItemPersonagem>) it.next();
            
            stringItensPersonagemCabeca[i] = itemPersonagem.getValue().getItem().getNome();
            
            i++;
            
        }
        
        selectItemCabeca.setModel(new javax.swing.DefaultComboBoxModel<>(stringItensPersonagemCabeca));
        // ------------------------------- CABEÇA -------------------------------
        
        
        
        // ------------------------------- PESCOÇO -------------------------------
        i=0;
        String[] stringItensPersonagemPescoco = new String[itensPersonagemPescoco.size()];
        
        //iterando no mapa de itens
        for (Iterator it = itensPersonagemPescoco.entrySet().iterator(); it.hasNext();) {
            
            Map.Entry<Integer, ItemPersonagem> itemPersonagem = (Map.Entry<Integer, ItemPersonagem>) it.next();
            
            stringItensPersonagemPescoco[i] = itemPersonagem.getValue().getItem().getNome();
            
            i++;
            
        }
        
        selectItemPescoco.setModel(new javax.swing.DefaultComboBoxModel<>(stringItensPersonagemPescoco));
        // ------------------------------- PESCOÇO -------------------------------
        
        
        
        // ------------------------------- CINTO -------------------------------
        i=0;
        String[] stringItensPersonagemCinto = new String[itensPersonagemCinto.size()];
        
        //iterando no mapa de itens
        for (Iterator it = itensPersonagemCinto.entrySet().iterator(); it.hasNext();) {
            
            Map.Entry<Integer, ItemPersonagem> itemPersonagem = (Map.Entry<Integer, ItemPersonagem>) it.next();
            
            stringItensPersonagemCinto[i] = itemPersonagem.getValue().getItem().getNome();
            
            i++;
            
        }
        
        selectItemCinturao.setModel(new javax.swing.DefaultComboBoxModel<>(stringItensPersonagemCinto));
        // ------------------------------- CINTO -------------------------------
        
        
        
        // ------------------------------- ARMA -------------------------------
        i=0;
        String[] stringItensPersonagemArma = new String[itensPersonagemArma.size()];
        
        //iterando no mapa de itens
        for (Iterator it = itensPersonagemArma.entrySet().iterator(); it.hasNext();) {
            
            Map.Entry<Integer, ItemPersonagem> itemPersonagem = (Map.Entry<Integer, ItemPersonagem>) it.next();
            
            stringItensPersonagemArma[i] = itemPersonagem.getValue().getItem().getNome();
            
            i++;
            
        }
        
        selectItemArma.setModel(new javax.swing.DefaultComboBoxModel<>(stringItensPersonagemArma));
        // ------------------------------- ARMA -------------------------------
        
        
        
        // ------------------------------- ANEL DIREITO -------------------------------
        i=0;
        String[] stringItensPersonagemAnelDireito = new String[itensPersonagemAnelDireito.size()];
        
        //iterando no mapa de itens
        for (Iterator it = itensPersonagemAnelDireito.entrySet().iterator(); it.hasNext();) {
            
            Map.Entry<Integer, ItemPersonagem> itemPersonagem = (Map.Entry<Integer, ItemPersonagem>) it.next();
            
            stringItensPersonagemAnelDireito[i] = itemPersonagem.getValue().getItem().getNome();
            
            i++;
            
        }
        
        selectItemAnelDireito.setModel(new javax.swing.DefaultComboBoxModel<>(stringItensPersonagemAnelDireito));
        // ------------------------------- ANEL DIREITO -------------------------------
        
        
        
        // ------------------------------- ANEL ESQUERDO -------------------------------
        i=0;
        String[] stringItensPersonagemAnelEsquerdo = new String[itensPersonagemAnelEsquerdo.size()];
        
        //iterando no mapa de itens
        for (Iterator it = itensPersonagemAnelEsquerdo.entrySet().iterator(); it.hasNext();) {
            
            Map.Entry<Integer, ItemPersonagem> itemPersonagem = (Map.Entry<Integer, ItemPersonagem>) it.next();
            
            stringItensPersonagemAnelEsquerdo[i] = itemPersonagem.getValue().getItem().getNome();
            
            i++;
            
        }
        
        selectItemAnelEsquerdo.setModel(new javax.swing.DefaultComboBoxModel<>(stringItensPersonagemAnelEsquerdo));
        // ------------------------------- ANEL ESQUERDO -------------------------------
        
        
        
        
        // ------------------------------- BRACO DIREITO -------------------------------
        i=0;
        String[] stringItensPersonagemBracoDireito = new String[itensPersonagemBracoDireito.size()];
        
        //iterando no mapa de itens
        for (Iterator it = itensPersonagemBracoDireito.entrySet().iterator(); it.hasNext();) {
            
            Map.Entry<Integer, ItemPersonagem> itemPersonagem = (Map.Entry<Integer, ItemPersonagem>) it.next();
            
            stringItensPersonagemBracoDireito[i] = itemPersonagem.getValue().getItem().getNome();
            
            i++;
            
        }
        
        selectItemBracoDireito.setModel(new javax.swing.DefaultComboBoxModel<>(stringItensPersonagemBracoDireito));
        // ------------------------------- BRACO DIREITO -------------------------------
        
        
        
        // ------------------------------- BRACO ESQUERDO -------------------------------
        i=0;
        String[] stringItensPersonagemBracoEsquerdo = new String[itensPersonagemBracoEsquerdo.size()];
        
        //iterando no mapa de itens
        for (Iterator it = itensPersonagemBracoEsquerdo.entrySet().iterator(); it.hasNext();) {
            
            Map.Entry<Integer, ItemPersonagem> itemPersonagem = (Map.Entry<Integer, ItemPersonagem>) it.next();
            
            stringItensPersonagemBracoEsquerdo[i] = itemPersonagem.getValue().getItem().getNome();
            
            i++;
            
        }
        
        selectItemBracoEsquerdo.setModel(new javax.swing.DefaultComboBoxModel<>(stringItensPersonagemBracoEsquerdo));
        // ------------------------------- BRACO ESQUERDO -------------------------------
        
        
        
        
        // ------------------------------- PEITORAL -------------------------------
        i=0;
        String[] stringItensPersonagemPeitoral = new String[itensPersonagemPeitoral.size()];
        
        //iterando no mapa de itens
        for (Iterator it = itensPersonagemPeitoral.entrySet().iterator(); it.hasNext();) {
            
            Map.Entry<Integer, ItemPersonagem> itemPersonagem = (Map.Entry<Integer, ItemPersonagem>) it.next();
            
            stringItensPersonagemPeitoral[i] = itemPersonagem.getValue().getItem().getNome();
            
            i++;
            
        }
        
        selectItemPeitoral.setModel(new javax.swing.DefaultComboBoxModel<>(stringItensPersonagemPeitoral));
        // ------------------------------- PEITORAL -------------------------------
        
        
        
        // ------------------------------- PE -------------------------------
        i=0;
        String[] stringItensPersonagemPe = new String[itensPersonagemPe.size()];
        
        //iterando no mapa de itens
        for (Iterator it = itensPersonagemPe.entrySet().iterator(); it.hasNext();) {
            
            Map.Entry<Integer, ItemPersonagem> itemPersonagem = (Map.Entry<Integer, ItemPersonagem>) it.next();
            
            stringItensPersonagemPe[i] = itemPersonagem.getValue().getItem().getNome();
            
            i++;
            
        }
        
        selectItemBota.setModel(new javax.swing.DefaultComboBoxModel<>(stringItensPersonagemPe));
        // ------------------------------- PE -------------------------------
        
        
    }
    
    private void carregarTotalPontosEquipamento(Personagem personagem) throws SQLException, ClassNotFoundException{
        HashMap itensPersonagem = null;
        try {
            itensPersonagem = ItemPersonagemDAO.getItensPersonagemJoinCaracteristicasItemCombate(personagem);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        danoTotal = 0;
        defesaTotal = 0;
        negociacaoTotal = 0;
        fugaTotal = 0;
        
        for (Iterator it = itensPersonagem.entrySet().iterator(); it.hasNext();) {
            
            Map.Entry<Integer, ItemPersonagem> itemPersonagem = (Map.Entry<Integer, ItemPersonagem>) it.next();
            
            if(itemPersonagem.getValue().isEquipado() == 1){
                
                danoTotal += itemPersonagem.getValue().getItem().getDano();
                defesaTotal += itemPersonagem.getValue().getItem().getDefesa();
                negociacaoTotal += itemPersonagem.getValue().getItem().getNegociacao();
                fugaTotal += itemPersonagem.getValue().getItem().getFuga();
                
                switch(itemPersonagem.getValue().getItem().getAreaCorpo().getId()){
                    case 1:
                        btnPernaDireitaEquipado.setText(itemPersonagem.getValue().getItem().getNome());
                        break;
                    case 2:
                        btnPernaEsquerdaEquipado.setText(itemPersonagem.getValue().getItem().getNome());
                        break;
                    case 3:
                        btnCabecaEquipado.setText(itemPersonagem.getValue().getItem().getNome());
                        break;
                    case 4:
                        btnPescocoEquipado.setText(itemPersonagem.getValue().getItem().getNome());
                        break;
                    case 5:
                        btnCinturaoEquipado.setText(itemPersonagem.getValue().getItem().getNome());
                        break;
                    case 6:
                        btnArmaEquipada.setText(itemPersonagem.getValue().getItem().getNome());
                        break;
                    case 7:
                        btnAnelDireitoEquipado.setText(itemPersonagem.getValue().getItem().getNome());
                        break;
                    case 8:
                        btnAnelEsquerdoEquipado.setText(itemPersonagem.getValue().getItem().getNome());
                        break;
                    case 9:
                        btnBracoDireitoEquipado.setText(itemPersonagem.getValue().getItem().getNome());
                        break;
                    case 10:
                        btnBracoEsquerdoEquipado.setText(itemPersonagem.getValue().getItem().getNome());
                        break;
                    case 11:
                        btnPeitoralEquipado.setText(itemPersonagem.getValue().getItem().getNome());
                        break;
                    case 12:
                        btnBotaEquipado.setText(itemPersonagem.getValue().getItem().getNome());
                        break;
                }
                
            }
            
        }
        
        atualizarTotalItensEquipados();
    }
    
    private void atualizarTotalItensEquipados(){
        String html = "<html>"
                + "         <body>"
                + "             <table>"
                + "                 <tr>"
                + "                     <td>"
                + "                         Damage +" + danoTotal
                + "                     </td>"
                + "                 </tr>"
                + "                 <tr>"
                + "                     <td>"
                + "                         Defense +" + defesaTotal
                + "                     </td>"
                + "                 </tr>"
                + "                 <tr>"
                + "                     <td>"
                + "                         Escape +" + fugaTotal
                + "                     </td>"
                + "                 </tr>"
                + "                 <tr>"
                + "                     <td>"
                + "                         Negotiation +" + negociacaoTotal
                + "                     </td>"
                + "                 </tr>"
                + "             </table>"
                + "         </body>"
                + "     </html>";
        
        lblPontosTotaisItensEquipados.setText(html);
    }
    
    private void atualizaAtributosItem(String nomeItem) throws SQLException{
        
        try {
            Item item = ItemDAO.getItemPorNome(nomeItem);
            HashMap caracteristicasItem = CaracteristicaItemCombateDAO.getCaracteristicasItemCombatePorItem(item);
            
            int dano = 0;
            int negociacao = 0;
            int defesa = 0;
            int fuga = 0;
            
            
            for (Iterator it = caracteristicasItem.entrySet().iterator(); it.hasNext();) {
            
                Map.Entry<Integer, CaracteristicaItemCombate> caracteristicaItem = (Map.Entry<Integer, CaracteristicaItemCombate>) it.next();

                switch(caracteristicaItem.getValue().getAtributoCombate().getId()){
                    case 1:
                        negociacao = caracteristicaItem.getValue().getValor();
                        break;
                    case 2:
                        defesa = caracteristicaItem.getValue().getValor();
                        break;
                    case 3:
                        dano = caracteristicaItem.getValue().getValor();
                        break;
                    case 4:
                        fuga = caracteristicaItem.getValue().getValor();
                        break;
                } 

            }
            
            lblInfoItemTitulo.setText(item.getNome());
            
            String html = "<html>"
                + "         <body>"
                + "             <table>"
                + "                 <tr>"
                + "                     <td>"
                + "                         Damage +" + dano
                + "                     </td>"
                + "                 </tr>"
                + "                 <tr>"
                + "                     <td>"
                + "                         Defense +" + defesa
                + "                     </td>"
                + "                 </tr>"
                + "                 <tr>"
                + "                     <td>"
                + "                         Escape +" + fuga
                + "                     </td>"
                + "                 </tr>"
                + "                 <tr>"
                + "                     <td>"
                + "                         Negotiation +" + negociacao
                + "                     </td>"
                + "                 </tr>"
                + "             </table>"
                + "         </body>"
                + "     </html>";
        
        lblPontosItem.setText(html);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCabecaEquipado = new javax.swing.JButton();
        btnPescocoEquipado = new javax.swing.JButton();
        btnPeitoralEquipado = new javax.swing.JButton();
        btnBracoDireitoEquipado = new javax.swing.JButton();
        btnBracoEsquerdoEquipado = new javax.swing.JButton();
        btnCinturaoEquipado = new javax.swing.JButton();
        btnPernaDireitaEquipado = new javax.swing.JButton();
        btnPernaEsquerdaEquipado = new javax.swing.JButton();
        btnBotaEquipado = new javax.swing.JButton();
        btnAnelDireitoEquipado = new javax.swing.JButton();
        btnAnelEsquerdoEquipado = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEquiparCabeca = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        selectItemCabeca = new javax.swing.JComboBox<String>();
        btnEquiparPescoco = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        selectItemPescoco = new javax.swing.JComboBox<String>();
        btnEquiparPeitoral = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        selectItemPeitoral = new javax.swing.JComboBox<String>();
        btnEquiparBracoDireito = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        selectItemBracoDireito = new javax.swing.JComboBox<String>();
        btnEquiparBracoEsquerdo = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        selectItemBracoEsquerdo = new javax.swing.JComboBox<String>();
        btnEquiparCinturao = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        selectItemCinturao = new javax.swing.JComboBox<String>();
        btnEquiparAnelEsquerdo = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        selectItemAnelEsquerdo = new javax.swing.JComboBox<String>();
        btnEquiparAnelDireito = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        selectItemAnelDireito = new javax.swing.JComboBox<String>();
        btnEquiparPernaDireita = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        selectItemPernaDireita = new javax.swing.JComboBox<String>();
        btnEquiparPernaEsquerda = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        selectItemPernaEsquerda = new javax.swing.JComboBox<String>();
        btnEquiparBota = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        selectItemBota = new javax.swing.JComboBox<String>();
        btnEquiparArma = new javax.swing.JButton();
        selectItemArma = new javax.swing.JComboBox<String>();
        btnBotaEquipado1 = new javax.swing.JButton();
        btnArmaEquipada = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblInfoItemTitulo = new javax.swing.JLabel();
        lblPontosItem = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblPontosTotaisItensEquipados = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setResizable(false);
        setSize(new java.awt.Dimension(660, 600));
        getContentPane().setLayout(null);

        btnCabecaEquipado.setText("Head");
        btnCabecaEquipado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCabecaEquipadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCabecaEquipado);
        btnCabecaEquipado.setBounds(680, 90, 150, 23);

        btnPescocoEquipado.setText("Neck");
        btnPescocoEquipado.setToolTipText("");
        btnPescocoEquipado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPescocoEquipadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPescocoEquipado);
        btnPescocoEquipado.setBounds(680, 140, 170, 23);

        btnPeitoralEquipado.setText("Chest");
        btnPeitoralEquipado.setToolTipText("");
        btnPeitoralEquipado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeitoralEquipadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPeitoralEquipado);
        btnPeitoralEquipado.setBounds(700, 200, 130, 23);

        btnBracoDireitoEquipado.setText("Arm");
        btnBracoDireitoEquipado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBracoDireitoEquipadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnBracoDireitoEquipado);
        btnBracoDireitoEquipado.setBounds(600, 250, 150, 23);

        btnBracoEsquerdoEquipado.setText("Arm");
        btnBracoEsquerdoEquipado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBracoEsquerdoEquipadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnBracoEsquerdoEquipado);
        btnBracoEsquerdoEquipado.setBounds(800, 250, 150, 23);

        btnCinturaoEquipado.setText("Belt");
        btnCinturaoEquipado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCinturaoEquipadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCinturaoEquipado);
        btnCinturaoEquipado.setBounds(690, 310, 150, 23);

        btnPernaDireitaEquipado.setText("Leg");
        btnPernaDireitaEquipado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPernaDireitaEquipadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPernaDireitaEquipado);
        btnPernaDireitaEquipado.setBounds(620, 410, 140, 23);

        btnPernaEsquerdaEquipado.setText("Leg");
        btnPernaEsquerdaEquipado.setToolTipText("");
        btnPernaEsquerdaEquipado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPernaEsquerdaEquipadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPernaEsquerdaEquipado);
        btnPernaEsquerdaEquipado.setBounds(770, 410, 150, 23);

        btnBotaEquipado.setText("Feet");
        btnBotaEquipado.setToolTipText("");
        btnBotaEquipado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBotaEquipadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnBotaEquipado);
        btnBotaEquipado.setBounds(710, 530, 110, 23);

        btnAnelDireitoEquipado.setText("Ring");
        btnAnelDireitoEquipado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnelDireitoEquipadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnelDireitoEquipado);
        btnAnelDireitoEquipado.setBounds(610, 340, 120, 23);

        btnAnelEsquerdoEquipado.setText("Ring");
        btnAnelEsquerdoEquipado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnelEsquerdoEquipadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnelEsquerdoEquipado);
        btnAnelEsquerdoEquipado.setBounds(820, 340, 110, 23);

        btnCancelar.setText("Finalize");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(400, 470, 150, 40);

        btnEquiparCabeca.setText("Equipar");
        btnEquiparCabeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquiparCabecaActionPerformed(evt);
            }
        });
        getContentPane().add(btnEquiparCabeca);
        btnEquiparCabeca.setBounds(260, 60, 90, 23);

        jLabel6.setText("Head");
        jLabel6.setName(""); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(100, 54, 50, 30);
        jLabel6.getAccessibleContext().setAccessibleDescription("");

        selectItemCabeca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Capacete 1", "Capacete 2", "Capacete 3", "Capacete 4" }));
        selectItemCabeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectItemCabecaActionPerformed(evt);
            }
        });
        getContentPane().add(selectItemCabeca);
        selectItemCabeca.setBounds(150, 60, 110, 20);

        btnEquiparPescoco.setText("Equipar");
        btnEquiparPescoco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquiparPescocoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEquiparPescoco);
        btnEquiparPescoco.setBounds(260, 100, 90, 23);

        jLabel7.setText("Neck");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(100, 94, 50, 30);

        selectItemPescoco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cordão 1", "Cordão 2", "Cordão 3", "Cordão 4" }));
        getContentPane().add(selectItemPescoco);
        selectItemPescoco.setBounds(150, 100, 110, 20);

        btnEquiparPeitoral.setText("Equipar");
        btnEquiparPeitoral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquiparPeitoralActionPerformed(evt);
            }
        });
        getContentPane().add(btnEquiparPeitoral);
        btnEquiparPeitoral.setBounds(260, 140, 90, 23);

        jLabel8.setText("Chest");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(100, 134, 50, 30);

        selectItemPeitoral.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Malha 1", "Malha 2", "Malha 3", "Colete 1", "Colete 2", "Colete 3", " " }));
        getContentPane().add(selectItemPeitoral);
        selectItemPeitoral.setBounds(150, 140, 110, 20);

        btnEquiparBracoDireito.setText("Equipar");
        btnEquiparBracoDireito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquiparBracoDireitoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEquiparBracoDireito);
        btnEquiparBracoDireito.setBounds(260, 180, 90, 23);

        jLabel9.setText("Right Arm");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(80, 174, 70, 30);

        selectItemBracoDireito.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Braçadeira 1", "Braçadeira 2", "Braçadeira 3" }));
        selectItemBracoDireito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectItemBracoDireitoActionPerformed(evt);
            }
        });
        getContentPane().add(selectItemBracoDireito);
        selectItemBracoDireito.setBounds(150, 180, 110, 20);

        btnEquiparBracoEsquerdo.setText("Equipar");
        btnEquiparBracoEsquerdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquiparBracoEsquerdoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEquiparBracoEsquerdo);
        btnEquiparBracoEsquerdo.setBounds(260, 220, 90, 23);

        jLabel10.setText("Left Arm");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(90, 214, 60, 30);

        selectItemBracoEsquerdo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Braçadeira 1", "Braçadeira 2", "Braçadeira 3", " " }));
        getContentPane().add(selectItemBracoEsquerdo);
        selectItemBracoEsquerdo.setBounds(150, 220, 110, 20);

        btnEquiparCinturao.setText("Equipar");
        btnEquiparCinturao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquiparCinturaoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEquiparCinturao);
        btnEquiparCinturao.setBounds(260, 260, 90, 23);

        jLabel11.setText("Belt");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(110, 254, 40, 30);

        selectItemCinturao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cinturão 1", "Cinturão 2", "Cinturão 3" }));
        getContentPane().add(selectItemCinturao);
        selectItemCinturao.setBounds(150, 260, 110, 20);

        btnEquiparAnelEsquerdo.setText("Equipar");
        btnEquiparAnelEsquerdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquiparAnelEsquerdoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEquiparAnelEsquerdo);
        btnEquiparAnelEsquerdo.setBounds(260, 300, 90, 23);

        jLabel12.setText("Left Ring");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(90, 294, 60, 30);

        selectItemAnelEsquerdo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Anel 1", "Anel 2", "Anel 3", "Anel 4" }));
        getContentPane().add(selectItemAnelEsquerdo);
        selectItemAnelEsquerdo.setBounds(150, 300, 110, 20);

        btnEquiparAnelDireito.setText("Equipar");
        btnEquiparAnelDireito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquiparAnelDireitoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEquiparAnelDireito);
        btnEquiparAnelDireito.setBounds(260, 340, 90, 23);

        jLabel13.setText("Right Ring");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(80, 334, 70, 30);

        selectItemAnelDireito.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Anel 1", "Anel 2", "Anel 3", "Anel 4" }));
        getContentPane().add(selectItemAnelDireito);
        selectItemAnelDireito.setBounds(150, 340, 110, 20);

        btnEquiparPernaDireita.setText("Equipar");
        btnEquiparPernaDireita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquiparPernaDireitaActionPerformed(evt);
            }
        });
        getContentPane().add(btnEquiparPernaDireita);
        btnEquiparPernaDireita.setBounds(260, 380, 90, 23);

        jLabel14.setText("Right Leg");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(90, 374, 60, 30);

        selectItemPernaDireita.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Perneira 1", "Perneira 2", "Perneira 3", " " }));
        getContentPane().add(selectItemPernaDireita);
        selectItemPernaDireita.setBounds(150, 380, 110, 20);

        btnEquiparPernaEsquerda.setText("Equipar");
        btnEquiparPernaEsquerda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquiparPernaEsquerdaActionPerformed(evt);
            }
        });
        getContentPane().add(btnEquiparPernaEsquerda);
        btnEquiparPernaEsquerda.setBounds(260, 420, 90, 23);

        jLabel15.setText("Left Leg");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(90, 414, 60, 30);

        selectItemPernaEsquerda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Perneira 1", "Perneira 2", "Perneira 3" }));
        getContentPane().add(selectItemPernaEsquerda);
        selectItemPernaEsquerda.setBounds(150, 420, 110, 20);

        btnEquiparBota.setText("Equipar");
        btnEquiparBota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquiparBotaActionPerformed(evt);
            }
        });
        getContentPane().add(btnEquiparBota);
        btnEquiparBota.setBounds(260, 460, 90, 23);

        jLabel16.setText("Feet");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(110, 454, 40, 30);

        selectItemBota.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Calçado 1", "Calçado 2", "Calçado 3", "Calçado 4" }));
        getContentPane().add(selectItemBota);
        selectItemBota.setBounds(150, 460, 110, 20);

        btnEquiparArma.setText("Equipar");
        btnEquiparArma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquiparArmaActionPerformed(evt);
            }
        });
        getContentPane().add(btnEquiparArma);
        btnEquiparArma.setBounds(260, 500, 90, 23);

        selectItemArma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Arco", "Fuzil", "Espada", "Adaga" }));
        getContentPane().add(selectItemArma);
        selectItemArma.setBounds(150, 500, 110, 20);

        btnBotaEquipado1.setText("BotaX");
        btnBotaEquipado1.setToolTipText("");
        getContentPane().add(btnBotaEquipado1);
        btnBotaEquipado1.setBounds(710, 530, 110, 23);

        btnArmaEquipada.setText("Weapon");
        btnArmaEquipada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArmaEquipadaActionPerformed(evt);
            }
        });
        getContentPane().add(btnArmaEquipada);
        btnArmaEquipada.setBounds(840, 460, 130, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/corpo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(600, 60, 380, 540);

        jLabel17.setText("Weapon");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(90, 495, 50, 30);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(590, 50, 390, 530);

        lblInfoItemTitulo.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        lblInfoItemTitulo.setText("Item Attributes");
        getContentPane().add(lblInfoItemTitulo);
        lblInfoItemTitulo.setBounds(380, 240, 200, 20);

        lblPontosItem.setText("<html> \t<body><table><tr><td>Damage +0</td></tr><tr><td>Defense +0</td></tr><tr><td>Escape +0</td></tr><tr><td>Negotiation +0 \t\t\t\t</td> \t\t\t</tr> \t\t</table> \t</body> </html>");
        getContentPane().add(lblPontosItem);
        lblPontosItem.setBounds(380, 270, 130, 110);

        jLabel19.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel19.setText("Total Itens");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(380, 60, 190, 20);

        lblPontosTotaisItensEquipados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPontosTotaisItensEquipados.setText("<html> \t<body><table><tr><td>Damage +0</td></tr><tr><td>Defense +0</td></tr><tr><td>Escape +0</td></tr><tr><td>Negotiation +0 \t\t\t\t</td> \t\t\t</tr> \t\t</table> \t</body> </html>");
        getContentPane().add(lblPontosTotaisItensEquipados);
        lblPontosTotaisItensEquipados.setBounds(380, 90, 120, 110);
        getContentPane().add(jPanel2);
        jPanel2.setBounds(370, 50, 210, 170);
        getContentPane().add(jPanel3);
        jPanel3.setBounds(370, 230, 210, 170);
        getContentPane().add(jPanel4);
        jPanel4.setBounds(370, 410, 210, 170);
        getContentPane().add(jPanel5);
        jPanel5.setBounds(20, 50, 340, 530);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/armadura.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1020, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCabecaEquipadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCabecaEquipadoActionPerformed
        
        try {
            atualizaAtributosItem(btnCabecaEquipado.getText());
        } catch (SQLException ex) {
            Logger.getLogger(GerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnCabecaEquipadoActionPerformed

    private void btnPescocoEquipadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPescocoEquipadoActionPerformed
        
        try {
            atualizaAtributosItem(btnPescocoEquipado.getText());
        } catch (SQLException ex) {
            Logger.getLogger(GerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPescocoEquipadoActionPerformed

    private void btnPeitoralEquipadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeitoralEquipadoActionPerformed
                
        try {
            atualizaAtributosItem(btnPeitoralEquipado.getText());
        } catch (SQLException ex) {
            Logger.getLogger(GerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnPeitoralEquipadoActionPerformed

    private void btnBracoDireitoEquipadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBracoDireitoEquipadoActionPerformed
        
        try {
            atualizaAtributosItem(btnBracoDireitoEquipado.getText());
        } catch (SQLException ex) {
            Logger.getLogger(GerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBracoDireitoEquipadoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        MenuIntermediario menuIntermediario = new MenuIntermediario();
        menuIntermediario.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void equiparItem(javax.swing.JButton botao, String textoSelect){
        
        try {
            Item item = ItemDAO.getCaracteristicasItemCombate(ItemDAO.getItemPorNome(textoSelect));
            
            ItemPersonagem itemPersonagemEquipado = ItemPersonagemDAO.getItemPorPersonagemEItem(PersonagemDAO.getPersonagemPorID(MenuIntermediario.idPersonagem), item);
            
            itemPersonagemEquipado.setEquipado(1);
            
            ItemPersonagemDAO.alterarItemPersonagem(itemPersonagemEquipado);

            switch(botao.getText()){
                
                case "Head":
                case "Neck":
                case "Chest":
                case "Arm":
                case "Belt":
                case "Ring":
                case "Leg":
                case "Weapon":
                case "Feet":
                
                    break;
                    
                default:
                    ItemPersonagem itemPersonagemNaoEquipado = ItemPersonagemDAO.getItemPorPersonagemEItem(PersonagemDAO.getPersonagemPorID(MenuIntermediario.idPersonagem), ItemDAO.getItemPorNome(botao.getText()));
                    System.out.println(botao.getText());
                    
                    itemPersonagemNaoEquipado.setEquipado(0);
                    ItemPersonagemDAO.alterarItemPersonagem(itemPersonagemNaoEquipado);
                    break;
            }
            
            carregarTotalPontosEquipamento(PersonagemDAO.getPersonagemPorID(MenuIntermediario.idPersonagem));
            atualizarTotalItensEquipados();
            botao.setText(textoSelect);
            
        } catch (SQLException ex) {
            Logger.getLogger(GerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void btnEquiparCabecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiparCabecaActionPerformed
        equiparItem(btnCabecaEquipado, selectItemCabeca.getSelectedItem().toString());
    }//GEN-LAST:event_btnEquiparCabecaActionPerformed

    private void btnEquiparPescocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiparPescocoActionPerformed
        equiparItem(btnPescocoEquipado, selectItemPescoco.getSelectedItem().toString());
    }//GEN-LAST:event_btnEquiparPescocoActionPerformed

    private void btnEquiparPeitoralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiparPeitoralActionPerformed
        equiparItem(btnPeitoralEquipado, selectItemPeitoral.getSelectedItem().toString());
    }//GEN-LAST:event_btnEquiparPeitoralActionPerformed

    private void btnEquiparBracoDireitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiparBracoDireitoActionPerformed
        equiparItem(btnBracoDireitoEquipado, selectItemBracoDireito.getSelectedItem().toString());
    }//GEN-LAST:event_btnEquiparBracoDireitoActionPerformed

    private void btnEquiparBracoEsquerdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiparBracoEsquerdoActionPerformed
        equiparItem(btnBracoEsquerdoEquipado, selectItemBracoEsquerdo.getSelectedItem().toString());
    }//GEN-LAST:event_btnEquiparBracoEsquerdoActionPerformed

    private void btnEquiparCinturaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiparCinturaoActionPerformed
        equiparItem(btnCinturaoEquipado, selectItemCinturao.getSelectedItem().toString());
    }//GEN-LAST:event_btnEquiparCinturaoActionPerformed

    private void btnEquiparAnelEsquerdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiparAnelEsquerdoActionPerformed
        equiparItem(btnAnelEsquerdoEquipado, selectItemAnelEsquerdo.getSelectedItem().toString());
    }//GEN-LAST:event_btnEquiparAnelEsquerdoActionPerformed

    private void btnEquiparAnelDireitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiparAnelDireitoActionPerformed
        equiparItem(btnAnelDireitoEquipado, selectItemAnelDireito.getSelectedItem().toString());
    }//GEN-LAST:event_btnEquiparAnelDireitoActionPerformed

    private void btnEquiparPernaDireitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiparPernaDireitaActionPerformed
        equiparItem(btnPernaDireitaEquipado, selectItemPernaDireita.getSelectedItem().toString());
    }//GEN-LAST:event_btnEquiparPernaDireitaActionPerformed

    private void btnEquiparPernaEsquerdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiparPernaEsquerdaActionPerformed
        equiparItem(btnPernaEsquerdaEquipado, selectItemPernaEsquerda.getSelectedItem().toString());
    }//GEN-LAST:event_btnEquiparPernaEsquerdaActionPerformed

    private void btnEquiparBotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiparBotaActionPerformed
        equiparItem(btnBotaEquipado, selectItemBota.getSelectedItem().toString());
    }//GEN-LAST:event_btnEquiparBotaActionPerformed

    private void btnEquiparArmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiparArmaActionPerformed
        equiparItem(btnArmaEquipada, selectItemArma.getSelectedItem().toString());
    }//GEN-LAST:event_btnEquiparArmaActionPerformed

    private void selectItemCabecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectItemCabecaActionPerformed
        
    }//GEN-LAST:event_selectItemCabecaActionPerformed

    private void selectItemBracoDireitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectItemBracoDireitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectItemBracoDireitoActionPerformed

    private void btnBracoEsquerdoEquipadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBracoEsquerdoEquipadoActionPerformed
        try {
            atualizaAtributosItem(btnBracoEsquerdoEquipado.getText());
        } catch (SQLException ex) {
            Logger.getLogger(GerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBracoEsquerdoEquipadoActionPerformed

    private void btnCinturaoEquipadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCinturaoEquipadoActionPerformed
                
        try {
            atualizaAtributosItem(btnCinturaoEquipado.getText());
        } catch (SQLException ex) {
            Logger.getLogger(GerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnCinturaoEquipadoActionPerformed

    private void btnAnelDireitoEquipadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnelDireitoEquipadoActionPerformed
                
        try {
            atualizaAtributosItem(btnAnelDireitoEquipado.getText());
        } catch (SQLException ex) {
            Logger.getLogger(GerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnAnelDireitoEquipadoActionPerformed

    private void btnAnelEsquerdoEquipadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnelEsquerdoEquipadoActionPerformed
                
        try {
            atualizaAtributosItem(btnAnelEsquerdoEquipado.getText());
        } catch (SQLException ex) {
            Logger.getLogger(GerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnAnelEsquerdoEquipadoActionPerformed

    private void btnPernaDireitaEquipadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPernaDireitaEquipadoActionPerformed
                
        try {
            atualizaAtributosItem(btnPernaDireitaEquipado.getText());
        } catch (SQLException ex) {
            Logger.getLogger(GerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnPernaDireitaEquipadoActionPerformed

    private void btnPernaEsquerdaEquipadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPernaEsquerdaEquipadoActionPerformed
                
        try {
            atualizaAtributosItem(btnPernaEsquerdaEquipado.getText());
        } catch (SQLException ex) {
            Logger.getLogger(GerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnPernaEsquerdaEquipadoActionPerformed

    private void btnArmaEquipadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArmaEquipadaActionPerformed
        
        try {
            atualizaAtributosItem(btnArmaEquipada.getText());
        } catch (SQLException ex) {
            Logger.getLogger(GerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnArmaEquipadaActionPerformed

    private void btnBotaEquipadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBotaEquipadoActionPerformed
        
        try {
            atualizaAtributosItem(btnBotaEquipado.getText());
        } catch (SQLException ex) {
            Logger.getLogger(GerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnBotaEquipadoActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(GerenciaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GerenciaItens().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnelDireitoEquipado;
    private javax.swing.JButton btnAnelEsquerdoEquipado;
    private javax.swing.JButton btnArmaEquipada;
    private javax.swing.JButton btnBotaEquipado;
    private javax.swing.JButton btnBotaEquipado1;
    private javax.swing.JButton btnBracoDireitoEquipado;
    private javax.swing.JButton btnBracoEsquerdoEquipado;
    private javax.swing.JButton btnCabecaEquipado;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCinturaoEquipado;
    private javax.swing.JButton btnEquiparAnelDireito;
    private javax.swing.JButton btnEquiparAnelEsquerdo;
    private javax.swing.JButton btnEquiparArma;
    private javax.swing.JButton btnEquiparBota;
    private javax.swing.JButton btnEquiparBracoDireito;
    private javax.swing.JButton btnEquiparBracoEsquerdo;
    private javax.swing.JButton btnEquiparCabeca;
    private javax.swing.JButton btnEquiparCinturao;
    private javax.swing.JButton btnEquiparPeitoral;
    private javax.swing.JButton btnEquiparPernaDireita;
    private javax.swing.JButton btnEquiparPernaEsquerda;
    private javax.swing.JButton btnEquiparPescoco;
    private javax.swing.JButton btnPeitoralEquipado;
    private javax.swing.JButton btnPernaDireitaEquipado;
    private javax.swing.JButton btnPernaEsquerdaEquipado;
    private javax.swing.JButton btnPescocoEquipado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblInfoItemTitulo;
    private javax.swing.JLabel lblPontosItem;
    private javax.swing.JLabel lblPontosTotaisItensEquipados;
    private javax.swing.JComboBox<String> selectItemAnelDireito;
    private javax.swing.JComboBox<String> selectItemAnelEsquerdo;
    private javax.swing.JComboBox<String> selectItemArma;
    private javax.swing.JComboBox<String> selectItemBota;
    private javax.swing.JComboBox<String> selectItemBracoDireito;
    private javax.swing.JComboBox<String> selectItemBracoEsquerdo;
    private javax.swing.JComboBox<String> selectItemCabeca;
    private javax.swing.JComboBox<String> selectItemCinturao;
    private javax.swing.JComboBox<String> selectItemPeitoral;
    private javax.swing.JComboBox<String> selectItemPernaDireita;
    private javax.swing.JComboBox<String> selectItemPernaEsquerda;
    private javax.swing.JComboBox<String> selectItemPescoco;
    // End of variables declaration//GEN-END:variables
    
}