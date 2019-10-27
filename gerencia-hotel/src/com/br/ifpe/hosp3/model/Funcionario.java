package com.br.ifpe.hosp3.model;

/**
 * @author Tayná Alexandra
 *
 * Classe Funcionario que herda da classe Pessoa 
 */

public class Funcionario extends Pessoa
{
	private String codigo_funcionario;

	public Funcionario(String nome, String cpf, String email, String senha, String telefone, Endereco endereco, String codigo_funcionario) 
	{
		super(nome, cpf, email, senha, telefone, endereco);
		this.codigo_funcionario = codigo_funcionario;
	}

	public String getCodigo_funcionario() 
	{
		return codigo_funcionario;
	}

	public void setCodigo_funcionario(String codigo_funcionario) 
	{
		this.codigo_funcionario = codigo_funcionario;
	}
}
