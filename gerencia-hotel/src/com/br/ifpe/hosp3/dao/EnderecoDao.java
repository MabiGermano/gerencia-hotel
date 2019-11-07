package com.br.ifpe.hosp3.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import com.br.ifpe.hosp3.connection.ConexaoMysql;
import com.br.ifpe.hosp3.connection.ManipulacaoDeDados;
import com.br.ifpe.hosp3.model.Endereco;

/**
 * @author Maria Beatriz Germano
 * 
 * Classe com m�todos de manipula��o de dados no banco
 * referente ao objeto Endere�o
 **/
public class EnderecoDao implements ManipulacaoDeDados {

	@Override
	/**
	 * M�todo para cria�ao do objeto Endere�o no banco de dados
	 * 
	 * @param object {@link Object}
	 **/
	public int create(Object object) {
		Connection conexao;
		int resultado = 0;
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
						+ " '" + endereco.getEstado() + "' ,"
						+ " '" + endereco.getComplemento() 
						+ " ')";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
			resultado = this.getLastInsertedId(ps.getGeneratedKeys());
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
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
						+ "estado = '" + endereco.getEstado() + "' ,"
						+ "complemento = '" + endereco.getComplemento() + "' "
						+ "WHERE id = " + endereco.getId();
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * Método de listagem para todos os objetos 
	 * de Endereço no banco de dados
	 * 
	 * @return listaEndereco {@link HashSet<Endereco>}
	 **/
	public HashSet<Object> listAll() {
		Connection conexao;
		HashSet<Object> listaEndereco = new HashSet<>();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM endereco";
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();
			
			while(result.next()) {
				
				Endereco endereco = new Endereco();
				endereco.setId(result.getInt("id"));
				endereco.setRua(result.getString("rua"));
				endereco.setNumero(result.getString("numero"));
				endereco.setBairro(result.getString("bairro"));
				endereco.setCep(result.getString("cep"));
				endereco.setComplemento(result.getString("complemento"));
				endereco.setCidade(result.getString("cidade"));
				endereco.setEstado(result.getString("estado"));
				endereco.setPais(result.getString("pais"));
				
				listaEndereco.add(endereco);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return listaEndereco;
	}

	@Override
	/**
	 * Método para listar o objeto 
	 * Endereço no banco de dados por ID
	 * 
	 * @param id {@link int}
	 * @return endereco {@link Endereco}
	 **/
	public Object getById(int id) {
		Connection conexao;
		Endereco endereco = new Endereco();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM endereco WHERE id =" + id;
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();				
			endereco.setId(result.getInt("id"));
			endereco.setRua(result.getString("rua"));
			endereco.setNumero(result.getString("numero"));
			endereco.setBairro(result.getString("bairro"));
			endereco.setCep(result.getString("cep"));
			endereco.setComplemento(result.getString("complemento"));
			endereco.setCidade(result.getString("cidade"));
			endereco.setEstado(result.getString("estado"));
			endereco.setPais(result.getString("pais"));
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return endereco;
	}

	@Override
	/**
	 * Método para deletar o objeto 
	 * Endereço no banco de dados por Id
	 * 
	 * @param endereco {@link Endereco}
	 **/
	public void delete(int id) {
		Connection conexao;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "DELETE FROM endereco WHERE id =" + id;
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void softDelete(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLastInsertedId(ResultSet rs) {
		int resultado = 0;
	
		try {
			if(rs.next()) {
				resultado = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return resultado;
	}
	
	

}
