package com.br.ifpe.hosp3.model;

public class Registro 
{
	private boolean flagAtivo;
	private String pagamento;
	private int codigo_consumo;
	private int codigo_quarto;
	private int codigo_hospede;
	
	public Registro(boolean flagAtivo, String pagamento, int codigo_consumo, int codigo_quarto, int codigo_hospede) 
	{
		this.flagAtivo = flagAtivo;
		this.pagamento = pagamento;
		this.codigo_consumo = codigo_consumo;
		this.codigo_quarto = codigo_quarto;
		this.codigo_hospede = codigo_hospede;
	}

	public boolean isFlagAtivo() 
	{
		return flagAtivo;
	}

	public void setFlagAtivo(boolean flagAtivo) 
	{
		this.flagAtivo = flagAtivo;
	}

	public String getPagamento() 
	{
		return pagamento;
	}

	public void setPagamento(String pagamento) 
	{
		this.pagamento = pagamento;
	}

	public int getCodigo_consumoExtra() 
	{
		return codigo_consumo;
	}

	public void setCodigo_consumoExtra(int codigo_consumo) 
	{
		this.codigo_consumo = codigo_consumo;
	}

	public int getCodigo_quarto() 
	{
		return codigo_quarto;
	}

	public void setCodigo_quarto(int codigo_quarto) 
	{
		this.codigo_quarto = codigo_quarto;
	}

	public int getCodigo_hospede() 
	{
		return codigo_hospede;
	}

	public void setCodigo_hospede(int codigo_hospede) 
	{
		this.codigo_hospede = codigo_hospede;
	}
	
}
