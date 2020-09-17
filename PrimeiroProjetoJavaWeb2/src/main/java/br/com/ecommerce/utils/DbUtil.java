package br.com.ecommerce.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	static Connection connection;
	
	public static Connection getConnection() {
		if(connection != null) {
			return connection;
		}
		else {
			String url = "jdbc:mysql://localhost:3306/";
			                                   //corrige problema da timezone
			String dbname = "rapaduralivre?useTimezone=true&serverTimezone=UTC";
			String uname = "";
			String pwd = "";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url+dbname, uname, pwd);
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			return connection;
		}
	}
}
