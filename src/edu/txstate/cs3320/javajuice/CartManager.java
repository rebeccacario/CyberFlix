package edu.txstate.cs3320.javajuice;

import java.util.HashMap;

public class CartManager {
	private static final CartManager cartManager = new CartManager();
	
	HashMap<String, Cart> hmap = new HashMap<String, Cart>();
	
	public boolean isSession(String session) {
		return hmap.containsKey(session);
	}
	
	public void newSession(String session, Cart cart) {
		hmap.put(session, cart);
	}
	
	public Cart getExistingCart(String session) {
		Cart cart = hmap.get(session);
		return cart;
	}
	
	public static CartManager getInstance() {
		return cartManager;
	}

	
}
