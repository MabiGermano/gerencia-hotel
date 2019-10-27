package com.br.ifpe.hosp3.model;

public class Endereco 
{
	private String rua;
	private String numero;
	private String cep;
	private String bairro;
	private String pais;
	private String cidade;
	private String complemento;
	
	public Endereco(String rua, String numero, String cep, String bairro, String pais, String cidade, String complemento) 
	{
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.pais = pais;
		this.cidade = cidade;
		this.complemento = complemento;
	}

	public String getRua() 
	{
		return rua;
	}

	public void setRua(String rua) 
	{
		this.rua = rua;
	}

	public String getNumero() 
	{
		return numero;
	}

	public void setNumero(String numero) 
	{
		this.numero = numero;
	}

	public String getCep() 
	{
		return cep;
	}

	public void setCep(String cep) 
	{
		this.cep = cep;
	}

	public String getBairro() 
	{
		return bairro;
	}

	public void setBairro(String bairro) 
	{
		this.bairro = bairro;
	}

	public String getPais() 
	{
		return pais;
	}

	public void setPais(String pais) 
	{
		this.pais = pais;
	}

	public String getCidade() 
	{
		return cidade;
	}

	public void setCidade(String cidade) 
	{
		this.cidade = cidade;
	}

	public String getComplemento() 
	{
		return complemento;
	}

	public void setComplemento(String complemento) 
	{
		this.complemento = complemento;
	}
	
}
