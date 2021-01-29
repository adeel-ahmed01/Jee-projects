package fr.libonline.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.libonline.dao.CommandeDao;
import fr.libonline.dao.sql.CommandeDaoSqlImpl;
import fr.libonline.model.Commande;

@WebServlet("/commande-ajout")
public class CommandeAjoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/views/commande/ajout.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idCommandeString = req.getParameter("idCommande");
		String dateCommandeString = req.getParameter("dateCommande");
		String clientIdString = req.getParameter("clientId");
		String montantCommandeString = req.getParameter("montantCommande");
		
		Date dateCommande = convertDate(dateCommandeString);
		int clientId = Integer.parseInt(clientIdString);
		int montantCommande = Integer.parseInt(montantCommandeString);
		int idCommande = Integer.parseInt(idCommandeString);
		
		Commande maCommande = new Commande();
		
		maCommande.id(idCommande);
		maCommande.clientId(clientId);
		maCommande.montant(montantCommande);
		maCommande.date(dateCommande);
		
		CommandeDao daoCommande = new CommandeDaoSqlImpl();
		
		daoCommande.add(maCommande);
		
		resp.sendRedirect("commandes");
	}

	private Date convertDate(String dateCommandeString) {
		
		String format = "yyyy-MM-dd";
		Date date = new Date();
		try {
		 date = new SimpleDateFormat(format).parse(dateCommandeString);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return date;
	}
	
}