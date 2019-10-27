package com.br.ifpe.hosp3.model;

public class ConsumoExtra 
{
	private int codigo_consumoExtra;
	private String descricao;
	private float valor;
	
	public ConsumoExtra(int codigo_consumoExtra, String descricao, float valor) 
	{
		this.codigo_consumoExtra = codigo_consumoExtra;
		this.descricao = descricao;
		this.valor = valor;
	}

	public int getCodigo_consumoExtra() 
	{
		return codigo_consumoExtra;
	}

	public void setCodigo_consumoExtra(int codigo_consumoExtra) 
	{
		this.codigo_consumoExtra = codigo_consumoExtra;
	}

	public String getDescricao() 
	{
		return descricao;
	}

	public void setDescricao(String descricao) 
	{
		this.descricao = descricao;
	}

	public float getValor() 
	{
		return valor;
	}

	public void setValor(float valor) 
	{
		this.valor = valor;
	}

}
