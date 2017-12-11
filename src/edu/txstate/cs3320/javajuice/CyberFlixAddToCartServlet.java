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

import edu.txstate.internet.cyberflix.data.DataSource;
import edu.txstate.internet.cyberflix.data.film.Film;


/**
 * Servlet implementation class CyberFlixLoginServlet
 */
@WebServlet("/CyberFlixAddToCartServlet")
public class CyberFlixAddToCartServlet extends HttpServlet {
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
		DataSource dataSource = new DataSource();
		String filmName = request.getParameter("film");
		List <Film> foundFilms = dataSource.findFilmsByTitle(filmName, "", 0, null);
		
		HttpSession session =request.getSession();
		Cart cart = getCart(session);
		//System.out.println(foundFilms.get(0).getTitle());
		cart.addFilm(foundFilms.get(0));
		request.setAttribute("films", cart.getFilms());
		//System.out.print(cart.getPrice());
		request.setAttribute("total", cart.getPrice());
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
	
	public Cart getCart(HttpSession session) {
		Cart cart = new Cart();
		if(!CartManager.getInstance().isSession(session.getId())) {
			CartManager.getInstance().newSession(session.getId(), cart);
		}
		else {
		cart= CartManager.getInstance().getExistingCart(session.getId());
		}
		return cart;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
