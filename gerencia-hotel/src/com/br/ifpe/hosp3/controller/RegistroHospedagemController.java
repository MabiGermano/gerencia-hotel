package com.br.ifpe.hosp3.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.br.ifpe.hosp3.dao.HospedagemDao;
import com.br.ifpe.hosp3.dao.QuartoDao;
import com.br.ifpe.hosp3.dao.RegistroDao;
import com.br.ifpe.hosp3.model.Hospedagem;
import com.br.ifpe.hosp3.model.Registro;

/**
 * @author Maria Beatriz Germano
 * Classe controladora para gestão das regras de negócio 
 * relacionadas ao Registro de Hospedagem
 **/
public class RegistroHospedagemController {
	/**
	 * Método contendo a regra de negócio necessária para criação do registro de hospedagem
	 * comunicando com as classes de interface com o banco de dados
	 * 
	 * @param registro {@link Registro}
	 * @throws Exception
	 **/
	public static void criarRegistroHospedagem(Registro registro) throws Exception {
		try {
			QuartoDao quartoDao = new QuartoDao();
			registro.getHospedagem().getQuarto().setDisponivel(false);
			
			registro.setDataCheckin(new Timestamp(System.currentTimeMillis()));
			quartoDao.updade(registro.getHospedagem().getQuarto());
			
			HospedagemDao hospedagemDao = new HospedagemDao();
			registro.getHospedagem().setId(hospedagemDao.create(registro.getHospedagem()));
			
			RegistroDao registroDao = new RegistroDao();
			registroDao.create(registro);
		}catch(Exception e){
			throw new Exception("Erro na inclusão do registro");
		}
	}

	/**
	 * Método contendo a regra de negócio necessária para listagem das hospedagens
	 * comunicando com a classe de interface com o banco de dados
	 * 
	 * @return listaHospedagens {@link Set<Hospedagem>}
	 * @throws Exception
	 **/
	public Set<Hospedagem> listarHospedagens() throws Exception{
		HospedagemDao hospedagemDao = new HospedagemDao();
		Set<Hospedagem> listaHospedagens = new HashSet<>();
		try {
			listaHospedagens = hospedagemDao.listAll();
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro na consulta de hospedagens, tente novamente mais tarde");
		}
		return listaHospedagens;
	}
	
	/**
	 * Método contendo a regra de negócio necessária busca do registro de hospedagem 
	 * comunicando com a classe de interface com o banco de dados
	 * 
	 * @return listaHospedagens {@link Set<Hospedagem>}
	 * @throws Exception
	 **/
	public Registro buscarPeloCpf(String cpf) throws Exception{
		HospedagemDao hospedagemDao = new HospedagemDao();
		RegistroDao registroDao = new RegistroDao();
		Registro registro = new Registro();
		try {
			Hospedagem hospedagem = hospedagemDao.getByHospede(cpf);
			Date now = new Date();
			registro = registroDao.getByHospedagem(hospedagem.getId());
			
			//por essa lógica para a classe model
			long diferenca = registro.getDataCheckin().getTime() - now.getTime();
			float dias = 1 +  (diferenca / (1000*60*60*24));
			
			registro.setValor(registro.getHospedagem().getQuarto().getValor() * (int) dias);
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro na consulta de hospedagens, tente novamente mais tarde");
		}
		return registro;
	}
	
}
