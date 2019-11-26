/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.ifpe.hosp3.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.br.ifpe.hosp3.model.Funcionario;

/**
 *
 * @author Thaysa Gomes
 */
public class TelaPrincipal extends javax.swing.JFrame {

	Funcionario funcionario;

	/**
	 * Cria nova tela Principal
	 */
	public TelaPrincipal() {
		setResizable(false);
		initComponents();
	}

	public TelaPrincipal(Funcionario funcionario) {
		this();
		this.funcionario = funcionario;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		try {
			URL url = getClass().getResource("./../img/lobby.jpg");
			img = ImageIO.read(new File(url.getPath()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		desktop = this.initDesktop(img);
		Menu = new javax.swing.JMenuBar();
		menuCadastro = new javax.swing.JMenu();
		menuCadastroFuncionario = new javax.swing.JMenuItem();
		menuCadastroHospede = new javax.swing.JMenuItem();
		menuRelatorio = new javax.swing.JMenu();
		menuRelatorioHospedagem = new javax.swing.JMenuItem();
		menuRelatorioConsumo = new javax.swing.JMenuItem();
		menuOpcoes = new javax.swing.JMenu();
		menuOpcoesSair = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Hosp3 - Gerencia");
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowActivated(java.awt.event.WindowEvent evt) {
				formWindowActivated(evt);
			}
		});

		menuCadastro.setText("Cadastro");
		menuCadastro.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuCadastroActionPerformed(evt);
			}
		});

		menuCadastroFuncionario.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
		menuCadastroFuncionario.setText("Funcionário");
		menuCadastroFuncionario.setEnabled(false);
		menuCadastroFuncionario.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuCadastroFuncionarioActionPerformed(evt);
			}
		});
		menuCadastro.add(menuCadastroFuncionario);

		menuCadastroHospede.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
		menuCadastroHospede.setText("Hóspede");
		menuCadastroHospede.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuCadastroHospedeActionPerformed(evt);
			}
		});
		menuCadastro.add(menuCadastroHospede);

		Menu.add(menuCadastro);

		menuRelatorio.setText("Relatório");

		menuRelatorioHospedagem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
		menuRelatorioHospedagem.setText("Hospedagem");
		menuRelatorio.add(menuRelatorioHospedagem);

		menuRelatorioConsumo.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
		menuRelatorioConsumo.setText("Consumo Extra");
		menuRelatorio.add(menuRelatorioConsumo);

		Menu.add(menuRelatorio);

		menuOpcoes.setText("Opções");
		menuOpcoes.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuOpcoesActionPerformed(evt);
			}
		});

		menuOpcoesSair.setText("Sair");
		menuOpcoesSair.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuOpcoesSairActionPerformed(evt);
			}
		});
		menuOpcoes.add(menuOpcoesSair);

		Menu.add(menuOpcoes);

		setJMenuBar(Menu);

		JPanel panel = new JPanel();

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(desktop, GroupLayout.PREFERRED_SIZE, 631, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE).addGap(68)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(desktop, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panel.setLayout(null);
		lblUsuario = new javax.swing.JLabel();
		lblUsuario.setBounds(32, 12, 112, 36);
		panel.add(lblUsuario);

		lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
		lblUsuario.setText("Usuário");
		jLabel2 = new javax.swing.JLabel();
		jLabel2.setBounds(143, 23, 0, 0);
		panel.add(jLabel2);
		lblData = new javax.swing.JLabel();
		lblData.setBounds(36, 57, 91, 23);
		panel.add(lblData);

		lblData.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		lblData.setText("Data");
		jLabel3 = new javax.swing.JLabel();
		jLabel3.setBounds(32, 122, 53, 14);
		panel.add(jLabel3);

		jLabel3.setText("Cadastro");
		comboCadastro = new javax.swing.JComboBox<>();
		comboCadastro.setBounds(32, 138, 95, 23);
		panel.add(comboCadastro);

		comboCadastro
				.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcionário", "Hóspede", "Quarto" }));
		btnCadastro = new javax.swing.JButton();
		btnCadastro.setBounds(32, 167, 50, 24);
		panel.add(btnCadastro);

		btnCadastro.setText("Ok");
		jLabel1 = new javax.swing.JLabel();
		jLabel1.setBounds(26, 230, 155, 155);
		panel.add(jLabel1);

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/ifpe/hosp3/img/logo.png")));
		btnCadastro.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCadastroActionPerformed(evt);
			}
		});
		comboCadastro.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				comboCadastroItemStateChanged(evt);
			}
		});
		desktop.setLayout(null);

		Icon iconCheckin = new ImageIcon(getClass().getResource("/com/br/ifpe/hosp3/img/check-in_p.png"));
		btnCheckin = new JButton("Check-in", iconCheckin);
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				try {
					btnCheckInActionPerformed(event);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCheckin.setBounds(96, 33, 131, 45);
		desktop.add(btnCheckin);

		Icon iconCheckout = new ImageIcon(getClass().getResource("/com/br/ifpe/hosp3/img/check-out_p.png"));
		JButton btnNewButton = new JButton("Check-out", iconCheckout);
		btnNewButton.setBounds(389, 33, 131, 45);
		desktop.add(btnNewButton);

		getContentPane().setLayout(layout);
		this.setPreferredSize(new Dimension(850, 440));
		pack();
		setLocationRelativeTo(null);
	}

	private JDesktopPane initDesktop(BufferedImage img) {
		return new JDesktopPane() {
			@Override
			protected void paintComponent(Graphics grphcs) {
				super.paintComponent(grphcs);
				grphcs.drawImage(img, 0, 0, null);
			}

			@Override
			public Dimension getPreferredSize() {
				return new Dimension(img.getWidth(), img.getHeight());
			}
		};
	}

	/**
	 * 
	 * Método para abrir a janela de cadastro de Funcionário
	 */
	private void menuCadastroFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {
		TelaFuncionario funcionario = null;
		try {
			funcionario = new TelaFuncionario();
		} catch (IOException ex) {
			Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
		}
		funcionario.setVisible(true);
		desktop.add(funcionario);
	}

	/**
	 * 
	 * Método para formatar a data da tela principal
	 */
	private void formWindowActivated(java.awt.event.WindowEvent evt) {
		Date data = new Date();
		DateFormat formataData = DateFormat.getDateInstance(DateFormat.SHORT);
		lblData.setText(formataData.format(data));

	}

	private void menuOpcoesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuOpcoesActionPerformed

	}// GEN-LAST:event_menuOpcoesActionPerformed

	/**
	 * 
	 * Método sair do sistema
	 */
	private void menuOpcoesSairActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuOpcoesSairActionPerformed
		int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Alerta",
				JOptionPane.YES_NO_OPTION);

		if (sair == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}// GEN-LAST:event_menuOpcoesSairActionPerformed

	/**
	 * 
	 * Método para abrir a janela de cadastro de Hóspede
	 */
	private void menuCadastroHospedeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuCadastroHospedeActionPerformed
		TelaCriarHospede hospede = new TelaCriarHospede();
		hospede.setVisible(true);
		Component add;
		add = desktop.add(hospede);
	}// GEN-LAST:event_menuCadastroHospedeActionPerformed

	private void menuCadastroActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuCadastroActionPerformed

	}// GEN-LAST:event_menuCadastroActionPerformed

	private void comboCadastroItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_comboCadastroItemStateChanged
		// TODO add your handling code here:
	}// GEN-LAST:event_comboCadastroItemStateChanged

	private void btnCheckInActionPerformed(java.awt.event.ActionEvent event) throws IOException {
		TelaCriarHospedagem novaHospedagem = null;
		novaHospedagem = new TelaCriarHospedagem(this.funcionario);
		novaHospedagem.setVisible(true);
		desktop.add(novaHospedagem);
	}

	private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCadastroActionPerformed
		String sel = comboCadastro.getSelectedItem().toString();

		if (sel.equals("Funcionário")) {
			TelaFuncionario funcionario = null;
			try {
				funcionario = new TelaFuncionario();
			} catch (IOException ex) {
				Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
			}
			funcionario.setVisible(true);
			Component add;
			add = desktop.add(funcionario);
		}
		if (sel.equals("Hóspede")) {
			TelaCriarHospede hospede = new TelaCriarHospede();
			hospede.setVisible(true);
			Component add;
			add = desktop.add(hospede);
		}
		if (sel.equals("Quarto")) {
			TelaCriarQuarto quarto = new TelaCriarQuarto();
			quarto.setVisible(true);
			Component add;
			add = desktop.add(quarto);
		} else {

		}
	}// GEN-LAST:event_btnCadastroActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(() -> {
			new TelaPrincipal().setVisible(true);
		});
	}

	private javax.swing.JMenuBar Menu;
	private javax.swing.JButton btnCadastro;
	private javax.swing.JComboBox<String> comboCadastro;
	private javax.swing.JDesktopPane desktop;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel lblData;
	public static javax.swing.JLabel lblUsuario;
	private javax.swing.JMenu menuCadastro;
	public static javax.swing.JMenuItem menuCadastroFuncionario;
	private javax.swing.JMenuItem menuCadastroHospede;
	private javax.swing.JMenu menuOpcoes;
	private javax.swing.JMenuItem menuOpcoesSair;
	public static javax.swing.JMenu menuRelatorio;
	private javax.swing.JMenuItem menuRelatorioConsumo;
	private javax.swing.JMenuItem menuRelatorioHospedagem;
	private BufferedImage img;
	private JButton btnCheckin;
}
