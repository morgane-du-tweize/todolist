package servlets.taches;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TacheDAO;

@WebServlet("/DeleteTask")
public class DeleteTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTache = Integer.valueOf(request.getParameter("idtache")); 
		TacheDAO.removeTache(idTache);
		response.sendRedirect("accueil");
	}

}
