package com.br.ifpe.hosp3.controller;

import java.util.HashSet;
import java.util.Set;

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

	public void criarHospede(Hospede hospede) throws Exception {
		
		try {
			EnderecoDao enderecoDao = new EnderecoDao();
			hospede.getEndereco().setId(enderecoDao.create(hospede.getEndereco()));
			
			HospedeDao hospedeDao = new HospedeDao();
			hospede.setPalavraPasse(Criptografia.criptografar(hospede.getPalavraPasse()));
			hospede.setId(hospedeDao.create(hospede));
			
		}catch(Exception e) {
			throw e;
		}
	}

	public void editarHospede(Hospede hospede) throws Exception {

		try {
			HospedeDao hospedeDao = new HospedeDao();
			hospede.setPalavraPasse(Criptografia.criptografar(hospede.getPalavraPasse()));
			hospedeDao.updade(hospede);

		} catch (Exception e) {
			throw e;
		}
	}
	public static Hospede buscarHospede(String cpf) throws Exception {
		Hospede hospedeRetorno = null;
		try {
			HospedeDao hospedeDao = new HospedeDao();
			hospedeRetorno = hospedeDao.findByCpf(cpf);
			if(hospedeRetorno == null) {
				throw new Exception("Hospede não encontrado, tente novamente");
			}
		} catch (Exception e) {
			throw new Exception("Usuário não encontrado! "
					+ "\n" + "Verifique: "
					+ "\n" + "**CPF deve ter no máximo 14 digitos"
					+ "\n" + "***CPF não pode estar vazio");
		}
		
		return hospedeRetorno;
	}
	
	/**
	 * Método contendo a regra de negócio necessária para listagem dos hóspedes
	 * comunicando com a classe de interface com o banco de dados
	 * 
	 * @return listaHospedes {@link Set<Hospede>}
	 * @throws Exception
	 **/
	public Set<Hospede> listarHospedes() throws Exception{
		HospedeDao hospedeDao = new HospedeDao();
		Set<Hospede> listaHospedes = new HashSet<>();
		try {
			listaHospedes = hospedeDao.listAll();
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro na consulta de hospedes, tente novamente mais tarde");
		}
		return listaHospedes;
	}
}
