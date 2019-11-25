package com.br.ifpe.hosp3.model;

/**
 * @author Tayn� Alexandra
 *
 * Classe Funcionario que herda da classe Pessoa 
 */

public class Funcionario extends Pessoa
{
	private String codigo;
	private String cargo;
	
	public Funcionario() {
		
	}
	
	public Funcionario(String nome, String cpf, String email, String telefone, String palavra_passe, 
						Endereco endereco, int id, String cargo, String codigo) 
	{
		super(nome, cpf, email, telefone, palavra_passe, endereco);
		this.cargo = cargo;
		this.codigo = codigo;
	}
	public Funcionario(String codigo, String palavraPasse) {
		super(null, null, null, null, palavraPasse, null);
		this.codigo = codigo;
	}

	/**
	 * @return codigo {@link String}
	 */
	public String getCodigo() 
	{
		return codigo;
	}

	/**
	 * @param codigo {@link String}
	 */
	public void setCodigo(String codigo) 
	{
		this.codigo = codigo;
	}

	/**
	 * @return cargo {@link String}
	 */
	public String getCargo() {
		return this.cargo;
	}

	/**
	 * @param cargo {@link String}
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}