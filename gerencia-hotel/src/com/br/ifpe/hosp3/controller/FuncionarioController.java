package com.br.ifpe.hosp3.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.br.ifpe.hosp3.dao.FuncionarioDao;
import com.br.ifpe.hosp3.dao.QuartoDao;
import com.br.ifpe.hosp3.model.Funcionario;
import com.br.ifpe.hosp3.model.Quarto;
import com.br.ifpe.hosp3.util.Criptografia;

/**
 * @author Maria Beatriz Germano
 * 
 * Classe controladora para gest„o das regras de negÛcio 
 * relacionadas ao funcion·rio
 * 
 **/
public class FuncionarioController {

	/**
	 * MÈtodo est·tico para autenticaÁ„o do funcion·rio
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
				
				throw new NullPointerException("Ops, n„o foi possivel encontrar o funcion·rio");
			}
		} catch (NullPointerException e) {
			throw e;
		}
		return funcionarioCorrespondente;
	}
	
	/**
	 * M√©todo contendo a regra de neg√≥cio necess√°ria para listagem dos funcion√°rios
	 * comunicando com a classe de interface com o banco de dados
	 * 
	 * @return listaFuncionarios {@link Set<Funcionario>}
	 * @throws Exception
	 **/
	public Set<Funcionario> listarFuncionarios() throws Exception{
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Set<Funcionario> listaFuncionarios = new HashSet<>();
		try {
			listaFuncionarios = funcionarioDao.listAll();
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro na consulta de funcionarios, tente novamente mais tarde");
		}
		return listaFuncionarios;
	}

}