package com.br.ifpe.hosp3.view;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaListagemHospedagem extends JInternalFrame {
	private DefaultTableModel modelTableHospedagem;
	private JTable tableListaHospedagem;
	private JTextField txtBuscaCpf;
	private JTextField txtBuscarNumQuarto;

	/**
	 * Create the frame.
	 */
	public TelaListagemHospedagem() {
		setClosable(true);
		setBounds(-5, 75, 644, 349);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JLabel lblHospedagens = new JLabel("Hospedagens");
		lblHospedagens.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHospedagens.setBounds(276, 11, 83, 26);
		panel.add(lblHospedagens);
		
		txtBuscaCpf = new JTextField();
		txtBuscaCpf.setBounds(417, 48, 157, 25);
		panel.add(txtBuscaCpf);
		txtBuscaCpf.setColumns(10);
		
		JLabel lblCpf = new JLabel("Buscar CPF:");
		lblCpf.setBounds(345, 52, 73, 14);
		panel.add(lblCpf);
		
		JButton btnBuscarPorCpf = new JButton("");
		btnBuscarPorCpf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/ifpe/hosp3/img/serch_p.png")));
		btnBuscarPorCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarPorCpf.setBounds(584, 48, 32, 25);
		panel.add(btnBuscarPorCpf);
		
		JLabel lblNumQuarto = new JLabel("Buscar nº Quarto:");
		lblNumQuarto.setBounds(10, 52, 97, 14);
		panel.add(lblNumQuarto);
		
		txtBuscarNumQuarto = new JTextField();
		txtBuscarNumQuarto.setBounds(108, 48, 157, 25);
		panel.add(txtBuscarNumQuarto);
		txtBuscarNumQuarto.setColumns(10);
		
		JButton btnBuscarPorNumQuarto = new JButton("");
		btnBuscarPorNumQuarto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/ifpe/hosp3/img/serch_p.png")));
		btnBuscarPorNumQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscarPorNumQuarto.setBounds(275, 48, 32, 25);
		panel.add(btnBuscarPorNumQuarto);
		
		JScrollPane scrollTableHospedagem = new JScrollPane();
		scrollTableHospedagem.setBounds(10, 82, 606, 224);
		panel.add(scrollTableHospedagem);
		
		tableListaHospedagem = new JTable();
		tableListaHospedagem.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				
			}
		));
		scrollTableHospedagem.setViewportView(tableListaHospedagem);


	}

}
