package com.br.ifpe.hosp3.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
/*
 * @author Maria Beatriz Germano 
 * 
 *  Classe de conexão com o banco de dados mysql
 */
public class ConexaoMysql {
	
    public static String status = "Não conectou...";
 
        public ConexaoMysql() {
 
    }
 
public static java.sql.Connection getConexaoMySQL() {
 
        Connection connection = null;

try {
 
String driverName = "com.mysql.jdbc.Driver";                        
 
Class.forName(driverName);
 
        String serverName = "127.0.0.1";
 
        String mydatabase = "mysql";
 
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
 
        String username = "mgermano";      
 
        String password = "";
 
        connection = (Connection) DriverManager.getConnection(url, username, password);
 
        if (connection != null) {
            status = ("STATUS--->Conectado com sucesso!");
        } else {
            status = ("STATUS--->Não foi possivel realizar conexão");
        }
        
        return connection;
        } catch (ClassNotFoundException e) {
 
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
 
        } catch (SQLException e) {
 
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
 
            return null;
        } 
    }

    public static String statusConection() {
        return status;
    }
  
    public static boolean FecharConexao() {
 
        try {
            ConexaoMysql.getConexaoMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
 
    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return ConexaoMysql.getConexaoMySQL();
	}

}
