package com.br.ifpe.hosp3.connection;

import java.sql.Connection;

public class TesteConexao {

	public static void main(String[] args) {
		ConexaoMysql cm = new ConexaoMysql();
		Connection conexao = cm.getConexaoMySQL();
		System.out.println(cm.statusConection());
	}

}
