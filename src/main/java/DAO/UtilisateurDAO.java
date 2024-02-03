package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import com.mysql.cj.util.Util;

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
			String request = "SELECT * FROM td_users WHERE u_pseudo =?;" ;

			try (PreparedStatement prep = connection.prepareStatement(request)){
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
							System.out.println(newUser);
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
	
	public static Utilisateur selectById(String idUser) {
		
		try(Connection connection = DriverManager.getConnection(url, login, password)){
			String request = "SELECT * FROM td_users WHERE u_id=?;";
			try(PreparedStatement prep = connection.prepareStatement(request)){
				prep.setString(1, idUser);
				try(ResultSet resultSet = prep.executeQuery()){
					if (resultSet.next()) {
						String userName = resultSet.getString(2);
						String password = resultSet.getString(3);
						Utilisateur utilisateur = new Utilisateur(userName, password);
						return utilisateur;
					}
					
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}


}
