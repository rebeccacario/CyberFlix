package edu.txstate.cs3320.javajuice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.txstate.internet.cyberflix.data.DataSource;
import edu.txstate.internet.cyberflix.data.film.Film;

/**
 * Servlet implementation class CyberFlixDetailServlet
 */
@WebServlet("/CyberFlixMovieDetailServlet")
public class CyberFlixMovieDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CyberFlixMovieDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filmName = request.getParameter("film_title");
		DataSource dataSource = new DataSource();
		List <Film> foundFilms = dataSource.findFilmsByTitle(filmName, "", 0, null);
		Film film = dataSource.getFilmDetail(foundFilms.get(0));
		
		HttpSession session=request.getSession();
		Cart cart = getCart(session);
		request.setAttribute("cart", cart.getFilms());
		
		request.setAttribute("film", film);
		request.getRequestDispatcher("movieDetails.jsp").forward(request, response);
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
