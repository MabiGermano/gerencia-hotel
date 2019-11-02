package com.br.ifpe.hosp3.connection;

import java.io.IOException;
import java.sql.Connection;

public class TesteConexao {

	public static void main(String[] args) {
		ConexaoMysql cm = new ConexaoMysql();
		try {
			Connection conexao = cm.getConexaoMySQL();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cm.getStatus());
	}

}
