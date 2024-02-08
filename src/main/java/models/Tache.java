package models;

import java.sql.Date;

import javax.management.RuntimeErrorException;

public class Tache {
	
	private String id;
	private String description ;
	private Date dateLimite ;
	private int idUser;

	public Tache(String description, Date dateLimite) {
		setDescription(description);
		setDateLimite(dateLimite);
	}
	
	public Tache(String id, String description, Date dateLimite) {
		setId(id);
		setDescription(description);
		setDateLimite(dateLimite);
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getDateLimite() {
		return dateLimite;
	}
	
	public void setDateLimite(Date dateLimite) {
		this.dateLimite = dateLimite;
	}
	
	public void setNouvelleDate(Date dateLimite) {
		long maintenant = System.currentTimeMillis();
		Date dateNow = new Date(maintenant);
		if (dateNow.after(dateLimite)) {
			throw new RuntimeException();
		}
		this.dateLimite = dateLimite;		
	}
	
	public int getIdUser() {
		return idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "Tache :\n"
				+ "[id=" + id + ", description = " + description + ", dateLimite = " + dateLimite + ", idUser = " + idUser ;
	}
	
}
