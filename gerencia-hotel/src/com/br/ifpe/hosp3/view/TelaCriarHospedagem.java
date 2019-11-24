package com.br.ifpe.hosp3.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import com.br.ifpe.hosp3.model.Hospede;
import com.br.ifpe.hosp3.util.ButtonEditor;
import com.br.ifpe.hosp3.util.ButtonRenderer;
import com.jgoodies.forms.factories.DefaultComponentFactory;
/**
 * Classe de interface gráfica para criação de hospedagem
 **/
public class TelaCriarHospedagem extends JInternalFrame {
	private JTextField textCpf;
	private DefaultTableModel model;
	private JPanel panel;
	JScrollPane scrollpaneTable ;
	private JTable table;

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
		setBounds(100, 100, 450, 300);
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
		);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200,600));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JLabel lblCheckInTitle = DefaultComponentFactory.getInstance().createTitle("Check-in");
		lblCheckInTitle.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCheckInTitle.setBounds(188, 13, 90, 14);
        panel.add(lblCheckInTitle);
		
		JLabel lblBuscarHospede = new JLabel("Buscar Hospede");
		lblBuscarHospede.setBounds(55, 54, 96, 14);
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
		scrollpaneTable.setBounds(27, 97, 371, 51);
		panel.add(scrollpaneTable);
		
		
		model = new DefaultTableModel();
		model.addColumn("Nome");
		model.addColumn("CPF");
		model.addColumn("Telefone");
		model.addColumn("Ações");
	    
	    table = new JTable(model);
	    scrollpaneTable.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}
	
	private void btnBuscaHospedeAction(ActionEvent event) {
		
		Hospede hospede = this.buscarHospede();
		table.getColumn("Ações").setCellRenderer(new ButtonRenderer());
	    table.getColumn("Ações").setCellEditor(new ButtonEditor(new JCheckBox()));
	    table.getColumn("Ações").getCellEditor().addCellEditorListener(new CellEditorListener() {
			
			@Override
			public void editingStopped(ChangeEvent e) {
				System.out.println("stop " + hospede.getId());
				scrollpaneTable.remove(table);
				scrollpaneTable.repaint();
				
			}
			
			@Override
			public void editingCanceled(ChangeEvent e) {
				System.out.println("Cancel");
				
			}
		});
		
		model.addRow(new Object[]{hospede.getNome(), hospede.getCpf(), hospede.getTelefone(), "selecionar"});
		
	}
	
	public void selectHospedeAction(Integer id) {
		
	}
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

