package com.br.ifpe.hosp3.connection;

import java.sql.ResultSet;
import java.util.HashSet;

/**
 * @author Maria Beatriz Germano
 * 
 * Interface para implementação de métodos comuns aos objetos
 * na manipulação de dados no banco
 **/
public interface ManipulacaoDeDados<Type> {

	/**
	 * @param type {@link Type}
	 **/
	public int create(Type type) throws Exception;
	
	/**
	 * @param type {@link Type}
	 **/
	public void updade(Type type)  throws Exception;

	/**
	 * @return HashSet {@link HashSet<Type>}
	 **/
	public HashSet<Type> listAll() throws Exception;
	
	/**
	 * @return HashSet {@link HashSet<Type>}
	 **/
	public HashSet<Type> listDisponible() throws Exception;

	/**
	 * @param id {@link int}
	 * @return type {@link Type}
	 **/
	public Type getById(int id);
	
	/**
	 * @param id {@link dint}
	 **/
	public void delete(int id);

	/**
	 * @param type {@link Type}
	 **/
	public void softDelete(Type type);
	
	/**
	 * @param rs {@link ResultSet}
	 * @return int {@link int}
	 **/
	public int getLastInsertedId(ResultSet rs);

}
