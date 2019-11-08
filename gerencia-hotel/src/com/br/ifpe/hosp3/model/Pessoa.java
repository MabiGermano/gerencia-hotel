package com.br.ifpe.hosp3.model;

/**
 * @author Tayná Alexandra
 *
 * Classe abstrata Pessoa
 */

public abstract class Pessoa 
{
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String palavra_passe;
	private Endereco endereco;
	private boolean deleted;

	public Pessoa(String nome, String cpf, String email, String telefone, String palavra_passe, Endereco endereco) 
	{
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.palavra_passe = palavra_passe;
		this.endereco = endereco;
	}

	/**
	 * @return nome {@link String}
	 */
	public String getNome() 
	{
		return nome;
	}

	/**
	 * @param nome {@link String}
	 */
	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	/**
	 * @return cpf {@link String}
	 */
	public String getCpf() 
	{
		return cpf;
	}

	/**
	 * @param cpf {@link String}
	 */
	public void setCpf(String cpf) 
	{
		this.cpf = cpf;
	}

	/**
	 * @return email {@link String}
	 */
	public String getEmail() 
	{
		return email;
	}

	/**
	 * @param email {@link String}
	 */
	public void setEmail(String email) 
	{
		this.email = email;
	}

	/**
	 * @return telefone {@link String}
	 */
	public String getTelefone() 
	{
		return telefone;
	}

	/**
	 * @param telefone {@link String}
	 */
	public void setTelefone(String telefone) 
	{
		this.telefone = telefone;
	}

	/**
	 * @return palavra_passe {@link String}
	 */
	public String getPalavra_passe() 
	{
		return palavra_passe;
	}

	/**
	 * @param palavra_passe {@link String}
	 */
	public void setPalavra_passe(String palavra_passe) 
	{
		this.palavra_passe = palavra_passe;
	}

	/**
	 * @return endereco {@link Endereco}
	 */
	public Endereco getEndereco() 
	{
		return endereco;
	}

	/**
	 * @param endereco {@link Endereco}
	 */
	public void setEndereco(Endereco endereco) 
	{
		this.endereco = endereco;
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
	
	