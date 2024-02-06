package servlets.taches;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TacheDAO;
import models.Tache;

@WebServlet("/UpdateTask")
public class UpdateTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String description = request.getParameter("ndescription");
		String dateLimiteStr = request.getParameter("ndatelim");
		Date dateLimite = Date.valueOf(dateLimiteStr);
		int idTache = Integer.valueOf(request.getParameter("idtache"));
		TacheDAO.updateTache(idTache, description, dateLimite);
		response.sendRedirect("accueil");
	}

}
