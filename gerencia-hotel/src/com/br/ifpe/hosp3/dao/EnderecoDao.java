package com.br.ifpe.hosp3.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class EnderecoDao implements ManipulacaoDeDados<Endereco> {

	@Override
	/**
	 * M�todo para cria�ao do objeto Endere�o no banco de dados
	 * 
	 * @param object {@link Object}
	 **/
	public int create(Endereco endereco) throws Exception {
		Connection conexao;
		int resultado = 0;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			
			String sql = "INSERT INTO endereco (rua, numero, cep, "
						+ "bairro, pais, cidade, estado,complemento)"
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
			
			PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.execute();
			resultado = this.getLastInsertedId(ps.getGeneratedKeys());
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			throw new Exception("Os dados de endereço estão incorretos, verefique e tente novamente");
		}
		
		return resultado;
	}

	@Override
	/**
	 * Método para alterar o objeto Endereço no banco de dados
	 * 
	 * @param object {@link Object}
	 **/
	public void updade(Endereco endereco) {
		Connection conexao;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			
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
			ConexaoMysql.FecharConexao();
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
	public HashSet<Endereco> listAll() {
		Connection conexao;
		HashSet<Endereco> listaEndereco = new HashSet<>();
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
			ConexaoMysql.FecharConexao();
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
	public Endereco getById(int id) {
		Connection conexao;
		Endereco endereco = new Endereco();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM endereco WHERE id =" + id;
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();	
			if(result != null && result.next()) {
				endereco.setId(result.getInt("id"));
				endereco.setRua(result.getString("rua"));
				endereco.setNumero(result.getString("numero"));
				endereco.setBairro(result.getString("bairro"));
				endereco.setCep(result.getString("cep"));
				endereco.setComplemento(result.getString("complemento"));
				endereco.setCidade(result.getString("cidade"));
				endereco.setEstado(result.getString("estado"));
				endereco.setPais(result.getString("pais"));	
			}			
			ConexaoMysql.FecharConexao();
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
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void softDelete(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * O método pega o ultimo ID inserido no banco de dados
	 * 
	 * @param rs {@link ResultSet}
	 **/
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

	@Override
	public HashSet<Endereco> listDisponible() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
