package fr.libonline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.libonline.model.Client;

@WebServlet(value = "/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client currentUser = (Client) request.getSession().getAttribute("currentUser");
		if (currentUser != null) {
			/* Si un user est connect� on emp�che l'acc�s � la page d'inscription
			 * Dans ce cas, il sera redirig� vers l'affichage des livres
			 */
			response.sendRedirect("livres");
			return;
		}
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/views/user/register.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
