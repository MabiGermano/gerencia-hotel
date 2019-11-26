package com.br.ifpe.hosp3.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
import com.br.ifpe.hosp3.controller.QuartoController;
import com.br.ifpe.hosp3.controller.RegistroHospedagemController;
import com.br.ifpe.hosp3.model.Funcionario;
import com.br.ifpe.hosp3.model.Hospedagem;
import com.br.ifpe.hosp3.model.Hospede;
import com.br.ifpe.hosp3.model.Quarto;
import com.br.ifpe.hosp3.model.Registro;
import com.br.ifpe.hosp3.util.ButtonEditor;
import com.br.ifpe.hosp3.util.ButtonRenderer;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
/**
 * @author Maria Beatriz Germano
 * Classe de interface gráfica para criação de hospedagem
 **/
public class TelaCriarHospedagem extends JInternalFrame {
	Funcionario funcionario;
	private JTextField textCpf;
	private DefaultTableModel modelTableHospede;
	private DefaultTableModel modelTableQuarto;
	private JPanel panel;
	JScrollPane scrollpaneTable ;
	private JTable table;
	private Hospedagem hospedagem;
	private JLabel lblQuartosDisponveis;
	private JScrollPane scrollPaneTableQuarto;
	private JTable tableQuartos;
	private final JButton btnSalvar = new JButton("Salvar");
	private final JButton btnCancelar = new JButton("Cancelar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCriarHospedagem frame = new TelaCriarHospedagem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCriarHospedagem() {
		setBounds(60, 100, 500, 300);
		
		JScrollPane scrollPane = new JScrollPane();
		hospedagem = new Hospedagem();
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
		);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200,320));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JLabel lblCheckInTitle = DefaultComponentFactory.getInstance().createTitle("Check-in");
		lblCheckInTitle.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCheckInTitle.setBounds(188, 13, 90, 14);
        panel.add(lblCheckInTitle);
		
		JLabel lblBuscarHospede = new JLabel("Buscar Hospede(CPF)");
		lblBuscarHospede.setBounds(23, 53, 139, 14);
		panel.add(lblBuscarHospede);
		
		textCpf = new JTextField();
		textCpf.setBounds(169, 48, 154, 25);
		panel.add(textCpf);
		textCpf.setColumns(10);
		
		Icon iconSearch= new ImageIcon(getClass().getResource("/com/br/ifpe/hosp3/img/serch_p.png"));
		JButton btnNewButton = new JButton("", iconSearch);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				btnBuscaHospedeAction(event);
			}
		});
		btnNewButton.setBounds(324, 48, 30, 25);
		panel.add(btnNewButton);
		
		scrollpaneTable = new JScrollPane();
		scrollpaneTable.setBounds(27, 97, 416, 51);
		panel.add(scrollpaneTable);
		
		
		modelTableHospede = new DefaultTableModel();
		modelTableHospede.addColumn("Nome");
		modelTableHospede.addColumn("CPF");
		modelTableHospede.addColumn("Telefone");
		modelTableHospede.addColumn("Ações");
	    
	    table = new JTable(modelTableHospede);

	    
	    scrollpaneTable.setViewportView(table);
	    
	    lblQuartosDisponveis = new JLabel("Quartos disponíveis");
	    lblQuartosDisponveis.setBounds(10, 161, 139, 14);
	    panel.add(lblQuartosDisponveis);
	    
	    modelTableQuarto = new DefaultTableModel();
	    modelTableQuarto.addColumn("Número");
	    modelTableQuarto.addColumn("Tipo");
	    modelTableQuarto.addColumn("Qtd. Pessoas");
	    modelTableQuarto.addColumn("Valor");
	    modelTableQuarto.addColumn("Ações");
	    
	    
	    scrollpaneTable.setViewportView(table);
	    
	    scrollPaneTableQuarto = new JScrollPane();
	    scrollPaneTableQuarto.setBounds(10, 187, 450, 60);
	    panel.add(scrollPaneTableQuarto);
	    
	    tableQuartos = new JTable(modelTableQuarto);
	    
	    scrollPaneTableQuarto.setViewportView(tableQuartos);
	    btnSalvar.setBounds(312, 264, 108, 33);
	    panel.add(btnSalvar);
	    btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				criarRegistroHospedagem();
				
			}
		});
	    btnCancelar.setBounds(38, 264, 138, 33);
	    panel.add(btnCancelar);
	    btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelarCriacao();
				
			}
		});
	    listarQuartosDisponiveis();
		getContentPane().setLayout(groupLayout);

	}
	public TelaCriarHospedagem(Funcionario funcionario) {
		this();
		this.funcionario = funcionario;
	}
	/**
	 * Método para fechar o frame de criação
	 **/
	private void cancelarCriacao() {
		this.dispose();
	}
	
	/**
	 * Método de ação na interface para criação de registro de hospedagem
	 * 
	 **/
	private void criarRegistroHospedagem() {
		try {
			Registro registro = new Registro();
			registro.setFuncionario(this.funcionario);
			registro.setHospedagem(this.hospedagem);
			registro.setValor(this.hospedagem.getQuarto().getValor());
			RegistroHospedagemController.criarRegistroHospedagem(registro);
			JOptionPane.showMessageDialog(null, "Check-in realizado com sucesso.");
			this.dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	/**
	 * Método de ação para popular tabela e executar ação ao selecionar hospede
	 * 
	 * @param event {@link ActionEvent}
	 **/
	private void btnBuscaHospedeAction(ActionEvent event) {
		
		Hospede hospede = this.buscarHospede();
		modelTableHospede.getDataVector().removeAllElements();
		textCpf.setText("");
		
		table.getColumn("Ações").setCellRenderer(new ButtonRenderer());
	    table.getColumn("Ações").setCellEditor(new ButtonEditor(new JCheckBox()));
	    table.getColumn("Ações").getCellEditor().addCellEditorListener(new CellEditorListener() {
			
			@Override
			public void editingStopped(ChangeEvent e) {
					System.out.println("stop " + hospede.getId());
					modelTableHospede.getDataVector().removeAllElements();
					modelTableHospede.addRow(new Object[]{hospede.getNome(), hospede.getCpf(), hospede.getTelefone(), "Ok"});
					hospedagem.setHospede(hospede);
					System.out.println(hospedagem);
			}
			
			@Override
			public void editingCanceled(ChangeEvent e) {
				System.out.println("Cancel");
				
			}
		});
		modelTableHospede.addRow(new Object[]{hospede.getNome(), hospede.getCpf(), hospede.getTelefone(), "selecionar"});
		
	}
	/**
	 * Método para listagem dos quartos disponíveis e execução de ação de seleção de quarto
	 **/
	private void listarQuartosDisponiveis() {
		Set<Quarto> listaQuartos = this.buscarQuartosDisponiveis();
		tableQuartos.getColumn("Ações").setCellRenderer(new ButtonRenderer());
		tableQuartos.getColumn("Ações").setCellEditor(new ButtonEditor(new JCheckBox()));
		
	    listaQuartos.stream().map(quarto -> new Object[]{quarto.getNumero(), quarto.getTipo(), 
	    		quarto.getQuantidadePessoas() ,quarto.getValor(), "selecionar"})
	    .forEach(quarto -> modelTableQuarto.addRow(quarto));
	    
	    listaQuartos.forEach(quartoSelecionado -> {
	    	tableQuartos.getColumn("Ações").getCellEditor().addCellEditorListener(new CellEditorListener() {
				
				@Override
				public void editingStopped(ChangeEvent e) {
					System.out.println("stop " + quartoSelecionado.getId());
					modelTableQuarto.getDataVector().removeAllElements();
					modelTableQuarto.addRow(new Object[]{quartoSelecionado.getNumero(), quartoSelecionado.getTipo(), 
							quartoSelecionado.getQuantidadePessoas(), quartoSelecionado.getValor(), "Ok"});
					hospedagem.setQuarto(quartoSelecionado);
				}
				
				@Override
				public void editingCanceled(ChangeEvent e) {
					System.out.println("Cancel");
					
				}
			});
    	});
	    
	}
	/**
	 * Método de busca dos quartos disponíveis
	 * @return listaQuartos {@link Set<Quarto>}
	 **/
	private Set<Quarto> buscarQuartosDisponiveis() {
		Set<Quarto> listaQuartos = new HashSet<>();
		
		try {
			listaQuartos = QuartoController.listarQuartosDisponiveis();
		} catch (Exception e) {
			
		}
		return listaQuartos;
	}
	/**
	 * Método de busca do hospede a partir do cpf digitado
	 * 
	 * @return hospede {@link Hospede}
	 **/
	public Hospede buscarHospede() {
		Hospede hospede = null;
		try {
			hospede = HospedeController.buscarHospede(textCpf.getText());
			
		} catch (Exception e) {
			panel.remove(table);
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		return hospede;
	}
}

