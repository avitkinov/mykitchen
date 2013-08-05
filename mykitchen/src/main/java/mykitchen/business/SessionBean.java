package mykitchen.business;

import javax.ejb.Local;

import mykitchen.model.User;

/**
 * 
 * Interface represents session operations.
 * 
 * @author Asparuh Vitkinov
 */
@Local
public interface SessionBean {

	/**
	 * Login with provided username and password.
	 * 
	 * @param userName
	 *            Username for login
	 * @param password
	 *            Password for login
	 * 
	 * @return User if exist, otherwise <code>null</code>
	 */
	User login(String userName, String password);

	boolean isExist(String userName);

	void add(User user);
}