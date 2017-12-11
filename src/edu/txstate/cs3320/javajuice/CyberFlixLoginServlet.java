package edu.txstate.cs3320.javajuice;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.txstate.internet.cyberflix.data.Customer;
import edu.txstate.internet.cyberflix.data.DataSource;


/**
 * Servlet implementation class CyberFlixLoginServlet
 */
@WebServlet("/CyberFlixLoginServlet")
public class CyberFlixLoginServlet extends HttpServlet {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSource dataSource = new DataSource();
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Customer customer = dataSource.findCustomer(email);
		if(customer == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		Cart cart = getCart(session);
		
		if(customer.getPassword()==password) {
			cart.setUser(customer);
			request.setAttribute("email", cart.getCustomer().getEmailAddress());
		}
		request.setAttribute("loggedIn", cart.isLoggedIn());
		request.setAttribute("cart", cart.getFilms());
		//doGet(request, response);
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
}
