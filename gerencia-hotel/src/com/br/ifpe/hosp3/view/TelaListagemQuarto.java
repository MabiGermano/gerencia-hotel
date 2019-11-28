package com.br.ifpe.hosp3.view;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;
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
	public TelaListagemQuarto(TelaPrincipal desktop) {
		this();
		this.desktop = desktop;
	}

	private void listarQuartos() {
		Set<Quarto> listaQuartos = this.buscarQuartos();

		listaQuartos.stream().forEach(quarto -> {
			table.getColumn("Ações").setCellRenderer(new ButtonRenderer());
			table.getColumn("Ações").setCellEditor(new ButtonEditor(new JCheckBox()));
			Object[] objeto = new Object[] { quarto.getNumero(), quarto.getTipo(), quarto.getQuantidadePessoas(),
					quarto.getValor(), quarto.isDisponivel() ? "Sim" : "Não", "Editar" };
			modelTableQuarto.addRow(objeto);
			
			table.getColumn("Ações").getCellEditor().addCellEditorListener(new CellEditorListener() {

				@Override
				public void editingStopped(ChangeEvent e) {
					System.out.println("stop " + quarto.getId());
					modelTableQuarto.getDataVector().removeAllElements();
					modelTableQuarto.addRow(new Object[] { quarto.getNumero(), quarto.getTipo(),
							quarto.getQuantidadePessoas(), quarto.getValor(), "Ok" });
					TelaCriarQuarto alterarQuarto = new TelaCriarQuarto(quarto);
					desktop.getDesktop().add(alterarQuarto);
					alterarQuarto.setVisible(true);
					tratadorEventos = new TratadorEventos(desktop);
					alterarQuarto.addInternalFrameListener(tratadorEventos);
					
				}

				@Override
				public void editingCanceled(ChangeEvent e) {
					System.out.println("Cancel");

				}

			});
		});

		
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