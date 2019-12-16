package com.br.ifpe.hosp3.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;


import com.br.ifpe.hosp3.controller.RegistroHospedagemController;
import com.br.ifpe.hosp3.model.Hospedagem;

import com.br.ifpe.hosp3.util.ButtonEditor;
import com.br.ifpe.hosp3.util.ButtonRenderer;

public class TelaListagemHospedagem extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelTableHospedagem;
	private JTable tableListaHospedagem;
	private JTextField txtBuscaCpf;
	private JTextField txtBuscarNumQuarto;
	private RegistroHospedagemController registroHospedagemController = new RegistroHospedagemController();
	private Hospedagem hospedagem;

	/**
	 * Cria tela de listagem de hospedagem.
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
		
		modelTableHospedagem = new DefaultTableModel();
		modelTableHospedagem.addColumn("Hóspede");
		modelTableHospedagem.addColumn("Nº Quarto");
		modelTableHospedagem.addColumn("Valor");
		modelTableHospedagem.addColumn("Ações");
		
		tableListaHospedagem = new JTable(modelTableHospedagem);
		scrollTableHospedagem.setViewportView(tableListaHospedagem);
		
		listarHospedagens();
	}
	
	/**
	 * Método para listar hospedagens.
	 * 
	 **/
	private void listarHospedagens() {
		Set<Hospedagem> listaHospedagens = this.buscarHospedagens();
		tableListaHospedagem.getColumn("Ações").setCellRenderer(new ButtonRenderer());
		tableListaHospedagem.getColumn("Ações").setCellEditor(new ButtonEditor(new JCheckBox()));
		
		listaHospedagens.stream().forEach(hospedagem -> {
			Object[] objeto = new Object[] { hospedagem.getHospede(), hospedagem.getQuarto(), "", "Editar"};
			
			tableListaHospedagem.getColumn("Ações").getCellEditor().addCellEditorListener(new CellEditorListener() {

				@Override
				public void editingCanceled(ChangeEvent arg0) {
					System.out.println("stop " + hospedagem.getId());
					modelTableHospedagem.getDataVector().removeAllElements();
					modelTableHospedagem.addRow(new Object[] { hospedagem.getHospede(), hospedagem.getQuarto(), "", "Ok"});
					TelaCriarHospedagem alterarHospedagem = new TelaCriarHospedagem();
					alterarHospedagem.setVisible(true);
					Component add;
				}

				@Override
				public void editingStopped(ChangeEvent arg0) {
					System.out.println("Cancel");
		
				}
			});
			
			modelTableHospedagem.addRow(objeto);
		});
	}
	
	/**
	 * Método para buscar hospedagens.
	 * 
	 * @return listaHospedagens {@link Set<Hospedagem>}
	 **/
	private Set<Hospedagem> buscarHospedagens() {
		Set<Hospedagem> listaHospedagens = new HashSet<>();
		try {
			listaHospedagens = registroHospedagemController.listarHospedagens();
		} catch (Exception e) {

		}
		return listaHospedagens;
	}

}
