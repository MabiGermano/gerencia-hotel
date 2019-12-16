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
		setBounds(35, 10, 527, 379);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 511, 488);
		getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Cadastrar Funcionário");
		label.setBounds(174, 11, 142, 19);
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel.add(label);
		
		JLabel lblNomeFunc = new JLabel("Nome");
		lblNomeFunc.setBounds(30, 41, 47, 14);
		panel.add(lblNomeFunc);
		
		txtNomeFunc = new JTextField();
		txtNomeFunc.setBounds(30, 57, 206, 25);
		txtNomeFunc.setColumns(10);
		panel.add(txtNomeFunc);
		
		JLabel lblCpfFunc = new JLabel("CPF");
		lblCpfFunc.setBounds(266, 41, 36, 14);
		panel.add(lblCpfFunc);
		
		txtCpfFunc = new JTextField();
		txtCpfFunc.setBounds(266, 57, 200, 25);
		txtCpfFunc.setColumns(10);
		panel.add(txtCpfFunc);
		
		JLabel lblRuaFunc = new JLabel("Rua");
		lblRuaFunc.setBounds(30, 88, 206, 14);
		panel.add(lblRuaFunc);
		
		txtRuaFunc = new JTextField();
		txtRuaFunc.setBounds(30, 104, 206, 25);
		panel.add(txtRuaFunc);
		txtRuaFunc.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(260, 188, 46, 14);
		panel.add(lblEmail);
		
		txtEmailFunc = new JTextField();
		txtEmailFunc.setBounds(260, 204, 206, 25);
		panel.add(txtEmailFunc);
		txtEmailFunc.setColumns(10);
		
		JLabel lblNumFunc = new JLabel("Número");
		lblNumFunc.setBounds(266, 88, 46, 14);
		panel.add(lblNumFunc);
		
		txtNumFunc = new JTextField();
		txtNumFunc.setBounds(266, 105, 46, 24);
		panel.add(txtNumFunc);
		txtNumFunc.setColumns(10);
		
		JLabel lblCepFunc = new JLabel("CEP");
		lblCepFunc.setBounds(329, 88, 46, 14);
		panel.add(lblCepFunc);
		
		txtCepFunc = new JTextField();
		txtCepFunc.setBounds(327, 105, 139, 24);
		panel.add(txtCepFunc);
		txtCepFunc.setColumns(10);
		
		JLabel lblBairroFunc = new JLabel("Bairro");
		lblBairroFunc.setBounds(31, 140, 46, 14);
		panel.add(lblBairroFunc);
		
		txtBairroFunc = new JTextField();
		txtBairroFunc.setBounds(30, 157, 97, 25);
		panel.add(txtBairroFunc);
		txtBairroFunc.setColumns(10);
		
		JLabel lblPaisFunc = new JLabel("País");
		lblPaisFunc.setBounds(137, 140, 46, 14);
		panel.add(lblPaisFunc);
		
		txtPaisFunc = new JTextField();
		txtPaisFunc.setBounds(137, 157, 94, 25);
		panel.add(txtPaisFunc);
		txtPaisFunc.setColumns(10);
		
		JLabel lblCidadeFunc = new JLabel("Cidade");
		lblCidadeFunc.setBounds(260, 141, 46, 14);
		panel.add(lblCidadeFunc);
		
		txtCidadeFunc = new JTextField();
		txtCidadeFunc.setBounds(260, 156, 110, 25);
		panel.add(txtCidadeFunc);
		txtCidadeFunc.setColumns(10);
		
		txtEstadoFunc = new JTextField();
		txtEstadoFunc.setBounds(380, 156, 86, 25);
		panel.add(txtEstadoFunc);
		txtEstadoFunc.setColumns(10);
		
		JLabel lblEstadoFunc = new JLabel("Estado");
		lblEstadoFunc.setBounds(380, 140, 46, 14);
		panel.add(lblEstadoFunc);
		
		txtCompFunc = new JTextField();
		txtCompFunc.setBounds(30, 204, 200, 25);
		panel.add(txtCompFunc);
		txtCompFunc.setColumns(10);
		
		JLabel lblCompFunc = new JLabel("Complemento");
		lblCompFunc.setBounds(30, 189, 97, 14);
		panel.add(lblCompFunc);
		
		JLabel lblTelFunc = new JLabel("Telefone");
		lblTelFunc.setBounds(30, 234, 69, 14);
		panel.add(lblTelFunc);
		
		txtTelFunc = new JTextField();
		txtTelFunc.setBounds(30, 253, 134, 25);
		panel.add(txtTelFunc);
		txtTelFunc.setColumns(10);
		
		JLabel lblCodFunc = new JLabel("Código");
		lblCodFunc.setBounds(174, 234, 46, 14);
		panel.add(lblCodFunc);
		
		txtCodFunc = new JTextField();
		txtCodFunc.setBounds(174, 253, 56, 25);
		panel.add(txtCodFunc);
		txtCodFunc.setColumns(10);
		
		JLabel lblCargoFunc = new JLabel("Cargo");
		lblCargoFunc.setBounds(260, 234, 46, 14);
		panel.add(lblCargoFunc);
		
		txtCargoFunc = new JTextField();
		txtCargoFunc.setBounds(260, 253, 86, 25);
		panel.add(txtCargoFunc);
		txtCargoFunc.setColumns(10);
		
		JLabel lblPassFunc = new JLabel("Palavra passe");
		lblPassFunc.setBounds(366, 234, 100, 14);
		panel.add(lblPassFunc);
		
		txtPassFunc = new JTextField();
		txtPassFunc.setBounds(365, 253, 94, 25);
		panel.add(txtPassFunc);
		txtPassFunc.setColumns(10);
		
		JButton btnCancelarFunc = new JButton("Cancelar");
		btnCancelarFunc.setBounds(277, 301, 89, 31);
		panel.add(btnCancelarFunc);
		
		JButton btnAdicionarFunc = new JButton("Adicionar");
		btnAdicionarFunc.setBounds(377, 301, 89, 31);
		panel.add(btnAdicionarFunc);

	}
}
