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
import com.br.ifpe.hosp3.model.Quarto;

/**
 * @author Tayn� Alexandra
 * 
 * Classe com m�todos de manipula�ao de dados no banco
 * referente ao objeto Quarto
 **/

public class QuartoDao implements ManipulacaoDeDados{

	@Override
	/**
	 * M�todo para cria��o do objeto Quarto no banco de dados
	 * 
	 * @param object {@link Object}
	 **/
	public int create(Object object) {
		Connection conexao;
		int resultado = 0;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			Quarto quarto = new Quarto();
			quarto = (Quarto) object;
			
			String sql = "INSERT INTO quarto (valor, quantidadePessoas, "
					    + "tipo, numero, disponivel)"
					    + "VALUES ("
					    + " '" + quarto.getValor() + "' ,"
					    + " '" + quarto.getQuantidadePessoas() + "' ,"
					    + " '" + quarto.getTipo() + "' ,"
					    + " '" + quarto.getNumero() + "' ,"
					    + " '" + quarto.isDisponivel()
					    + " ')";
			
			PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.execute();
			resultado = this.getLastInsertedId(ps.getGeneratedKeys());
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}

	@Override
	/**
	 * M�todo para alterar o objeto Quarto no banco de dados
	 * 
	 * @param object {@link Object}
	 **/
	public void updade(Object object) {
		Connection conexao;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			Quarto quarto = new Quarto();
			quarto = (Quarto) object;
			
			String sql = "UPDATE quarto SET "
						+ "valor = '" + quarto.getValor() + "' ,"
					    + "quantidade_pessoas = '" + quarto.getQuantidadePessoas() + "' ,"
					    + "tipo = '" + quarto.getTipo() + "' ,"
					    + "numero = '" + quarto.getNumero() + "' ,"
					    + "disponivel = '" + quarto.isDisponivel() + "' "
					    + "WHERE id = " + quarto.getId();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	/**
	 * M�todo de listagem para todos os objetos 
	 * de Quarto no banco de dados
	 * 
	 * @return listaQuarto {@link HashSet<Quarto>}
	 **/
	public HashSet<Object> listAll() {
		Connection conexao;
		HashSet<Object> listaQuarto = new HashSet<>();
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
			e.printStackTrace();
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
	public Object getById(int id) {
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
	public void delete(int id) {
		Connection conexao;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "DELETE FROM quarto WHERE id =" + id;
						
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
	/**
	 * O m�todo pega o ultimo ID inserido no banco de dados
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
}