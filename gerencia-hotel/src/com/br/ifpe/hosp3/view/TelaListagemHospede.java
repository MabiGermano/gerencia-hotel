package com.br.ifpe.hosp3.view;

import java.awt.BorderLayout;
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

import com.br.ifpe.hosp3.controller.HospedeController;
import com.br.ifpe.hosp3.model.Hospede;
import com.br.ifpe.hosp3.util.ButtonEditor;
import com.br.ifpe.hosp3.util.ButtonRenderer;
import com.br.ifpe.hosp3.util.TratadorEventos;

/**
 * @author Tayná Alexandra 
 * Classe de interface gráfica para listagem de Hóspedes
 **/

public class TelaListagemHospede extends JInternalFrame {
	private DefaultTableModel modelTableHospede;
	private JTable tableListaHospede;
	private JTextField txtBuscaNome;
	private JTextField txtBuscarCpf;
	private HospedeController hospedeController = new HospedeController();
	private Map<String, Hospede> listaMap;
	private TelaPrincipal desktop;
	private TratadorEventos tratadorEventos;


	public TelaListagemHospede(TelaPrincipal desktop) {
		this();
		this.desktop = desktop;
	}

	public TelaListagemHospede() {
		setClosable(true);
		setBounds(-5, 75, 584, 334);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JLabel lblHspedes = new JLabel("Hóspedes");
		lblHspedes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHspedes.setBounds(252, 11, 73, 26);
		panel.add(lblHspedes);
		
		txtBuscaNome = new JTextField();
		txtBuscaNome.setBounds(376, 48, 136, 25);
		panel.add(txtBuscaNome);
		txtBuscaNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Buscar Nome:");
		lblNome.setBounds(286, 53, 81, 14);
		panel.add(lblNome);
		
		JButton btnBuscarPorNome = new JButton("");
		btnBuscarPorNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/ifpe/hosp3/img/serch_p.png")));
		btnBuscarPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscaPorNome();
			}
		});
		btnBuscarPorNome.setBounds(522, 48, 32, 25);
		panel.add(btnBuscarPorNome);
		
		JLabel lblCpf = new JLabel("Buscar CPF:");
		lblCpf.setBounds(10, 53, 73, 14);
		panel.add(lblCpf);
		
		txtBuscarCpf = new JTextField();
		txtBuscarCpf.setBounds(93, 48, 136, 25);
		panel.add(txtBuscarCpf);
		txtBuscarCpf.setColumns(10);
		
		JButton btnBuscarPorCpf = new JButton("");
		btnBuscarPorCpf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/ifpe/hosp3/img/serch_p.png")));
		btnBuscarPorCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscaPorCpf();
			}
		});
		btnBuscarPorCpf.setBounds(239, 48, 32, 25);
		panel.add(btnBuscarPorCpf);
		
		JScrollPane scrollTableHospede = new JScrollPane();
		scrollTableHospede.setBounds(10, 82, 547, 213);
		panel.add(scrollTableHospede);
		
		modelTableHospede = new DefaultTableModel();
		modelTableHospede.addColumn("HashCode");
		modelTableHospede.addColumn("Nome");
		modelTableHospede.addColumn("CPF");
		modelTableHospede.addColumn("Email");
		modelTableHospede.addColumn("Telefone");
		modelTableHospede.addColumn("Editar");
		modelTableHospede.addColumn("Excluir");
		
		tableListaHospede = new JTable(modelTableHospede);
		scrollTableHospede.setViewportView(tableListaHospede);
		
		listarHospedes(this.buscarHospedes());
	}

	private void listarHospedes(Set<Hospede> lista) {
		Set<Hospede> listaHospedes = lista;
		listaMap = listaHospedes.stream()
				.collect(Collectors.toMap(Hospede::getHash,Function.identity()));

		listaMap.forEach((chave,hospede) -> {
			tableListaHospede.getColumn("Editar").setCellRenderer(new ButtonRenderer());
			tableListaHospede.getColumn("Editar").setCellEditor(new ButtonEditor(new JCheckBox()));
			
			tableListaHospede.getColumn("Excluir").setCellRenderer(new ButtonRenderer());
			tableListaHospede.getColumn("Excluir").setCellEditor(new ButtonEditor(new JCheckBox()));
			
			Object[] objeto = new Object[] {chave,  hospede.getNome(), hospede.getCpf(), hospede.getEmail(),
					hospede.getTelefone(), "Editar", "Excluir"};
			modelTableHospede.addRow(objeto);
			tableListaHospede.getColumn("Editar").getCellEditor().addCellEditorListener(new CellEditorListener() {
				
				@Override
				public void editingStopped(ChangeEvent e) {
					
					clickedButton(tableListaHospede.getValueAt(tableListaHospede.getSelectedRow(), 0).toString());
					
				}
				
				@Override
				public void editingCanceled(ChangeEvent e) {
					System.out.println("Cancel");
					
				}
				
			});
			
			tableListaHospede.getColumn("Excluir").getCellEditor().addCellEditorListener(new CellEditorListener() {

				@Override
				public void editingStopped(ChangeEvent e) {

					clickedButtonDelete(tableListaHospede.getValueAt(tableListaHospede.getSelectedRow(), 0).toString());

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
		Hospede hospede = listaMap.get(chave);
		
		TelaCriarHospede alterarHospede = new TelaCriarHospede(hospede);
		
		alterarHospede.setVisible(true);
		desktop.getDesktop().add(alterarHospede);
		tratadorEventos = new TratadorEventos(desktop);
		alterarHospede.addInternalFrameListener(tratadorEventos);
		modelTableHospede.setRowCount(0);
		
		listarHospedes(this.buscarHospedes());
	}
	
	private void buscaPorNome() {
		Set<Hospede> listaHospedes = new HashSet<>();
		try {
			listaHospedes = hospedeController.buscarHospedeNome(txtBuscaNome.getText());
			modelTableHospede.setRowCount(0);
			txtBuscaNome.setText("");
			if(listaHospedes.size() > 0) {				
				listarHospedes(listaHospedes);
			}else {
				JOptionPane.showMessageDialog(null, "Nenhum hospede encontrado");
				listarHospedes(this.buscarHospedes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void buscaPorCpf() {
		Set<Hospede> listaHospedes = new HashSet<>();
		Hospede hospede = new Hospede();
		try {
			hospede = hospedeController.buscarHospedeCpf(txtBuscarCpf.getText());
			modelTableHospede.setRowCount(0);
			listaHospedes.add(hospede);
			listarHospedes(listaHospedes);
		} catch (Exception e) {
			modelTableHospede.setRowCount(0);
			JOptionPane.showMessageDialog(null,e.getMessage());
			listarHospedes(this.buscarHospedes());
		}
		txtBuscarCpf.setText("");
	}
	
	/**
	 * Método contendo a lógica de deleção a partir do clique
	 * no botão de excluir.
	 * 
	 * @param chave {@link String}
	 **/
	private void clickedButtonDelete(String chave) {
		System.out.println("stop " + chave);
		Hospede hospede = listaMap.get(chave);
		try {
			int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o hóspede " 
														+ hospede.getNome() + "?");
			if(confirm == JOptionPane.YES_OPTION) {
				hospedeController.deleteHospede(hospede);
			}
			modelTableHospede.setRowCount(0);
			
			listarHospedes(this.buscarHospedes());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	
	}
	
	


	private Set<Hospede> buscarHospedes() {
		Set<Hospede> listaHospedes = new HashSet<>();
		try {
			HospedeController hospedeController = new HospedeController();
			listaHospedes = hospedeController.listarHospedes();
		} catch (Exception e) {
			
		}
		return listaHospedes;
	}
	
	
}
