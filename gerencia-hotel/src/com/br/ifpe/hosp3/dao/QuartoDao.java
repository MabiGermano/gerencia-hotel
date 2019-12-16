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
import com.br.ifpe.hosp3.model.Hospede;
import com.br.ifpe.hosp3.model.Quarto;

/**
 * @author Tayn� Alexandra
 * 
 * Classe com m�todos de manipula�ao de dados no banco
 * referente ao objeto Quarto
 **/

public class QuartoDao implements ManipulacaoDeDados<Quarto>{

	@Override
	/**
	 * M�todo para cria��o do objeto Quarto no banco de dados
	 * 
	 * @param object {@link Object}
	 **/
	public int create(Quarto quarto) throws Exception {
		Connection conexao;
		int resultado = 0;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			
			String sql = "INSERT INTO quarto (valor, quantidade_pessoas, "
					    + "tipo, numero, disponivel)"
					    + "VALUES ("
					    + 		 quarto.getValor() + " ,"
					    + 		 quarto.getQuantidadePessoas() + " ,"
					    + " '" + quarto.getTipo() + "' ,"
					    + " '" + quarto.getNumero() + "' ,"
					    +		 quarto.isDisponivel()
					    + " )";
			
			PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.execute();
			resultado = this.getLastInsertedId(ps.getGeneratedKeys());
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			throw new Exception("Não foi possível incluir quarto, dados inválidos");
		}
		
		return resultado;
	}

	@Override
	/**
	 * M�todo para alterar o objeto Quarto no banco de dados
	 * 
	 * @param object {@link Object}
	 **/
	public void updade(Quarto quarto) throws Exception {
		Connection conexao;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			
			String sql = "UPDATE quarto SET "
						+ "valor = " + quarto.getValor() + " ,"
					    + "quantidade_pessoas = " + quarto.getQuantidadePessoas() + " ,"
					    + "tipo = '" + quarto.getTipo() + "' ,"
					    + "numero = '" + quarto.getNumero() + "' ,"
					    + "disponivel = " + quarto.isDisponivel()
					    + " WHERE id = " + quarto.getId();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			throw e;
		}	
	}
	
	@Override
	/**
	 * M�todo de listagem para todos os objetos 
	 * de Quarto no banco de dados
	 * 
	 * @return listaQuarto {@link HashSet<Quarto>}
	 **/
	public HashSet<Quarto> listAll() throws Exception {
		Connection conexao;
		HashSet<Quarto> listaQuarto = new HashSet<>();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM quarto";
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();
			
			while(result.next()) {
				
				Quarto quarto = new Quarto();
				
				quarto.setId(result.getInt("id"));
				quarto.setValor(result.getFloat("valor"));
				quarto.setQuantidadePessoas(result.getInt("quantidade_pessoas"));
				quarto.setTipo(result.getString("tipo"));
				quarto.setNumero(result.getString("numero"));
				quarto.setDisponivel(result.getBoolean("disponivel"));
				
				listaQuarto.add(quarto);
			}
		} catch (IOException | SQLException e) {
			throw e;
		}

		return listaQuarto;
	}

	@Override
	/**
	 * M�todo de listagem para todos os objetos 
	 * de Quarto setados como disponível no banco de dados
	 * 
	 * @return listaQuarto {@link HashSet<Quarto>}
	 **/
	public HashSet<Quarto> listDisponible() throws Exception {
		Connection conexao;
		HashSet<Quarto> listaQuarto = new HashSet<>();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM quarto where disponivel =" + true;
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();
			
			while(result.next()) {
				
				Quarto quarto = new Quarto();
				
				quarto.setId(result.getInt("id"));
				quarto.setValor(result.getFloat("valor"));
				quarto.setQuantidadePessoas(result.getInt("quantidade_pessoas"));
				quarto.setTipo(result.getString("tipo"));
				quarto.setNumero(result.getString("numero"));
				quarto.setDisponivel(result.getBoolean("disponivel"));
				
				listaQuarto.add(quarto);
			}
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			throw e;
		}

		return listaQuarto;
	}

	@Override
	/**
	 * M�todo para listar o objeto 
	 * Quarto no banco de dados por ID
	 * 
	 * @param id {@link int}
	 * @return quarto {@link Quarto}
	 **/
	public Quarto getById(int id) {
		Connection conexao;
		Quarto quarto = new Quarto();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM quarto WHERE id =" + id;
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();
			if(result != null && result.next()) {
				quarto.setId(result.getInt("id"));
				quarto.setValor(result.getFloat("valor"));
				quarto.setQuantidadePessoas(result.getInt("quantidade_pessoas"));
				quarto.setTipo(result.getString("tipo"));
				quarto.setNumero(result.getString("numero"));
				quarto.setDisponivel(result.getBoolean("disponivel"));	
			}
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	
		return quarto;
	}

	@Override
	/**
	 * M�todo para deletar o objeto 
	 * Quarto no banco de dados por Id
	 * 
	 * @param id {@link Int}
	 **/
	public void delete(int id) throws Exception {
		Connection conexao;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "DELETE FROM quarto WHERE id =" + id;
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			throw new Exception("Não foi possível deletar este quarto");
		}
	}

	@Override
	public void softDelete(Quarto quarto) {
		
		
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

	/**
	 * Método para busca do objeto Quarto no banco de dados
	 * pelo numero
	 * @param numero {@link String}
	 * @return  {@link Hospede}
	 * @throws Exception 
	 **/
	public Quarto findByNumero(String numero) {
		
		Connection conexao;
		Quarto quarto = new Quarto();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM quarto WHERE numero =" + numero;
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();
			if(result != null && result.next()) {
				quarto.setId(result.getInt("id"));
				quarto.setValor(result.getFloat("valor"));
				quarto.setQuantidadePessoas(result.getInt("quantidade_pessoas"));
				quarto.setTipo(result.getString("tipo"));
				quarto.setNumero(result.getString("numero"));
				quarto.setDisponivel(result.getBoolean("disponivel"));	
			}
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	
		return quarto;
	}
}
