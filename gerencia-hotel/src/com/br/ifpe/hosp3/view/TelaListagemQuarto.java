package com.br.ifpe.hosp3.view;

import java.awt.Component;
import java.util.HashSet;
import java.util.Set;

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
import com.jgoodies.forms.factories.DefaultComponentFactory;

/**
 * @author Maria Beatriz Germano Classe de interface gráfica para listagem de
 *         quartos
 **/
public class TelaListagemQuarto extends JInternalFrame {
	private JTable table;
	private DefaultTableModel modelTableQuarto;

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
		Set<Quarto> listaQuartos = this.buscarQuartos();
		table.getColumn("Ações").setCellRenderer(new ButtonRenderer());
		table.getColumn("Ações").setCellEditor(new ButtonEditor(new JCheckBox()));

		listaQuartos.stream().forEach(quarto -> {
			Object[] objeto = new Object[] { quarto.getNumero(), quarto.getTipo(), quarto.getQuantidadePessoas(),
					quarto.getValor(), quarto.isDisponivel() ? "Sim" : "Não", "Editar" };

			table.getColumn("Ações").getCellEditor().addCellEditorListener(new CellEditorListener() {

				@Override
				public void editingStopped(ChangeEvent e) {
					System.out.println("stop " + quarto.getId());
					modelTableQuarto.getDataVector().removeAllElements();
					modelTableQuarto.addRow(new Object[] { quarto.getNumero(), quarto.getTipo(),
							quarto.getQuantidadePessoas(), quarto.getValor(), "Ok" });
					TelaCriarQuarto alterarQuarto = new TelaCriarQuarto(quarto);
					alterarQuarto.setVisible(true);
					Component add;
				//	add = desktop.add(quarto);
					
				}

				@Override
				public void editingCanceled(ChangeEvent e) {
					System.out.println("Cancel");

				}

			});

			modelTableQuarto.addRow(objeto);
		});

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