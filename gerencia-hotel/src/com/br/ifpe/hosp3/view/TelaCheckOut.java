package com.br.ifpe.hosp3.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.br.ifpe.hosp3.enums.FormasDePagamentoEnum;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Tayná Alexandra 
 * Classe de interface gráfica Check-out
 **/

public class TelaCheckOut extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNomeHospedeCheckOut;
	private JTextField txtNumQuartoCheckOut;
	private JTextField txtCosumoExtraCheckOut;
	private JTextField txtValorCheckOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCheckOut frame = new TelaCheckOut();
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
	public TelaCheckOut() {
		setClosable(true);
		setBounds(100, 100, 501, 337);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JLabel lblCheckOut = DefaultComponentFactory.getInstance().createTitle("Check-out");
		lblCheckOut.setBounds(212, 11, 64, 17);
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblCheckOut);
		
		txtNomeHospedeCheckOut = new JTextField();
		txtNomeHospedeCheckOut.setBounds(26, 70, 160, 25);
		panel.add(txtNomeHospedeCheckOut);
		txtNomeHospedeCheckOut.setColumns(10);
		
		JLabel lblNomeDoHspede = new JLabel("Nome do Hóspede:");
		lblNomeDoHspede.setBounds(26, 53, 115, 14);
		panel.add(lblNomeDoHspede);
		
		txtNumQuartoCheckOut = new JTextField();
		txtNumQuartoCheckOut.setBounds(268, 70, 160, 25);
		panel.add(txtNumQuartoCheckOut);
		txtNumQuartoCheckOut.setColumns(10);
		
		JLabel lblNQuarto = new JLabel("Nº Quarto:");
		lblNQuarto.setBounds(268, 53, 100, 14);
		panel.add(lblNQuarto);
		
		txtCosumoExtraCheckOut = new JTextField();
		txtCosumoExtraCheckOut.setBounds(26, 142, 160, 25);
		panel.add(txtCosumoExtraCheckOut);
		txtCosumoExtraCheckOut.setColumns(10);
		
		JLabel lblConsumoExtra = new JLabel("Consumo Extra:");
		lblConsumoExtra.setBounds(26, 127, 100, 14);
		panel.add(lblConsumoExtra);
		
		txtValorCheckOut = new JTextField();
		txtValorCheckOut.setBounds(268, 142, 160, 25);
		panel.add(txtValorCheckOut);
		txtValorCheckOut.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(268, 127, 46, 14);
		panel.add(lblValor);
		
		JComboBox comboBoxFormasDePagamento = new JComboBox();
		comboBoxFormasDePagamento.setModel(new DefaultComboBoxModel(FormasDePagamentoEnum.values()));
		comboBoxFormasDePagamento.setBounds(26, 211, 160, 25);
		panel.add(comboBoxFormasDePagamento);
		
		JLabel lblFormaDePagamento = new JLabel("Forma de Pagamento:");
		lblFormaDePagamento.setBounds(26, 195, 160, 14);
		panel.add(lblFormaDePagamento);
		
		JButton btnRealizarCheckout = new JButton("Check-out");
		btnRealizarCheckout.setBounds(340, 247, 100, 32);
		panel.add(btnRealizarCheckout);
		
		JButton buttonBuscaNome = new JButton("");
		buttonBuscaNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/ifpe/hosp3/img/serch_p.png")));
		buttonBuscaNome.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonBuscaNome.setBounds(196, 70, 26, 25);
		panel.add(buttonBuscaNome);
		
		JButton buttonBuscaNumQuarto = new JButton("");
		buttonBuscaNumQuarto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/ifpe/hosp3/img/serch_p.png")));
		buttonBuscaNumQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonBuscaNumQuarto.setBounds(431, 70, 26, 25);
		panel.add(buttonBuscaNumQuarto);

	}
}
