package com.br.ifpe.hosp3.connection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.jdbc.ScriptRunner;
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
	public static void criarBanco() throws SQLException, IOException {
		ConexaoMysql.lerScript("./lib/banco_gerencia_hotel.sql");
	}
	
	/**
	 * Método estático para popular as tabelas 
	 * no banco de dados
	 * 
	 * @throws IOException {@link IOException}
	 * @throws SQLException {@link SQLException}
	 **/
	public static void popularBanco() throws IOException, SQLException {
		ConexaoMysql.lerScript("./lib/dump_hosp3.sql");
	} 
	
}
