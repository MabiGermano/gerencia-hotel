package com.br.ifpe.hosp3.controller;

import com.br.ifpe.hosp3.dao.EnderecoDao;
import com.br.ifpe.hosp3.dao.HospedeDao;
import com.br.ifpe.hosp3.model.Endereco;
import com.br.ifpe.hosp3.model.Hospede;
import com.br.ifpe.hosp3.util.Criptografia;

/**
 * @author Maria Beatriz Germano
 * 
 * Classe controladora para gestão das regras de negócio 
 * relacionadas ao Hospede
 * 
 **/
public class HospedeController {

	public static Hospede criarHospede(Hospede hospede, Endereco endereco) {
		Hospede hospedeRetorno = null;
		try {
			EnderecoDao enderecoDao = new EnderecoDao();
			endereco.setId(enderecoDao.create(endereco));
			
			HospedeDao hospedeDao = new HospedeDao();
			hospede.setEndereco(endereco);
			hospede.setPalavraPasse(Criptografia.criptografar(hospede.getPalavraPasse()));
			hospede.setId(hospedeDao.create(hospede));
			if(hospede.getId() != null){
				hospedeRetorno = hospede;
			}else {
				throw new NullPointerException("Não foi possível incluir este usuário, verifique os dados inseridos e tente novamente");
			}
			
		}catch(NullPointerException e) {
			throw e;
		}
		return hospedeRetorno;
	}
}
