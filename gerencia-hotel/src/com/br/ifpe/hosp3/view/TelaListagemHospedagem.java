package com.br.ifpe.hosp3.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;


import com.br.ifpe.hosp3.controller.RegistroHospedagemController;
import com.br.ifpe.hosp3.model.Hospedagem;
import com.br.ifpe.hosp3.model.Hospede;
import com.br.ifpe.hosp3.model.Registro;
import com.br.ifpe.hosp3.util.ButtonEditor;
import com.br.ifpe.hosp3.util.ButtonRenderer;
import com.br.ifpe.hosp3.util.TratadorEventos;

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
	private Map<String, Registro> listaMap;
	private TelaPrincipal desktop;
	private TratadorEventos tratadorEventos;
	

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
		modelTableHospedagem.addColumn("Editar");
		modelTableHospedagem.addColumn("Excluir");
		
		tableListaHospedagem = new JTable(modelTableHospedagem);
		scrollTableHospedagem.setViewportView(tableListaHospedagem);
		
		listarHospedagens(this.buscarHospedagens());
	}
	public TelaListagemHospedagem(TelaPrincipal desktop) {
		this();
		this.desktop = desktop;
	}
	
	public TelaListagemHospedagem(TelaPrincipal telaPrincipal) {
		this.desktop = telaPrincipal;
	}

	/**
	 * Método para listar hospedagens.
	 * 
	 **/
	private void listarHospedagens(Set<Registro> lista) {
		Set<Registro> listaHospedagens = lista;
		listaMap = listaHospedagens.stream()
				.collect(Collectors.toMap(Registro::getHash,Function.identity()));
		
		listaMap.forEach((chave, registro) -> {
			tableListaHospedagem.getColumn("Editar").setCellRenderer(new ButtonRenderer());
			tableListaHospedagem.getColumn("Editar").setCellEditor(new ButtonEditor(new JCheckBox()));
		
			tableListaHospedagem.getColumn("Excluir").setCellRenderer(new ButtonRenderer());
			tableListaHospedagem.getColumn("Excluir").setCellEditor(new ButtonEditor(new JCheckBox()));
		
			
			Object[] objeto = new Object[] { registro.getHospedagem().getHospede().getNome(), registro.getHospedagem().getQuarto().getNumero(), registro.getValor(), "Editar", "Excluir"};
			modelTableHospedagem.addRow(objeto);
			
			tableListaHospedagem.getColumn("Editar").getCellEditor().addCellEditorListener(new CellEditorListener() {

				@Override
				public void editingStopped(ChangeEvent e) {
					clickedButton(tableListaHospedagem.getValueAt(tableListaHospedagem.getSelectedRow(), 0).toString());
					
				}
				
				@Override
				public void editingCanceled(ChangeEvent e) {
					System.out.println("Cancel");
					
				}
				
			});
			
			tableListaHospedagem.getColumn("Excluir").getCellEditor().addCellEditorListener(new CellEditorListener() {
				@Override
				public void editingStopped(ChangeEvent e) {

					clickedButtonDelete(tableListaHospedagem.getValueAt(tableListaHospedagem.getSelectedRow(), 0).toString());

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
	private void clickedButton(String chave) {
		System.out.println("stop " + chave);
		Registro registro = listaMap.get(chave);
		
		TelaCriarHospedagem alterarHospedagem = new TelaCriarHospedagem(registro);

		alterarHospedagem.setVisible(true);
		desktop.getDesktop().add(alterarHospedagem);
		tratadorEventos = new TratadorEventos(desktop);
		alterarHospedagem.addInternalFrameListener(tratadorEventos);
		modelTableHospedagem.setRowCount(0);
		
		listarHospedagens(this.buscarHospedagens());
	}
	
	/**
	 * Método contendo a lógica de deleção a partir do clique
	 * no botão de excluir.
	 * 
	 * @param chave {@link String}
	 **/
	private void clickedButtonDelete(String chave) {
		System.out.println("stop " + chave);
		Registro registro = listaMap.get(chave);
		try {
			int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir a hospedagem " 
														+ registro.getId() + "?");
			if(confirm == JOptionPane.YES_OPTION) {
				RegistroHospedagemController.deleteHospedagem(hospedagem);
			}
			modelTableHospedagem.setRowCount(0);
			
			listarHospedagens(this.buscarHospedagens());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	/**
	 * Método para buscar hospedagens.
	 * 
	 * @return listaHospedagens {@link Set<Hospedagem>}
	 **/
	private Set<Registro> buscarHospedagens() {
		Set<Registro> listaHospedagens = new HashSet<>();
		try {
			listaHospedagens = registroHospedagemController.listarHospedagens();
		} catch (Exception e) {

		}
		return listaHospedagens;
	}
	
	public TelaPrincipal getDesktop() {
		return desktop;
	}
	public void setDesktop(TelaPrincipal desktop) {
		this.desktop = desktop;
	}
	
	
	
}
