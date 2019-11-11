package com.br.ifpe.hosp3.connection;

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
	public void create(Object object);
	
	/**
	 * @param object {@link Object}
	 **/
	public void updade(Object object);

	/**
	 * @return HashSet {@link HashSet<Object>}
	 **/
	public HashSet<Object> listAll();

	/**
	 * @param id {@link int}
	 * @return object {@link Object}
	 **/
	public Object getById(int id);
	
	/**
	 * @param id {@link int}
	 **/
	public void delete(int id);

	/**
	 * @param object {@link Object}
	 **/
	public void softDelete(Object object);

}
