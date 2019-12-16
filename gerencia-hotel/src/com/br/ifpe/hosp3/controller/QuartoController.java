package com.br.ifpe.hosp3.controller;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

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
	public void criarQuarto(Quarto quarto) throws Exception{
		
		try {
			QuartoDao quartoDao = new QuartoDao();
			quarto.setDisponivel(true);
			quartoDao.create(quarto);
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Método contendo a regra de negócio necessária para listagem dos quartos
	 * disponíveis no sistema, comunicando com a classe de interface com o banco de dados
	 * 
	 * @return listaQuartos {@link Set<Quarto>}
	 * @throws Exception
	 **/
	public Set<Quarto> listarQuartosDisponiveis() throws Exception{
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
	 * Método contendo a regra de negócio necessária para listagem dos quartos
	 * comunicando com a classe de interface com o banco de dados
	 * 
	 * @return listaQuartos {@link Set<Quarto>}
	 * @throws Exception
	 **/
	public Set<Quarto> listarQuartos() throws Exception{
		QuartoDao quartoDao = new QuartoDao();
		Set<Quarto> listaQuartos = new HashSet<>();
		try {
			listaQuartos = quartoDao.listAll();
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro na consulta de quartos, tente novamente mais tarde");
		}
		return listaQuartos;
	}
	
	/**
	 * Método contendo a regra de negócio necessária para alteração do quarto
	 * comunicando com a classe de interface com o banco de dados
	 * 
	 * @param quarto {@link Quarto}
	 * @throws Exception
	 **/
	public void alterarQuarto(Quarto quarto) throws Exception{

		try {
			QuartoDao quartoDao = new QuartoDao();
			if(!quarto.isDisponivel()){
				throw new Exception("Quarto não disponível para alteração no momento. "
						+ "\n" + "Verifique se o quarto está em hospedagem e tente novamente mais tarde.");
			}
			quartoDao.updade(quarto);
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Método contendo a regra de negócio necessária para deleção do quarto
	 * comunicando com a classe de interface com o banco de dados
	 * 
	 * @param quarto {@link Quarto}
	 * @throws Exception
	 **/
	public void deleteQuarto(Quarto quarto) throws Exception {
		QuartoDao quartoDao = new QuartoDao();
		try {
			quartoDao.delete(quarto.getId());
		} catch (Exception e) {
			throw e;
		}
	}
}