package com.br.ifpe.hosp3.connection;

import java.io.IOException;
import java.sql.SQLException;
/**
 * @author Maria Beatriz Germano 
 * 
 *  Classe de execução de arquivos sql para o banco de dados
 **/
public class EstruturaBD {
	/**
	 * Método estático para criação da estrutura 
	 * do banco de dados
	 * 
	 *   @throws IOException {@link IOException}
	 *   @throws SQLException {@link SQLException}
	 **/
	public void criarBanco() throws SQLException, IOException {
		ConexaoMysql.lerScript("./resources/sql/banco_gerencia_hotel.sql");
	}
	
	/**
	 * Método estático para popular as tabelas 
	 * no banco de dados
	 * 
	 * @throws IOException {@link IOException}
	 * @throws SQLException {@link SQLException}
	 **/
	public void popularBanco() throws IOException, SQLException {
		ConexaoMysql.lerScript("./resource/sql/dump_hosp3.sql");
	} 
	
}
