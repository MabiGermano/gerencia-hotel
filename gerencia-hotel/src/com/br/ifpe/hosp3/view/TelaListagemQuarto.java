package com.br.ifpe.hosp3.view;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

import com.br.ifpe.hosp3.controller.QuartoController;
import com.br.ifpe.hosp3.model.Quarto;
import com.br.ifpe.hosp3.util.ButtonEditor;
import com.br.ifpe.hosp3.util.ButtonRenderer;
import com.br.ifpe.hosp3.util.TratadorEventos;
import com.jgoodies.forms.factories.DefaultComponentFactory;

/**
 * @author Maria Beatriz Germano Classe de interface gráfica para listagem de
 *         quartos
 **/
public class TelaListagemQuarto extends JInternalFrame {
	private JTable table;
	private DefaultTableModel modelTableQuarto;
	private TelaPrincipal desktop;
	private TratadorEventos tratadorEventos;
	private Map<String, Quarto> listaMap;

	/**
	 * Create the frame.
	 */
	public TelaListagemQuarto() {

		setClosable(true);
		this.setBounds(25, 100, 583, 300);

		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 577, 269);
		getContentPane().add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		JLabel lblQuartos = DefaultComponentFactory.getInstance().createTitle("Quartos");
		lblQuartos.setBounds(243, 12, 56, 14);
		panel.add(lblQuartos);

		JScrollPane scrollTableQuarto = new JScrollPane();
		scrollTableQuarto.setBounds(12, 52, 550, 202);
		panel.add(scrollTableQuarto);

		modelTableQuarto = new DefaultTableModel();
		modelTableQuarto.addColumn("Codigo");
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
	public TelaListagemQuarto(TelaPrincipal desktop) {
		this();
		this.desktop = desktop;
	}

	private void listarQuartos() {
		Set<Quarto> listaQuartos = this.buscarQuartos();
		listaMap = listaQuartos.stream()
				.collect(Collectors.toMap(Quarto::getHash,Function.identity()));


		listaMap.forEach((chave,quarto) -> {
			table.getColumn("Ações").setCellRenderer(new ButtonRenderer());
			table.getColumn("Ações").setCellEditor(new ButtonEditor(new JCheckBox()));
			Object[] objeto = new Object[] {chave,  quarto.getNumero(), quarto.getTipo(), quarto.getQuantidadePessoas(),
					quarto.getValor(), quarto.isDisponivel() ? "Sim" : "Não", "Editar"};
			modelTableQuarto.addRow(objeto);
			table.getColumn("Ações").getCellEditor().addCellEditorListener(new CellEditorListener() {
				
				@Override
				public void editingStopped(ChangeEvent e) {
					
					clickedButton(table.getValueAt(table.getSelectedRow(), 0).toString());
					
				}
				
				@Override
				public void editingCanceled(ChangeEvent e) {
					System.out.println("Cancel");
					
				}
				
			});
		});

		
	}
	private void clickedButton(String chave) {
		System.out.println("stop " + chave);
		Quarto quarto = listaMap.get(chave);
		
		TelaCriarQuarto alterarQuarto = new TelaCriarQuarto(quarto);
		
		alterarQuarto.setVisible(true);
		desktop.getDesktop().add(alterarQuarto);
		tratadorEventos = new TratadorEventos(desktop);
		alterarQuarto.addInternalFrameListener(tratadorEventos);
		modelTableQuarto.getDataVector().removeAllElements();
		modelTableQuarto.addRow(new Object[] { chave, quarto.getNumero(), quarto.getTipo(),
				quarto.getQuantidadePessoas(), quarto.getValor(), "Ok" });
	}

	private Set<Quarto> buscarQuartos() {
		Set<Quarto> listaQuartos = new HashSet<>();
		try {
			QuartoController quartoController = new QuartoController();
			listaQuartos = quartoController.listarQuartos();
		} catch (Exception e) {

		}
		return listaQuartos;
	}
}