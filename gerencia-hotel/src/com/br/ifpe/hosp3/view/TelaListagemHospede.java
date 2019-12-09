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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		setBounds(100, 100, 623, 347);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JLabel lblHspedes = new JLabel("Hóspedes");
		lblHspedes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHspedes.setBounds(266, 11, 73, 26);
		panel.add(lblHspedes);
		
		txtBuscaNome = new JTextField();
		txtBuscaNome.setBounds(399, 48, 157, 25);
		panel.add(txtBuscaNome);
		txtBuscaNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Buscar Nome:");
		lblNome.setBounds(318, 53, 81, 14);
		panel.add(lblNome);
		
		JButton btnBuscarPorNome = new JButton("");
		btnBuscarPorNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/ifpe/hosp3/img/serch_p.png")));
		btnBuscarPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarPorNome.setBounds(566, 48, 32, 25);
		panel.add(btnBuscarPorNome);
		
		JLabel lblCpf = new JLabel("Buscar CPF:");
		lblCpf.setBounds(10, 52, 86, 14);
		panel.add(lblCpf);
		
		txtBuscarCpf = new JTextField();
		txtBuscarCpf.setBounds(82, 48, 157, 25);
		panel.add(txtBuscarCpf);
		txtBuscarCpf.setColumns(10);
		
		JButton btnBuscarPorCpf = new JButton("");
		btnBuscarPorCpf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/ifpe/hosp3/img/serch_p.png")));
		btnBuscarPorCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscarPorCpf.setBounds(249, 48, 32, 25);
		panel.add(btnBuscarPorCpf);
		
		JScrollPane scrollTableHospede = new JScrollPane();
		scrollTableHospede.setBounds(10, 82, 585, 224);
		panel.add(scrollTableHospede);
		
		modelTableHospede = new DefaultTableModel();
		modelTableHospede.addColumn("HashCode");
		modelTableHospede.addColumn("Nome");
		modelTableHospede.addColumn("CPF");
		modelTableHospede.addColumn("Email");
		modelTableHospede.addColumn("Telefone");
		modelTableHospede.addColumn("Ações");
		
		tableListaHospede = new JTable(modelTableHospede);
		scrollTableHospede.setViewportView(tableListaHospede);
		
		listarHospedes();
	}

	private void listarHospedes() {
		Set<Hospede> listaHospedes = this.buscarHospedes();
		listaMap = listaHospedes.stream()
				.collect(Collectors.toMap(Hospede::getHash,Function.identity()));

		listaMap.forEach((chave,hospede) -> {
			tableListaHospede.getColumn("Ações").setCellRenderer(new ButtonRenderer());
			tableListaHospede.getColumn("Ações").setCellEditor(new ButtonEditor(new JCheckBox()));
			Object[] objeto = new Object[] {chave,  hospede.getNome(), hospede.getCpf(), hospede.getEmail(),
					hospede.getTelefone(), "Editar"};
			modelTableHospede.addRow(objeto);
			tableListaHospede.getColumn("Ações").getCellEditor().addCellEditorListener(new CellEditorListener() {
				
				@Override
				public void editingStopped(ChangeEvent e) {
					
					clickedButton(tableListaHospede.getValueAt(tableListaHospede.getSelectedRow(), 0).toString());
					
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
		modelTableHospede.getDataVector().removeAllElements();
		modelTableHospede.addRow(new Object[] { chave,  hospede.getNome(), hospede.getCpf(), hospede.getEmail(),
				hospede.getTelefone(), "Ok" });
	}


	private Set<Hospede> buscarHospedes() {
		Set<Hospede> listaHospedes = new HashSet<>();
		try {
			listaHospedes = hospedeController.listarHospedes();
		} catch (Exception e) {
			
		}
		return listaHospedes;
	}
	
	
}
