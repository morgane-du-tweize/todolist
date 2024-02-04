package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UtilisateurDAO;
import models.Utilisateur;

@WebServlet("/enregistrement")
public class Enregistrement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("epseudo");
		String userPassword = request.getParameter("epassword");
		Utilisateur newUser = new Utilisateur(userName, userPassword);
		
		if (UtilisateurDAO.saveUser(newUser)) {
			newUser = UtilisateurDAO.isValidUtilisateur(userName, userPassword) ;
			HttpSession session = request.getSession(true);
			session.setAttribute("connectedUser", newUser);
			session.setAttribute("idUser", newUser.getuId());
			response.sendRedirect(request.getContextPath() + "/accueil");	
		}
		else {
			response.sendRedirect(request.getContextPath() + "");
		}

	}
}
