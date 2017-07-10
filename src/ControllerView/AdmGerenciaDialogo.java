 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerView;

import DAO.AdversidadeDAO;
import Model.AreaCorpo;
import Model.Item;
import Model.Dialogo;
import DAO.AreaCorpoDAO;
import DAO.Connect;
import DAO.DialogoDAO;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.List;
import java.awt.Point;
import java.security.KeyStore.Entry.Attribute;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitorlofonseca
 */
public class AdmGerenciaDialogo extends javax.swing.JFrame {

    /**
     * Criação de diálogo
     */
    public AdmGerenciaDialogo(Connection conn) throws SQLException, ClassNotFoundException {
        initComponents();
        
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;    
        setLocation(dx, dy);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloTela = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTexto = new javax.swing.JTextField();
        txtIdProximoDialogo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIdAdversidade = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtIdDialogoAnterior = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        tituloTela.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        tituloTela.setText("Cadastro Dialogo");
        getContentPane().add(tituloTela);
        tituloTela.setBounds(40, 10, 320, 25);

        jLabel2.setText("Texto");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 70, 140, 15);

        txtTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTextoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTexto);
        txtTexto.setBounds(165, 70, 230, 180);

        txtIdProximoDialogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProximoDialogoActionPerformed(evt);
            }
        });
        getContentPane().add(txtIdProximoDialogo);
        txtIdProximoDialogo.setBounds(160, 260, 230, 19);

        jLabel8.setText("id adversidade");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 320, 140, 15);

        txtIdAdversidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdAdversidadeActionPerformed(evt);
            }
        });
        getContentPane().add(txtIdAdversidade);
        txtIdAdversidade.setBounds(160, 320, 230, 19);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(60, 360, 122, 40);

        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(230, 360, 122, 40);

        jLabel10.setText("id próximo diálogo");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 260, 140, 15);

        jLabel9.setText("id diálogo anterior");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 290, 140, 15);

        txtIdDialogoAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdDialogoAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(txtIdDialogoAnterior);
        txtIdDialogoAnterior.setBounds(160, 290, 230, 19);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTextoActionPerformed

    private void txtIdProximoDialogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProximoDialogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProximoDialogoActionPerformed

    private void txtIdAdversidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdAdversidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdAdversidadeActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        Dialogo dialogo = new Dialogo();
        
        dialogo.setTexto(txtTexto.getText());
        dialogo.setIdDialogoAnterior(Integer.parseInt(txtIdDialogoAnterior.getText()));
        dialogo.setIdProximoDialogo(Integer.parseInt(txtIdProximoDialogo.getText()));
        try {
            dialogo.setAdversidade(AdversidadeDAO.getAdversidadePorID(Integer.parseInt(txtIdAdversidade.getText())));
            DialogoDAO.incluirDialogo(dialogo);
        } catch (SQLException ex) {
            Logger.getLogger(AdmGerenciaDialogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdmGerenciaDialogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtIdDialogoAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdDialogoAnteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdDialogoAnteriorActionPerformed

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
            java.util.logging.Logger.getLogger(AdmGerenciaDialogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmGerenciaDialogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmGerenciaDialogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmGerenciaDialogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                Connection conn = null;
                try {
                    conn = Connect.conectar();
                } catch (SQLException ex) {
                    Logger.getLogger(AdmGerenciaItens.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdmGerenciaDialogo.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try {
                    new AdmGerenciaDialogo(conn).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AdmGerenciaDialogo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdmGerenciaDialogo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel tituloTela;
    private javax.swing.JTextField txtIdAdversidade;
    private javax.swing.JTextField txtIdDialogoAnterior;
    private javax.swing.JTextField txtIdProximoDialogo;
    private javax.swing.JTextField txtTexto;
    // End of variables declaration//GEN-END:variables
}