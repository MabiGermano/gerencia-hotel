package com.br.ifpe.hosp3.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.br.ifpe.hosp3.dao.QuartoDao;
import com.br.ifpe.hosp3.model.Quarto;

/**
 * @author Maria Beatriz Germano
 * 
 * Classe controladora para gestão das regras de negócio 
 * relacionadas ao Quarto
 **/
public class QuartoController {
	
	/**
	 * Método contendo a regra de negócio necessária para criação do quarto
	 * comunicando com a classe de interface com o banco de dados
	 * 
	 * @param quarto {@link Quarto}
	 * @throws Exception
	 **/
	public static void criarQuarto(Quarto quarto) throws Exception{
		
		try {
			QuartoDao quartoDao = new QuartoDao();
			quarto.setDisponivel(true);
			quartoDao.create(quarto);
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
<<<<<<< HEAD
	 * Método contendo a regra de negócio necessária para listagem dos quartos
=======
	 * MÃ©todo contendo a regra de negÃ³cio necessÃ¡ria para listagem dos quartos
	 * disponÃ­veis no sistema, comunicando com a classe de interface com o banco de dados
	 * 
	 * @return listaQuartos {@link Set<Quarto>}
	 * @throws Exception
	 **/
	public static Set<Quarto> listarQuartosDisponiveis() throws Exception{
		QuartoDao quartoDao = new QuartoDao();
		Set<Quarto> listaQuartos = new HashSet<>();
		try {
			listaQuartos = quartoDao.listDisponible();
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro na consulta de quartos, tente novamente mais tarde");
		}
		return listaQuartos;
	}
	
	/**
	 * MÃ©todo contendo a regra de negÃ³cio necessÃ¡ria para listagem dos quartos
>>>>>>> 316b16771f7991dfbae3b7938846643de513efa5
	 * comunicando com a classe de interface com o banco de dados
	 * 
	 * @return listaQuartos {@link Set<Quarto>}
	 * @throws Exception
	 **/
	public static Set<Quarto> listarQuartos() throws Exception{
		QuartoDao quartoDao = new QuartoDao();
		Set<Quarto> listaQuartos = new HashSet<>();
		try {
			listaQuartos = quartoDao.listAll();
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro na consulta de quartos, tente novamente mais tarde");
		}
		return listaQuartos;
	}
}