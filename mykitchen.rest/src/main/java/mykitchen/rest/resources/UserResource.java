package mykitchen.rest.resources;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import mykitchen.model.User;
import mykitchen.repositories.UserRepository;

@Stateless
@LocalBean
@Path("/users")
public class UserResource {

	@EJB
	private UserRepository userRepository;

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public User login(@QueryParam("username") String username,
			@QueryParam("password") String password) {
		User user = userRepository.login(username, password);

		return user;
	}

}
