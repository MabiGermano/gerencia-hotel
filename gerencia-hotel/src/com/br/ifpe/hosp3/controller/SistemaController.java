package com.br.ifpe.hosp3.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.br.ifpe.hosp3.view.TelaLogin;

public class SistemaController {

	public static void main(String[] args) {
		init();
	}
	
	public static void init() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(() -> {
			try {
				new TelaLogin().setVisible(true);
			} catch (IOException ex) {
				Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
			}
		});
	}
}
