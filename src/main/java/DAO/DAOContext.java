package DAO;

import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

public class DAOContext {
	
	protected static String url;
	protected static String login;
	protected static String password;
	
	public static void init(ServletContext context) {
		
		try {
			Class.forName(context.getInitParameter("JDBC_DRIVER"));
			url = context.getInitParameter("JDBC_URL");
			login = context.getInitParameter("JDBC_LOGIN");
			password = context.getInitParameter("JDBC_PASSWORD");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
