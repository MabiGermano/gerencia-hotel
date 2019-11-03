package com.br.ifpe.hosp3.model;

/**
 * @author Tayná Alexandra
 *
 * Classe Hospede que herda da classe Pessoa 
 */

public class Hospede extends Pessoa
{
	private int id;

	public Hospede(String nome, String cpf, String email, String telefone, String palavra_passe, Endereco endereco, int id) 
	{
		super(nome, cpf, email, telefone, palavra_passe, endereco);
		this.id = id;
	}

	/**
	 * @return id {@link int}
	 */
	public int getId() 
	{
		return id;
	}

	/**
	 * @param id {@link int}
	 */
	public void setId(int id) 
	{
		this.id = id;
	}

}
