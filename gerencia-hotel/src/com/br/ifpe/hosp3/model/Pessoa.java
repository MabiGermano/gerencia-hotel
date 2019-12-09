package com.br.ifpe.hosp3.model;

import com.br.ifpe.hosp3.util.Criptografia;

/**
 * @author Tayn� Alexandra
 *
 * Classe abstrata Pessoa
 */

public abstract class Pessoa 
{
	private Integer id;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String palavraPasse;
	private Endereco endereco;

	public Pessoa(String nome, String cpf, String email, String telefone, String palavraPasse, Endereco endereco) 
	{
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.palavraPasse = palavraPasse;
	}
	
	public Pessoa() {
		
	}
	
	/**
	 * Gera hash para o objeto
	 * 
	 * @return String
	 **/
	public String getHash() {
		 
		return Criptografia.criarHashKey(getCpf()+getId());
	}

	/**
	 * @return id {@link int}
	 */
	public Integer getId() 
	{
		return id;
	}

	/**
	 * @param id {@link int}
	 */
	public void setId(Integer id) 
	{
		this.id = id;
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
	 * @return palavraPasse {@link String}
	 */
	public String getPalavraPasse() 
	{
		return palavraPasse;
	}

	/**
	 * @param palavraPasse {@link String}
	 */
	public void setPalavraPasse(String palavraPasse) 
	{
		
		this.palavraPasse = palavraPasse;
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
	
}
	
	