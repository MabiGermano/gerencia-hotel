/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.ifpe.hosp3.view;
import java.awt.Color;

import javax.swing.JOptionPane;

import com.br.ifpe.hosp3.controller.HospedeController;
import com.br.ifpe.hosp3.model.Endereco;
import com.br.ifpe.hosp3.model.Hospede;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JInternalFrame;

/**
 *
 * @author Thaysa Gomes
 */
public class TelaCriarHospede extends javax.swing.JInternalFrame {


	/**
	 * Método de ação na interface para criar hospede 
	 * 
	 * @param hospede {@link Hospede}
	 * @param endereco {@link Endereco}
	 * 
	 * @throws Exception
	 **/
	public void criarHospede(Hospede hospede, Endereco endereco) {
		try {
			HospedeController.criarHospede(hospede, endereco);
			JOptionPane.showMessageDialog(null, "Hospede " + hospede.getNome() + "Cadastrado com Sucesso!");
			this.dispose();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			this.dispose();
		}
		
	}

    /**
     * Cria nova tela de Hóspede
     */
    public TelaCriarHospede() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	txtRuaHospede = new javax.swing.JTextField();
    	txtRuaHospede.setBounds(320, 210, 220, 20);
    	

    	lblEstadoHospede = new javax.swing.JLabel();
    	txtEstadoHospede = new javax.swing.JTextField();
        
    	lblBuscaCpfHospede = new javax.swing.JLabel();
    	lblBuscaCpfHospede.setBounds(25, 30, 19, 14);
    	txtBuscaCpfHospede = new javax.swing.JTextField();
    	txtBuscaCpfHospede.setBounds(25, 51, 162, 20);
        
        lblNomeHospede = new javax.swing.JLabel();
        lblNomeHospede.setBounds(25, 190, 27, 14);
        txtNomeHospede = new javax.swing.JTextField();
        txtNomeHospede.setBounds(25, 210, 247, 20);
        
        btnAddHospede = new javax.swing.JButton();
        btnAddHospede.setBounds(25, 411, 80, 50);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Hóspede");

        //btnAddHospede.setIcon(new javax.swing.ImageIcon(getClass().getResource("./../resources/img/"))); // NOI18N /*iconfinder*/
        btnAddHospede.setText("Adicionar");
        
        Color cor = new Color(46,139, 87);
        btnAddHospede.setBackground(cor);
        btnAddHospede.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddHospede.setPreferredSize(new java.awt.Dimension(80, 50));

       

        lblBuscaCpfHospede.setText("CPF");

        txtNomeHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeHospedeActionPerformed(evt);
            }
        });

        txtRuaHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRuaHospedeActionPerformed(evt);
            }
           
        });
        
       //Adicionando evento para botão de salvar ouvir
        btnAddHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnAddHospedeAction(evt);
            }
        });
        
        lblNomeHospede.setText("Nome");
        
        JLabel label = new JLabel();
        label.setBounds(320, 190, 19, 14);
        label.setText("CPF");
        
        JButton btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.setBounds(193, 50, 79, 23);
        getContentPane().setLayout(null);
        getContentPane().add(txtBuscaCpfHospede);
        getContentPane().add(btnPesquisar);
        getContentPane().add(lblBuscaCpfHospede);
        getContentPane().add(lblNomeHospede);
        getContentPane().add(txtNomeHospede);
        getContentPane().add(label);
        getContentPane().add(txtRuaHospede);
        getContentPane().add(btnAddHospede);
        
        lblEmailHospede = new JLabel("E-mail");
        lblEmailHospede.setBounds(25, 241, 46, 14);
        getContentPane().add(lblEmailHospede);
        
        txtEmailHospede = new JTextField();
        txtEmailHospede.setBounds(25, 259, 247, 20);
        getContentPane().add(txtEmailHospede);
        txtEmailHospede.setColumns(10);
        
        lblRua = new JLabel("Rua");
        lblRua.setBounds(320, 241, 46, 14);
        getContentPane().add(lblRua);
        
        textField_1 = new JTextField();
        textField_1.setBounds(320, 259, 220, 20);
        getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
        lblNumHospede = new JLabel("Número");
        lblNumHospede.setBounds(25, 293, 46, 14);
        getContentPane().add(lblNumHospede);
        
        txtNumHospede = new JTextField();
        txtNumHospede.setBounds(25, 310, 46, 20);
        getContentPane().add(txtNumHospede);
        txtNumHospede.setColumns(10);
        
        lblCepHospede = new JLabel("CEP");
        lblCepHospede.setBounds(103, 293, 46, 14);
        getContentPane().add(lblCepHospede);
        
        txtCepHospede = new JTextField();
        txtCepHospede.setBounds(103, 310, 107, 20);
        getContentPane().add(txtCepHospede);
        txtCepHospede.setColumns(10);
        
        lblBairroHospede = new JLabel("Bairro");
        lblBairroHospede.setBounds(237, 290, 46, 14);
        getContentPane().add(lblBairroHospede);
        
        txtBairroHospede = new JTextField();
        txtBairroHospede.setBounds(237, 310, 86, 20);
        getContentPane().add(txtBairroHospede);
        txtBairroHospede.setColumns(10);
        
        lblPaisHospede = new JLabel("País");
        lblPaisHospede.setBounds(347, 290, 46, 14);
        getContentPane().add(lblPaisHospede);
        
        txtPaisHospede = new JTextField();
        txtPaisHospede.setBounds(346, 310, 86, 20);
        getContentPane().add(txtPaisHospede);
        txtPaisHospede.setColumns(10);
        
        lblCidadeHospede = new JLabel("Cidade");
        lblCidadeHospede.setBounds(455, 293, 46, 14);
        getContentPane().add(lblCidadeHospede);
        
        txtCidadeHospede = new JTextField();
        txtCidadeHospede.setBounds(454, 310, 86, 20);
        getContentPane().add(txtCidadeHospede);
        txtCidadeHospede.setColumns(10);
        
        lblEstadoHospede = new JLabel("Estado");
        lblEstadoHospede.setBounds(25, 349, 46, 14);
        getContentPane().add(lblEstadoHospede);
        
        txtEstadoHospede = new JTextField();
        txtEstadoHospede.setBounds(25, 366, 86, 20);
        getContentPane().add(txtEstadoHospede);
        txtEstadoHospede.setColumns(10);
        
        lblPassHospede = new JLabel("Palavra passe");
        lblPassHospede.setBounds(454, 349, 79, 14);
        getContentPane().add(lblPassHospede);
        
        txtPassHospede = new JTextField();
        txtPassHospede.setBounds(454, 366, 86, 20);
        getContentPane().add(txtPassHospede);
        txtPassHospede.setColumns(10);
        
        lblCompHospede = new JLabel("Complemento");
        lblCompHospede.setBounds(121, 349, 86, 14);
        getContentPane().add(lblCompHospede);
        
        txtCompHospede = new JTextField();
        txtCompHospede.setBounds(121, 366, 155, 20);
        getContentPane().add(txtCompHospede);
        txtCompHospede.setColumns(10);
        
        lblTelHospede = new JLabel("Telefone");
        lblTelHospede.setBounds(296, 349, 134, 14);
        getContentPane().add(lblTelHospede);
        
        txtTelHospede = new JTextField();
        txtTelHospede.setBounds(296, 366, 134, 20);
        getContentPane().add(txtTelHospede);
        txtTelHospede.setColumns(10);

        pack();
    }

    private void txtNomeHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeHospedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeHospedeActionPerformed

    private void txtRuaHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRuaHospedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRuaHospedeActionPerformed

    private void btnAddHospedeAction(java.awt.event.ActionEvent evt) {
    	Endereco endereco = new Endereco();
    	endereco.setBairro(txtBairroHospede.getText());
    	endereco.setCep(txtCepHospede.getText());
    	endereco.setCidade(txtCidadeHospede.getText());
    	endereco.setEstado(txtEstadoHospede.getText());
    	endereco.setComplemento(txtCompHospede.getText());
    	endereco.setNumero(txtNumHospede.getText());
    	endereco.setPais(txtPaisHospede.getText());
    	endereco.setRua(txtRuaHospede.getText());
    	
    	Hospede hospede = new Hospede();
    	hospede.setCpf(txtBuscaCpfHospede.getText());
    	hospede.setEmail(txtEmailHospede.getText());
    	hospede.setNome(txtNomeHospede.getText());
    	hospede.setPalavraPasse(txtPassHospede.getText());
    	hospede.setTelefone(txtTelHospede.getText());
    	
    	
    	this.criarHospede(hospede, endereco);
    }

    
    private javax.swing.JButton btnAddHospede;
    private javax.swing.JLabel lblBuscaCpfHospede;
    private javax.swing.JLabel lblNomeHospede;
    private javax.swing.JTextField txtBuscaCpfHospede;
    private javax.swing.JTextField txtNomeHospede;
    private javax.swing.JTextField txtRuaHospede;
    private JLabel lblEmailHospede;
    private JTextField txtEmailHospede;
    private JLabel lblRua;
    private JTextField textField_1;
    private JLabel lblNumHospede;
    private JTextField txtNumHospede;
    private JLabel lblCepHospede;
    private JTextField txtCepHospede;
    private JLabel lblBairroHospede;
    private JTextField txtBairroHospede;
    private JLabel lblPaisHospede;
    private JTextField txtPaisHospede;
    private JLabel lblCidadeHospede;
    private JTextField txtCidadeHospede;
    private JLabel lblEstadoHospede;
    private JTextField txtEstadoHospede;
    private JLabel lblPassHospede;
    private JTextField txtPassHospede;
    private JLabel lblCompHospede;
    private JTextField txtCompHospede;
    private JLabel lblTelHospede;
    private JTextField txtTelHospede;
}
