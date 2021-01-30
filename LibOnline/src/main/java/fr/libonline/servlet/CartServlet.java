package fr.libonline.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.libonline.dao.LivreDao;
import fr.libonline.dao.sql.LivreDaoSqlImpl;
import fr.libonline.model.Livre;

@WebServlet(value = "/panier")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération du panier depuis la session
		Map<Integer, Integer> cart = (Map<Integer, Integer>) request.getSession().getAttribute("cart");
		// S'il n'existe pas, on le crée
		if (cart == null) {
			request.getSession().setAttribute("cart", new HashMap<Integer, Integer>());
			cart = (Map<Integer, Integer>) request.getSession().getAttribute("cart");
		}
		// Gestion de l'ajout du livre dans le panier
		String livreId = request.getParameter("livreId");
		if (livreId != null) {
			LivreDao lDao = new LivreDaoSqlImpl();
			Livre fetchedBook = lDao.findById(Integer.parseInt(livreId));
			if (fetchedBook != null) {
				int id = fetchedBook.getId();
				if (cart.containsKey(id)) {
					// Si le livre est déjà dans le panier, on augmente sa quantité
					cart.replace(id, cart.get(id) + 1);
				} else {
					// Si c'est pas le cas, on l'ajoute en initialisant sa quantité
					cart.put(id, 1);
				}
				System.out.println(cart);
				response.sendRedirect("panier");
				return;
			}
		}
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/views/panier/cart_detail.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
