package com.br.ifpe.hosp3.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.br.ifpe.hosp3.controller.HospedeController;
import com.br.ifpe.hosp3.model.Hospede;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class TelaListagemHospede extends JInternalFrame {
	private DefaultTableModel modelTableHospede;
	private JTable tableListaHospede;
	private JTextField txtBuscaNome;
	private JTextField txtBuscarCpf;

	/**
	 * Create the frame.
	 */
	public TelaListagemHospede() {
		setBounds(100, 100, 644, 349);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JLabel lblHspedes = new JLabel("Hóspedes");
		lblHspedes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHspedes.setBounds(276, 11, 73, 26);
		panel.add(lblHspedes);
		
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
		
		JScrollPane scrollTableHospede = new JScrollPane();
		scrollTableHospede.setBounds(10, 82, 606, 224);
		panel.add(scrollTableHospede);
		
		tableListaHospede = new JTable();
		tableListaHospede.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF", "Email", "Endere\u00E7o", "Telefone", "A\u00E7\u00F5es"
			}
		));
		scrollTableHospede.setViewportView(tableListaHospede);
		
		

	}
}
