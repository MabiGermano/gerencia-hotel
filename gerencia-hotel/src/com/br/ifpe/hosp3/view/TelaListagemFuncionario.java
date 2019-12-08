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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaListagemFuncionario extends JInternalFrame {
	private DefaultTableModel modelTableFuncionario;
	private JTable tableListaFuncionario;
	private JTextField txtBuscaNome;
	private JTextField txtBuscarCpf;

	/**
	 * Create the frame.
	 */
	public TelaListagemFuncionario() {
		setClosable(true);
		setBounds(100, 100, 644, 349);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JLabel lblFuncionarios = new JLabel("Funcionários");
		lblFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFuncionarios.setBounds(276, 11, 83, 26);
		panel.add(lblFuncionarios);
		
		txtBuscaNome = new JTextField();
		txtBuscaNome.setBounds(417, 48, 157, 25);
		panel.add(txtBuscaNome);
		txtBuscaNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Buscar Nome:");
		lblNome.setBounds(345, 52, 73, 14);
		panel.add(lblNome);
		
		JButton btnBuscarPorNome = new JButton("");
		btnBuscarPorNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/ifpe/hosp3/img/serch_p.png")));
		btnBuscarPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarPorNome.setBounds(584, 48, 32, 25);
		panel.add(btnBuscarPorNome);
		
		JLabel lblCpf = new JLabel("Buscar CPF:");
		lblCpf.setBounds(10, 52, 73, 14);
		panel.add(lblCpf);
		
		txtBuscarCpf = new JTextField();
		txtBuscarCpf.setBounds(74, 48, 157, 25);
		panel.add(txtBuscarCpf);
		txtBuscarCpf.setColumns(10);
		
		JButton btnBuscarPorCpf = new JButton("");
		btnBuscarPorCpf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/ifpe/hosp3/img/serch_p.png")));
		btnBuscarPorCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscarPorCpf.setBounds(242, 48, 32, 25);
		panel.add(btnBuscarPorCpf);
		
		JScrollPane scrollTableFuncionario = new JScrollPane();
		scrollTableFuncionario.setBounds(10, 82, 606, 224);
		panel.add(scrollTableFuncionario);
		
		tableListaFuncionario = new JTable();
		tableListaFuncionario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "CPF", "Email", "Telefone", "A\u00E7\u00F5es"
			}
		));
		scrollTableFuncionario.setViewportView(tableListaFuncionario);

	}

}
