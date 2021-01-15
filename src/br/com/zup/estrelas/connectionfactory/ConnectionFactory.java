package br.com.zup.estrelas.connectionfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection fabricaConexao() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/estrelas?user=root"
					+ "&password=root&useTimezone=true&serverTimezone=UTC");

		} catch (SQLException e) {
			return null;
		}
	}
}
