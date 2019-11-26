package com.br.ifpe.hosp3.view;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.br.ifpe.hosp3.controller.QuartoController;
import com.br.ifpe.hosp3.model.Quarto;
import com.br.ifpe.hosp3.util.ButtonEditor;
import com.br.ifpe.hosp3.util.ButtonRenderer;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class TelaListagemQuarto extends JInternalFrame {
	private JTable table;
	private DefaultTableModel modelTableQuarto;

	/**
	 * Create the frame.
	 */
	public TelaListagemQuarto() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 440, 269);
		getContentPane().add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		JLabel lblQuartos = DefaultComponentFactory.getInstance().createTitle("Quartos");
		lblQuartos.setBounds(199, 18, 106, 14);
		panel.add(lblQuartos);
		
		JScrollPane scrollTableQuarto = new JScrollPane();
		scrollTableQuarto.setBounds(12, 52, 413, 150);
		panel.add(scrollTableQuarto);
		
		
		modelTableQuarto = new DefaultTableModel();
	    modelTableQuarto.addColumn("Número");
	    modelTableQuarto.addColumn("Tipo");
	    modelTableQuarto.addColumn("Qtd. Pessoas");
	    modelTableQuarto.addColumn("Valor");
	    modelTableQuarto.addColumn("Disponível");
	    modelTableQuarto.addColumn("Ações");
	    
		table = new JTable(modelTableQuarto);
		scrollTableQuarto.setViewportView(table);

		listarQuartos();
	}

	private void listarQuartos() {
		Set<Quarto> listaQuartos  = this.buscarQuartos();
		table.getColumn("Ações").setCellRenderer(new ButtonRenderer());
		table.getColumn("Ações").setCellEditor(new ButtonEditor(new JCheckBox()));
		
		listaQuartos.stream().map(quarto -> new Object[]{quarto.getNumero(), quarto.getTipo(), 
	    							quarto.getQuantidadePessoas() ,quarto.getValor(), "selecionar"})
	    .forEach(quarto -> modelTableQuarto.addRow(quarto));
	}

	private Set<Quarto> buscarQuartos() {

		Set<Quarto> listaQuartos = new HashSet<>();
		try {
			listaQuartos = QuartoController.listarQuartos();
		} catch (Exception e) {

		}
		return listaQuartos;
	}
}
