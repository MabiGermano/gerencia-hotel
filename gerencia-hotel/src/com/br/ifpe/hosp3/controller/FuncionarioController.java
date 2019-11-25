package com.br.ifpe.hosp3.controller;

import java.io.IOException;

import com.br.ifpe.hosp3.dao.FuncionarioDao;
import com.br.ifpe.hosp3.model.Funcionario;
import com.br.ifpe.hosp3.util.Criptografia;

/**
 * @author Maria Beatriz Germano
 * 
 * Classe controladora para gest�o das regras de neg�cio 
 * relacionadas ao funcion�rio
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

}