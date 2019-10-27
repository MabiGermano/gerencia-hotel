package com.br.ifpe.hosp3.model;

/**
 * @author Tayná Alexandra
 *
 * Classe Hospede que herda da classe Pessoa 
 */

public class Hospede extends Pessoa
{
	private String codigo_hospede;

	public Hospede(String nome, String cpf, String email, String senha, String telefone, Endereco endereco, String codigo_hospede) 
	{
		super(nome, cpf, email, senha, telefone, endereco);
		this.codigo_hospede = codigo_hospede;
	}

	public String getCodigo_hospede() 
	{
		return codigo_hospede;
	}

	public void setCodigo_hospede(String codigo_hospede) 
	{
		this.codigo_hospede = codigo_hospede;
	}
	
}
