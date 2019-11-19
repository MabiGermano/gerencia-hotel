package com.br.ifpe.hosp3.model;

/**
 * @author Tayná Alexandra
 *
 * Classe Funcionario que herda da classe Pessoa 
 */

public class Funcionario extends Pessoa
{
	private int id;
	private String codigo;
	private boolean deleted;
	
	public Funcionario() {
		
	}
	
	public Funcionario(String nome, String cpf, String email, String telefone, String palavra_passe, Endereco endereco, int id, String codigo) 
	{
		super(nome, cpf, email, telefone, palavra_passe, endereco);
		this.id = id;
		this.codigo = codigo;
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

	/**
	 * @return codigo {@link String}
	 */
	public String getCodigo() 
	{
		return codigo;
	}

	/**
	 * @param codigo {@link String}
	 */
	public void setCodigo(String codigo) 
	{
		this.codigo = codigo;
	}

	/**
	 * @return deleted {@link boolean}
	 */
	public boolean isDeleted()
	{
		return deleted;
	}

	/**
	 * @param deleted {@link boolean}
	 */
	public void setDeleted(boolean deleted)
	{
		this.deleted = deleted;
	}

}
