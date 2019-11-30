package com.br.ifpe.hosp3.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaRelatorioDatas extends JFrame {

	private JPanel contentPane;
	private JTextField txtDataCheckin;
	private JTextField txtDataCheckout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorioDatas frame = new TelaRelatorioDatas();
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
	public TelaRelatorioDatas() {
		setTitle("Relatório de Hospedagem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataCheckin = new JLabel("Data de Check-in");
		lblDataCheckin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataCheckin.setIcon(new ImageIcon(TelaRelatorioDatas.class.getResource("/com/br/ifpe/hosp3/img/check-in_p.png")));
		lblDataCheckin.setBounds(62, 68, 134, 30);
		contentPane.add(lblDataCheckin);
		
		JLabel lblDataCheckout = new JLabel("Data de Check-out");
		lblDataCheckout.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataCheckout.setIcon(new ImageIcon(TelaRelatorioDatas.class.getResource("/com/br/ifpe/hosp3/img/check-out_p.png")));
		lblDataCheckout.setBounds(290, 67, 140, 33);
		contentPane.add(lblDataCheckout);
		
		txtDataCheckin = new JTextField();
		txtDataCheckin.setBounds(72, 106, 130, 20);
		contentPane.add(txtDataCheckin);
		txtDataCheckin.setColumns(10);
		
		txtDataCheckout = new JTextField();
		txtDataCheckout.setBounds(300, 106, 130, 20);
		contentPane.add(txtDataCheckout);
		txtDataCheckout.setColumns(10);
		
		JButton btnImprimirRelatorioDatas = new JButton("Imprimir relat\u00F3rio");
		btnImprimirRelatorioDatas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnImprimirRelatorioDatas.setIcon(new ImageIcon(TelaRelatorioDatas.class.getResource("/com/br/ifpe/hosp3/img/iconfinder_print_172530.png")));
		btnImprimirRelatorioDatas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnImprimirRelatorioDatas.setBounds(154, 182, 206, 62);
		contentPane.add(btnImprimirRelatorioDatas);
	}
}
