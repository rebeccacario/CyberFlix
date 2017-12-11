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
import edu.txstate.internet.cyberflix.data.film.Film.FilmRating;


/**
 * Servlet implementation class CyberFlixServlet
 */
@WebServlet("/CyberFlixServlet")
public class CyberFlixServlet extends HttpServlet {
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
    public CyberFlixServlet() {
        super();
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List <Film> foundFilms = null;
		String runtimeString = null;
		
		String keyword = null;
		DataSource dataSource = new DataSource();
		request.setAttribute("detailServlet", "http://localhost:8080/CyberFlix/CyberFlixMovieDetailServlet");
		
		int runtime = 0;
		if(request.getParameter("length") != null && !request.getParameter("length").isEmpty()) {
			runtimeString = request.getParameter("length");
			runtime = Integer.parseInt(runtimeString);
		}
		
		FilmRating filmRating = FilmRating.UR;
		if(request.getParameter("rating") != null) {
			String rating = request.getParameter("rating");
			filmRating = Film.getRatingFromString(rating);
		}

		if(request.getParameter("film_title") != null) {
			keyword = request.getParameter("film_title");
			foundFilms = dataSource.findFilmsByTitle(keyword, "", runtime, filmRating);
			foundFilms.addAll(dataSource.findFilmsByTitle("", keyword, runtime, filmRating));
		}
		
		String letter = null;
		if(request.getParameter("letter") != null) {
			letter = request.getParameter("letter");
			letter = letter.substring(0,1);
			foundFilms = dataSource.findFilmsAlphabetically(letter);
		}
		
		HttpSession session=request.getSession();
		Cart cart = getCart(session);
		request.setAttribute("cart", cart.getFilms());
		
		request.setAttribute("films", foundFilms);
		
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
