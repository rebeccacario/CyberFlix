package edu.txstate.cs3320.javajuice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.txstate.internet.cyberflix.data.film.Film;


/**
 * Servlet implementation class CyberFlixLoginServlet
 */
@WebServlet("/CyberFlixShowCartServlet")
public class CyberFlixShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
//		ServletUtils.setAbsolutePath(config);
//	    DataSource.init();
	}

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		Cart cart = getCart(session);

		List <Film> cartFilms = cart.getFilms();
		
		request.setAttribute("films", cartFilms);
		request.setAttribute("total", cart.getPrice());
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
	
	public Cart getCart(HttpSession session) {
		Cart cart = null;
		if(!CartManager.getInstance().isSession(session.getId())) {
			CartManager.getInstance().newSession(session.getId(), cart);
		}
		
		cart= CartManager.getInstance().getExistingCart(session.getId());
		
		return cart;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
