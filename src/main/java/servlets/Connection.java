package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAOContext;
import DAO.UtilisateurDAO;
import models.Utilisateur;

@WebServlet(
		name = "connection",
		urlPatterns = {
				"", "/connection"
		},
		loadOnStartup = 1)
public class Connection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Connection() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	DAOContext.init(this.getServletContext());
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsps/connection.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pseudo = request.getParameter("cpseudo");
		String password = request.getParameter("cpassword");
		Utilisateur utilisateur = UtilisateurDAO.isValidUtilisateur(pseudo, password) ;
		
		if (utilisateur != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("connectedUser", utilisateur);
			session.setAttribute("idUser", utilisateur.getuId());
			response.sendRedirect(request.getContextPath() + "/accueil");
		}
		else {
			response.sendRedirect(request.getContextPath() + "/connection");
		}
	}

}
