package com.br.ifpe.hosp3.model;

/**
 * @author Tayná Alexandra
 *
 * Classe Hospedagem 
 */

public class Hospedagem 
{
	private int id;
	private Hospede hospede;
	private Quarto quarto;
	private boolean deleted;
	
	public Hospedagem(int id, Hospede hospede, Quarto quarto) 
	{
		this.id = id;
		this.hospede = hospede;
		this.quarto = quarto;
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