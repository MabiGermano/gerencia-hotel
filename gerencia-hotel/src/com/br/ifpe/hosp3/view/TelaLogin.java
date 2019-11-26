/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.ifpe.hosp3.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.br.ifpe.hosp3.connection.ConexaoMysql;
import com.br.ifpe.hosp3.connection.EstruturaBD;
import com.br.ifpe.hosp3.controller.FuncionarioController;
import com.br.ifpe.hosp3.model.Funcionario;

/**
 *
 * @author Thaysa Gomes
 */
public class TelaLogin extends javax.swing.JFrame {
	Connection connection = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public void logar() {
		try {
			Funcionario funcionarioForm = new Funcionario(txtCodigo.getText(), txtSenha.getText());
			Funcionario funcionarioEncontrado = FuncionarioController.autentication(funcionarioForm);
			if (funcionarioEncontrado != null) {
				if (funcionarioEncontrado.getCargo() == "666") {
					TelaPrincipal principal = new TelaPrincipal(funcionarioEncontrado);
					principal.setVisible(true);
					TelaPrincipal.menuRelatorio.setEnabled(true);
					TelaPrincipal.menuCadastroFuncionario.setEnabled(true);
					TelaPrincipal.lblUsuario.setText(funcionarioEncontrado.getNome());
					this.dispose();
				} else {
					TelaPrincipal principal = new TelaPrincipal(funcionarioEncontrado);
					principal.setVisible(true);
					this.dispose();
				}
			}else {
				 JOptionPane.showMessageDialog(null, "OH-Ow Código ou senha incorretos... Tente novamente");
			}
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}
	
	public void resetarSistema() {
		try {
			EstruturaBD estrutura = new EstruturaBD();
			estrutura.criarBanco();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "N�o foi possivel resetar a base de dados");
		} 
		
		
		
	}

	/**
	 * Creates new form TelaLogin
	 * 
	 * @throws java.io.IOException
	 */

	public TelaLogin() throws IOException {
		initComponents();
		connection = ConexaoMysql.getConexaoMySQL();
		System.out.println(connection);

		if (connection != null) {
			lblStatus.setText("Conectado");
		} else {
			lblStatus.setText("Não conectado");
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Hotel Renascença ");
		setResizable(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{540, 0};
		gridBagLayout.rowHeights = new int[]{181, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		panel = new JPanel();
		panel.setLayout(null);
		lblImgLogin = new javax.swing.JLabel();
		lblImgLogin.setBounds(47, 17, 152, 152);
		panel.add(lblImgLogin);
		
				lblImgLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/ifpe/hosp3/img/logo.png")));
				lblSenhaLogin = new javax.swing.JLabel();
				lblSenhaLogin.setBounds(276, 81, 36, 14);
				panel.add(lblSenhaLogin);
				
						lblSenhaLogin.setText("Senha");
						lblC�digoLogin = new javax.swing.JLabel();
						lblC�digoLogin.setBounds(265, 43, 47, 14);
						panel.add(lblC�digoLogin);
						
								lblC�digoLogin.setText("C\u00F3digo");
								
										txtCodigo = new javax.swing.JTextField();
										txtCodigo.setBounds(330, 38, 164, 24);
										panel.add(txtCodigo);
										txtSenha = new javax.swing.JPasswordField();
										txtSenha.setBounds(330, 74, 164, 25);
										panel.add(txtSenha);
										loginButton = new javax.swing.JButton();
										loginButton.setBounds(424, 133, 70, 24);
										panel.add(loginButton);
										
												loginButton.setText("Entrar");
												loginButton.addActionListener(new java.awt.event.ActionListener() {
													public void actionPerformed(java.awt.event.ActionEvent evt) {
														loginButtonActionPerformed(evt);
													}
												});
												lblStatus = new javax.swing.JLabel();
												lblStatus.setBounds(451, 11, 79, 14);
												panel.add(lblStatus);
												
														lblStatus.setText("status");
														
																txtSenha.addActionListener(new java.awt.event.ActionListener() {
																	public void actionPerformed(java.awt.event.ActionEvent evt) {
																		txtSenhaActionPerformed(evt);
																	}
																});
																GridBagConstraints gbc_panel = new GridBagConstraints();
																gbc_panel.fill = GridBagConstraints.BOTH;
																gbc_panel.gridx = 0;
																gbc_panel.gridy = 0;
																getContentPane().add(panel, gbc_panel);
																
																JButton btnResetSistema = new JButton("Reset sistema");
																btnResetSistema.addActionListener(new ActionListener() {
																	
																	@Override
																	public void actionPerformed(ActionEvent e) {
																		actionResetSistema();
																		
																	}
																});
																btnResetSistema.setBounds(255, 134, 113, 23);
																panel.add(btnResetSistema);
																
																

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	private void actionResetSistema() {
		int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja resetar o sistema? Todos os dados ser�o apagados", "Alerta", JOptionPane.YES_NO_OPTION);
		
		if(confirm == JOptionPane.YES_OPTION) {
			
			resetarSistema();
		} 
	}
	private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtSenhaActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtSenhaActionPerformed

	private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginButtonActionPerformed
		logar();
	}// GEN-LAST:event_loginButtonActionPerformed

	
	private javax.swing.JLabel lblC�digoLogin;
	private javax.swing.JLabel lblSenhaLogin;
	private javax.swing.JLabel lblImgLogin;
	private javax.swing.JLabel lblStatus;
	private javax.swing.JButton loginButton;
	private javax.swing.JTextField txtCodigo;
	private javax.swing.JPasswordField txtSenha;
	private JPanel panel;
}
