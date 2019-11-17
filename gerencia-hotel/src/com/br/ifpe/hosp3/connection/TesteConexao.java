package com.br.ifpe.hosp3.connection;

import java.io.IOException;

import com.br.ifpe.hosp3.dao.EnderecoDao;
import com.br.ifpe.hosp3.dao.QuartoDao;
import com.br.ifpe.hosp3.model.Endereco;
import com.br.ifpe.hosp3.model.Hospede;
import com.br.ifpe.hosp3.model.Quarto;

public class TesteConexao {

	public static void main(String[] args) {
		try {
			Endereco end = new Endereco();
			EnderecoDao endDao = new EnderecoDao();
			end = endDao.getById(1);
			Hospede h = new Hospede("alberto", "56565656565", "albertinho.boladao@gmail.com", "98989895", "tente", end);
			Quarto q = new Quarto(350, 2, "suite", "20", true);
			QuartoDao quartoDao = new QuartoDao();
			q.setId(quartoDao.create(q));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
