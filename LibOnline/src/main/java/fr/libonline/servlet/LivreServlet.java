package fr.libonline.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.libonline.dao.LivreDao;
import fr.libonline.dao.sql.LivreDaoSqlImpl;

@WebServlet("/livres")
public class LivreServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LivreDao daoLivre = new LivreDaoSqlImpl();
		
		req.setAttribute("produits", daoLivre.findAll());
		
		//DELEGATION DE LA REQUETE
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/views/livre/liste-livres.jsp")
			.forward(req, resp);
	}	
}
