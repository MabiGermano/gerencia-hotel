package com.br.ifpe.hosp3.controller;

import java.io.IOException;

import com.br.ifpe.hosp3.dao.FuncionarioDao;
import com.br.ifpe.hosp3.model.Funcionario;
import com.br.ifpe.hosp3.util.Criptografia;

/**
 * @author Maria Beatriz Germano
 * 
 * Classe controladora para gestão das regras de negócio 
 * relacionadas ao funcionário
 * 
 **/
public class FuncionarioController {

	/**
	 * Método estático para autenticação do funcionário
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
				
				throw new NullPointerException("Ops, não foi possivel encontrar o funcionário");
			}
		} catch (NullPointerException e) {
			throw e;
		}
		return funcionarioCorrespondente;
	}

}