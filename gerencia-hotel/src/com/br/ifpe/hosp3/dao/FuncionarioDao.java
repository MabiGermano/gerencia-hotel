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
import com.br.ifpe.hosp3.model.Funcionario;
import com.br.ifpe.hosp3.util.Criptografia;

public class FuncionarioDao implements ManipulacaoDeDados<Funcionario>{
	
	@Override
	/**
	 * M�todo para cria�ao do objeto Funcionario no banco de dados
	 * 
	 * @param object {@link Object}
	 **/
	public int create(Funcionario funcionario) {
		Connection conexao;
		int retorno = 0;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			
			String sql = "INSERT INTO funcionario (nome, cpf, email, cargo, codigo, telefone, palavra_passe, endereco_id)"
						+ " VALUES ("
						+ " '" + funcionario.getNome() + "' ," 
						+ " '" + funcionario.getCpf() + "' ," 
						+ " '" + funcionario.getEmail() + "' ,"
						+ " '" + funcionario.getCargo() + "' ,"
						+ " '" + funcionario.getCodigo() + "' ,"
						+ " '" + funcionario.getTelefone() + "' ,"
						+ " '" + Criptografia.criptografar(funcionario.getPalavraPasse()) + "' ,"
						+ funcionario.getEndereco().getId()
						+ ")";
			
			PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.execute();
			retorno = this.getLastInsertedId(ps.getGeneratedKeys());
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}

	@Override
	/**
	 * M�todo para altera�ao do objeto Funcionario no banco de dados
	 * 
	 * @param object {@link Object}
	 **/
	public void updade(Funcionario funcionario) {
		Connection conexao;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			
			EnderecoDao endDao = new EnderecoDao();
			endDao.updade(funcionario.getEndereco());
			
			String sql = "UPDATE funcionario SET "
						+ "nome = '" + funcionario.getNome()+ "' ," 
						+ "cpf = '" + funcionario.getCpf() + "' ," 
						+ "email = '" + funcionario.getEmail() + "' ," 
						+ "cargo = '" + funcionario.getCargo() + "' ,"
						+ "telefone = '" + funcionario.getTelefone() + "' ,"
						+ "palavra_passe = '" + Criptografia.criptografar(funcionario.getPalavraPasse()) + "' ,"
						+ "endereco_id = '" + funcionario.getEndereco().getId() + "' "
						+ "WHERE id = " + funcionario.getId();
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * M�todo para listagem do objetos Funcionarios no banco de dados
	 * 
	 * @return listaFuncionario {@link HashSet<object>}
	 **/
	public HashSet<Funcionario> listAll() {
		Connection conexao;
		HashSet<Funcionario> listaFuncionario = new HashSet<>();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM funcionario";
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();
			
			while(result.next()) {
				
				Funcionario funcionario = new Funcionario();
				funcionario = this.constructObject(funcionario, result);
			
				listaFuncionario.add(funcionario);
			}
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return listaFuncionario;
	}

	@Override
	/**
	 * Método para busca do objeto Funcionario no banco de dados
	 * pelo id
	 * @return funcionario {@link Funcionario}
	 **/
	public Funcionario getById(int id) {
		Connection conexao;
		Funcionario funcionario = new Funcionario();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM funcionario WHERE id =" + id;
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();				
			if(result != null && result.next()) {

				funcionario = this.constructObject(funcionario, result);
			}
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return funcionario;
	}

	@Override
	/**
	 * Método para deletar o objeto 
	 * Funcionario no banco de dados por Id
	 * 
	 * @param funcionario {@link Funcionario}
	 **/
	public void delete(int id) {
		Connection conexao;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "DELETE FROM funcionario WHERE id =" + id;
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void softDelete(Funcionario funcionario) {
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
	 * Método de busca de funcionário pelo código
	 * 
	 *  @param funcionario {@link Funcionario}
	 *  @return retorno {@link boolean}
	 *  @throws IOException {@link IOException}
	 **/
	public Funcionario getByCode(Funcionario funcionario) throws IOException {
		Connection conexao;
		Funcionario funcionarioEncontrado = null;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM funcionario WHERE codigo = '" + funcionario.getCodigo() + "'";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet result =  ps.executeQuery();				
			Funcionario funcionarioCompare = new Funcionario();
			if(result != null && result.next()) {
				funcionarioEncontrado = this.constructObject(funcionarioCompare, result);
			}else {
				throw new NullPointerException("Email ou senha incorretos, tente novamente");
			}
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			throw new IOException("Ops... erro na busca, contacte nosso suporte");
		} 
		
		return funcionarioEncontrado;
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
	
	/**
	 * Montagem de objeto funcionário a partir do resultado da busca
	 * 
	 * @param funcionario {@link Funcionario}
	 * @param result {@link ResultSet}
	 * 
	 * @return funcionario {@link Funcionario}
	 * @throws SQLException {@link SQLException}
	 **/
	private Funcionario constructObject(Funcionario funcionario, ResultSet result) throws SQLException {
		EnderecoDao endDao = new EnderecoDao();
		Endereco endereco = endDao.getById(result.getInt("endereco_id"));
		funcionario.setId(result.getInt("id"));
		funcionario.setNome(result.getString("nome"));
		funcionario.setCpf(result.getString("cpf"));
		funcionario.setEmail(result.getString("email"));
		funcionario.setCargo(result.getString("cargo"));
		funcionario.setCodigo(result.getString("codigo"));
		funcionario.setTelefone(result.getString("telefone"));
		funcionario.setPalavraPasse(result.getString("palavra_passe"));
		funcionario.setEndereco(endereco);
		return funcionario;
	}

	@Override
	public HashSet<Funcionario> listDisponible() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
