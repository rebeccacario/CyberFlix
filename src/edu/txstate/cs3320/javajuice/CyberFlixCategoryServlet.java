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
import edu.txstate.internet.cyberflix.data.film.FilmCategory;


/**
 * Servlet implementation class CyberFlixServlet
 */
@WebServlet("/CyberFlixCategoryServlet")
public class CyberFlixCategoryServlet extends HttpServlet {
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

		FilmCategory filmCategory = FilmCategory.NONE;
		if(request.getParameter("category") != null) {
			String category = request.getParameter("category");
			filmCategory = Film.getCategoryFromString(category);
		}

		request.setAttribute("detailServlet", "http://localhost:8080/CyberFlix/CyberFlixMovieDetailServlet");
		DataSource dataSource = new DataSource();
		List <Film> foundFilms = dataSource.findFilmsByCategory(filmCategory);
		request.setAttribute("films", foundFilms);
		HttpSession session=request.getSession();
		Cart cart = getCart(session);
		request.setAttribute("cart", cart.getFilms());
		
		
		response.setContentType("text/html; charset=windows-1252");
	    
	    request.getRequestDispatcher("SearchResults.jsp").forward(request, response);

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
