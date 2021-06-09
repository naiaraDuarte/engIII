package br.com.fatecmc.esiii.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	public static Connection getConnectionPostgres() throws ClassNotFoundException, SQLException {
		driver = "org.postgresql.Driver";
		url = "jdbc:postgresql://localhost:5432/crudEngIII";
		user = "postgres";
		password = "postgres";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

}
