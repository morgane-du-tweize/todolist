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
import models.Tache;

@WebServlet("/details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("connection");
			return ;
		}
		request.getRequestDispatcher("/jsps/details.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("connection");
			return ;
		}
		String idTache = request.getParameter("idtask");
		Tache nouvelleTache = TacheDAO.selectById(idTache);
		if (nouvelleTache == null) {
			System.out.println("rien");
		}
		else {
			request.setAttribute("idTache", nouvelleTache.getId());
			request.setAttribute("dateLimite", nouvelleTache.getDateLimite());
			request.setAttribute("description", nouvelleTache.getDescription());
			doGet(request, response);			
		}

	}

}
