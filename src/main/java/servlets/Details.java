package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		Tache oneTask = (Tache) session.getAttribute("oneTask");
		
		System.out.println(oneTask);
		request.getRequestDispatcher("/jsps/details.jsp").forward(request, response);
	}


}
