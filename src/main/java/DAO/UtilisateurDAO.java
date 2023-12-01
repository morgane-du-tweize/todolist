package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import models.Utilisateur;

public class UtilisateurDAO extends DAOContext {

	public static void saveUser(Utilisateur newUser) {
		try(Connection connection = DriverManager.getConnection(url, login, password)){
			
			String hashed = BCrypt.hashpw(newUser.getuPassword(), BCrypt.gensalt());
			String saveUser = "INSERT INTO td_users (u_pseudo, u_password) VALUES (?, ?); ";
			try (PreparedStatement prep = connection.prepareStatement(saveUser)){
				prep.setString(1, newUser.getuPseudo());
				prep.setString(2, hashed);
				prep.executeUpdate();
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
			String isConnectedUser = "SELECT * FROM td_users WHERE u_pseudo =?;" ;

			try (PreparedStatement prep = connection.prepareStatement(isConnectedUser)){
				prep.setString(1, uLogin);
				try(ResultSet resultSet = prep.executeQuery()){
					if (resultSet.next()) {
						int uID = resultSet.getInt(1);
						String hashedPassword = resultSet.getString("u_password");
						if (BCrypt.checkpw(uPassword, hashedPassword)) {
							Utilisateur newUser = new Utilisateur(
									resultSet.getString("u_pseudo"),
									uPassword
								);
							newUser.setuId(uID);
							return newUser ;

						}else {
							return null ;
						}
					}else {
						return null;
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

}
