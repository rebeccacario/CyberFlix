package edu.txstate.internet.cyberflix.data;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password;
	
	public Customer(int _id, String _firstName, String _lastName, String _emailAddress, String _password) {
		this.id = _id;
		this.firstName = _firstName;
		this.lastName = _lastName;
		this.emailAddress = _emailAddress;
		this.password = _password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
