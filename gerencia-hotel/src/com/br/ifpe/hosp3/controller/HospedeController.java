package com.br.ifpe.hosp3.controller;

import com.br.ifpe.hosp3.dao.EnderecoDao;
import com.br.ifpe.hosp3.dao.HospedeDao;
import com.br.ifpe.hosp3.model.Endereco;
import com.br.ifpe.hosp3.model.Hospede;
import com.br.ifpe.hosp3.util.Criptografia;

/**
 * @author Maria Beatriz Germano
 * 
 * Classe controladora para gest�o das regras de neg�cio 
 * relacionadas ao Hospede
 * 
 **/
public class HospedeController {

	public static void criarHospede(Hospede hospede, Endereco endereco) throws Exception {
		
		try {
			EnderecoDao enderecoDao = new EnderecoDao();
			endereco.setId(enderecoDao.create(endereco));
			
			HospedeDao hospedeDao = new HospedeDao();
			hospede.setEndereco(endereco);
			hospede.setPalavraPasse(Criptografia.criptografar(hospede.getPalavraPasse()));
			hospede.setId(hospedeDao.create(hospede));
			
		}catch(Exception e) {
			throw e;
		}
	}
	
	public static Hospede buscarHospede(String cpf) throws Exception {
		Hospede hospedeRetorno = null;
		try {
			HospedeDao hospedeDao = new HospedeDao();
			hospedeRetorno = hospedeDao.findByCpf(cpf);
			if(hospedeRetorno == null) {
				throw new Exception("Hospede n�o encontrado, tente novamente");
			}
		} catch (Exception e) {
			throw new Exception("Usu�rio n�o encontrado! "
					+ "\n" + "Verifique: "
					+ "\n" + "**CPF deve ter no m�ximo 14 digitos"
					+ "\n" + "***CPF n�o pode estar vazio");
		}
		
		return hospedeRetorno;
	}
}