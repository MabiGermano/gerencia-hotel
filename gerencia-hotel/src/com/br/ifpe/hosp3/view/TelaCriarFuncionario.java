package com.br.ifpe.hosp3.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCriarFuncionario extends JInternalFrame {
	private JTextField txtNomeFunc;
	private JTextField txtCpfFunc;
	private JTextField txtEmailFunc;
	private JTextField txtPassFunc;
	private JTextField txtCodFunc;
	private JTextField txtTelFunc;
	private JTextField txtCepFunc;
	private JTextField txtRuaFunc;
	private JTextField txtNumFunc;
	private JTextField txtBairroFunc;
	private JTextField txtCompFunc;
	private JTextField txtCidadeFunc;
	private JTextField txtEstadoFunc;
	private JTextField txtPaisFunc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCriarFuncionario frame = new TelaCriarFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
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
		
		JLabel lblCadastrarFuncionrio = new JLabel("Cadastrar Funcionário");
		lblCadastrarFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastrarFuncionrio.setBounds(182, 27, 144, 14);
		panel.add(lblCadastrarFuncionrio);
		
		JLabel lblNomeFunc = new JLabel("Nome");
		lblNomeFunc.setBounds(40, 65, 46, 14);
		panel.add(lblNomeFunc);
		
		txtNomeFunc = new JTextField();
		txtNomeFunc.setBounds(39, 81, 188, 20);
		panel.add(txtNomeFunc);
		txtNomeFunc.setColumns(10);
		
		JLabel lblCpfFunc = new JLabel("CPF");
		lblCpfFunc.setBounds(267, 65, 46, 14);
		panel.add(lblCpfFunc);
		
		txtCpfFunc = new JTextField();
		txtCpfFunc.setBounds(267, 81, 188, 20);
		panel.add(txtCpfFunc);
		txtCpfFunc.setColumns(10);
		
		JLabel lblEmailFunc = new JLabel("E-mail");
		lblEmailFunc.setBounds(40, 127, 46, 14);
		panel.add(lblEmailFunc);
		
		txtEmailFunc = new JTextField();
		txtEmailFunc.setBounds(40, 144, 187, 20);
		panel.add(txtEmailFunc);
		txtEmailFunc.setColumns(10);
		
		JLabel lblPassFunc = new JLabel("Palavra passe");
		lblPassFunc.setBounds(267, 127, 75, 14);
		panel.add(lblPassFunc);
		
		txtPassFunc = new JTextField();
		txtPassFunc.setBounds(267, 144, 188, 20);
		panel.add(txtPassFunc);
		txtPassFunc.setColumns(10);
		
		JLabel lblCodFunc = new JLabel("Código");
		lblCodFunc.setBounds(40, 190, 46, 14);
		panel.add(lblCodFunc);
		
		txtCodFunc = new JTextField();
		txtCodFunc.setBounds(40, 206, 66, 20);
		panel.add(txtCodFunc);
		txtCodFunc.setColumns(10);
		
		JLabel lblTelFunc = new JLabel("Telefone");
		lblTelFunc.setBounds(128, 190, 46, 14);
		panel.add(lblTelFunc);
		
		txtTelFunc = new JTextField();
		txtTelFunc.setBounds(128, 206, 144, 20);
		panel.add(txtTelFunc);
		txtTelFunc.setColumns(10);
		
		JLabel lblCepFunc = new JLabel("CEP");
		lblCepFunc.setBounds(296, 190, 46, 14);
		panel.add(lblCepFunc);
		
		txtCepFunc = new JTextField();
		txtCepFunc.setBounds(296, 206, 159, 20);
		panel.add(txtCepFunc);
		txtCepFunc.setColumns(10);
		
		JLabel lblRuaFunc = new JLabel("Rua");
		lblRuaFunc.setBounds(40, 249, 46, 14);
		panel.add(lblRuaFunc);
		
		txtRuaFunc = new JTextField();
		txtRuaFunc.setBounds(40, 265, 232, 20);
		panel.add(txtRuaFunc);
		txtRuaFunc.setColumns(10);
		
		JLabel lblNumFunc = new JLabel("Número");
		lblNumFunc.setBounds(293, 249, 46, 14);
		panel.add(lblNumFunc);
		
		txtNumFunc = new JTextField();
		txtNumFunc.setBounds(291, 265, 51, 20);
		panel.add(txtNumFunc);
		txtNumFunc.setColumns(10);
		
		JLabel lblBairroFunc = new JLabel("Bairro");
		lblBairroFunc.setBounds(355, 249, 46, 14);
		panel.add(lblBairroFunc);
		
		txtBairroFunc = new JTextField();
		txtBairroFunc.setBounds(355, 265, 100, 20);
		panel.add(txtBairroFunc);
		txtBairroFunc.setColumns(10);
		
		JLabel lblCompFunc = new JLabel("Complemento");
		lblCompFunc.setBounds(40, 306, 66, 14);
		panel.add(lblCompFunc);
		
		txtCompFunc = new JTextField();
		txtCompFunc.setBounds(38, 322, 234, 20);
		panel.add(txtCompFunc);
		txtCompFunc.setColumns(10);
		
		JLabel lblCidadeFunc = new JLabel("Cidade");
		lblCidadeFunc.setBounds(293, 306, 46, 14);
		panel.add(lblCidadeFunc);
		
		txtCidadeFunc = new JTextField();
		txtCidadeFunc.setBounds(293, 322, 162, 20);
		panel.add(txtCidadeFunc);
		txtCidadeFunc.setColumns(10);
		
		JLabel lblEstadoFunc = new JLabel("Estado");
		lblEstadoFunc.setBounds(40, 364, 46, 14);
		panel.add(lblEstadoFunc);
		
		txtEstadoFunc = new JTextField();
		txtEstadoFunc.setBounds(38, 379, 86, 20);
		panel.add(txtEstadoFunc);
		txtEstadoFunc.setColumns(10);
		
		JLabel lblPaisFunc = new JLabel("País");
		lblPaisFunc.setBounds(155, 364, 46, 14);
		panel.add(lblPaisFunc);
		
		txtPaisFunc = new JTextField();
		txtPaisFunc.setBounds(155, 379, 114, 20);
		panel.add(txtPaisFunc);
		txtPaisFunc.setColumns(10);
		
		JButton btnCancelarFunc = new JButton("Cancelar");
		btnCancelarFunc.setBounds(267, 420, 89, 36);
		panel.add(btnCancelarFunc);
		
		JButton btnAdicionarFunc = new JButton("Adicionar");
		btnAdicionarFunc.setBounds(366, 420, 89, 36);
		panel.add(btnAdicionarFunc);

	}
}
