/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerView;

import DAO.AreaCorpoDAO;
import DAO.ItemDAO;
import Model.AreaCorpo;
import Model.Item;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
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

    /**
     * Creates new form Taverna
     */
    public Taverna() throws SQLException, ClassNotFoundException {
        initComponents();
        
        this.carregarSelect();
        
        this.carregarItens(null);
        
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;    
        setLocation(dx, dy);
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
        
        
        listaItens.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                
                if (evt.getClickCount() == 1) {
                    int index = list.locationToIndex(evt.getPoint());
                    
                    Item item = null;
                    try {
                        item = ItemDAO.getItemPorNome(listaItens.getSelectedValue());
                    } catch (SQLException ex) {
                        Logger.getLogger(AdmGerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AdmGerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    lblInfoItem.setText(item.getNome());
                    
                    
                    
                }
                
                
                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    
                    Item itemEdicao = null;
                    try {
                        itemEdicao = ItemDAO.getItemPorNome(listaItens.getSelectedValue());
                    } catch (SQLException ex) {
                        Logger.getLogger(AdmGerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AdmGerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    AdmGerenciaItem telaGerenciaItem = null;
                    try {
                        Connection conn = null;
                        telaGerenciaItem = new AdmGerenciaItem(itemEdicao, conn);
                    } catch (SQLException ex) {
                        Logger.getLogger(AdmGerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AdmGerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    telaGerenciaItem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    telaGerenciaItem.setVisible(true);
                }
            }
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
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblInfoItem = new javax.swing.JLabel();
        btnMenuIntermediario = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jPanel6 = new javax.swing.JPanel();
        lblInfoItemTitulo3 = new javax.swing.JLabel();
        selectAreaCorpo = new javax.swing.JComboBox<>();
        btnFiltrar = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
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
        lblInfoItemTitulo.setText("Atributos Personagem");
        jPanel3.add(lblInfoItemTitulo);
        lblInfoItemTitulo.setBounds(20, 20, 200, 18);

        jLabel5.setText("<html> \t<body> \t\t<table> \t\t\t<tr> \t\t\t\t<td> \t\t\t\t\tDano +5 \t\t\t\t</td> \t\t\t</tr> \t\t\t<tr> \t\t\t\t<td> \t\t\t\t\tDefesa +10 \t\t\t\t</td> \t\t\t</tr> \t\t\t<tr> \t\t\t\t<td> \t\t\t\t\tFuga +1 \t\t\t\t</td> \t\t\t</tr> \t\t\t<tr> \t\t\t\t<td> \t\t\t\t\tNegociação +2 \t\t\t\t</td> \t\t\t</tr> \t\t</table> \t</body> </html>");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(20, 50, 114, 94);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(500, 130, 240, 170);

        jPanel4.setLayout(null);

        jLabel6.setText("<html> \t<body> \t\t<table> \t\t\t<tr> \t\t\t\t<td> \t\t\t\t\tDano +5 \t\t\t\t</td> \t\t\t</tr> \t\t\t<tr> \t\t\t\t<td> \t\t\t\t\tDefesa +10 \t\t\t\t</td> \t\t\t</tr> \t\t\t<tr> \t\t\t\t<td> \t\t\t\t\tFuga +1 \t\t\t\t</td> \t\t\t</tr> \t\t\t<tr> \t\t\t\t<td> \t\t\t\t\tNegociação +2 \t\t\t\t</td> \t\t\t</tr> \t\t</table> \t</body> </html>");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(20, 50, 114, 94);

        lblInfoItem.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        lblInfoItem.setText("Malha X");
        jPanel4.add(lblInfoItem);
        lblInfoItem.setBounds(20, 20, 190, 18);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(500, 310, 240, 170);

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

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

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

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("¨1,000,000");
        jPanel5.add(jLabel7);
        jLabel7.setBounds(150, 0, 130, 50);

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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblInfoItem;
    private javax.swing.JLabel lblInfoItemTitulo;
    private javax.swing.JLabel lblInfoItemTitulo3;
    private javax.swing.JLabel lblInfoItemTitulo4;
    private javax.swing.JList<String> listaItens;
    private javax.swing.JComboBox<String> selectAreaCorpo;
    // End of variables declaration//GEN-END:variables
}
