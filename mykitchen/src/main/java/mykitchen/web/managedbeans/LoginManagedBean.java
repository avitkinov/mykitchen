package mykitchen.web.managedbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mykitchen.business.SessionBean;
import mykitchen.model.User;
import mykitchen.util.NavigationPage;

import org.apache.log4j.Logger;

/**
 * Controls the login process and stores the logged in user.
 * 
 * @author Asparuh Vitkinov
 */
@ManagedBean
@SessionScoped
public class LoginManagedBean implements Serializable {
	/** Serial Version ID. */
	private static final long serialVersionUID = 6704436797880373164L;

	/** Logger. */
	private static final Logger cLogger = Logger
			.getLogger(LoginManagedBean.class);

	/** Variable for username field. */
	private String iUsername;

	/** Variable for password field. */
	private String iPassword;

	/** Session service. */
	@EJB
	private SessionBean sessionService;

	private User logedUser;

	/** Initialize container with messages. */
	@PostConstruct
	public void postContruct() {
		cLogger.info("LoginManagedBean is initialized");
	}

	/**
	 * Get username.
	 * 
	 * @return the Username
	 */
	public String getUsername() {
		return iUsername;
	}

	/**
	 * Set username.
	 * 
	 * @param aUsername
	 *            the Username to set
	 */
	public void setUsername(final String aUsername) {
		this.iUsername = aUsername;
	}

	/**
	 * Get password.
	 * 
	 * @return the Password
	 */
	public String getPassword() {
		return iPassword;
	}

	/**
	 * Set password.
	 * 
	 * @param aPassword
	 *            the iPassword to set
	 */
	public void setPassword(final String aPassword) {
		this.iPassword = aPassword;
	}

	/**
	 * The user logs into the system. He has access to all functionality after
	 * log in.
	 * 
	 * @return {@link ApplicationPage#INDEX#value()} if the user has entered
	 *         valid username and password or empty string otherwise
	 */
	public String login() {
		String tRedirectPage = null;
		User user = sessionService.login(iUsername, iPassword);

		if (user.getId() > 0) {
			UserSessionHelper.setUser(user);
			logedUser = user;
			tRedirectPage = NavigationPage.INDEX.value();
		} else {
			UserSessionHelper.addFacesMessage(FacesMessage.SEVERITY_ERROR,
					"login failed");
		}

		return tRedirectPage;
	}

	/**
	 * User logs out from the system and redirect to Login page.
	 * 
	 * @return Logout the application
	 */
	public String logout() {
		String tRedirectPage = NavigationPage.LOGIN.value();

		UserSessionHelper.invalidateUserSession();
		logedUser = null;
		return tRedirectPage;
	}

	public User getLogedUser() {
		System.out.println("asgfsdg");
		return logedUser;
	}
}
