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

import com.br.ifpe.hosp3.controller.FuncionarioController;
import com.br.ifpe.hosp3.model.Funcionario;
import com.br.ifpe.hosp3.model.Hospede;
import com.br.ifpe.hosp3.util.ButtonEditor;
import com.br.ifpe.hosp3.util.ButtonRenderer;
import com.br.ifpe.hosp3.util.TratadorEventos;

/**
 * @author Tayná Alexandra 
 * Classe de interface gráfica para listagem de funcionários
 **/

public class TelaListagemFuncionario extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelTableFuncionario;
	private JTable tableListaFuncionario;
	private JTextField txtBuscaNome;
	private JTextField txtBuscarCpf;
	private TelaPrincipal desktop;
	private TratadorEventos tratadorEventos;
	private FuncionarioController funcionarioController = new FuncionarioController();
	private Map<String, Funcionario> listaMap;

	/**
	 * Cria tela de listagem de funcionário.
	 */
	public TelaListagemFuncionario() {
		setClosable(true);
		setBounds(-5, 75, 600, 349);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JLabel lblFuncionarios = new JLabel("Funcionários");
		lblFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFuncionarios.setBounds(254, 11, 83, 26);
		panel.add(lblFuncionarios);
		
		txtBuscaNome = new JTextField();
		txtBuscaNome.setBounds(373, 48, 157, 25);
		panel.add(txtBuscaNome);
		txtBuscaNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Buscar Nome:");
		lblNome.setBounds(288, 53, 83, 14);
		panel.add(lblNome);
		
		JButton btnBuscarPorNome = new JButton("");
		btnBuscarPorNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/ifpe/hosp3/img/serch_p.png")));
		btnBuscarPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscaPorNome();
			}
		});
		btnBuscarPorNome.setBounds(540, 48, 32, 25);
		panel.add(btnBuscarPorNome);
		
		JLabel lblCpf = new JLabel("Buscar CPF:");
		lblCpf.setBounds(10, 52, 70, 14);
		panel.add(lblCpf);
		
		txtBuscarCpf = new JTextField();
		txtBuscarCpf.setBounds(81, 48, 144, 25);
		panel.add(txtBuscarCpf);
		txtBuscarCpf.setColumns(10);
		
		JButton btnBuscarPorCpf = new JButton("");
		btnBuscarPorCpf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/ifpe/hosp3/img/serch_p.png")));
		btnBuscarPorCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscaPorCpf();
			}
		});
		btnBuscarPorCpf.setBounds(235, 48, 32, 25);
		panel.add(btnBuscarPorCpf);
		
		JScrollPane scrollTableFuncionario = new JScrollPane();
		scrollTableFuncionario.setBounds(10, 82, 562, 224);
		panel.add(scrollTableFuncionario);
		
		modelTableFuncionario = new DefaultTableModel();
		modelTableFuncionario.addColumn("HashCode");
		modelTableFuncionario.addColumn("Código");
		modelTableFuncionario.addColumn("Nome");
		modelTableFuncionario.addColumn("CPF");
		modelTableFuncionario.addColumn("Email");
		modelTableFuncionario.addColumn("Telefone");
		modelTableFuncionario.addColumn("Editar");
		modelTableFuncionario.addColumn("Excluir");
		
		tableListaFuncionario = new JTable(modelTableFuncionario);
		scrollTableFuncionario.setViewportView(tableListaFuncionario);
		
		listarFuncionarios(this.buscarFuncionarios());
	}
	public TelaListagemFuncionario(TelaPrincipal desktop) {
		this();
		this.desktop = desktop;
	}

	/**
	 * Método para Listar os funcionários
	 **/
	private void listarFuncionarios(Set<Funcionario> lista) {
		Set<Funcionario> listaFuncionarios = lista;
		listaMap = listaFuncionarios.stream()
				.collect(Collectors.toMap(Funcionario::getHash,Function.identity()));


		listaMap.forEach((chave,funcionario) -> {
			tableListaFuncionario.getColumn("Editar").setCellRenderer(new ButtonRenderer());
			tableListaFuncionario.getColumn("Editar").setCellEditor(new ButtonEditor(new JCheckBox()));
			
			tableListaFuncionario.getColumn("Excluir").setCellRenderer(new ButtonRenderer());
			tableListaFuncionario.getColumn("Excluir").setCellEditor(new ButtonEditor(new JCheckBox()));
			
			Object[] objeto = new Object[] {chave,  funcionario.getCodigo(), funcionario.getNome(), funcionario.getCpf(),
					funcionario.getEmail(), funcionario.getTelefone(), "Editar", "Excluir"};
			modelTableFuncionario.addRow(objeto);
			tableListaFuncionario.getColumn("Editar").getCellEditor().addCellEditorListener(new CellEditorListener() {
				
				@Override
				public void editingStopped(ChangeEvent e) {
					
					clickedButtonEdit(tableListaFuncionario.getValueAt(tableListaFuncionario.getSelectedRow(), 0).toString());
					
				}
				
				@Override
				public void editingCanceled(ChangeEvent e) {
					System.out.println("Cancel");
					
				}
				
			});
			tableListaFuncionario.getColumn("Excluir").getCellEditor().addCellEditorListener(new CellEditorListener() {
				
				@Override
				public void editingStopped(ChangeEvent e) {
					
					clickedButtonDelete(tableListaFuncionario.getValueAt(tableListaFuncionario.getSelectedRow(), 0).toString());
					
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
		Funcionario funcionario = listaMap.get(chave);
		
		TelaCriarFuncionario alterarFuncionario = new TelaCriarFuncionario(funcionario);
		
		alterarFuncionario.setVisible(true);
		desktop.getDesktop().add(alterarFuncionario);
		tratadorEventos = new TratadorEventos(desktop);
		alterarFuncionario.addInternalFrameListener(tratadorEventos);
		modelTableFuncionario.setRowCount(0);
		
		listarFuncionarios(this.buscarFuncionarios());
	}
	
	/**
	 * Método contendo a lógica de deleção a partir do clique
	 * no botão de excluir.
	 * 
	 * @param chave {@link String}
	 **/
		private void clickedButtonDelete(String chave) {
		System.out.println("stop " + chave);
		Funcionario funcionario = listaMap.get(chave);
		try {
			int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o funcionário " 
														+ funcionario.getNome() + "?");
			if(confirm == JOptionPane.YES_OPTION) {
				funcionarioController.deleteFuncionario(funcionario);
			}
			modelTableFuncionario.setRowCount(0);
			listarFuncionarios(this.buscarFuncionarios());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		

		
	}
	
	/**
	 * Método para buscar funcionários.
	 * 
	 * @return listaFuncionarios {@link Set<Funcionario>}
	 **/
	private Set<Funcionario> buscarFuncionarios() {
		Set<Funcionario> listaFuncionarios = new HashSet<>();
		try {
			FuncionarioController funcionarioController = new FuncionarioController();
			listaFuncionarios = funcionarioController.listarFuncionarios();
		} catch (Exception e) {
			
		}
		return listaFuncionarios;
	}
	

	private void buscaPorNome() {
		Set<Funcionario> listaFuncionarios= new HashSet<>();
		try {
			listaFuncionarios = funcionarioController.buscarFuncionarioNome(txtBuscaNome.getText());
			modelTableFuncionario.setRowCount(0);
			txtBuscaNome.setText("");
			if(listaFuncionarios.size() > 0) {				
				listarFuncionarios(listaFuncionarios);
			}else {
				JOptionPane.showMessageDialog(null, "Nenhum hospede encontrado");
				listarFuncionarios(this.buscarFuncionarios());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void buscaPorCpf() {
		Set<Funcionario> listaFuncionarios = new HashSet<>();
		Funcionario funcionario= new Funcionario();
		try {
			funcionario = funcionarioController.buscarFuncionarioCpf(txtBuscarCpf.getText());
			modelTableFuncionario.setRowCount(0);
			listaFuncionarios.add(funcionario);
			listarFuncionarios(listaFuncionarios);
		} catch (Exception e) {
			modelTableFuncionario.setRowCount(0);
			JOptionPane.showMessageDialog(null,e.getMessage());
			listarFuncionarios(this.buscarFuncionarios());
		}
		txtBuscarCpf.setText("");
	}
}
