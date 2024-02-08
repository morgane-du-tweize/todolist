package servlets.taches;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TacheDAO;
import models.Tache;

@WebServlet("/task")
public class CreateTasks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String description = request.getParameter("ndescription");
		String dateLimiteStr = request.getParameter("ndatelim");
		Date dateLimite = Date.valueOf(dateLimiteStr);
		
		Tache nouvelleTache = new Tache(description, dateLimite);
		nouvelleTache.setNouvelleDate(dateLimite);
		HttpSession session = request.getSession(true);
		int idUser = (int) session.getAttribute("idUser") ;

		TacheDAO.saveTache(nouvelleTache, idUser);
		response.sendRedirect("accueil");
	}
		
}
