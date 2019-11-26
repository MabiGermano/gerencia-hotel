package com.br.ifpe.hosp3.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class TesteDeConexao {

	public static void main(String[] args) throws SQLException {
		try {

			System.out.println(ConexaoMysql.getStatus() );
			ConexaoMysql.lerScript("./lib/teste.sql");
			System.out.println(ConexaoMysql.getStatus() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
