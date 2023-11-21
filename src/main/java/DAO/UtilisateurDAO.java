package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Utilisateur;

public class UtilisateurDAO extends DAOContext {

	public static void saveUser(Utilisateur newUser) {
		try(Connection connection = DriverManager.getConnection(url, login, password)){
			
			String saveUser = "INSERT INTO td_users (u_pseudo, u_password) VALUES (?, ?); ";
			try (PreparedStatement prep = connection.prepareStatement(saveUser)){
				prep.setString(1, newUser.getuPseudo());
				prep.setString(2, newUser.getuPassword());

				prep.executeUpdate();
				System.out.println("utilisateur créé en base de données");
			}
		}
		catch (SQLException e) {
			System.out.println("url = " + url);
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Utilisateur isValidUtilisateur(String uLogin, String uPassword) {
		
		try(Connection connection = DriverManager.getConnection(url, login, password)){

			String isConnectedUser = "SELECT * FROM td_users WHERE u_pseudo =? AND u_password =?;" ;
			System.out.println("je suis connecté");

			try (PreparedStatement prep = connection.prepareStatement(isConnectedUser)){
				prep.setString(1, uLogin);
				prep.setString(2, uPassword);
				try(ResultSet resultSet = prep.executeQuery()){
					if (resultSet.next()) {
						return new Utilisateur(
							resultSet.getString("u_pseudo"),	
							resultSet.getString("u_password")
						);
					}
					else {
						return null ;
					}	
				}
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	
	
	
	//SELECT u_id FROM td_users WHERE u_pseudo = 'parrain13' AND u_password = 'pizza' ;

}
