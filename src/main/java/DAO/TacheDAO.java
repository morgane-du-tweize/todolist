package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Tache;

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
						Date dateLimite = result.getDate("t_date_limite");
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
	

	public static void saveTache(Tache newTask, int idUser) {
		
		try(Connection connection = DriverManager.getConnection(url, login, password)) {
			String saveSql = "INSERT INTO td_taches(t_description, t_date_limite, t_fk_users_id) VALUES (?, ?, ?); ";
			
			try (PreparedStatement prep = connection.prepareStatement(saveSql)){
				prep.setString(1, newTask.getDescription());
				prep.setDate(2, newTask.getDateLimite());				
				prep.setInt(3, idUser);

				prep.executeUpdate();
			}

		}
		catch(SQLException e) {
			System.out.println("erreur sql");
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
