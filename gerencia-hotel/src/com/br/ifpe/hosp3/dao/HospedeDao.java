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
import com.br.ifpe.hosp3.model.Hospede;

/**
 * @author Maria Beatriz Germano
 * 
 * Classe com m�todos de manipula��o de dados no banco
 * referente ao objeto Hospede
 **/
public class HospedeDao implements ManipulacaoDeDados<Hospede>{

	@Override
	/**
	 * M�todo para cria�ao do objeto Hospede no banco de dados
	 * 
	 * @param object {@link Object}
	 **/
	public int create(Hospede hospede) throws Exception {
		Connection conexao;
		int retorno = 0;
		try {
			
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "INSERT INTO hospede (nome, cpf, email, telefone, palavra_passe, endereco_id)"
						+ " VALUES ("
						+ " '" + hospede.getNome() + "' ," 
						+ " '" + hospede.getCpf() + "' ," 
						+ " '" + hospede.getEmail() + "' ,"
						+ " '" + hospede.getTelefone() + "' ,"
						+ " '" + hospede.getPalavraPasse() + "' ,"
						+ hospede.getEndereco().getId()
						+ ")";
			
			PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.execute();
			retorno = this.getLastInsertedId(ps.getGeneratedKeys());
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			throw new Exception("Não fui possível incluir hospede, verifique os dados e tente novamente");
		}
		
		return retorno;
	}

	@Override
	/**
	 * M�todo para altera�ao do objeto Hospede no banco de dados
	 * 
	 * @param object {@link Object}
	 **/
	public void updade(Hospede hospede) {
		Connection conexao;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			
			EnderecoDao endDao = new EnderecoDao();
			endDao.updade(hospede.getEndereco());
			
			String sql = "UPDATE hospede SET "
						+ "nome = '" + hospede.getNome()+ "' ," 
						+ "cpf = '" + hospede.getCpf() + "' ," 
						+ "email = '" + hospede.getEmail() + "' ," 
						+ "telefone = '" + hospede.getTelefone() + "' ,"
						+ "palavra_passe = '" + hospede.getPalavraPasse() + "' "
						+ "WHERE id = " + hospede.getId();
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * M�todo para listagem do objetos Hospedes no banco de dados
	 * 
	 * @return listaHospede {@link HashSet<object>}
	 **/
	public HashSet<Hospede> listAll() {
		Connection conexao;
		HashSet<Hospede> listaHospede = new HashSet<>();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM hospede";
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();
			
			while(result.next()) {
				EnderecoDao endDao = new EnderecoDao();
				Endereco endereco = endDao.getById(result.getInt("endereco_id"));
				Hospede hospede = new Hospede();
				hospede.setId(result.getInt("id"));
				hospede.setNome(result.getString("nome"));
				hospede.setCpf(result.getString("cpf"));
				hospede.setEmail(result.getString("email"));
				hospede.setTelefone(result.getString("telefone"));
				hospede.setPalavraPasse(result.getString("palavra_passe"));
				hospede.setEndereco(endereco);
			
				listaHospede.add(hospede);
			}
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return listaHospede;
	}

	@Override
	/**
	 * Método para busca do objeto Hospede no banco de dados
	 * pelo id
	 * @return hospede {@link Hospede}
	 **/
	public Hospede getById(int id) {
		Connection conexao;
		Hospede hospede = new Hospede();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM hospede WHERE id =" + id;
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();				
			if(result != null && result.next()) {
				EnderecoDao endDao = new EnderecoDao();
				hospede.setId(result.getInt("id"));
				hospede.setNome(result.getString("nome"));
				hospede.setCpf(result.getString("cpf"));
				hospede.setEmail(result.getString("email"));
				hospede.setTelefone(result.getString("telefone"));
				hospede.setPalavraPasse(result.getString("palavra_passe"));
				Endereco endereco = endDao.getById(result.getInt("endereco_id"));
				hospede.setEndereco(endereco);	
			}
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return hospede;
	}

	/**
	 * Método para busca do objeto Hospede no banco de dados
	 * pelo cpf
	 * @param cpf {@link String}
	 * @return hospede {@link Hospede}
	 * @throws Exception 
	 **/
	public Hospede findByCpf(String cpf) throws Exception {
		Connection conexao;
		Hospede hospede = new Hospede();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM hospede WHERE cpf ='" + cpf + "'";
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();				
			if(result != null && result.next()) {
				EnderecoDao endDao = new EnderecoDao();
				hospede.setId(result.getInt("id"));
				hospede.setNome(result.getString("nome"));
				hospede.setCpf(result.getString("cpf"));
				hospede.setEmail(result.getString("email"));
				hospede.setTelefone(result.getString("telefone"));
				hospede.setPalavraPasse(result.getString("palavra_passe"));
				Endereco endereco = endDao.getById(result.getInt("endereco_id"));
				hospede.setEndereco(endereco);	
			}else {
				hospede = null;
			}
			
		} catch (IOException | SQLException e) {
			throw e;
		}

		return hospede;
	}
	@Override
	/**
	 * Método para deletar o objeto 
	 * Hospede no banco de dados por Id
	 * 
	 * @param hospede {@link Hospede}
	 **/
	public void delete(int id) {
		Connection conexao;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "DELETE FROM hospede WHERE id =" + id;
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void softDelete(Hospede hospede) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * O método pega o ultimo ID inserido no banco de dados
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
	
	/**
	 * Método verifica se CPF já está registrado no banco de dados
	 * @param cpf {@link String}
	 * @return retorno {@link boolean}
	 **/
	public boolean verifyIsCpfRegistred(String cpf) {
		Connection conexao;
		boolean retorno = false;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM hospede WHERE cpf =" + cpf;
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();				
			if(result != null && result.next()) {
				retorno = true;	
			}
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	@Override
	public HashSet<Hospede> listDisponible() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
