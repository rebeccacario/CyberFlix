package edu.txstate.internet.cyberflix.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class CustomerDAO extends DAO {
	private final static Logger LOGGER = Logger.getLogger(CustomerDAO.class.getName());
	
	private static final int CUST_ID_COLUMN = 1;
	private static final int CUST_FIRST_NAME_COLUMN = 2;
	private static final int CUST_LAST_NAME_COLUMN = 3;
	private static final int CUST_EMAIL_COLUMN = 4;
	private static final int CUST_PASSWORD_COLUMN = 5;

	@Override
	public void save(Object anObject) throws SQLException {
		// TODO Auto-generated method stub		
	}

	private Customer buildResults (ResultSet results) {
		Customer customer = null;
		try {
			results.next();
			int id = results.getInt(CUST_ID_COLUMN);
			String custFirst = results.getString(CUST_FIRST_NAME_COLUMN);
			String custLast = results.getString(CUST_LAST_NAME_COLUMN);
			String custEmail = results.getString(CUST_EMAIL_COLUMN);
			String custPass = results.getString(CUST_PASSWORD_COLUMN);
			customer = new Customer(id, custFirst, custLast, custEmail, custPass);
		} catch (SQLException e) {
			LOGGER.severe(e.toString());
		}
		return customer;
	}
	
	public Customer findCustomer (String email) {
		Connection dbConnection = null;
		Customer customer = null;
		
		final String customerString = "SELECT customer_id, first_name, last_name, email, password from customer where email = '";
		
		StringBuilder stringBuilder = new StringBuilder(customerString);
		stringBuilder.append(email);
		stringBuilder.append("'");
		String selectString = stringBuilder.toString();
		
		try {
			dbConnection = DAO.getDBConnection();
			Statement statement 	= dbConnection.createStatement();
			ResultSet results = statement.executeQuery(selectString);
			customer = buildResults(results);
			dbConnection.close();
		} catch (SQLException e) {
			System.err.println("CustomerDAO.findCustomer: " + e.toString());
			LOGGER.severe(e.toString());
			closeQuietly(dbConnection);
		}	
		
		return customer;
	}
}
