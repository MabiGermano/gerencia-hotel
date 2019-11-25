package com.br.ifpe.hosp3.model;

/**
 * @author Tayn� Alexandra
 *
 * Classe Quarto 
 */

public class Quarto 
{
	private int id;
	private float valor;
	private int quantidadePessoas;
	private String tipo;
	private String numero;
	private boolean disponivel = true;
	
	public Quarto(int id, float valor, int quantidadePessoas, String tipo, String numero, boolean disponivel) 
	{
		this.id = id;
		this.valor = valor;
		this.quantidadePessoas = quantidadePessoas;
		this.tipo = tipo;
		this.numero = numero;
		this.disponivel = disponivel;
	}
	
	
	
	public Quarto(float valor, int quantidadePessoas, String tipo, String numero, boolean disponivel) 
	{
		this.valor = valor;
		this.quantidadePessoas = quantidadePessoas;
		this.tipo = tipo;
		this.numero = numero;
		this.disponivel = disponivel;
	}



	public Quarto() {
		
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
	 * @return quantidadePessoas {@link int}
	 */
	public int getQuantidadePessoas() 
	{
		return quantidadePessoas;
	}

	/**
	 * @param quantidadePessoas {@link int}
	 */
	public void setQuantidadePessoas(int quantidadePessoas) 
	{
		this.quantidadePessoas = quantidadePessoas;
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
}