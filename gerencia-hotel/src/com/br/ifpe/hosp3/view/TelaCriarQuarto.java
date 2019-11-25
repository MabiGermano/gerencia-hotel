/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.ifpe.hosp3.view;
import java.awt.Font;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.br.ifpe.hosp3.controller.QuartoController;
import com.br.ifpe.hosp3.model.Quarto;
import com.jgoodies.forms.factories.DefaultComponentFactory;

/**
 *
 * @author THG
 */
public class TelaCriarQuarto extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaCriarQuarto
     */
    public TelaCriarQuarto() {
        initComponents();
    }

    /**
     * Método de ação na interface para criação de quarto
     * @param quarto {@link Quarto}
     * @throws Exception
     **/
    public void criarQuarto(Quarto quarto) {
    	try {
    		QuartoController.criarQuarto(quarto);
    		JOptionPane.showMessageDialog(null, "Quarto "+ quarto.getNumero() + "íncluido com sucesso");
    		this.dispose();
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, e.getMessage());
    	}
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        txtCpfFunc = new javax.swing.JTextField();
        lblCpfFunc = new javax.swing.JLabel();
        lblCpfFunc1 = new javax.swing.JLabel();
        lblCpfFunc1.setBounds(340, 146, 24, 14);
        boxTipo = new javax.swing.JComboBox<>();
        boxTipo.setBounds(340, 167, 121, 23);
        jButton1 = new javax.swing.JButton();
        jButton1.setBounds(321, 272, 74, 24);

        lblCpfFunc.setText("CPF");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Quarto");
        setPreferredSize(new java.awt.Dimension(540, 467));

        lblCpfFunc1.setText("Tipo");

        boxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simples", "Suite" }));

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(boxTipo);
        getContentPane().add(lblCpfFunc1);
        getContentPane().add(jButton1);
        
        textNumero = new JTextField();
        textNumero.setBounds(340, 87, 121, 23);
        getContentPane().add(textNumero);
        textNumero.setColumns(10);
        
        textQtdPessoas = new JTextField();
        textQtdPessoas.setBounds(106, 86, 142, 24);
        getContentPane().add(textQtdPessoas);
        textQtdPessoas.setColumns(10);
        
        textValor = new JTextField();
        textValor.setBounds(106, 172, 140, 24);
        getContentPane().add(textValor);
        textValor.setColumns(10);
        
        JLabel lblQuantidadeDePessoas = new JLabel("Quantidade de pessoas");
        lblQuantidadeDePessoas.setBounds(106, 60, 152, 14);
        getContentPane().add(lblQuantidadeDePessoas);
        
        JLabel lblValor = new JLabel("Valor");
        lblValor.setBounds(106, 146, 55, 14);
        getContentPane().add(lblValor);
        
        JLabel lblNmero = new JLabel("Número");
        lblNmero.setBounds(340, 60, 55, 14);
        getContentPane().add(lblNmero);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(148, 272, 98, 24);
        getContentPane().add(btnCancelar);
        
        JLabel lblNovoQuarto_1 = DefaultComponentFactory.getInstance().createTitle("Novo Quarto");
        lblNovoQuarto_1.setFont(new Font("Dialog", Font.BOLD, 15));
        lblNovoQuarto_1.setBounds(243, 12, 90, 14);
        getContentPane().add(lblNovoQuarto_1);

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	Quarto quarto = new Quarto();
    	quarto.setNumero(textNumero.getText());
    	quarto.setQuantidadePessoas(Integer.parseInt(textQtdPessoas.getText()));
    	quarto.setTipo(boxTipo.getToolTipText());
    	quarto.setValor(Float.parseFloat(textValor.getText()));
    	
    	this.criarQuarto(quarto);
        
    }


    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> boxTipo;
    private javax.swing.JLabel lblCpfFunc;
    private javax.swing.JLabel lblCpfFunc1;
    private javax.swing.JTextField txtCpfFunc;
    private JTextField textNumero;
    private JTextField textQtdPessoas;
    private JTextField textValor;
}
