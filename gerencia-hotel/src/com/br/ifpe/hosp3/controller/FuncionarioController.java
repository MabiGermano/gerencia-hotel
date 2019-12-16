package com.br.ifpe.hosp3.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.br.ifpe.hosp3.dao.FuncionarioDao;
import com.br.ifpe.hosp3.dao.HospedeDao;
import com.br.ifpe.hosp3.dao.QuartoDao;
import com.br.ifpe.hosp3.model.Funcionario;
import com.br.ifpe.hosp3.model.Hospede;
import com.br.ifpe.hosp3.model.Quarto;
import com.br.ifpe.hosp3.util.Criptografia;

/**
 * @author Maria Beatriz Germano
 * 
 *         Classe controladora para gest�o das regras de neg�cio relacionadas ao
 *         funcion�rio
 * 
 **/
public class FuncionarioController {

	/**
	 * M�todo est�tico para autentica��o do funcion�rio
	 * 
	 * @param funcionario {@link Funcionario}
	 * @return funcionarioCorrespondente {@link Funcionario}
	 * 
	 * @throws IOException {@link IOException}
	 **/
	public static Funcionario autentication(Funcionario funcionario) throws IOException {
		Funcionario funcionarioCorrespondente = null;
		try {
			funcionario.setPalavraPasse(Criptografia.criptografar(funcionario.getPalavraPasse()));
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			funcionarioCorrespondente = funcionarioDao.getByCode(funcionario);

			if (!(funcionarioCorrespondente.getCodigo().equals(funcionario.getCodigo())
					&& funcionarioCorrespondente.getPalavraPasse().equals(funcionario.getPalavraPasse()))) {

				throw new NullPointerException("Ops, n�o foi possivel encontrar o funcion�rio");
			}
		} catch (NullPointerException e) {
			throw e;
		}
		return funcionarioCorrespondente;
	}

	/**
	 * Método contendo a regra de negócio necessária para listagem dos funcionários
	 * comunicando com a classe de interface com o banco de dados
	 * 
	 * @return listaFuncionarios {@link Set<Funcionario>}
	 * @throws Exception
	 **/
	public Set<Funcionario> listarFuncionarios() throws Exception {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Set<Funcionario> listaFuncionarios = new HashSet<>();
		try {
			listaFuncionarios = funcionarioDao.listAll();
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro na consulta de funcionarios, tente novamente mais tarde");
		}
		return listaFuncionarios;
	}

	/**
	 * Método contendo a regra de negócio necessária para alteração do funcionário
	 * comunicando com a classe de interface com o banco de dados
	 * 
	 * @param funcionario {@link Funcionario}
	 * @throws Exception
	 **/
	public void alterarFuncionario(Funcionario funcionario) throws Exception {

		try {
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			funcionarioDao.updade(funcionario);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Método contendo a regra de negócio necessária para deleção do funcionário
	 * comunicando com a classe de interface com o banco de dados
	 * 
	 * @param funcionario {@link Funcionario}
	 * @throws Exception
	 **/
	public void deleteFuncionario(Funcionario funcionario) throws Exception {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		try {
			funcionarioDao.delete(funcionario.getId());
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Método contendo a regra de negócio necessária para busca do funcionario
	 * pelo cpf
	 * comunicando com a classe de interface com o banco de dados
	 * 
	 * @param cpf {@link String}
	 * @return funcionario {@link Funcionario}
	 * @throws Exception
	 **/
	public Funcionario buscarFuncionarioCpf(String cpf) throws Exception {
		Funcionario funcionarioRetorno = null;
		try {
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			funcionarioRetorno = funcionarioDao.findByCpf(cpf);
			if(funcionarioRetorno == null) {
				throw new Exception("Funcionário não encontrado, tente novamente");
			}
		} catch (Exception e) {
			throw new Exception("Usuário não encontrado! "
					+ "\n" + "Verifique: "
					+ "\n" + "**CPF deve ter no máximo 14 digitos"
					+ "\n" + "***CPF não pode estar vazio");
		}
		
		return funcionarioRetorno;
	}
	
	/**
	 * Método contendo a regra de negócio necessária para busca do funcionario
	 * pelo nome
	 * comunicando com a classe de interface com o banco de dados
	 * 
	 * @param nome {@link String}
	 * @return listaFuncionarios {@link Set<Funcionario>}
	 * @throws Exception
	 **/
	public Set<Funcionario> buscarFuncionarioNome(String nome) throws Exception{
	
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Set<Funcionario> listaFuncionarios = new HashSet<>();
		try {
			listaFuncionarios = funcionarioDao.findByNome(nome);
		} catch (Exception e) {
			throw new Exception("Usuário não encontrado! "
					+ "\n" + "Verifique: "
					+ "\n" + "**nome não pode estar vazio");
		}
		return listaFuncionarios;
	}
}