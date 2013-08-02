package mykitchen.business;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import mykitchen.model.User;

/**
 * Session service for login and logout.
 * 
 * @author Asparuh Vitkinov
 */
@Stateless
public class SessionBean implements ISessionBean {

	/**
	 * Initialize session bean.
	 */
	@PostConstruct
	public void initSessionBean() {

		/* Initialize service */
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.sepp.bidding.business.ISessionService#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public User login(String userName, String password) {
		User user = null;

		return user;
	}
}
