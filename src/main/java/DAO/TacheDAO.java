package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Tache;
import models.Utilisateur;

public class TacheDAO extends DAOContext {
	
	public static ArrayList<Tache> selectAll(int idUser) {
		try (Connection connection = DriverManager.getConnection(url, login, password)){
			String sqlOrder = "SELECT * FROM td_taches WHERE t_fk_users_id =? ;";
			ArrayList<Tache> listTaches = new ArrayList<>();
			try (PreparedStatement prep = connection.prepareStatement(sqlOrder)){
				prep.setInt(1, idUser);
				try(ResultSet result = prep.executeQuery()){
					while(result.next()) {
						String description = result.getString("t_description");
						String dateLimite = result.getString("t_date_limite");
						Tache newTask = new Tache(description, dateLimite);
						listTaches.add(newTask);
					}
					return listTaches;
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null ;
	}

}
