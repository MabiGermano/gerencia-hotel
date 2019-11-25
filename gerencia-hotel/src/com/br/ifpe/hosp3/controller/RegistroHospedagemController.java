package com.br.ifpe.hosp3.controller;

import com.br.ifpe.hosp3.dao.HospedagemDao;
import com.br.ifpe.hosp3.dao.QuartoDao;
import com.br.ifpe.hosp3.dao.RegistroDao;
import com.br.ifpe.hosp3.model.Registro;

/**
 * @author Maria Beatriz Germano
 * Classe controladora para gest�o das regras de neg�cio 
 * relacionadas ao Registro de Hospedagem
 **/
public class RegistroHospedagemController {
	/**
	 * M�todo contendo a regra de neg�cio necess�ria para cria��o do registro de hospedagem
	 * comunicando com as classes de interface com o banco de dados
	 * 
	 * @param registro {@link Registro}
	 * @throws Exception
	 **/
	public static void criarRegistroHospedagem(Registro registro) throws Exception {
		try {
			QuartoDao quartoDao = new QuartoDao();
			registro.getHospedagem().getQuarto().setDisponivel(false);
			quartoDao.updade(registro.getHospedagem().getQuarto());
			
			HospedagemDao hospedagemDao = new HospedagemDao();
			registro.getHospedagem().setId(hospedagemDao.create(registro.getHospedagem()));
			
			RegistroDao registroDao = new RegistroDao();
			registroDao.create(registro);
		}catch(Exception e){
			throw new Exception("Erro na inclus�o do registro");
		}
	}
}