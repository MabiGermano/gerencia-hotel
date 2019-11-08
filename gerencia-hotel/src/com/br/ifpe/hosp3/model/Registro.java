package com.br.ifpe.hosp3.model;

/**
 * @author Tayn� Alexandra
 *
 * Classe Registro 
 */

public class Registro 
{
	private int id;
	private boolean flag_ativo;
	private String pagamento;
	private Hospedagem hospedagem;
	private Quarto quarto;
	private ConsumoExtra consumoExtra;
	private Funcionario funcionario;
	private boolean deleted;
	
	public Registro(int id, boolean flag_ativo, String pagamento, Hospedagem hospedagem, 
			Quarto quarto, ConsumoExtra consumoExtra, Funcionario funcionario) {
		this.id = id;
		this.flag_ativo = flag_ativo;
		this.pagamento = pagamento;
		this.hospedagem = hospedagem;
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
	 * @return flag_ativo {@link boolean}
	 */
	public boolean isFlag_ativo() 
	{
		return flag_ativo;
	}

	/**
	 * @param flag_ativo {@link boolean}
	 */
	public void setFlag_ativo(boolean flag_ativo) 
	{
		this.flag_ativo = flag_ativo;
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

	/**
	 * @return deleted {@link boolean}
	 */
	public boolean isDeleted()
	{
		return deleted;
	}

	/**
	 * @param deleted {@link boolean}
	 */
	public void setDeleted(boolean deleted)
	{
		this.deleted = deleted;
	}
	
}
