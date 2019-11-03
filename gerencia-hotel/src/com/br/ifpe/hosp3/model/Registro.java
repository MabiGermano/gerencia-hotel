package com.br.ifpe.hosp3.model;

/**
 * @author Tayn� Alexandra
 *
 * Classe Registro 
 */

public class Registro 
{
	private int id;
	private boolean flagAtivo;
	private String pagamento;
	private Hospede hospede;
	private Quarto quarto;
	private ConsumoExtra consumoExtra;
	private Funcionario funcionario;
	
	public Registro(int id, boolean flagAtivo, String pagamento, Hospede hospede, Quarto quarto, ConsumoExtra consumoExtra, Funcionario funcionario) 
	{
		this.id = id;
		this.flagAtivo = flagAtivo;
		this.pagamento = pagamento;
		this.hospede = hospede;
		this.quarto = quarto;
		this.consumoExtra = consumoExtra;
		this.funcionario = funcionario;
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
	public Hospede getHospede() 
	{
		return hospede;
	}

	/**
	 * @param hospede {@link Hospede}
	 */
	public void setHospede(Hospede hospede) 
	{
		this.hospede = hospede;
	}

	/**
	 * @return quarto {@link Quarto}
	 */
	public Quarto getQuarto() 
	{
		return quarto;
	}

	/**
	 * @param quarto {@link Quarto}
	 */
	public void setQuarto(Quarto quarto) 
	{
		this.quarto = quarto;
	}

	/**
	 * @return consumoExtra {@link ConsumoExtra}
	 */
	public ConsumoExtra getConsumoExtra() 
	{
		return consumoExtra;
	}

	/**
	 * @param consumoExtra {@link ConsumoExtra}
	 */
	public void setConsumoExtra(ConsumoExtra consumoExtra) 
	{
		this.consumoExtra = consumoExtra;
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
	
}
