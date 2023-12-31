package models;

public class Utilisateur {
	private int uId ;
	private String uPseudo ;
	private String uPassword ;
	
	public Utilisateur(String uPseudo, String uPassword) {
		setuPseudo(uPseudo);
		setuPassword(uPassword);
	}

	public int getuId() {
		return uId;
	}
	
	public void setuId(int uId) {
		this.uId = uId;
	}
	
	public String getuPseudo() {
		return uPseudo;
	}
	
	public void setuPseudo(String uPseudo) {
		this.uPseudo = uPseudo;
	}
	
	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	@Override
	public String toString() {
		return "Utilisateur :\n [uId = " + uId + ", uPseudo = " + uPseudo + ", uPassword = " + uPassword + "]";
	}
	
}
