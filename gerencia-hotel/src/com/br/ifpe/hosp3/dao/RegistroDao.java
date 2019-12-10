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
import com.br.ifpe.hosp3.model.Funcionario;
import com.br.ifpe.hosp3.model.Hospedagem;
import com.br.ifpe.hosp3.model.Registro;

public class RegistroDao implements ManipulacaoDeDados<Registro>{

	@Override
	/**
	 * M�todo para cria��o do objeto Registro no banco de dados
	 * 
	 * @param object {@link Object}
	 * @throws Exception
	 **/
	public int create(Registro registro) throws Exception {
		Connection conexao;
		int retorno = 0;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			
			String sql = "INSERT INTO registro (flag_ativo, pagamento, dataCheckin, valor,funcionario_id, hospedagem_id)"
						+ " VALUES ("
						+ registro.isFlagAtivo() + " ,'"
						+ registro.getPagamento() + "' ,'"
						+ registro.getDataCheckin() + "' ,"
						+ registro.getHospedagem().getQuarto().getValor() + ","
						+ registro.getFuncionario().getId() + " ,"
						+ registro.getHospedagem().getId() 
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
	 * M�todo para altera��o do objeto Registro no banco de dados
	 * 
	 * @param object {@link Object}
	 **/
	public void updade(Registro registro) throws Exception {
		Connection conexao;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			
			HospedagemDao hospDao = new HospedagemDao();
			hospDao.updade(registro.getHospedagem());

			FuncionarioDao funcionarioDao = new FuncionarioDao();
			funcionarioDao.updade(registro.getFuncionario());
			
			String sql = "UPDATE registro SET "
						+ "flag_ativo = " + registro.isFlagAtivo() + " ,"
						+ "hospedagem_id = " + registro.getHospedagem().getId() + " ,"
						+ "funcionario_id = '" + registro.getFuncionario().getId() + "' "
						+ "pagamento = '" + registro.getPagamento() + "' "
						+ "WHERE id = " + registro.getId();
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	/**
	 * M�todo para listagem do objetos Registro no banco de dados
	 * 
	 * @return listaRegistro {@link HashSet<object>}
	 **/
	public HashSet<Registro> listAll() {
		Connection conexao;
		HashSet<Registro> listaRegistro = new HashSet<>();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM registro";
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();
			
			while(result.next()) {
				HospedagemDao hospDao = new HospedagemDao();
				Hospedagem hospedagem = hospDao.getById(result.getInt("hospedagem_id"));

				FuncionarioDao funcionarioDao = new FuncionarioDao();
				Funcionario funcionario = funcionarioDao.getById(result.getInt("hospedagem_id"));
				
				Registro registro = new Registro();
				registro.setId(result.getInt("id"));
				registro.setHospedagem(hospedagem);
				registro.setFuncionario(funcionario);
				registro.setFlagAtivo(result.getBoolean("flag_Ativo"));
				registro.setPagamento(result.getString("pagamento"));
			
				listaRegistro.add(registro);
				ConexaoMysql.FecharConexao();
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return listaRegistro;
	}

	@Override
	/**
	 * M�todo para busca do objeto Registro no banco de dados
	 * pelo id
	 * @return registro {@link Registro}
	 **/
	public Registro getById(int id) {
		Connection conexao;
		Registro registro = new Registro();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM registro WHERE id =" + id;
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();				
			if(result != null && result.next()) {
				HospedagemDao hospDao = new HospedagemDao();
				FuncionarioDao funcionarioDao = new FuncionarioDao();
				
				registro.setId(result.getInt("id"));
				registro.setPagamento(result.getString("pagamento"));
				registro.setFlagAtivo(result.getBoolean("flag_ativo"));
				registro.setDataCheckin(result.getTimestamp("dataCheckin"));
				registro.setDataCheckout(result.getTimestamp("dataCheckout"));
				Hospedagem hospedagem = hospDao.getById(result.getInt("hospedagem_id"));
				registro.setHospedagem(hospedagem);
				Funcionario funcionario = funcionarioDao.getById(result.getInt("funcioario_id"));
				registro.setFuncionario(funcionario);
			}
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return registro;
	}
	
	/**
	 * M�todo para busca do objeto Registro no banco de dados
	 * pelo id da hospedagem 
	 * @return registro {@link Registro}
	 **/
	public Registro getByHospedagem(int hospedagem_id) {
		Connection conexao;
		Registro registro = new Registro();
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "SELECT * FROM registro WHERE hospedagem_id =" + hospedagem_id;
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet result =  ps.executeQuery();				
			if(result != null && result.next()) {
				HospedagemDao hospDao = new HospedagemDao();
				FuncionarioDao funcionarioDao = new FuncionarioDao();
				
				registro.setId(result.getInt("id"));
				registro.setPagamento(result.getString("pagamento"));
				registro.setFlagAtivo(result.getBoolean("flag_ativo"));
				registro.setDataCheckin(result.getTimestamp("dataCheckin"));
				registro.setDataCheckout(result.getTimestamp("dataCheckout"));
				Hospedagem hospedagem = hospDao.getById(result.getInt("hospedagem_id"));
				registro.setHospedagem(hospedagem);
				Funcionario funcionario = funcionarioDao.getById(result.getInt("funcionario_id"));
				registro.setFuncionario(funcionario);
			}
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return registro;
	}

	@Override
	/**
	 * M�todo para deletar o objeto 
	 * Registro no banco de dados por Id
	 * 
	 * @param registro {@link Registro}
	 **/
	public void delete(int id) {
		Connection conexao;
		try {
			conexao = ConexaoMysql.getConexaoMySQL();
			String sql = "DELETE FROM registro WHERE id =" + id;
						
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
			ConexaoMysql.FecharConexao();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void softDelete(Registro registro) {
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
	public HashSet<Registro> listDisponible() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}