/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerView;

import DAO.JogadorDAO;
import Model.Jogador;
import Model.SaveGame;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitorlofonseca
 */
public class SalvarJogo extends javax.swing.JFrame {

    /**
     * Creates new form SalvarJogo
     */
    public SalvarJogo() {
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

        btnCancelar = new javax.swing.JButton();
        btnSalvarJogo = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(410, 250));
        setResizable(false);
        getContentPane().setLayout(null);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(205, 158, 96, 25);

        btnSalvarJogo.setText("Salvar");
        btnSalvarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarJogoActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvarJogo);
        btnSalvarJogo.setBounds(100, 158, 78, 25);
        getContentPane().add(txtNome);
        txtNome.setBounds(160, 100, 140, 19);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Salvar Jogo");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 10, 340, 70);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 100, 45, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon("/home/vitorlofonseca/NetBeansProjects/nyte/src/img/corredor.jpg")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-360, 0, 810, 250);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarJogoActionPerformed
        
        System.out.println(MenuIntermediario.idPersonagem);
        
        try {
            
            //se não tiver diálogo nem salva
<<<<<<< HEAD
           // if(Dialogo.dialogoCheckpoint == null){
=======
            if(TelaDialogo.dialogoCheckpoint == null){
>>>>>>> 5bcc6c7294c879eb14c55fe548a764c9c8bf5171
                System.out.println("O jogo ainda está no início");
            //} else {
            
                Jogador jogador = JogadorDAO.getJogadorPorID(MenuIntermediario.idPersonagem);

                SaveGame saveGame = new SaveGame();
                saveGame.setJogador(jogador);
                saveGame.setDialogoCheckpoint(TelaDialogo.dialogoCheckpoint);
                saveGame.setNome(txtNome.getText());
                
            //}
            
        } catch (SQLException ex) {
            Logger.getLogger(SalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalvarJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        MenuIntermediario menuIntermediario = new MenuIntermediario();
        menuIntermediario.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSalvarJogoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        MenuIntermediario menuIntermediario = new MenuIntermediario();
        menuIntermediario.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(SalvarJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalvarJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalvarJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalvarJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalvarJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvarJogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
