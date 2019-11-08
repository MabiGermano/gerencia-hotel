package com.br.ifpe.hosp3.model;

/**
 * @author Tayná Alexandra
 *
 * Classe Consumo Extra 
 */

public class ConsumoExtra 
{
	private int id;
	private String descricao;
	private float valor;
	private boolean deleted;
	
	public ConsumoExtra(int id, String descricao, float valor) 
	{
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
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
	 * @return descricao {@link String}
	 */
	public String getDescricao() 
	{
		return descricao;
	}

	/**
	 * @param descricao {@link String}
	 */
	public void setDescricao(String descricao) 
	{
		this.descricao = descricao;
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
