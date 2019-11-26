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
import com.br.ifpe.hosp3.model.ConsumoExtra;

/**
 * @author Tayn� Alexandra
 * 
 * Classe com m�todos de manipula�ao de dados no banco
 * referente ao objeto ConsumoExtra
 **/

public class ConsumoExtraDao implements ManipulacaoDeDados<ConsumoExtra> {

	@Override
	/**
	 * M�todo para cria��o do objeto ConsumoExtra no banco de dados
	 * 
	 * @param object {@link Object}
	 **/
	public int create(ConsumoExtra consumoExtra) {
		Connection conexao;
		int resultado = 0;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			
			String sql = "INSERT INTO consumo_extra (descricao, valor, hospedagem_id)"
						+ "VALUES ("
						+ " '" + consumoExtra.getDescricao() + "' ,"
						+ 		consumoExtra.getValor() + " ,"
						+  		consumoExtra.getHospedagem().getId()
						+ " )";
			
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
	 * M�todo para alterar o objeto ConsumoExtra no banco de dados
	 * 
	 * @param object {@link Object}
	 **/
	public void updade(ConsumoExtra consumoExtra) {
		Connection conexao;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			
			String sql = "UPDATE consumo_extra set"
						+ "descricao = '" + consumoExtra.getDescricao() + "' ,"
						+ "valor = " + consumoExtra.getValor() + " ,"
						+ "hospedagem_id = " + consumoExtra.getHospedagem().getId()
						+ "WHERE id = " + consumoExtra.getId();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	/**
	 * M�todo de listagem para todos os objetos 
	 * de ConsumoExtra no banco de dados
	 * 
	 * @return listaConsumoExtra {@link HashSet<ConsumoExtra>}
	 **/
	public HashSet<ConsumoExtra> listAll() {
		Connection conexao;
		HashSet<ConsumoExtra> listaConsumoExtra = new HashSet<>();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM consumo_extra";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
		
			ResultSet result =  ps.executeQuery();
		
			while(result.next()) {
				
				ConsumoExtra consumoExtra = new ConsumoExtra();
				
				consumoExtra.setId(result.getInt("id"));
				consumoExtra.setDescricao(result.getString("descricao"));
				consumoExtra.setValor(result.getFloat("valor"));
			
				listaConsumoExtra.add(consumoExtra);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return listaConsumoExtra;
	}

	@Override
	/**
	 * M�todo para listar o objeto 
	 * ConsumoExtra no banco de dados por ID
	 * 
	 * @param id {@link int}
	 * @return consumoExtra {@link ConsumoExtra}
	 **/
	public ConsumoExtra getById(int id) {
		Connection conexao;
		ConsumoExtra consumoExtra = new ConsumoExtra();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM consumo_extra WHERE id =" + id;
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();
			if(result != null && result.next()) {
				consumoExtra.setId(result.getInt("id"));
				consumoExtra.setDescricao(result.getString("descricao"));
				consumoExtra.setValor(result.getFloat("valor"));
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return consumoExtra;
	}

	@Override
	/**
	 * M�todo para deletar o objeto 
	 * ConsumoExtra no banco de dados por Id
	 * 
	 * @param id {@link Int}
	 **/
	public void delete(int id) {
		Connection conexao;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "DELETE FROM consumo_extra WHERE id =" + id;
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void softDelete(ConsumoExtra consumoExtra) {
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

	@Override
	public HashSet<ConsumoExtra> listDisponible() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
