package com.br.ifpe.hosp3.dao;

import java.util.HashSet;

/**
 * @author Maria Beatriz Germano
 * 
 * Interface para implementação de métodos comuns aos objetos
 * na manipulação de dados no banco
 **/
public interface ManipulacaoDeDados {

	/**
	 * @param object {@link Object}
	 **/
	public static void create(Object object) {

	}
	
	/**
	 * @param object {@link Object}
	 **/
	public static void updade(Object object) {

	}

	/**
	 * @return HashSet {@link HashSet<Object>}
	 **/
	public static HashSet<Object> listAll() {
		return null;
	}

	/**
	 * @return object {@link Object}
	 **/
	public static Object getById(int id) {
		return null;
	}
	
	/**
	 * @param object {@link Object}
	 **/
	public static void delete(Object object) {

	}
}
