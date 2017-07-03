/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerView;

import DAO.EspecieDAO;
import Model.Especie;
import Model.Personagem;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author vitorlofonseca
 */
public class NovoJogo extends javax.swing.JFrame {
    
    private final static int pontosEspecializacao = 20;
    private final static int pontosCombate = 20;
    
    private void carregarListenerSpinnersEspecializacoes(){
        
        ChangeListener listener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                
                int pontosTotaisEspecializacao = 0;
        
                pontosTotaisEspecializacao += Integer.parseInt(spinnerAgilidadeEsp.getValue().toString());
                pontosTotaisEspecializacao += Integer.parseInt(spinnerConhecimentoEsp.getValue().toString());
                pontosTotaisEspecializacao += Integer.parseInt(spinnerBlefeEsp.getValue().toString());
                pontosTotaisEspecializacao += Integer.parseInt(spinnerForcaEsp.getValue().toString());
                pontosTotaisEspecializacao += Integer.parseInt(spinnerFurtividade.getValue().toString());
                pontosTotaisEspecializacao += Integer.parseInt(spinnerInteligencia.getValue().toString());
                pontosTotaisEspecializacao += Integer.parseInt(spinnerLabia.getValue().toString());
                pontosTotaisEspecializacao += Integer.parseInt(spinnerPercepcao.getValue().toString());
                pontosTotaisEspecializacao += Integer.parseInt(spinnerResistencia.getValue().toString());
                pontosTotaisEspecializacao += Integer.parseInt(spinnerSobrevivencia.getValue().toString());
                pontosTotaisEspecializacao += Integer.parseInt(spinnerVontade.getValue().toString());
                
                //se for maior que vinte, volta pra não bugar os spinners
                if(pontosTotaisEspecializacao > 20){
                    pontosTotaisEspecializacao = 21;
                } 
                
                if(pontosTotaisEspecializacao > 20) {
                    
                    spinnerAgilidadeEsp.setModel(new SpinnerNumberModel(Integer.parseInt(spinnerAgilidadeEsp.getValue().toString()) - 1, 0, Integer.parseInt(spinnerAgilidadeEsp.getValue().toString()), 1));
                    spinnerConhecimentoEsp.setModel(new SpinnerNumberModel(Integer.parseInt(spinnerConhecimentoEsp.getValue().toString()) - 1, 0, Integer.parseInt(spinnerConhecimentoEsp.getValue().toString()), 1));
                    spinnerBlefeEsp.setModel(new SpinnerNumberModel(Integer.parseInt(spinnerBlefeEsp.getValue().toString()) - 1, 0, Integer.parseInt(spinnerBlefeEsp.getValue().toString()), 1));
                    spinnerForcaEsp.setModel(new SpinnerNumberModel(Integer.parseInt(spinnerForcaEsp.getValue().toString()) - 1, 0, Integer.parseInt(spinnerForcaEsp.getValue().toString()), 1));
                    spinnerFurtividade.setModel(new SpinnerNumberModel(Integer.parseInt(spinnerFurtividade.getValue().toString()) - 1, 0, Integer.parseInt(spinnerFurtividade.getValue().toString()), 1));
                    spinnerInteligencia.setModel(new SpinnerNumberModel(Integer.parseInt(spinnerInteligencia.getValue().toString()) - 1, 0, Integer.parseInt(spinnerInteligencia.getValue().toString()), 1));
                    spinnerLabia.setModel(new SpinnerNumberModel(Integer.parseInt(spinnerLabia.getValue().toString()) - 1, 0, Integer.parseInt(spinnerLabia.getValue().toString()), 1));
                    spinnerPercepcao.setModel(new SpinnerNumberModel(Integer.parseInt(spinnerPercepcao.getValue().toString()) - 1, 0, Integer.parseInt(spinnerPercepcao.getValue().toString()), 1));
                    spinnerResistencia.setModel(new SpinnerNumberModel(Integer.parseInt(spinnerResistencia.getValue().toString()) - 1, 0, Integer.parseInt(spinnerResistencia.getValue().toString()), 1));
                    spinnerSobrevivencia.setModel(new SpinnerNumberModel(Integer.parseInt(spinnerSobrevivencia.getValue().toString()) - 1, 0, Integer.parseInt(spinnerSobrevivencia.getValue().toString()), 1));
                    spinnerVontade.setModel(new SpinnerNumberModel(Integer.parseInt(spinnerVontade.getValue().toString()) - 1, 0, Integer.parseInt(spinnerVontade.getValue().toString()), 1));
                    
                } else {
                
                    lblEspecializacao.setText(String.valueOf(NovoJogo.pontosEspecializacao - pontosTotaisEspecializacao));
                }
            }
        };
        
        spinnerAgilidadeEsp.addChangeListener(listener);
        spinnerConhecimentoEsp.addChangeListener(listener);
        spinnerBlefeEsp.addChangeListener(listener);
        spinnerForcaEsp.addChangeListener(listener);
        spinnerFurtividade.addChangeListener(listener);
        spinnerInteligencia.addChangeListener(listener);
        spinnerLabia.addChangeListener(listener);
        spinnerPercepcao.addChangeListener(listener);
        spinnerResistencia.addChangeListener(listener);
        spinnerSobrevivencia.addChangeListener(listener);
        spinnerVontade.addChangeListener(listener);
        
    }
    
    
    
    private void carregarListenerSpinnersCombate(){
        
        ChangeListener listener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                
                int pontosTotaisCombate = 0;
        
                pontosTotaisCombate += Integer.parseInt(spinnerAgilidadeComb.getValue().toString());
                pontosTotaisCombate += Integer.parseInt(spinnerConhecimentoComb.getValue().toString());
                pontosTotaisCombate += Integer.parseInt(spinnerBlefeComb.getValue().toString());
                pontosTotaisCombate += Integer.parseInt(spinnerForcaComb.getValue().toString());
                
                //se for maior que vinte, volta pra não bugar os spinners
                if(pontosTotaisCombate > 20){
                    pontosTotaisCombate = 21;
                } 
                
                if(pontosTotaisCombate > 20) {
                    
                    spinnerAgilidadeComb.setModel(new SpinnerNumberModel(Integer.parseInt(spinnerAgilidadeComb.getValue().toString()) - 1, 0, Integer.parseInt(spinnerAgilidadeComb.getValue().toString()), 1));
                    spinnerConhecimentoComb.setModel(new SpinnerNumberModel(Integer.parseInt(spinnerConhecimentoComb.getValue().toString()) - 1, 0, Integer.parseInt(spinnerConhecimentoComb.getValue().toString()), 1));
                    spinnerBlefeComb.setModel(new SpinnerNumberModel(Integer.parseInt(spinnerBlefeComb.getValue().toString()) - 1, 0, Integer.parseInt(spinnerBlefeComb.getValue().toString()), 1));
                    spinnerForcaComb.setModel(new SpinnerNumberModel(Integer.parseInt(spinnerForcaComb.getValue().toString()), 0, Integer.parseInt(spinnerForcaComb.getValue().toString()), 1));
                    
                } else {
                
                    lblCombate.setText(String.valueOf(NovoJogo.pontosEspecializacao - pontosTotaisCombate));
                }
            }
        };
        
        spinnerAgilidadeComb.addChangeListener(listener);
        spinnerConhecimentoComb.addChangeListener(listener);
        spinnerBlefeComb.addChangeListener(listener);
        spinnerForcaComb.addChangeListener(listener);
        
    }
    
    
    
    /**
     * Creates new form NovoJogo
     */
    public NovoJogo() throws SQLException, ClassNotFoundException {
        initComponents();
        
        this.carregarSelect();
     
        carregarListenerSpinnersEspecializacoes();
        carregarListenerSpinnersCombate();
        
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

        jFrame1 = new javax.swing.JFrame();
        panelEspecializacoes = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        spinnerInteligencia = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        spinnerAgilidadeEsp = new javax.swing.JSpinner();
        spinnerConhecimentoEsp = new javax.swing.JSpinner();
        spinnerBlefeEsp = new javax.swing.JSpinner();
        spinnerForcaEsp = new javax.swing.JSpinner();
        spinnerFurtividade = new javax.swing.JSpinner();
        lblEspecializacao = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        spinnerLabia = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        spinnerPercepcao = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        spinnerResistencia = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        spinnerSobrevivencia = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
        spinnerVontade = new javax.swing.JSpinner();
        panel2 = new java.awt.Panel();
        jLabel6 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtIdade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtAltura = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        selectTipo = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        panelEspecializacoes1 = new java.awt.Panel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        spinnerAgilidadeComb = new javax.swing.JSpinner();
        spinnerConhecimentoComb = new javax.swing.JSpinner();
        spinnerBlefeComb = new javax.swing.JSpinner();
        spinnerForcaComb = new javax.swing.JSpinner();
        lblCombate = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        btnTaverna = new javax.swing.JToggleButton();
        btnSalvar = new javax.swing.JToggleButton();
        btnVoltarTelaInicial = new javax.swing.JToggleButton();
        jLabel25 = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 550));
        setResizable(false);
        getContentPane().setLayout(null);

        panelEspecializacoes.setLayout(null);

        jLabel1.setText("Agilidade");
        panelEspecializacoes.add(jLabel1);
        jLabel1.setBounds(10, 50, 66, 15);

        jLabel2.setText("Conhecimento");
        panelEspecializacoes.add(jLabel2);
        jLabel2.setBounds(10, 80, 110, 15);

        jLabel3.setText("Blefe");
        panelEspecializacoes.add(jLabel3);
        jLabel3.setBounds(10, 110, 80, 15);

        jLabel4.setText("Força");
        panelEspecializacoes.add(jLabel4);
        jLabel4.setBounds(10, 140, 100, 15);

        jLabel5.setText("Furtividade");
        panelEspecializacoes.add(jLabel5);
        jLabel5.setBounds(10, 170, 100, 15);

        jLabel11.setText("Inteligência");
        panelEspecializacoes.add(jLabel11);
        jLabel11.setBounds(10, 200, 90, 15);

        jLabel13.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel13.setText("Especializações");
        panelEspecializacoes.add(jLabel13);
        jLabel13.setBounds(20, 10, 180, 20);

        spinnerInteligencia.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        panelEspecializacoes.add(spinnerInteligencia);
        spinnerInteligencia.setBounds(120, 200, 60, 20);

        jLabel14.setText("Restantes:");
        panelEspecializacoes.add(jLabel14);
        jLabel14.setBounds(200, 150, 80, 15);

        spinnerAgilidadeEsp.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        panelEspecializacoes.add(spinnerAgilidadeEsp);
        spinnerAgilidadeEsp.setBounds(120, 50, 60, 20);

        spinnerConhecimentoEsp.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        panelEspecializacoes.add(spinnerConhecimentoEsp);
        spinnerConhecimentoEsp.setBounds(120, 80, 60, 20);

        spinnerBlefeEsp.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        panelEspecializacoes.add(spinnerBlefeEsp);
        spinnerBlefeEsp.setBounds(120, 110, 60, 20);

        spinnerForcaEsp.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        panelEspecializacoes.add(spinnerForcaEsp);
        spinnerForcaEsp.setBounds(120, 140, 60, 20);

        spinnerFurtividade.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        panelEspecializacoes.add(spinnerFurtividade);
        spinnerFurtividade.setBounds(120, 170, 60, 20);

        lblEspecializacao.setFont(new java.awt.Font("Cantarell", 1, 36)); // NOI18N
        lblEspecializacao.setText("20");
        lblEspecializacao.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelEspecializacoes.add(lblEspecializacao);
        lblEspecializacao.setBounds(230, 170, 50, 40);

        jLabel16.setText("Lábia");
        panelEspecializacoes.add(jLabel16);
        jLabel16.setBounds(10, 230, 90, 15);

        spinnerLabia.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        panelEspecializacoes.add(spinnerLabia);
        spinnerLabia.setBounds(120, 230, 60, 20);

        jLabel17.setText("Percepção");
        panelEspecializacoes.add(jLabel17);
        jLabel17.setBounds(10, 260, 90, 15);

        spinnerPercepcao.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        panelEspecializacoes.add(spinnerPercepcao);
        spinnerPercepcao.setBounds(120, 260, 60, 20);

        jLabel18.setText("Resistência");
        panelEspecializacoes.add(jLabel18);
        jLabel18.setBounds(10, 290, 90, 15);

        spinnerResistencia.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        panelEspecializacoes.add(spinnerResistencia);
        spinnerResistencia.setBounds(120, 290, 60, 20);

        jLabel19.setText("Sobrevivência");
        panelEspecializacoes.add(jLabel19);
        jLabel19.setBounds(10, 320, 100, 15);

        spinnerSobrevivencia.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        panelEspecializacoes.add(spinnerSobrevivencia);
        spinnerSobrevivencia.setBounds(120, 320, 60, 20);

        jLabel20.setText("Vontade");
        panelEspecializacoes.add(jLabel20);
        jLabel20.setBounds(10, 350, 90, 15);

        spinnerVontade.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        panelEspecializacoes.add(spinnerVontade);
        spinnerVontade.setBounds(120, 350, 60, 20);

        getContentPane().add(panelEspecializacoes);
        panelEspecializacoes.setBounds(350, 100, 300, 390);

        panel2.setLayout(null);

        jLabel6.setText("Nome");
        panel2.add(jLabel6);
        jLabel6.setBounds(20, 50, 40, 15);
        panel2.add(txtNome);
        txtNome.setBounds(70, 50, 210, 19);
        panel2.add(txtIdade);
        txtIdade.setBounds(70, 90, 210, 19);

        jLabel7.setText("Idade");
        panel2.add(jLabel7);
        jLabel7.setBounds(20, 90, 40, 15);

        jLabel8.setText("Tipo");
        panel2.add(jLabel8);
        jLabel8.setBounds(20, 130, 30, 15);

        txtAltura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlturaActionPerformed(evt);
            }
        });
        panel2.add(txtAltura);
        txtAltura.setBounds(70, 170, 210, 19);

        jLabel9.setText("Altura");
        panel2.add(jLabel9);
        jLabel9.setBounds(20, 170, 43, 15);
        panel2.add(txtPeso);
        txtPeso.setBounds(70, 210, 210, 19);

        jLabel10.setText("Peso");
        panel2.add(jLabel10);
        jLabel10.setBounds(20, 210, 35, 15);

        selectTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panel2.add(selectTipo);
        selectTipo.setBounds(70, 130, 210, 24);

        jLabel12.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel12.setText("Dados");
        panel2.add(jLabel12);
        jLabel12.setBounds(20, 10, 180, 20);

        getContentPane().add(panel2);
        panel2.setBounds(20, 100, 300, 280);

        panelEspecializacoes1.setLayout(null);

        jLabel21.setText("Agilidade");
        panelEspecializacoes1.add(jLabel21);
        jLabel21.setBounds(10, 50, 66, 15);

        jLabel22.setText("Conhecimento");
        panelEspecializacoes1.add(jLabel22);
        jLabel22.setBounds(10, 90, 110, 15);

        jLabel23.setText("Blefe");
        panelEspecializacoes1.add(jLabel23);
        jLabel23.setBounds(10, 130, 80, 15);

        jLabel24.setText("Força");
        panelEspecializacoes1.add(jLabel24);
        jLabel24.setBounds(10, 170, 100, 15);

        jLabel28.setText("Restantes:");
        panelEspecializacoes1.add(jLabel28);
        jLabel28.setBounds(200, 80, 80, 15);
        panelEspecializacoes1.add(spinnerAgilidadeComb);
        spinnerAgilidadeComb.setBounds(120, 50, 60, 20);
        panelEspecializacoes1.add(spinnerConhecimentoComb);
        spinnerConhecimentoComb.setBounds(120, 90, 60, 20);
        panelEspecializacoes1.add(spinnerBlefeComb);
        spinnerBlefeComb.setBounds(120, 130, 60, 20);
        panelEspecializacoes1.add(spinnerForcaComb);
        spinnerForcaComb.setBounds(120, 170, 60, 20);

        lblCombate.setFont(new java.awt.Font("Cantarell", 1, 36)); // NOI18N
        lblCombate.setText("20");
        lblCombate.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelEspecializacoes1.add(lblCombate);
        lblCombate.setBounds(230, 100, 50, 40);

        jLabel35.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel35.setText("Combate");
        panelEspecializacoes1.add(jLabel35);
        jLabel35.setBounds(20, 10, 180, 20);

        getContentPane().add(panelEspecializacoes1);
        panelEspecializacoes1.setBounds(680, 100, 300, 220);

        btnTaverna.setText("Taverna");
        btnTaverna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTavernaActionPerformed(evt);
            }
        });
        getContentPane().add(btnTaverna);
        btnTaverna.setBounds(20, 410, 300, 50);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(850, 410, 130, 50);

        btnVoltarTelaInicial.setText("Voltar");
        btnVoltarTelaInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarTelaInicialActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltarTelaInicial);
        btnVoltarTelaInicial.setBounds(680, 410, 130, 50);

        jLabel25.setFont(new java.awt.Font("Cantarell", 1, 48)); // NOI18N
        jLabel25.setText("Novo Personagem");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(40, 0, 550, 90);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/castelo.jpg"))); // NOI18N
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, 0, 1010, 650);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarSelect() throws SQLException, ClassNotFoundException{
        
        HashMap especiesPersonagem = EspecieDAO.getEspecies();
        
        int i=0;
        String[] especiesPersonagemString = new String[especiesPersonagem.size()];
        
        //iterando no mapa de itens
        for (Iterator it = especiesPersonagem.entrySet().iterator(); it.hasNext();) {
            
            Map.Entry<Integer, Especie> especiePersonagem = (Map.Entry<Integer, Especie>) it.next();
            
            especiesPersonagemString[i] = especiePersonagem.getValue().getNome();
            
            i++;
            
        }
        
        selectTipo.setModel(new javax.swing.DefaultComboBoxModel<>(especiesPersonagemString));
        
    }
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
              
        
        try {
            
            //IDADE
            int idade;
            
            if(txtIdade.getText() != ""){
                
                //se a idade não for numeric, exception
                if(!txtIdade.getText().matches("[-+]?\\d*\\.?\\d+")){
                    throw new Exception("Idade não é número");
                }
                
                idade = Integer.parseInt(txtIdade.getText());   
            } else {
                throw new Exception("Idade não recebida");
            } 
            
            Personagem personagem = new Personagem();
            personagem.setNome(txtNome.getText());
            personagem.setIdade(idade);
            personagem.setAltura(Float.parseFloat(txtAltura.getText()));
            personagem.setPeso(Float.parseFloat(txtAltura.getText()));
        
            System.out.println(spinnerAgilidadeEsp.getValue());            
            
        } catch (Exception ex) {
            Logger.getLogger(NovoJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        MenuIntermediario menuIntermediario = new MenuIntermediario();
        menuIntermediario.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSalvarActionPerformed
  
    
    private void btnTavernaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTavernaActionPerformed
        Taverna taverna = new Taverna();
        taverna.setVisible(true);
        taverna.setCaller("NovoJogo");
        this.setVisible(false);
    }//GEN-LAST:event_btnTavernaActionPerformed

    private void btnVoltarTelaInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarTelaInicialActionPerformed
        TelaInicial telaInicial = new TelaInicial();
        this.setVisible(false);
        telaInicial.setVisible(true);
    }//GEN-LAST:event_btnVoltarTelaInicialActionPerformed

    private void txtAlturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlturaActionPerformed

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
            java.util.logging.Logger.getLogger(NovoJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {                
                    new NovoJogo().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(NovoJogo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NovoJogo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnSalvar;
    private javax.swing.JToggleButton btnTaverna;
    private javax.swing.JToggleButton btnVoltarTelaInicial;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblCombate;
    private javax.swing.JLabel lblEspecializacao;
    private java.awt.Panel panel2;
    private java.awt.Panel panelEspecializacoes;
    private java.awt.Panel panelEspecializacoes1;
    private javax.swing.JComboBox<String> selectTipo;
    private javax.swing.JSpinner spinnerAgilidadeComb;
    private javax.swing.JSpinner spinnerAgilidadeEsp;
    private javax.swing.JSpinner spinnerBlefeComb;
    private javax.swing.JSpinner spinnerBlefeEsp;
    private javax.swing.JSpinner spinnerConhecimentoComb;
    private javax.swing.JSpinner spinnerConhecimentoEsp;
    private javax.swing.JSpinner spinnerForcaComb;
    private javax.swing.JSpinner spinnerForcaEsp;
    private javax.swing.JSpinner spinnerFurtividade;
    private javax.swing.JSpinner spinnerInteligencia;
    private javax.swing.JSpinner spinnerLabia;
    private javax.swing.JSpinner spinnerPercepcao;
    private javax.swing.JSpinner spinnerResistencia;
    private javax.swing.JSpinner spinnerSobrevivencia;
    private javax.swing.JSpinner spinnerVontade;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables
}
