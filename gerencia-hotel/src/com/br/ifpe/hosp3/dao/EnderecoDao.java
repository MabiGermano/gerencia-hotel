package com.br.ifpe.hosp3.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;

import com.br.ifpe.hosp3.connection.ConexaoMysql;
import com.br.ifpe.hosp3.model.Endereco;

/**
 * @author Maria Beatriz Germano
 * 
 * Classe com métodos de manipulação de dados no banco
 * referente ao objeto Endereço
 **/
public class EnderecoDao implements ManipulacaoDeDados {
	
	@Override
	/**
	 * Método para criação do objeto Endereço no banco de dados
	 * 
	 * @param object {@link Object}
	 **/
	public void create(Object object) {
		Connection conexao;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			Endereco endereco = new Endereco();
			endereco = (Endereco) object;
			
			String sql = "INSERT INTO endereco (rua, numero, cep, "
						+ "bairro, pais, cidade, complemento)"
						+ " VALUES ("
						+ " '" + endereco.getRua() + "' ," 
						+ " '" + endereco.getNumero() + "' ," 
						+ " '" + endereco.getCep() + "' ,"
						+ " '" + endereco.getBairro() + "' ,"
						+ " '" + endereco.getPais() + "' ," 
						+ " '" + endereco.getCidade() + "' ,"
						+ " '" + endereco.getComplemento() 
						+ " ')";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * Método para alterar o objeto Endereço no banco de dados
	 * 
	 * @param object {@link Object}
	 **/
	public void updade(Object object) {
		Connection conexao;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			Endereco endereco = new Endereco();
			endereco = (Endereco) object;
			
			String sql = "UPDATE endereco SET "
						+ "rua = '" + endereco.getRua() + "' ," 
						+ "numero = '" + endereco.getNumero() + "' ," 
						+ "cep = '" + endereco.getCep() + "' ," 
						+ "bairro = '" + endereco.getBairro() + "' ,"
						+ "pais = '" + endereco.getPais() + "' ,"
						+ "cidade = '" + endereco.getCidade() + "' ,"
						+ "complemento = '" + endereco.getComplemento() + "' "
						+ "WHERE id = " + endereco.getId();
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public HashSet<Object> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		
	}

}
