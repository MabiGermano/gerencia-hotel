package com.br.ifpe.hosp3.model;

/**
 * @author Tayn� Alexandra
 *
 * Classe Consumo Extra 
 */

public class ConsumoExtra 
{
	private int id;
	private String descricao;
	private float valor;
	private Hospedagem hospedagem;
	
	public ConsumoExtra(int id, String descricao, float valor, Hospedagem hospedagem) 
	{
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.hospedagem = hospedagem;
	}
	
	public ConsumoExtra() {
		
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
	 * @return hospedagem {@link Hospedagem}
	 */
	public Hospedagem getHospedagem() {
		return hospedagem;
	}
	/**
	 * @param hospedagem {@link Hospedagem}
	 */
	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}
	
}