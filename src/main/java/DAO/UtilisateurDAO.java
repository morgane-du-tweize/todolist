package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

}
