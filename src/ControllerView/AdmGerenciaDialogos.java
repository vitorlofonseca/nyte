/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerView;

import Model.Item;
import DAO.Connect;
import DAO.ItemDAO;
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
public class AdmGerenciaDialogos extends javax.swing.JFrame {
        
    private HashMap itens;
    private Connection conn;

    /**
     * Creates new form admGerenciaItens
     */
    public AdmGerenciaDialogos() throws SQLException, ClassNotFoundException {
        
        initComponents();
        
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;    
        setLocation(dx, dy);
        
        mostraDialogos();
        
    }
    
    private void mostraDialogos(){
        
        this.itens = ItemDAO.getItens();        
        String[] itensString = new String[this.itens.size()];
        
        int i=0;
        
        //iterando no mapa de itens
        for (Iterator it = this.itens.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Integer, Item> item = (Map.Entry<Integer, Item>) it.next();
            itensString[i] = item.getValue().getNome();
            i++;
        }
        
        //lista de itens
        listaDialogos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = itensString;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        
        listaDialogos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    
                    Item itemEdicao = null;
                    try {
                        itemEdicao = ItemDAO.getItemPorNome(listaDialogos.getSelectedValue());
                    } catch (SQLException ex) {
                        Logger.getLogger(AdmGerenciaDialogos.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AdmGerenciaDialogos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    AdmGerenciaItem telaGerenciaItem = null;
                    try {
                        telaGerenciaItem = new AdmGerenciaItem(itemEdicao, conn);
                    } catch (SQLException ex) {
                        Logger.getLogger(AdmGerenciaDialogos.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AdmGerenciaDialogos.class.getName()).log(Level.SEVERE, null, ex);
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
        listaDialogos = new javax.swing.JList<>();
        btnAdicionarDialogo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setResizable(false);
        getContentPane().setLayout(null);

        listaDialogos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaDialogos.setMinimumSize(new java.awt.Dimension(1000, 650));
        jScrollPane1.setViewportView(listaDialogos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 70, 770, 420);

        btnAdicionarDialogo.setText("Adicionar Item");
        btnAdicionarDialogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarDialogoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionarDialogo);
        btnAdicionarDialogo.setBounds(820, 70, 130, 25);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(380, 500, 150, 60);

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel1.setText("Gerência de Diálogos");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 30, 320, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarDialogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarDialogoActionPerformed
        
    }//GEN-LAST:event_btnAdicionarDialogoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    
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
            java.util.logging.Logger.getLogger(AdmGerenciaDialogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmGerenciaDialogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmGerenciaDialogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmGerenciaDialogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AdmGerenciaDialogos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AdmGerenciaDialogos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdmGerenciaDialogos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarDialogo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaDialogos;
    // End of variables declaration//GEN-END:variables
}
