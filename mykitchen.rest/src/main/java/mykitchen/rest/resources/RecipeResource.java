package mykitchen.rest.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import mykitchen.model.Recipe;
import mykitchen.model.User;
import mykitchen.model.UserProduct;
import mykitchen.repositories.RecipeRepository;
import mykitchen.repositories.UserRepository;

@Stateless
@LocalBean
@Path("/recipes")
public class RecipeResource {

	@EJB
	private RecipeRepository recipeRepository;

	@EJB
	private UserRepository userRepository;

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Recipe> getAllRecipies() {
		return recipeRepository.getAll();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("availabe")
	public List<Recipe> getAvailableRecipies(@QueryParam("userId") String userId) {
		List<Recipe> result = new ArrayList<Recipe>();
		User user = userRepository.find(Long.valueOf(userId));
		
		if (user != null) {
			List<UserProduct> userProducts = user.getProducts();
			
			result = recipeRepository.getAvailableRecipes(userProducts);
		}
		
		return result;
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("{id}")
	public Recipe read(@PathParam("id") long id) {
		// return recipeRepository.find(id);
		return null;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void put(JAXBElement<Recipe> input) {
		Recipe recipe = input.getValue();

		if (recipe.getId() == 0) {
			recipeRepository.add(recipe);
		} else {
			recipeRepository.edit(recipe);
		}
	}

	@GET
	@Produces({ MediaType.TEXT_PLAIN })
	@Path("images")
	public String getRecipeImages() {
		List<String> allImages = recipeRepository.getAllImages();
		StringBuilder result = new StringBuilder();

		for (String imagePath : allImages) {
			result.append(imagePath).append('!');
		}

		return result.toString();
	}
}
