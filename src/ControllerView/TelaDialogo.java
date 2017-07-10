/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerView;

import DAO.DialogoDAO;
import java.awt.Color;
import Model.Dialogo;
import Model.SaveGame;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author vitorlofonseca
 */
public class TelaDialogo extends javax.swing.JFrame {
    
    /**
     * Creates new form dialogo
     */
    public TelaDialogo() {
        initComponents();
        
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;    
        setLocation(dx, dy);
        
        /*
        //se tiver jogo salvo, chama o método passando o savegame
        if(){
            atualizarTela(dialogo);
        } else {
            atualizarTela(null);
        }
        */
        
    }
    
    
    private void atualizarTela(SaveGame saveGame) throws SQLException, ClassNotFoundException{
        
        Dialogo dialogoCheckpoint = null;
        
        if(saveGame == null){
            dialogoCheckpoint = DialogoDAO.getDialogoPorID(1);
        } else {
            dialogoCheckpoint = saveGame.getDialogoCheckpoint();
        } 
        
        String txtPuroDialogo = dialogoCheckpoint.getTexto();
        
        String dialogoTratado = "";
        
        for(int i=0 ; i<txtPuroDialogo.length() ; i++){
            //se a quantidade de chars for divisivel por 20, br
            if(i % 50 == 0){
                dialogoTratado += "<br>";
            }   
            dialogoTratado += txtPuroDialogo.charAt(i);
        }            
        
        String dialogoFinal = "<html><body>";
        
        dialogoFinal += dialogoTratado;
        
        dialogoFinal += "</body></html>";
        
        lblDialogo.setText(dialogoFinal);
        
        barHp.setValue(100);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDado = new javax.swing.JLabel();
        btnLancarDado = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        paneDialogo = new javax.swing.JScrollPane();
        lblDialogo = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        barHp = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        lblCaixaDialogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setResizable(false);
        getContentPane().setLayout(null);

        lblDado.setFont(new java.awt.Font("Cantarell", 1, 72)); // NOI18N
        lblDado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDado.setText("-");
        lblDado.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblDado.setAlignmentY(0.2F);
        getContentPane().add(lblDado);
        lblDado.setBounds(550, 327, 130, 73);

        btnLancarDado.setText("Lançar Dado");
        btnLancarDado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLancarDadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnLancarDado);
        btnLancarDado.setBounds(550, 430, 130, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/narrador.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 150, 440, 490);

        paneDialogo.setToolTipText("");
        paneDialogo.setName(""); // NOI18N

        lblDialogo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        paneDialogo.setViewportView(lblDialogo);

        getContentPane().add(paneDialogo);
        paneDialogo.setBounds(350, 40, 380, 140);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar);
        btnVoltar.setBounds(780, 550, 150, 50);
        getContentPane().add(barHp);
        barHp.setBounds(420, 220, 330, 30);

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel2.setText("HP: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(310, 320, 60, 20);

        lblCaixaDialogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/caixaDialogo.png"))); // NOI18N
        getContentPane().add(lblCaixaDialogo);
        lblCaixaDialogo.setBounds(300, -50, 600, 350);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(550, 330, 130, 90);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/jornada.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 1030, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLancarDadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLancarDadoActionPerformed
             
        Random random = new Random();
        int resultDado = random.nextInt(20)+1;
        
        //impressão do resultado
        lblDado.setText(Integer.toString(resultDado));
    }//GEN-LAST:event_btnLancarDadoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        MenuIntermediario menuIntermediario = new MenuIntermediario();
        menuIntermediario.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDialogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDialogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDialogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDialogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDialogo().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barHp;
    private javax.swing.JButton btnLancarDado;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCaixaDialogo;
    private javax.swing.JLabel lblDado;
    private javax.swing.JLabel lblDialogo;
    private javax.swing.JScrollPane paneDialogo;
    // End of variables declaration//GEN-END:variables
}
