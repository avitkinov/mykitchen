package mykitchen.web.utils;

import java.io.IOException;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import mykitchen.model.User;

/**
 * 
 * 
 * @author Asparuh Vitkinov
 */
public class UserSessionHelper {
	/** Constants string for login user. */
	public static final String LOG_IN_USER = "LogInUser";

	/**
	 * Get faces context from current instance.
	 * 
	 * @return Current faces context
	 */
	public static FacesContext getCurrentFacesContextInstance() {
		return FacesContext.getCurrentInstance();
	}

	/**
	 * Get external faces context from current faces context instance.
	 * 
	 * @return Current external faces context
	 */
	public static ExternalContext getCurrentExternalContext() {
		return getCurrentFacesContextInstance().getExternalContext();
	}

	/**
	 * Get session map from current faces context instance.
	 * 
	 * @return Current session map
	 */
	public static Map<String, Object> getSessionMap() {
		return getCurrentExternalContext().getSessionMap();
	}

	/**
	 * Get request map from current faces context instance.
	 * 
	 * @return Current request map
	 */
	public static Map<String, Object> getRequestMap() {
		return getCurrentExternalContext().getRequestMap();
	}

	/**
	 * Set login user in current session map.
	 * 
	 * @param aSessionId
	 *            session id to set
	 */
	public static void setUser(User user) {
		getSessionMap().put(LOG_IN_USER, user);

	}

	/**
	 * Get login user.
	 * 
	 * @return Session id
	 */
	public static User getUser() {
		return (User) getSessionMap().get(LOG_IN_USER);
	}

	/**
	 * Invalidate current user session.
	 */
	public static void invalidateUserSession() {
		getCurrentExternalContext().invalidateSession();
	}

	/**
	 * Add faces message to current faces context.
	 * 
	 * @param aFacesMessageSeverity
	 *            Severity of message
	 * @param aMessage
	 *            message to set
	 */
	public static void addFacesMessage(final Severity aFacesMessageSeverity,
			final String aMessage) {
		FacesMessage tFacesMessage = new FacesMessage(aFacesMessageSeverity,
				aMessage, null);
		getCurrentFacesContextInstance().addMessage(null, tFacesMessage);
	}
	
	public static void redirect(final String outcome) throws IOException {
		FacesContext context = getCurrentFacesContextInstance();
		context.getApplication().getNavigationHandler().handleNavigation(context, null, outcome);
	}
}
