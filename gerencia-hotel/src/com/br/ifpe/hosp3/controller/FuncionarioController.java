package com.br.ifpe.hosp3.controller;

import java.io.IOException;

import com.br.ifpe.hosp3.dao.FuncionarioDao;
import com.br.ifpe.hosp3.model.Funcionario;

public class FuncionarioController {

	public static Funcionario login(Funcionario funcionario) throws IOException {
		Funcionario funcionarioCorrespondente = null;
		try {
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			funcionarioCorrespondente = funcionarioDao.autentication(funcionario);
		} catch (NullPointerException e) {
			throw e;
		}
		return funcionarioCorrespondente;
	}

}
