package com.br.ifpe.hosp3.enums;

public enum FormasDePagamentoEnum
{
	DINHEIRO("Dinheiro"),
	CARTAO_DE_CREDITO("Cartão de Crédito"),
	CARTAO_DE_DEBITO("Cartão de Débito");
	
	private String descricao;
	
	FormasDePagamentoEnum(String descricao) 
	{
		
	}

	public String getDescricao() 
	{
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}

