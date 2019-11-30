/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.ifpe.hosp3.view;

import java.sql.*;
import com.br.ifpe.hosp3.connection.ConexaoMysql;
import com.br.ifpe.hosp3.model.Funcionario;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;

/**
 *
 * @author Thaysa Gomes
 */
public class TelaFuncionario extends javax.swing.JInternalFrame {
	private boolean alterar = false;

    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Cria nova tela de Funcionário
     *
     * @throws java.io.IOException
     */
    public TelaFuncionario() throws IOException {
        initComponents();

        connection = ConexaoMysql.getConexaoMySQL();
        
        
    }
    
    public TelaFuncionario(Funcionario funcionario) throws IOException {
    	this();
    	setFields(funcionario);
	}

    

	/**
     * 
     * Método para consulta dados de Funcionário
     */
    private void consultar() {
        String sql = "select * from funcionario where nome=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, txtNomeFunc.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                txtCpfFunc.setText(rs.getString(3));
                txtEmailFunc.setText(rs.getString(5));
                txtTelFunc.setText(rs.getString(6));
                txtCodFunc.setText(rs.getString(7));
                txtPassFunc.setText(rs.getString(8));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
                txtNomeFunc.setText(null);
                txtCpfFunc.setText(null);
                txtEmailFunc.setText(null);
                txtTelFunc.setText(null);
                txtCodFunc.setText(null);
                txtPassFunc.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /**
     * 
     * Método para adicionar dados de Funcionário
     */
    private void adicionar() {
        String sql = "insert into funcionario(id, nome, cpf, endereco_id, email, telefone, codigo, palavra_passe) values(?,?,?,?,?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(2, txtNomeFunc.getText());
            pst.setString(3, txtCpfFunc.getText());
            pst.setString(4, txtRuaFunc.getText());
            pst.setString(5, txtEmailFunc.getText());
            pst.setString(6, txtTelFunc.getText());
            pst.setString(7, txtCodFunc.getText());
            pst.setString(8, txtPassFunc.getText());

            if ((txtNomeFunc.getText().isEmpty()) || (txtCpfFunc.getText().isEmpty()) || (txtRuaFunc.getText().isEmpty()) || (txtEmailFunc.getText().isEmpty()) || (txtTelFunc.getText().isEmpty()) || (txtCodFunc.getText().isEmpty()) || (txtPassFunc.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Insira as informações em todos os campos.");
            } else {
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário não pôde ser cadastrado. Tente novamente.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /**
     * 
     * Método para alterar dados de Funcionário
     */
    public void alterar(){
        String sql = "update funcionario set nome=?, cpf=?, endereco_id=?, email=?, telefone=?, codigo=?, palavra_passe=? where id=?";
        
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, txtNomeFunc.getText());
            pst.setString(2, txtCpfFunc.getText());
            pst.setString(3, txtRuaFunc.getText());
            pst.setString(4, txtEmailFunc.getText());
            pst.setString(5, txtTelFunc.getText());
            pst.setString(6, txtCodFunc.getText());
            pst.setString(7, txtPassFunc.getText());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Funcionário");
        getContentPane().setLayout(null);
        scrollPane.setBounds(0, 0, 514, 463);
        getContentPane().add(scrollPane);
        
        JPanel panel = new JPanel();
        scrollPane.setViewportView(panel);
                        panel.setLayout(null);
                
                        lblNomeFunc = new javax.swing.JLabel();
                        lblNomeFunc.setBounds(39, 59, 27, 14);
                        panel.add(lblNomeFunc);
                        
                                lblNomeFunc.setText("Nome");
                txtNomeFunc = new javax.swing.JTextField();
                txtNomeFunc.setBounds(39, 74, 195, 25);
                panel.add(txtNomeFunc);
                lblCpfFunc = new javax.swing.JLabel();
                lblCpfFunc.setBounds(284, 59, 176, 14);
                panel.add(lblCpfFunc);
                
                        lblCpfFunc.setText("CPF");
                        txtCpfFunc = new javax.swing.JTextField();
                        txtCpfFunc.setBounds(284, 74, 190, 25);
                        panel.add(txtCpfFunc);
                        lblCodFunc = new javax.swing.JLabel();
                        lblCodFunc.setBounds(39, 166, 33, 14);
                        panel.add(lblCodFunc);
                        
                                lblCodFunc.setText("Código");
                                txtCodFunc = new javax.swing.JTextField();
                                txtCodFunc.setBounds(39, 183, 78, 25);
                                panel.add(txtCodFunc);
                                lblPassFunc = new javax.swing.JLabel();
                                lblPassFunc.setBounds(277, 112, 67, 14);
                                panel.add(lblPassFunc);
                                
                                        lblPassFunc.setText("Palavra passe");
                                        txtPassFunc = new javax.swing.JTextField();
                                        txtPassFunc.setBounds(277, 129, 197, 25);
                                        panel.add(txtPassFunc);
                                        lblCepFunc = new javax.swing.JLabel();
                                        lblCepFunc.setBounds(350, 166, 117, 14);
                                        panel.add(lblCepFunc);
                                        
                                                lblCepFunc.setText("CEP");
                                        txtCepFunc = new javax.swing.JTextField();
                                        txtCepFunc.setBounds(350, 183, 124, 25);
                                        panel.add(txtCepFunc);
                                        lblCompFunc = new javax.swing.JLabel();
                                        lblCompFunc.setBounds(39, 283, 195, 14);
                                        panel.add(lblCompFunc);
                                        
                                                lblCompFunc.setText("Complemento");
                                                txtCompFunc = new javax.swing.JTextField();
                                                txtCompFunc.setBounds(39, 300, 207, 25);
                                                panel.add(txtCompFunc);
                                                lblPaisFunc = new javax.swing.JLabel();
                                                lblPaisFunc.setBounds(183, 336, 19, 14);
                                                panel.add(lblPaisFunc);
                                                
                                                        lblPaisFunc.setText("País");
                                                        txtPaisFunc = new javax.swing.JTextField();
                                                        txtPaisFunc.setBounds(183, 352, 76, 25);
                                                        panel.add(txtPaisFunc);
                                                                lblEmailFunc = new javax.swing.JLabel();
                                                                lblEmailFunc.setBounds(39, 110, 28, 14);
                                                                panel.add(lblEmailFunc);
                                                                
                                                                        lblEmailFunc.setText("E-mail");
                                                                        txtEmailFunc = new javax.swing.JTextField();
                                                                        txtEmailFunc.setBounds(39, 129, 195, 25);
                                                                        panel.add(txtEmailFunc);
                                                                        lblCidadeFunc = new javax.swing.JLabel();
                                                                        lblCidadeFunc.setBounds(293, 283, 47, 14);
                                                                        panel.add(lblCidadeFunc);
                                                                        
                                                                                lblCidadeFunc.setText("Cidade");
                                                                                txtCidadeFunc = new javax.swing.JTextField();
                                                                                txtCidadeFunc.setBounds(293, 301, 181, 25);
                                                                                panel.add(txtCidadeFunc);
                                                                                lblBairroFunc = new javax.swing.JLabel();
                                                                                lblBairroFunc.setBounds(350, 223, 28, 14);
                                                                                panel.add(lblBairroFunc);
                                                                                
                                                                                        lblBairroFunc.setText("Bairro");
                                                                                        txtBairroFunc = new javax.swing.JTextField();
                                                                                        txtBairroFunc.setBounds(350, 241, 124, 25);
                                                                                        panel.add(txtBairroFunc);
                                                                                        lblEndIdFunc = new javax.swing.JLabel();
                                                                                        lblEndIdFunc.setBounds(39, 222, 19, 14);
                                                                                        panel.add(lblEndIdFunc);
                                                                                        
                                                                                                lblEndIdFunc.setText("Rua");
                                                                                                txtRuaFunc = new javax.swing.JTextField();
                                                                                                txtRuaFunc.setBounds(39, 241, 220, 25);
                                                                                                panel.add(txtRuaFunc);
                                                                                                lblNumFunc = new javax.swing.JLabel();
                                                                                                lblNumFunc.setBounds(282, 226, 37, 14);
                                                                                                panel.add(lblNumFunc);
                                                                                                
                                                                                                        lblNumFunc.setText("Número");
                                                                                                        txtNumFunc = new javax.swing.JTextField();
                                                                                                        txtNumFunc.setBounds(282, 241, 47, 25);
                                                                                                        panel.add(txtNumFunc);
                                                                                                        lblTelFunc = new javax.swing.JLabel();
                                                                                                        lblTelFunc.setBounds(159, 166, 154, 14);
                                                                                                        panel.add(lblTelFunc);
                                                                                                        
                                                                                                                lblTelFunc.setText("Telefone");
                                                                                                                txtTelFunc = new javax.swing.JTextField();
                                                                                                                txtTelFunc.setBounds(159, 183, 154, 25);
                                                                                                                panel.add(txtTelFunc);
                                                                                                                
                                                                                                                lblEstadoFunc = new JLabel("Estado");
                                                                                                                lblEstadoFunc.setBounds(39, 336, 46, 14);
                                                                                                                panel.add(lblEstadoFunc);
                                                                                                                
                                                                                                                txtEstadoFunc = new JTextField();
                                                                                                                txtEstadoFunc.setBounds(39, 352, 97, 25);
                                                                                                                panel.add(txtEstadoFunc);
                                                                                                                txtEstadoFunc.setColumns(10);
                                                                                                                btnAddFunc = new javax.swing.JButton();
                                                                                                                btnAddFunc.setBackground(new Color(0, 128, 0));
                                                                                                                btnAddFunc.setBounds(379, 401, 95, 35);
                                                                                                                panel.add(btnAddFunc);
                                                                                                                
                                                                                                                        btnAddFunc.setText("Adicionar");
                                                                                                                        btnAddFunc.setToolTipText("Adicionar");
                                                                                                                        btnAddFunc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                                                                                                                        btnAddFunc.setPreferredSize(new java.awt.Dimension(80, 80));
                                                                                                                        
                                                                                                                        btnCancelar = new JButton("Cancelar");
                                                                                                                        btnCancelar.setBackground(new Color(0, 128, 0));
                                                                                                                        btnCancelar.setBounds(265, 401, 95, 35);
                                                                                                                        panel.add(btnCancelar);
                                                                                                                        
                                                                                                                        JLabel lblCadastrarFuncionrio = DefaultComponentFactory.getInstance().createTitle("Cadastrar Funcionário");
                                                                                                                        lblCadastrarFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
                                                                                                                        lblCadastrarFuncionrio.setBounds(179, 22, 140, 14);
                                                                                                                        panel.add(lblCadastrarFuncionrio);
                                                                                                                        btnAddFunc.addActionListener(new java.awt.event.ActionListener() {
                                                                                                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                                                                                                btnAddFuncActionPerformed(evt);
                                                                                                                            }
                                                                                                                        });
                                                                                                
                                                                                                        txtRuaFunc.addActionListener(new java.awt.event.ActionListener() {
                                                                                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                                                                                txtRuaFuncActionPerformed(evt);
                                                                                                            }
                                                                                                        });
                                                        
                                                                txtPaisFunc.addActionListener(new java.awt.event.ActionListener() {
                                                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                                        txtPaisFuncActionPerformed(evt);
                                                                    }
                                                                });
                
                        txtNomeFunc.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtNomeFuncActionPerformed(evt);
                            }
                        });

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void setFields(Funcionario funcionario) {
    	txtCodFunc.setText(funcionario.getCodigo());
    	txtNomeFunc.setText(funcionario.getNome());
    	txtCpfFunc.setText(funcionario.getCpf());
    	txtEmailFunc.setText(funcionario.getEmail());
    	txtTelFunc.setText(funcionario.getTelefone());
    	this.alterar = true;
	}

    private void txtRuaFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRuaFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRuaFuncActionPerformed

    private void btnAddFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFuncActionPerformed
        adicionar();
    }//GEN-LAST:event_btnAddFuncActionPerformed

    private void txtPaisFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaisFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaisFuncActionPerformed

    private void txtNomeFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeFuncActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFunc;
    private javax.swing.JLabel lblBairroFunc;
    private javax.swing.JLabel lblCepFunc;
    private javax.swing.JLabel lblCidadeFunc;
    private javax.swing.JLabel lblCodFunc;
    private javax.swing.JLabel lblCompFunc;
    private javax.swing.JLabel lblCpfFunc;
    private javax.swing.JLabel lblEmailFunc;
    private javax.swing.JLabel lblEndIdFunc;
    private javax.swing.JLabel lblNomeFunc;
    private javax.swing.JLabel lblNumFunc;
    private javax.swing.JLabel lblPaisFunc;
    private javax.swing.JLabel lblPassFunc;
    private javax.swing.JLabel lblTelFunc;
    private javax.swing.JTextField txtBairroFunc;
    private javax.swing.JTextField txtCepFunc;
    private javax.swing.JTextField txtCidadeFunc;
    private javax.swing.JTextField txtCodFunc;
    private javax.swing.JTextField txtCompFunc;
    private javax.swing.JTextField txtCpfFunc;
    private javax.swing.JTextField txtEmailFunc;
    private javax.swing.JTextField txtNomeFunc;
    private javax.swing.JTextField txtNumFunc;
    private javax.swing.JTextField txtPaisFunc;
    private javax.swing.JTextField txtPassFunc;
    private javax.swing.JTextField txtRuaFunc;
    private javax.swing.JTextField txtTelFunc;
    private JLabel lblEstadoFunc;
    private JTextField txtEstadoFunc;
    private final JScrollPane scrollPane = new JScrollPane();
    private JButton btnCancelar;
}
