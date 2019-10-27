package com.br.ifpe.hosp3.model;

public class Quarto 
{
	private String tipo;
	private String numero;
	private float valor;
	private int quantidade_pessoas;
	private boolean disponivel;
	private int codigo_hospede;
	
	public Quarto(String tipo, String numero, float valor, int quantidade_pessoas, boolean disponivel, int codigo_hospede) 
	{
		this.tipo = tipo;
		this.numero = numero;
		this.valor = valor;
		this.quantidade_pessoas = quantidade_pessoas;
		this.disponivel = disponivel;
		this.setCodigo_hospede(codigo_hospede);
	}

	public String getTipo() 
	{
		return tipo;
	}

	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}

	public String getNumero() 
	{
		return numero;
	}

	public void setNumero(String numero) 
	{
		this.numero = numero;
	}

	public float getValor() 
	{
		return valor;
	}

	public void setValor(float valor) 
	{
		this.valor = valor;
	}

	public int getQuantidade_pessoas() 
	{
		return quantidade_pessoas;
	}

	public void setQuantidade_pessoas(int quantidade_pessoas) 
	{
		this.quantidade_pessoas = quantidade_pessoas;
	}

	public boolean isDisponivel() 
	{
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) 
	{
		this.disponivel = disponivel;
	}

	public int getCodigo_hospede() 
	{
		return codigo_hospede;
	}

	public void setCodigo_hospede(int codigo_hospede) 
	{
		this.codigo_hospede = codigo_hospede;
	}
	
}
