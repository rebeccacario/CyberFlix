package edu.txstate.cs3320.javajuice;

import java.util.ArrayList;
import java.util.List;

import edu.txstate.internet.cyberflix.data.Customer;
import edu.txstate.internet.cyberflix.data.film.Film;

public class Cart {
	List <Film> films = new ArrayList<Film>();
	Customer user;
	boolean loggedIn;
	
	public Cart() {
		user=null;
		loggedIn=false;
	}
	
	public void addFilm(Film film) {
		films.add(film);
	}
	
	public List<Film> getFilms(){
		return films;
	}
	
	public String getPrice() {
		return Integer.toString(films.size());
	}
	
	public void setUser(Customer customer) {
		this.user=customer;
		loggedIn=true;
	}
	
	public Customer getCustomer() {
		return user;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
}
