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
import com.br.ifpe.hosp3.model.Hospedagem;
import com.br.ifpe.hosp3.model.Hospede;
import com.br.ifpe.hosp3.model.Quarto;

/**
 * @author Tayn� Alexandra
 * 
 * Classe com m�todos de manipula��o de dados no banco
 * referente ao objeto Hospedagem
 **/

public class HospedagemDao implements ManipulacaoDeDados<Hospedagem>{

	@Override
	/**
	 * M�todo para cria��o do objeto Hospedagem no banco de dados
	 * 
	 * @param object {@link Object}
	 * @throws Exception
	 **/
	public int create(Hospedagem hospedagem) throws Exception {
		Connection conexao;
		int retorno = 0;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			
			String sql = "INSERT INTO hospedagem (hospede_id, quarto_id)"
						+ " VALUES ("
						+ hospedagem.getHospede().getId() + " ,"
						+ hospedagem.getQuarto().getId()
						+ ")";
			
			PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.execute();
			retorno = this.getLastInsertedId(ps.getGeneratedKeys());
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			throw e;
		}
		
		return retorno;
	}

	@Override
	/**
	 * M�todo para altera��o do objeto Hospedagem no banco de dados
	 * 
	 * @param object {@link Object}
	 **/
	public void updade(Hospedagem hospedagem) throws Exception {
		Connection conexao;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			
			HospedeDao hospDao = new HospedeDao();
			hospDao.updade(hospedagem.getHospede());
			
			QuartoDao quartoDao = new QuartoDao();
			quartoDao.updade(hospedagem.getQuarto());
			
			String sql = "UPDATE hospedagem SET "
						+ "hospede_id = '" + hospedagem.getHospede().getId() + "' ,"
						+ "quarto_id = '" + hospedagem.getQuarto().getId() + "' "
						+ "WHERE id = " + hospedagem.getId();
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	/**
	 * M�todo para listagem do objetos Hospedagem no banco de dados
	 * 
	 * @return listaHospedagem {@link HashSet<object>}
	 **/
	public HashSet<Hospedagem> listAll() {
		Connection conexao;
		HashSet<Hospedagem> listaHospedagem = new HashSet<>();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM hospedagem";
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();
			
			while(result.next()) {
				HospedeDao hospDao = new HospedeDao();
				Hospede hospede = hospDao.getById(result.getInt("hospede_id"));
				
				QuartoDao quartoDao = new QuartoDao();
				Quarto quarto = quartoDao.getById(result.getInt("quarto_id"));
				
				Hospedagem hospedagem = new Hospedagem();
				hospedagem.setId(result.getInt("id"));
				hospedagem.setHospede(hospede);
				hospedagem.setQuarto(quarto);
			
				listaHospedagem.add(hospedagem);
			}
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return listaHospedagem;
	}

	@Override
	/**
	 * M�todo para busca do objeto Hospedagem no banco de dados
	 * pelo id
	 * @return hospedagem {@link Hospedagem}
	 **/
	public Hospedagem getById(int id) {
		Connection conexao;
		Hospedagem hospedagem = new Hospedagem();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM hospedagem WHERE id =" + id;
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();				
			if(result != null && result.next()) {
				HospedeDao hospDao = new HospedeDao();
				QuartoDao quartoDao = new QuartoDao();
				
				hospedagem.setId(result.getInt("id"));
				Hospede hospede = hospDao.getById(result.getInt("hospede_id"));
				hospedagem.setHospede(hospede);
				Quarto quarto = quartoDao.getById(result.getInt("quarto_id"));
				hospedagem.setQuarto(quarto);
			}
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return hospedagem;
	}

	@Override
	/**
	 * M�todo para deletar o objeto 
	 * Hospedagem no banco de dados por Id
	 * 
	 * @param hospedagem {@link Hospedagem}
	 **/
	public void delete(int id) {
		Connection conexao;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "DELETE FROM hospedagem WHERE id =" + id;
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void softDelete(Hospedagem hospedagem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * O m�todo pega o ultimo ID inserido no banco de dados
	 * 
	 * @param rs {@link ResultSet}
	 * @return resultado {@link int}
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
	public HashSet<Hospedagem> listDisponible() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
