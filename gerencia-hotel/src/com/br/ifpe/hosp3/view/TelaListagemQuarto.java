package com.br.ifpe.hosp3.view;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
 * @author Maria Beatriz Germano 
 * Classe de interface gráfica para listagem de
 *         quartos
 **/
public class TelaListagemQuarto extends JInternalFrame {
	private JTable table;
	private DefaultTableModel modelTableQuarto;
	private TelaPrincipal desktop;
	private TratadorEventos tratadorEventos;
	private Map<String, Quarto> listaMap;
	private QuartoController quartoController = new QuartoController();

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
		modelTableQuarto.addColumn("HashCode");
		modelTableQuarto.addColumn("Número");
		modelTableQuarto.addColumn("Tipo");
		modelTableQuarto.addColumn("Qtd. Pessoas");
		modelTableQuarto.addColumn("Valor");
		modelTableQuarto.addColumn("Disponível");
		modelTableQuarto.addColumn("Editar");
		modelTableQuarto.addColumn("Excluir");
		
		table = new JTable(modelTableQuarto);
		scrollTableQuarto.setViewportView(table);

		listarQuartos();
	}
	public TelaListagemQuarto(TelaPrincipal desktop) {
		this();
		this.desktop = desktop;
	}

	/**
	 * Método para Listar os quartos
	 **/
	private void listarQuartos() {
		Set<Quarto> listaQuartos = this.buscarQuartos();
		listaMap = listaQuartos.stream()
				.collect(Collectors.toMap(Quarto::getHash,Function.identity()));


		listaMap.forEach((chave,quarto) -> {
			table.getColumn("Editar").setCellRenderer(new ButtonRenderer());
			table.getColumn("Editar").setCellEditor(new ButtonEditor(new JCheckBox()));
					
			table.getColumn("Excluir").setCellRenderer(new ButtonRenderer());
			table.getColumn("Excluir").setCellEditor(new ButtonEditor(new JCheckBox()));

			Object[] objeto = new Object[] {chave,  quarto.getNumero(), quarto.getTipo(), quarto.getQuantidadePessoas(),
					quarto.getValor(), quarto.isDisponivel() ? "Sim" : "Não", "Editar", "Excluir"};
			modelTableQuarto.addRow(objeto);
			table.getColumn("Editar").getCellEditor().addCellEditorListener(new CellEditorListener() {
				
				@Override
				public void editingStopped(ChangeEvent e) {
					
					clickedButtonEdit(table.getValueAt(table.getSelectedRow(), 0).toString());
					
				}
				
				@Override
				public void editingCanceled(ChangeEvent e) {
					System.out.println("Cancel");
					
				}
				
			});
			table.getColumn("Excluir").getCellEditor().addCellEditorListener(new CellEditorListener() {

				@Override
				public void editingStopped(ChangeEvent e) {

					clickedButtonDelete(table.getValueAt(table.getSelectedRow(), 0).toString());

				}

				@Override
				public void editingCanceled(ChangeEvent e) {
					System.out.println("Cancel");

				}

			});
		});

		
	}
	/**
	 * Método contendo a lógica de visualização a partir do clique
	 * no botão de editar.
	 * 
	 * @param chave {@link String}
	 **/
	private void clickedButtonEdit(String chave) {
		System.out.println("stop " + chave);
		Quarto quarto = listaMap.get(chave);
		
		TelaCriarQuarto alterarQuarto = new TelaCriarQuarto(quarto);
		
		alterarQuarto.setVisible(true);
		desktop.getDesktop().add(alterarQuarto);
		tratadorEventos = new TratadorEventos(desktop);
		alterarQuarto.addInternalFrameListener(tratadorEventos);
		modelTableQuarto.setRowCount(0);
		listarQuartos();
	}
	
	/**
	 * Método contendo a lógica de deleção a partir do clique
	 * no botão de excluir.
	 * 
	 * @param chave {@link String}
	 **/
	private void clickedButtonDelete(String chave) {
		System.out.println("stop " + chave);
		Quarto quarto = listaMap.get(chave);
		try {
			int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o quarto " 
														+ quarto.getNumero() + "?");
			if(confirm == JOptionPane.YES_OPTION) {
				quartoController.deleteQuarto(quarto);
			}
			
			modelTableQuarto.setRowCount(0);
			listarQuartos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		

		
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