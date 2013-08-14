package mykitchen.business;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ws.rs.core.MediaType;

import mykitchen.model.User;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Session service for login and logout.
 * 
 * @author Asparuh Vitkinov
 */
@Stateless
public class RestfulUserBean implements UserBean {

	private static final String RESTFUL_SERVER = "http://localhost:8080/mykitchen.rest";
	private WebResource resource;

	/**
	 * Initialize session bean.
	 */
	@PostConstruct
	public void initSessionBean() {
		Client client = Client.create();
		resource = client.resource(RESTFUL_SERVER);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.sepp.bidding.business.ISessionService#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public User login(final String userName, final String password) {
		User response = resource.path("users").queryParam("username", userName)
				.queryParam("password", password).accept("application/xml")
				.get(User.class);

		return response;
	}

	@Override
	public boolean isExist(String userName) {
		WebResource webResource = resource.path("users").path("exist")
				.path(userName);

		String response = webResource.accept(MediaType.TEXT_PLAIN).get(
				String.class);

		return response.toLowerCase().equals("true");
	}

	@Override
	public int put(final User user) {
		ClientResponse response = resource.path("users")
				.type(MediaType.APPLICATION_XML)
				.put(ClientResponse.class, user);

		return response.getStatus();
	}
}
