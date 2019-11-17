package com.br.ifpe.hosp3.connection;

import java.io.IOException;

import com.br.ifpe.hosp3.dao.EnderecoDao;
import com.br.ifpe.hosp3.model.Endereco;
import com.br.ifpe.hosp3.model.Hospede;

public class TesteConexao {

	public static void main(String[] args) {
		try {
			Endereco end = new Endereco();
			EnderecoDao endDao = new EnderecoDao();
			end = endDao.getById(1);
			Hospede h = new Hospede(nome, cpf, email, telefone, palavra_passe, endereco);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
