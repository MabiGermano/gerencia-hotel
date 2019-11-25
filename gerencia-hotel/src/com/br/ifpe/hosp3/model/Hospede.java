package com.br.ifpe.hosp3.model;

/**
 * @author Tayná Alexandra
 *
 * Classe Hospede que herda da classe Pessoa 
 */

public class Hospede extends Pessoa
{

	public Hospede(String nome, String cpf, String email, String telefone, String palavra_passe, Endereco endereco) 
	{
		super(nome, cpf, email, telefone, palavra_passe, endereco);
	}
	public Hospede() {
		
	}

}