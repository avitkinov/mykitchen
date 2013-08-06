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
import mykitchen.web.utils.UserSessionHelper;

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

	private User user = new User();

	private String passwordagain;

	private boolean logged;

	/** Session service. */
	@EJB
	private SessionBean sessionService;

	/** Initialize container with messages. */
	@PostConstruct
	public void init() {
		System.out.println("LoginManagedBean is initialized");
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPasswordagain() {
		return passwordagain;
	}

	public void setPasswordagain(String passwordagain) {
		this.passwordagain = passwordagain;
	}

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
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
		User user = sessionService.login(this.user.getUsername(),
				this.user.getPassword());

		if (user.getId() > 0) {
			UserSessionHelper.setUser(user);
			setUser(user);
			setLogged(true);
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
		String redirectPage = NavigationPage.INDEX.value();

		UserSessionHelper.invalidateUserSession();

		return redirectPage;
	}

	public String register() {
		String redirectPage;
		boolean isExistUsername = sessionService.isExist(user.getUsername());
		if (isExistUsername) {
			UserSessionHelper.addFacesMessage(FacesMessage.SEVERITY_ERROR,
					"Username exist");
			redirectPage = null;
		} else {
			sessionService.add(user);
			redirectPage = NavigationPage.LOGIN.value();
		}

		return redirectPage;
	}
}
