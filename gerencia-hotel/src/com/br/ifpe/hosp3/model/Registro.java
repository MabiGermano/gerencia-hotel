package com.br.ifpe.hosp3.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Tayn� Alexandra
 *
 * Classe Registro 
 */

public class Registro 
{
	private int id;
	private boolean flagAtivo = true;
	private String pagamento = "Pendente";
	private Hospedagem hospedagem;
	private Funcionario funcionario;
	private Timestamp dataCheckin;
	private Timestamp dataCheckout;
	private double valor;
	
	public Registro(int id, String pagamento, Hospedagem hospedagem, Funcionario funcionario) {
		this.id = id;
		this.pagamento = pagamento;
		this.hospedagem = hospedagem;
		this.funcionario = funcionario;
		this.dataCheckin = new Timestamp(System.currentTimeMillis());
	}
	
	public Registro(String pagamento, Hospedagem hospedagem, Funcionario funcionario) {
		this.pagamento = pagamento;
		this.hospedagem = hospedagem;
		this.funcionario = funcionario;
	}
	public Registro() {
		
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
	 * @return flagAtivo {@link boolean}
	 */
	public boolean isFlagAtivo() 
	{
		return flagAtivo;
	}

	/**
	 * @param flagAtivo {@link boolean}
	 */
	public void setFlagAtivo(boolean flagAtivo) 
	{
		this.flagAtivo = flagAtivo;
	}

	/**
	 * @return pagamento {@link String}
	 */
	public String getPagamento() 
	{
		return pagamento;
	}

	/**
	 * @param pagamento {@link String}
	 */
	public void setPagamento(String pagamento) 
	{
		this.pagamento = pagamento;
	}

	/**
	 * @return hospede {@link Hospede}
	 */
	public Hospedagem getHospedagem() 
	{
		return hospedagem;
	}

	/**
	 * @param hospede {@link Hospede}
	 */
	public void setHospedagem(Hospedagem hospedagem) 
	{
		this.hospedagem = hospedagem;
	}

	/**
	 * @return funcionario {@link Funcionario}
	 */
	public Funcionario getFuncionario() 
	{
		return funcionario;
	}

	/**
	 * @param funcionario {@link Funcionario}
	 */
	public void setFuncionario(Funcionario funcionario) 
	{
		this.funcionario = funcionario;
	}

	/**
	 * @return valor {@link double}
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor {@link double}
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * @return dataCheckin {@link Timestamp}
	 */
	public Timestamp getDataCheckin() {
		return dataCheckin;
	}

	/**
	 * @param dataCheckin {@link Timestamp}
	 */
	public void setDataCheckin(Timestamp dataCheckin) {
		this.dataCheckin = dataCheckin;
	}

	/**
	 * @return dataCheckout {@link Timestamp}
	 */
	public Timestamp getDataCheckout() {
		return dataCheckout;
	}

	/**
	 * @param dataCheckout {@link Timestamp}
	 */
	public void setDataCheckout(Timestamp dataCheckout) {
		this.dataCheckout = dataCheckout;
	}
	
	
	
	
}