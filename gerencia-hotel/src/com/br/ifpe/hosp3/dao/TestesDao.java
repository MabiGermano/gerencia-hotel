package com.br.ifpe.hosp3.dao;

import com.br.ifpe.hosp3.model.Endereco;
import com.br.ifpe.hosp3.model.Hospede;

public class TestesDao {

	public static void main(String[] args) {
		Endereco endereco = new Endereco("nome da rua", "52", "5454545", "Nome do bairro", "Nome do país", 
										"Nome da cidade", "nome do estado", "complementozinho");
		EnderecoDao endDao = new EnderecoDao();
		int id_endereco = endDao.create(endereco);
		endereco.setId(id_endereco);
		Hospede hospede = new Hospede("nome do hospede", "11111111111", "olha o email aí gente", 
										"848484888", "palavinha passe", endereco);
		HospedeDao hospDao = new HospedeDao();
		hospDao.create(hospede);
	}

}
