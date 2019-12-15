package com.br.ifpe.hosp3.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.br.ifpe.hosp3.model.Funcionario;
import javax.swing.JScrollBar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class TelaCriarFuncionario extends JInternalFrame {
	private JTextField txtNomeFunc;
	private JTextField txtCpfFunc;
	private JTextField txtRuaFunc;
	private JTextField txtEmailFunc;
	private JTextField txtNumFunc;
	private JTextField txtCepFunc;
	private JTextField txtBairroFunc;
	private JTextField txtPaisFunc;
	private JTextField txtCidadeFunc;
	private JTextField txtEstadoFunc;
	private JTextField txtCompFunc;
	private JTextField txtTelFunc;
	private JTextField txtCodFunc;
	private JTextField txtCargoFunc;
	private JTextField txtPassFunc;

	public TelaCriarFuncionario(Funcionario funcionario) {
		this();
	}
	public TelaCriarFuncionario() {
		setClosable(true);
		setBounds(100, 100, 527, 352);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 511, 488);
		getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Cadastrar Funcionário");
		label.setBounds(174, 31, 142, 19);
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel.add(label);
		
		JLabel lblNomeFunc = new JLabel("Nome");
		lblNomeFunc.setBounds(30, 72, 27, 14);
		panel.add(lblNomeFunc);
		
		txtNomeFunc = new JTextField();
		txtNomeFunc.setBounds(30, 88, 206, 20);
		txtNomeFunc.setColumns(10);
		panel.add(txtNomeFunc);
		
		JLabel lblCpfFunc = new JLabel("CPF");
		lblCpfFunc.setBounds(266, 72, 19, 14);
		panel.add(lblCpfFunc);
		
		txtCpfFunc = new JTextField();
		txtCpfFunc.setBounds(266, 88, 200, 20);
		txtCpfFunc.setColumns(10);
		panel.add(txtCpfFunc);
		
		JLabel lblRuaFunc = new JLabel("Rua");
		lblRuaFunc.setBounds(30, 119, 206, 14);
		panel.add(lblRuaFunc);
		
		txtRuaFunc = new JTextField();
		txtRuaFunc.setBounds(30, 135, 206, 20);
		panel.add(txtRuaFunc);
		txtRuaFunc.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(260, 213, 46, 14);
		panel.add(lblEmail);
		
		txtEmailFunc = new JTextField();
		txtEmailFunc.setBounds(260, 229, 206, 20);
		panel.add(txtEmailFunc);
		txtEmailFunc.setColumns(10);
		
		JLabel lblNumFunc = new JLabel("Número");
		lblNumFunc.setBounds(266, 119, 46, 14);
		panel.add(lblNumFunc);
		
		txtNumFunc = new JTextField();
		txtNumFunc.setBounds(266, 136, 46, 20);
		panel.add(txtNumFunc);
		txtNumFunc.setColumns(10);
		
		JLabel lblCepFunc = new JLabel("CEP");
		lblCepFunc.setBounds(329, 119, 46, 14);
		panel.add(lblCepFunc);
		
		txtCepFunc = new JTextField();
		txtCepFunc.setBounds(327, 136, 139, 20);
		panel.add(txtCepFunc);
		txtCepFunc.setColumns(10);
		
		JLabel lblBairroFunc = new JLabel("Bairro");
		lblBairroFunc.setBounds(31, 166, 46, 14);
		panel.add(lblBairroFunc);
		
		txtBairroFunc = new JTextField();
		txtBairroFunc.setBounds(30, 183, 97, 20);
		panel.add(txtBairroFunc);
		txtBairroFunc.setColumns(10);
		
		JLabel lblPaisFunc = new JLabel("País");
		lblPaisFunc.setBounds(137, 166, 46, 14);
		panel.add(lblPaisFunc);
		
		txtPaisFunc = new JTextField();
		txtPaisFunc.setBounds(137, 183, 94, 20);
		panel.add(txtPaisFunc);
		txtPaisFunc.setColumns(10);
		
		JLabel lblCidadeFunc = new JLabel("Cidade");
		lblCidadeFunc.setBounds(260, 167, 46, 14);
		panel.add(lblCidadeFunc);
		
		txtCidadeFunc = new JTextField();
		txtCidadeFunc.setBounds(260, 182, 110, 20);
		panel.add(txtCidadeFunc);
		txtCidadeFunc.setColumns(10);
		
		txtEstadoFunc = new JTextField();
		txtEstadoFunc.setBounds(380, 182, 86, 20);
		panel.add(txtEstadoFunc);
		txtEstadoFunc.setColumns(10);
		
		JLabel lblEstadoFunc = new JLabel("Estado");
		lblEstadoFunc.setBounds(380, 166, 46, 14);
		panel.add(lblEstadoFunc);
		
		txtCompFunc = new JTextField();
		txtCompFunc.setBounds(30, 229, 200, 20);
		panel.add(txtCompFunc);
		txtCompFunc.setColumns(10);
		
		JLabel lblCompFunc = new JLabel("Complemento");
		lblCompFunc.setBounds(30, 214, 65, 14);
		panel.add(lblCompFunc);
		
		JLabel lblTelFunc = new JLabel("Telefone");
		lblTelFunc.setBounds(30, 260, 46, 14);
		panel.add(lblTelFunc);
		
		txtTelFunc = new JTextField();
		txtTelFunc.setBounds(30, 279, 134, 20);
		panel.add(txtTelFunc);
		txtTelFunc.setColumns(10);
		
		JLabel lblCodFunc = new JLabel("Código");
		lblCodFunc.setBounds(174, 260, 46, 14);
		panel.add(lblCodFunc);
		
		txtCodFunc = new JTextField();
		txtCodFunc.setBounds(174, 279, 56, 20);
		panel.add(txtCodFunc);
		txtCodFunc.setColumns(10);
		
		JLabel lblCargoFunc = new JLabel("Cargo");
		lblCargoFunc.setBounds(260, 260, 46, 14);
		panel.add(lblCargoFunc);
		
		txtCargoFunc = new JTextField();
		txtCargoFunc.setBounds(260, 279, 86, 20);
		panel.add(txtCargoFunc);
		txtCargoFunc.setColumns(10);
		
		JLabel lblPassFunc = new JLabel("Palavra passe");
		lblPassFunc.setBounds(366, 260, 100, 14);
		panel.add(lblPassFunc);
		
		txtPassFunc = new JTextField();
		txtPassFunc.setBounds(365, 279, 94, 20);
		panel.add(txtPassFunc);
		txtPassFunc.setColumns(10);
		
		JButton btnCancelarFunc = new JButton("Cancelar");
		btnCancelarFunc.setBounds(280, 310, 89, 39);
		panel.add(btnCancelarFunc);
		
		JButton btnAdicionarFunc = new JButton("Adicionar");
		btnAdicionarFunc.setBounds(380, 310, 89, 31);
		panel.add(btnAdicionarFunc);

	}
}
