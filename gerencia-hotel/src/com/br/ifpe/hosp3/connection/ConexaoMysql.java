package com.br.ifpe.hosp3.connection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.jdbc.ScriptRunner;

import com.mysql.jdbc.Connection;

/**
 * @author Maria Beatriz Germano 
 * 
 *  Classe de Comunixação com o banco de dados
 **/
public class ConexaoMysql {

	public static String status = "N�o conectou...";

	public ConexaoMysql() {
		
	}
	/**
	 * Método estático para obter as propriedades de configuração
	 * presentes no arquivo application.properties
	 * 
	 * @return props {@link Properties}
	 **/
	public static Properties getProperties() throws IOException {
        Properties props = new Properties();
//        FileInputStream file = new FileInputStream(
//                "./src/application.properties");
        URL url = ClassLoader.getSystemResource("./application.properties");
        if(url != null) {
        	props.load(url.openStream());
        }else {
        	System.out.println("deu erro kakakak");
        }
        //props.load(file);
        return props;
    }
	
	/**
	 * Método estático para obter a conexão com o banco 
	 * de dados MySql
	 * 
	 * @return connection {@link Connection}
	 * @throws IOException
	 **/
	public static java.sql.Connection getConexaoMySQL() throws IOException {

		Connection connection = null;
		Properties prop = getProperties();
		String driverName = prop.getProperty("prop.server.driverName");
		String url = prop.getProperty("prop.server.url");
		String username = prop.getProperty("prop.server.login");
		String password = prop.getProperty("prop.server.password");

		try {
			Class.forName(driverName);
			connection = (Connection) DriverManager.getConnection(url, username, password);

			if (connection != null) {
				status = ("STATUS--->Conectado com sucesso!");
			} else {
				status = ("STATUS--->N�o foi possivel realizar conex�o");
			}

			return connection;
		} catch (ClassNotFoundException e) {

			System.out.println("O driver expecificado nao foi encontrado.");
			return null;

		} catch (SQLException e) {

			System.out.println("N�o foi possivel conectar ao Banco de Dados.");
			if(e.getErrorCode() == 1049){
				url = prop.getProperty("prop.server.urlDefault");
				connection = getConexaoDefault(url, username, password);
				connection = (Connection) getConexaoMySQL();
			}else {
				connection = null; 
			}


			return connection;
		}
	}
	/**
	 * Método para criação automática do banco de dados caso ele não exista
	 * @param url {@link String}
	 * @param username {@link String}
	 * @param password {@link String}
	 * 
	 * @return conexao {@link Connection}
	 * @throws SQLException {@link SQLException}
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 **/
	private static Connection getConexaoDefault(String url,String username,String password) {
		Connection conexao = null;
		
		try {
			conexao = (Connection) DriverManager.getConnection(url, username, password);
			ScriptRunner sr = new ScriptRunner(conexao);
		    Reader reader = new BufferedReader(new FileReader("./resources/sql/banco_gerencia_hotel.sql"));
		   
		    sr.runScript(reader);
		} catch (SQLException | FileNotFoundException e) {
			e.printStackTrace();
		}
		return conexao;
	}

	/**
	 * Método estático para obter status da conexao
	 * 
	 * @return status {@link String}
	 **/
	public static String getStatus() {
		return status;
	}

	/**
	 * Método estático para fechar a conexão com 
	 * o banco de dados MySql
	 * 
	 * @return boolean {@link boolean}
	 **/
	public static boolean FecharConexao() throws IOException {

		try {
			ConexaoMysql.getConexaoMySQL().close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Método estático para reiniciar a conexão com 
	 * o banco de dados MySql
	 * 
	 * @return ConexaoMysql.getConexaoMySQL() {@link Connection}
	 **/
	public static java.sql.Connection ReiniciarConexao() throws IOException {
		FecharConexao();
		return ConexaoMysql.getConexaoMySQL();
	}
	

	/**
	 * Método estático para leitura e execução de arquivos sql
	 * 
	 * @param caminhoDoArquivo {@link String}
	 * 
	 * @throws IOException {@link IOException} 
	 * @throws SQLException {@link SQLException}
	 **/
	public static void lerScript(String caminhoDoArquivo) throws IOException, SQLException {
		java.sql.Connection conexao = ConexaoMysql.getConexaoMySQL();
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	    ScriptRunner sr = new ScriptRunner(conexao);
	    Reader reader = new BufferedReader(new FileReader(caminhoDoArquivo));
	    
	    sr.runScript(reader);
	}

}
