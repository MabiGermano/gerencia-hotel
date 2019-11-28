package com.br.ifpe.hosp3.view;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.br.ifpe.hosp3.controller.FuncionarioController;
import com.br.ifpe.hosp3.model.Funcionario;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class TelaListagemFuncionario extends JInternalFrame {
	private DefaultTableModel modelTableFuncionario;
	private JTable tableListaFuncionario;
	private JTextField txtBuscaNome;
	private JTextField txtBuscarCpf;

	/**
	 * Create the frame.
	 */
	public TelaListagemFuncionario() {
		setBounds(100, 100, 644, 349);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JLabel lblFuncionarios = new JLabel("Funcionários");
		lblFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFuncionarios.setBounds(276, 11, 95, 26);
		panel.add(lblFuncionarios);
		
		txtBuscaNome = new JTextField();
		txtBuscaNome.setBounds(319, 48, 157, 23);
		panel.add(txtBuscaNome);
		txtBuscaNome.setColumns(10);
		
		JButton btnBuscarPorNome = new JButton("Buscar Nome");
		btnBuscarPorNome.setBounds(487, 47, 95, 23);
		panel.add(btnBuscarPorNome);
		
		txtBuscarCpf = new JTextField();
		txtBuscarCpf.setBounds(39, 48, 157, 23);
		panel.add(txtBuscarCpf);
		txtBuscarCpf.setColumns(10);
		
		JButton btnBuscarPorCpf = new JButton("Buscar CPF");
		btnBuscarPorCpf.setBounds(206, 48, 95, 23);
		panel.add(btnBuscarPorCpf);
		
		JScrollPane scrollTableFuncionario = new JScrollPane();
		scrollTableFuncionario.setBounds(10, 82, 606, 224);
		panel.add(scrollTableFuncionario);
		
		tableListaFuncionario = new JTable();
		tableListaFuncionario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF", "Email", "Endere\u00E7o", "Telefone", "A\u00E7\u00F5es"
			}
		));
		scrollTableFuncionario.setViewportView(tableListaFuncionario);

	}

}
