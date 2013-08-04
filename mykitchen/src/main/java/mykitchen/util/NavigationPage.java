package mykitchen.util;

/**
 * Application page enum type.
 * 
 * @author Asparuh Vitkinov
 */
public enum NavigationPage {
	LOGIN("login"), INDEX("index"), ADMIN("admin");

	private String page;

	/**
	 * Private constructor.
	 * 
	 * @param page
	 *            Page string for faces-config
	 */
	private NavigationPage(String page) {
		this.page = page;
	}

	/**
	 * Get page string.
	 * 
	 * @return page string
	 */
	public String value() {
		return page;
	}
}
