package com.br.ifpe.hosp3.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.br.ifpe.hosp3.controller.RegistroHospedagemController;
import com.br.ifpe.hosp3.enums.FormasDePagamentoEnum;
import com.br.ifpe.hosp3.model.Registro;
import com.jgoodies.forms.factories.DefaultComponentFactory;

/**
 * @author Tayná Alexandra 
 * Classe de interface gráfica Check-out
 **/

public class TelaCheckOut extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCpfHospedeCheckOut;
	private JTextField txtNumQuartoCheckOut;
	private JTextField txtValorCheckOut;
	private JTable tabelaConsumo;
	private DefaultTableModel modelTableDados;
	private RegistroHospedagemController hospedagemController = new RegistroHospedagemController();
	private JTable tabelaDados;
	private Registro registro;
	private JComboBox comboBoxFormasDePagamento;


	/**
	 * Cria a tela de Check-out.
	 */
	public TelaCheckOut() {
		setClosable(true);
		setBounds(100, 100, 496, 367);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		
		JLabel lblCheckOut = DefaultComponentFactory.getInstance().createTitle("Check-out");
		lblCheckOut.setBounds(212, 11, 102, 17);
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtCpfHospedeCheckOut = new JTextField();
		txtCpfHospedeCheckOut.setBounds(26, 70, 160, 25);
		txtCpfHospedeCheckOut.setColumns(10);
		
		JLabel lblCpfDoHspede = new JLabel("Cpf do Hóspede:");
		lblCpfDoHspede.setBounds(26, 53, 115, 14);
		
		txtNumQuartoCheckOut = new JTextField();
		txtNumQuartoCheckOut.setBounds(268, 70, 160, 25);
		txtNumQuartoCheckOut.setColumns(10);
		
		JLabel lblNQuarto = new JLabel("Nº Quarto:");
		lblNQuarto.setBounds(268, 53, 100, 14);
		
		JLabel lblConsumoExtra = new JLabel("Consumo Extra:");
		lblConsumoExtra.setBounds(268, 118, 100, 14);
		
		txtValorCheckOut = new JTextField();
		txtValorCheckOut.setBounds(268, 239, 203, 25);
		txtValorCheckOut.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(268, 217, 46, 14);
		
		comboBoxFormasDePagamento = new JComboBox();
		comboBoxFormasDePagamento.setBounds(26, 243, 160, 25);
		comboBoxFormasDePagamento.setModel(new DefaultComboBoxModel(FormasDePagamentoEnum.values()));
		
		JLabel lblFormaDePagamento = new JLabel("Forma de Pagamento:");
		lblFormaDePagamento.setBounds(26, 217, 160, 14);
		
		JButton btnRealizarCheckout = new JButton("Check-out");
		btnRealizarCheckout.setBounds(357, 292, 100, 32);
		btnRealizarCheckout.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				fazerCheckout();
			}
		});
		
		JButton buttonBuscaCpf = new JButton("");
		buttonBuscaCpf.setBounds(196, 70, 26, 25);
		buttonBuscaCpf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/ifpe/hosp3/img/serch_p.png")));
		buttonBuscaCpf.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				buscarRegistroPeloCpf();
			}
		});
		
		JButton buttonBuscaNumQuarto = new JButton("");
		buttonBuscaNumQuarto.setBounds(431, 70, 26, 25);
		buttonBuscaNumQuarto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/ifpe/hosp3/img/serch_p.png")));
		buttonBuscaNumQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarRegistroPeloNumQuarto();
			}
		});
		panel.setLayout(null);
		panel.add(lblCheckOut);
		panel.add(txtCpfHospedeCheckOut);
		panel.add(lblCpfDoHspede);
		panel.add(txtNumQuartoCheckOut);
		panel.add(lblNQuarto);
		panel.add(lblConsumoExtra);
		panel.add(txtValorCheckOut);
		panel.add(lblValor);
		panel.add(comboBoxFormasDePagamento);
		panel.add(lblFormaDePagamento);
		panel.add(btnRealizarCheckout);
		panel.add(buttonBuscaCpf);
		panel.add(buttonBuscaNumQuarto);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(268, 136, 203, 69);
		panel.add(scrollPane_1);
		
		tabelaConsumo = new JTable();
		scrollPane_1.setViewportView(tabelaConsumo);
		
		
		modelTableDados= new DefaultTableModel();
		modelTableDados.addColumn("Hospede");
		modelTableDados.addColumn("Quarto");
		JLabel lblHospedagem = new JLabel("Hospedagem");
		lblHospedagem.setBounds(26, 118, 115, 14);
		panel.add(lblHospedagem);
		
		JScrollPane scrollDados = new JScrollPane();
		scrollDados.setBounds(24, 136, 198, 69);
		panel.add(scrollDados);
		
		tabelaDados = new JTable(modelTableDados);
		scrollDados.setViewportView(tabelaDados);

	}
	
	/**
	 * Método para buscar registro de hospedagem pelo CPF do hóspede.
	 * 
	 **/
	private void buscarRegistroPeloCpf() {
		
		try {
			Registro registro = new Registro();
			registro = hospedagemController.buscarPeloCpf(txtCpfHospedeCheckOut.getText());
			this.registro = registro;
			setFields(registro);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	private void buscarRegistroPeloNumQuarto() {
		
		try {
			Registro registro = new Registro();
			registro = hospedagemController.buscarPeloNumQuarto(txtNumQuartoCheckOut.getText());
			this.registro = registro;
			setFields(registro);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	private void setFields(Registro registro) {
		modelTableDados.addRow(new Object[] { registro.getHospedagem().getHospede().getNome(), registro.getHospedagem().getQuarto().getNumero()});
		txtValorCheckOut.setText(String.valueOf(registro.getValor()));
		txtValorCheckOut.setEnabled(false);
	}
	
	/**
	 * Método para realizar Check-out.
	 * 
	 **/
	private void fazerCheckout() {
		
		try {
			this.registro.setPagamento(comboBoxFormasDePagamento.getToolTipText());
			hospedagemController.realizarCheckout(this.registro);
			JOptionPane.showMessageDialog(null, "Checkout realizado com sucesso.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
