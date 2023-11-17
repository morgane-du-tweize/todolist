package todoList;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Tayst {

	public static void main(String[] args) throws Exception {
		
		Properties props = new Properties();
		try (FileInputStream fis = new FileInputStream("conf.properties")){
			props.load(fis);
		}

		String className = props.getProperty("jdbc.driver.class");
		Class.forName(className);
		
		String url = props.getProperty("jdbc.url");
		String login = props.getProperty("jdbc.login");
		String password = props.getProperty("jdbc.password");
		
		try (Connection connection = DriverManager.getConnection(url, login, password)){
			
			String sqlOrder = "SELECT * FROM td_users;";
			
			try (Statement statement = connection.createStatement()){

				try (ResultSet result = statement.executeQuery(sqlOrder)){
					while(result.next()) {
						int index = result.getInt(1);
						String pseudo = result.getString(2);
						String mdp = result.getString("u_password");
					}				
				}
			

			}
		}
		
	}

}
