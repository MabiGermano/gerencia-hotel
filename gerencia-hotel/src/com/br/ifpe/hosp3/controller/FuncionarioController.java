package com.br.ifpe.hosp3.controller;

import java.io.IOException;

import com.br.ifpe.hosp3.dao.FuncionarioDao;
import com.br.ifpe.hosp3.model.Funcionario;

public class FuncionarioController {

	public static boolean login(Funcionario funcionario) throws IOException {
		boolean isCorrespondente = false;
		try {
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			isCorrespondente = funcionarioDao.autentication(funcionario);
		} catch (IOException e) {
			throw e;
		}
		return isCorrespondente;
	}

}
