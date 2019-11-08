package com.br.ifpe.hosp3.model;

/**
 * @author Tayná Alexandra
 *
 * Classe Quarto 
 */

public class Quarto 
{
	private int id;
	private float valor;
	private int quantidade_pessoas;
	private String tipo;
	private String numero;
	private boolean disponivel;
	private boolean deleted;
	
	public Quarto(int id, float valor, int quantidade_pessoas, String tipo, String numero, boolean disponivel) 
	{
		this.id = id;
		this.valor = valor;
		this.quantidade_pessoas = quantidade_pessoas;
		this.tipo = tipo;
		this.numero = numero;
		this.disponivel = disponivel;
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
	 * @return valor {@link float}
	 */
	public float getValor() 
	{
		return valor;
	}

	/**
	 * @param valor {@link float}
	 */
	public void setValor(float valor) 
	{
		this.valor = valor;
	}

	/**
	 * @return quantidade_pessoas {@link int}
	 */
	public int getQuantidade_pessoas() 
	{
		return quantidade_pessoas;
	}

	/**
	 * @param quantidade_pessoas {@link int}
	 */
	public void setQuantidade_pessoas(int quantidade_pessoas) 
	{
		this.quantidade_pessoas = quantidade_pessoas;
	}

	/**
	 * @return tipo {@link String}
	 */
	public String getTipo() 
	{
		return tipo;
	}

	/**
	 * @param tipo {@link String}
	 */
	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}

	/**
	 * @return numero {@link String}
	 */
	public String getNumero() 
	{
		return numero;
	}

	/**
	 * @param numero {@link String}
	 */
	public void setNumero(String numero) 
	{
		this.numero = numero;
	}

	/**
	 * @return disponivel {@link boolean}
	 */
	public boolean isDisponivel() 
	{
		return disponivel;
	}

	/**
	 * @param disponivel {@link boolean}
	 */
	public void setDisponivel(boolean disponivel) 
	{
		this.disponivel = disponivel;
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
