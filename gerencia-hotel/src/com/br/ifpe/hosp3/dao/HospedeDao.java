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
import com.br.ifpe.hosp3.model.Hospede;
import com.br.ifpe.hosp3.model.hospede;

/**
 * @author Maria Beatriz Germano
 * 
 * Classe com métodos de manipulação de dados no banco
 * referente ao objeto Hospede
 **/
public class HospedeDao implements ManipulacaoDeDados{

	@Override
	/**
	 * Método para criaçao do objeto Hospede no banco de dados
	 * 
	 * @param object {@link Object}
	 **/
	public int create(Object object) {
		Connection conexao;
		int retorno = 0;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			Hospede hospede = new Hospede();
			hospede = (Hospede) object;
			Endereco endereco = new Endereco(hospede.getEndereco());
			EnderecoDao endDao = new EnderecoDao();
			int endereco_id = endDao.create(endereco);
			
			
			String sql = "INSERT INTO hospede (nome, cpf, email, telefone, palavra_passe, hospede_id)"
						+ " VALUES ("
						+ " '" + hospede.getNome() + "' ," 
						+ " '" + hospede.getCpf() + "' ," 
						+ " '" + hospede.getEmail() + "' ,"
						+ " '" + hospede.getTelefone() + "' ,"
						+ " '" + hospede.getPalavra_passe() + "' ,"
						+ " '" + endereco_id + "' ,"
						+ " ')";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
			retorno = this.getLastInsertedId(ps.getGeneratedKeys());
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}

	@Override
	/**
	 * Método para alteraçao do objeto Hospede no banco de dados
	 * 
	 * @param object {@link Object}
	 **/
	public void updade(Object object) {
		Connection conexao;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			Hospede hospede = (Hospede) object;
			
			String sql = "UPDATE hospede SET "
						+ "nome = '" + hospede.getNome()+ "' ," 
						+ "cpf = '" + hospede.getCpf() + "' ," 
						+ "email = '" + hospede.getEmail() + "' ," 
						+ "telefone = '" + hospede.getTelefone() + "' ,"
						+ "palavra_passe = '" + hospede.getPalavra_passe() + "' ,"
						+ "hospede_id = '" + hospede.getEndereco().getId() + "' ,"
						+ "WHERE id = " + hospede.getId();
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * Método para listagem do objetos Hospedes no banco de dados
	 * 
	 * @return listaHospede {@link HashSet<object>}
	 **/
	public HashSet<Object> listAll() {
		Connection conexao;
		HashSet<Object> listaHospede = new HashSet<>();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM hospede";
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();
			
			while(result.next()) {
				EnderecoDao endDao = new EnderecoDao();
				Endereco endereco = (Endereco) endDao.getById(result.getInt("endereco_id"));
				Hospede hospede = new Hospede();
				hospede.setId(result.getInt("id"));
				hospede.setNome(result.getString("nome"));
				hospede.setCpf(result.getString("cpf"));
				hospede.setEmail(result.getString("email"));
				hospede.setTelefone(result.getString("telefone"));
				hospede.setPalavra_passe(result.getString("palavra_passe"));
				hospede.setEndereco(endereco);
			
				listaHospede.add(hospede);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return listaHospede;
	}

	@Override
	public Object getById(int id) {
		Connection conexao;
		Hospede hospede = new Hospede();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			EnderecoDao endDao = new EnderecoDao();
			String sql = "SELECT * FROM hospede WHERE id =" + id;
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();				
			hospede.setId(result.getInt("id"));
			hospede.setNome(result.getString("nome"));
			hospede.setCpf(result.getString("cpf"));
			hospede.setEmail(result.getString("email"));
			hospede.setTelefone(result.getString("telefone"));
			hospede.setPalavra_passe(result.getString("palavra_passe"));
			Endereco endereco = (Endereco) endDao.getById(result.getInt("endereco_id"));
			hospede.setEndereco(endereco);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return hospede;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
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
