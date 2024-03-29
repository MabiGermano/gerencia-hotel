/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.ifpe.hosp3.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.br.ifpe.hosp3.controller.HospedeController;
import com.br.ifpe.hosp3.model.Endereco;
import com.br.ifpe.hosp3.model.Hospede;
import com.jgoodies.forms.factories.DefaultComponentFactory;

/**
 *
 * @author Thaysa Gomes
 */
public class TelaCriarHospede extends javax.swing.JInternalFrame {

	private HospedeController hospedeController = new HospedeController();
	private Hospede hospede = new Hospede();
	private boolean alterar = false;
	/**
	 * Método de ação na interface para criar hospede 
	 * 
	 * @param hospede {@link Hospede}
	 * @param endereco {@link Endereco}
	 * 
	 * @throws Exception
	 **/
	public void criarHospede(Hospede hospede) {
		try {
			hospedeController.criarHospede(hospede);
			JOptionPane.showMessageDialog(null, "Hospede " + hospede.getNome() + "Cadastrado com Sucesso!");
			this.dispose();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			this.dispose();
		}
		
	}

	public void editarHospede(Hospede hospede) {
		try {
			hospedeController.editarHospede(hospede);
			JOptionPane.showMessageDialog(null, "Hospede " + hospede.getNome() + "Editado com Sucesso!");
			this.dispose();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			this.dispose();
		}
		
	}
	
    /**
     * Cria nova tela de Hóspede
     * @param hospede 
     */
    public TelaCriarHospede() {
        initComponents();
    }

    public TelaCriarHospede(Hospede hospede) {
    	this();
    	setFields(hospede);
    	this.alterar = true;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	

    	lblEstadoHospede = new javax.swing.JLabel();
    	txtEstadoHospede = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Hóspede");
        
        Color cor = new Color(46,139, 87);
        getContentPane().setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 552, 485);
        getContentPane().add(scrollPane);
        
        panel = new JPanel();
        scrollPane.setViewportView(panel);
        panel.setLayout(null);
        
        lblNomeHospede = new javax.swing.JLabel();
        lblNomeHospede.setBounds(42, 57, 34, 14);
        panel.add(lblNomeHospede);
        
        lblNomeHospede.setText("Nome");
        txtNomeHospede = new javax.swing.JTextField();
        txtNomeHospede.setBounds(41, 73, 154, 23);
        panel.add(txtNomeHospede);
        
        lblEmailHospede = new JLabel("E-mail");
        lblEmailHospede.setBounds(41, 111, 46, 14);
        panel.add(lblEmailHospede);
        
        txtEmailHospede = new JTextField();
        txtEmailHospede.setBounds(41, 129, 247, 23);
        panel.add(txtEmailHospede);
        txtEmailHospede.setColumns(10);
        
        lblRua = new JLabel("Rua");
        lblRua.setBounds(183, 163, 46, 14);
        panel.add(lblRua);
        txtRuaHospede = new javax.swing.JTextField();
        txtRuaHospede.setBounds(183, 180, 220, 23);
        panel.add(txtRuaHospede);
        
                txtRuaHospede.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        txtRuaHospedeActionPerformed(evt);
                    }
                   
                });
        
        JLabel lblCpfHospede = new JLabel();
        lblCpfHospede.setBounds(244, 57, 19, 14);
        panel.add(lblCpfHospede);
        lblCpfHospede.setText("CPF");
        
        txtCpf = new JTextField();
        txtCpf.setBounds(245, 73, 220, 23);
        panel.add(txtCpf);
        txtCpf.setColumns(10);
        
        lblCepHospede = new JLabel("CEP");
        lblCepHospede.setBounds(41, 223, 46, 14);
        panel.add(lblCepHospede);
        
        txtCepHospede = new JTextField();
        txtCepHospede.setBounds(41, 241, 107, 23);
        panel.add(txtCepHospede);
        txtCepHospede.setColumns(10);
        
        lblBairroHospede = new JLabel("Bairro");
        lblBairroHospede.setBounds(344, 275, 63, 14);
        panel.add(lblBairroHospede);
        
        txtBairroHospede = new JTextField();
        txtBairroHospede.setBounds(344, 294, 121, 23);
        panel.add(txtBairroHospede);
        txtBairroHospede.setColumns(10);
        
        lblPaisHospede = new JLabel("Pa\u00EDs");
        lblPaisHospede.setBounds(182, 223, 46, 14);
        panel.add(lblPaisHospede);
        
        txtPaisHospede = new JTextField();
        txtPaisHospede.setBounds(182, 241, 106, 23);
        panel.add(txtPaisHospede);
        txtPaisHospede.setColumns(10);
        
        lblCidadeHospede = new JLabel("Cidade");
        lblCidadeHospede.setBounds(323, 223, 46, 14);
        panel.add(lblCidadeHospede);
        
        txtCidadeHospede = new JTextField();
        txtCidadeHospede.setBounds(323, 241, 142, 23);
        panel.add(txtCidadeHospede);
        txtCidadeHospede.setColumns(10);
        
        lblEstadoHospede_1 = new JLabel("Estado");
        lblEstadoHospede_1.setBounds(41, 275, 46, 14);
        panel.add(lblEstadoHospede_1);
        
        txtEstadoHospede_1 = new JTextField();
        txtEstadoHospede_1.setBounds(41, 294, 86, 23);
        panel.add(txtEstadoHospede_1);
        txtEstadoHospede_1.setColumns(10);
        
        lblPassHospede = new JLabel("Palavra passe");
        lblPassHospede.setBounds(323, 116, 107, 14);
        panel.add(lblPassHospede);
        
        txtPassHospede = new JTextField();
        txtPassHospede.setBounds(323, 132, 142, 20);
        panel.add(txtPassHospede);
        txtPassHospede.setColumns(10);
        
        lblCompHospede = new JLabel("Complemento");
        lblCompHospede.setBounds(156, 275, 86, 14);
        panel.add(lblCompHospede);
        
        txtCompHospede = new JTextField();
        txtCompHospede.setBounds(156, 294, 155, 23);
        panel.add(txtCompHospede);
        txtCompHospede.setColumns(10);
        
        lblTelHospede = new JLabel("Telefone");
        lblTelHospede.setBounds(42, 163, 134, 14);
        panel.add(lblTelHospede);
        
        txtTelHospede = new JTextField();
        txtTelHospede.setBounds(42, 181, 120, 23);
        panel.add(txtTelHospede);
        txtTelHospede.setColumns(10);
        
        lblNumHospede = new JLabel("N\u00FAmero");
        lblNumHospede.setBounds(420, 163, 46, 14);
        panel.add(lblNumHospede);
        
        txtNumHospede = new JTextField();
        txtNumHospede.setBounds(420, 179, 46, 23);
        panel.add(txtNumHospede);
        txtNumHospede.setColumns(10);
                
                JLabel lblCadastrarHspede = DefaultComponentFactory.getInstance().createTitle("Cadastrar Hóspede");
                lblCadastrarHspede.setFont(new Font("Tahoma", Font.PLAIN, 14));
                lblCadastrarHspede.setBounds(194, 23, 117, 14);
                panel.add(lblCadastrarHspede);
                
                btnAddHospede = new javax.swing.JButton();
                btnAddHospede.setBounds(370, 350, 95, 35);
                panel.add(btnAddHospede);
                
                        //btnAddHospede.setIcon(new javax.swing.ImageIcon(getClass().getResource("./../resources/img/"))); // NOI18N /*iconfinder*/
                        btnAddHospede.setText("Adicionar");
                        btnAddHospede.setBackground(cor);
                        btnAddHospede.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                        btnAddHospede.setPreferredSize(new java.awt.Dimension(80, 50));
                        
                        JButton btnCancelar = new JButton("Cancelar");
                        btnCancelar.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent arg0) {
                        	}
                        });
                        btnCancelar.setBackground(new Color(0, 128, 0));
                        btnCancelar.setBounds(265, 350, 95, 35);
                        panel.add(btnCancelar);
                
       //Adicionando evento para botão de salvar ouvir
                btnAddHospede.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                    	btnSaveAction(evt);
                    }
                });
        
                txtNomeHospede.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        txtNomeHospedeActionPerformed(evt);
                    }
                });

        pack();
    }

    private void txtNomeHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeHospedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeHospedeActionPerformed

    private void txtRuaHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRuaHospedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRuaHospedeActionPerformed

    private void btnSaveAction(java.awt.event.ActionEvent evt) {
    	Endereco endereco = new Endereco();
    	endereco.setBairro(txtBairroHospede.getText());
    	endereco.setCep(txtCepHospede.getText());
    	endereco.setCidade(txtCidadeHospede.getText());
    	endereco.setEstado(txtEstadoHospede_1.getText());
    	endereco.setComplemento(txtCompHospede.getText());
    	endereco.setNumero(txtNumHospede.getText());
    	endereco.setPais(txtPaisHospede.getText());
    	endereco.setRua(txtRuaHospede.getText());
    	
    	this.hospede.setCpf(txtCpf.getText());
    	this.hospede.setEmail(txtEmailHospede.getText());
    	this.hospede.setNome(txtNomeHospede.getText());
    	this.hospede.setPalavraPasse(txtPassHospede.getText());
    	this.hospede.setTelefone(txtTelHospede.getText());
    	this.hospede.setEndereco(endereco);
	
    	if(this.alterar) {
    		this.editarHospede(this.hospede);
    	}else {
    		this.criarHospede(this.hospede);
    	}
    }
    
    private void setFields(Hospede hospede) {
    	this.hospede = hospede;
    	txtNomeHospede.setText(hospede.getNome());
    	txtCpf.setText(hospede.getCpf());
    	txtEmailHospede.setText(hospede.getEmail());
    	txtTelHospede.setText(hospede.getTelefone());
    	txtRuaHospede.setText(hospede.getEndereco().getRua());
    	txtNumHospede.setText(hospede.getEndereco().getNumero());
    	txtBairroHospede.setText(hospede.getEndereco().getBairro());
    	txtCepHospede.setText(hospede.getEndereco().getCep());
    	txtPaisHospede.setText(hospede.getEndereco().getPais());
    	txtCidadeHospede.setText(hospede.getEndereco().getCidade());
    	txtEstadoHospede_1.setText(hospede.getEndereco().getEstado());
    	txtCompHospede.setText(hospede.getEndereco().getComplemento());
    	Color cor = new Color(46,139, 87);
		btnEditHospede = new javax.swing.JButton();
	    btnEditHospede.setBounds(370, 350, 95, 35);
	    panel.add(btnEditHospede);
	    panel.remove(btnAddHospede);
	    btnEditHospede.setText("Salvar");
	    btnEditHospede.setBackground(cor);
	    btnEditHospede.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	    btnEditHospede.setPreferredSize(new java.awt.Dimension(80, 50));     
	    btnEditHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnSaveAction(evt);
            }
        });
    }

    
    private javax.swing.JButton btnAddHospede;
    private javax.swing.JButton btnEditHospede;
    private javax.swing.JLabel lblNomeHospede;
    private javax.swing.JTextField txtNomeHospede;
    private javax.swing.JTextField txtRuaHospede;
    private JLabel lblEmailHospede;
    private JTextField txtEmailHospede;
    private JLabel lblRua;
    private JTextField txtCpf;
    private JLabel lblNumHospede;
    private JTextField txtNumHospede;
    private JLabel lblCepHospede;
    private JTextField txtCepHospede;
    private JLabel lblBairroHospede;
    private JTextField txtBairroHospede;
    private JLabel lblPaisHospede;
    private JTextField txtPaisHospede;
    private JLabel lblCidadeHospede;
    private JTextField txtCidadeHospede;
    private JLabel lblEstadoHospede;
    private JLabel lblEstadoHospede_1;
    private JTextField txtEstadoHospede;
    private JTextField txtEstadoHospede_1;
    private JLabel lblPassHospede;
    private JTextField txtPassHospede;
    private JLabel lblCompHospede;
    private JTextField txtCompHospede;
    private JLabel lblTelHospede;
    private JTextField txtTelHospede;
    private JPanel panel;
}
