package com.br.ifpe.hosp3.dao;

import com.br.ifpe.hosp3.model.Hospede;

public class TestesDao {

	public static void main(String[] args) {
//		Endereco endereco = new Endereco("nome da rua", "52", "5454545", "Nome do bairro", "Nome do país", 
//										"Nome da cidade", "nome do estado", "complementozinho");
//		EnderecoDao endDao = new EnderecoDao();
//		int id_endereco = endDao.create(endereco);
//		endereco.setId(id_endereco);
		
		HospedeDao hospDao = new HospedeDao();
		Hospede hospede = (Hospede) hospDao.getById(6);
		hospede.setCpf("99999999");
		hospede.setNome("beira de piscina");
		hospede.setEmail("cobertura em malibu");
		hospede.getEndereco().setBairro("te fazer bemmm");
		hospede.getEndereco().setRua("Eu vou deixar você me sarar com amor");
		hospDao.updade(hospede);
		System.out.println(hospede.getEndereco().getBairro());
		
//		Quarto quarto = new Quarto((float) 100.00, 2, "Casal", "54", true);
		
//		QuartoDao quartoDao = new QuartoDao();
//		int id_quarto = quartoDao.create(quarto);
//		quarto.setId(id_quarto);
	}

}
