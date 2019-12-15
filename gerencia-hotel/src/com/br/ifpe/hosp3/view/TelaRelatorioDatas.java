package com.br.ifpe.hosp3.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class TelaRelatorioDatas extends javax.swing.JInternalFrame {
	
	Connection connection = null;
	private JPanel contentPane;
	private JTextField txtDataCheckin;
	private JTextField txtDataCheckout;

	/**
	 * Create the frame.
	 */
	public TelaRelatorioDatas() {
		setClosable(true);
		setTitle("Relatório de Hospedagem");
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);  
		setBounds(40, 85, 533, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataCheckin = new JLabel("Data de Check-in");
		lblDataCheckin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataCheckin.setIcon(new ImageIcon(TelaRelatorioDatas.class.getResource("/com/br/ifpe/hosp3/img/check-in_p.png")));
		lblDataCheckin.setBounds(78, 47, 134, 30);
		contentPane.add(lblDataCheckin);
		
		JLabel lblDataCheckout = new JLabel("Data de Check-out");
		lblDataCheckout.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataCheckout.setIcon(new ImageIcon(TelaRelatorioDatas.class.getResource("/com/br/ifpe/hosp3/img/check-out_p.png")));
		lblDataCheckout.setBounds(286, 47, 140, 33);
		contentPane.add(lblDataCheckout);
		
		txtDataCheckin = new JTextField();
		txtDataCheckin.setBounds(88, 85, 130, 30);
		contentPane.add(txtDataCheckin);
		txtDataCheckin.setColumns(10);
		
		txtDataCheckout = new JTextField();
		txtDataCheckout.setBounds(296, 86, 130, 30);
		contentPane.add(txtDataCheckout);
		txtDataCheckout.setColumns(10);
		
		JButton btnImprimirRelHospedagem = new JButton("   Imprimir relatório");
		btnImprimirRelHospedagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnImprimirRelHospedagem.setIcon(new ImageIcon(TelaRelatorioDatas.class.getResource("/com/br/ifpe/hosp3/img/iconfinder_print_172530.png")));
		btnImprimirRelHospedagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirma = JOptionPane.showConfirmDialog(null, "Confirma a impressão do relatório?", "Atenção", JOptionPane.YES_NO_OPTION);
				if (confirma == JOptionPane.YES_OPTION) {
					try {
						JasperPrint imprime = JasperFillManager.fillReport(".\\gerencia-hotel\\resources\\arquivos\\hospedagens.jasper", null, connection);
						JasperViewer.viewReport(imprime, false);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
					} 
				}
			}
		});
		btnImprimirRelHospedagem.setBounds(63, 154, 179, 47);
		contentPane.add(btnImprimirRelHospedagem);
		
		JButton btnCancelarRelHospedagem = new JButton("Cancelar");
		btnCancelarRelHospedagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		btnCancelarRelHospedagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelarRelHospedagem.setBounds(319, 154, 130, 45);
		contentPane.add(btnCancelarRelHospedagem);
	}
}
