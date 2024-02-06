package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TacheDAO;
import DAO.UtilisateurDAO;
import models.Tache;
import models.Utilisateur;

@WebServlet("/accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("connection");
			return ;
		}

		int idUtilisateur = (int) session.getAttribute("idUser") ;
		Utilisateur utilisateur = UtilisateurDAO.selectById(String.valueOf(idUtilisateur));
		ArrayList<Tache> listeTaches = TacheDAO.selectAll(idUtilisateur) ;
		request.setAttribute("listeTaches", listeTaches);
		request.setAttribute("utilisateur", utilisateur);
		request.getRequestDispatcher("/jsps/accueil.jsp").forward(request, response);

	}
}
