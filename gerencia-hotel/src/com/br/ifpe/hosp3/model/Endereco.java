package com.br.ifpe.hosp3.model;

/**
 * @author Tayn� Alexandra
 *
 *         Classe Endereco
 */

public class Endereco {
	private int id;
	private String rua;
	private String numero;
	private String cep;
	private String bairro;
	private String pais;
	private String cidade;
	private String estado;
	private String complemento;

	public Endereco() {

	}

	public Endereco(int id, String rua, String numero, String cep, String bairro, String pais, String cidade,
			String estado, String complemento) {
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.pais = pais;
		this.cidade = cidade;
		this.estado = estado;
		this.complemento = complemento;
	}
	
	public Endereco(String rua, String numero, String cep, String bairro, String pais, String cidade,
			String estado, String complemento) {
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.pais = pais;
		this.cidade = cidade;
		this.estado = estado;
		this.complemento = complemento;
	}
	
	public Endereco(Endereco endereco) {
		this.id = endereco.getId();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.cep = endereco.getCep();
		this.bairro = endereco.getBairro();
		this.pais = endereco.getPais();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.complemento = endereco.getComplemento();
	}


	/**
	 * @return id {@link String}
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id {@link int}
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return rua {@link String}
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * @param rua {@link String}
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * @return numero {@link String}
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero {@link String}
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return cep {@link String}
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep {@link String}
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return bairro {@link String}
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro {@link String}
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return pais {@link String}
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais {@link String}
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return cidade {@link String}
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade {@link String}
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	/**
	 * @return estado {@link String}
	 */
	public String getEstado() {
		return estado;
	}


	/**
	 * @param estado {@link String}
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return complemento {@link String}
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento {@link String}
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}