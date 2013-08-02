package mykitchen.rest.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import mykitchen.model.Recipe;
import mykitchen.repositories.RecipeRepository;

@Stateless
@LocalBean
@Path("/recipes")
public class RecipeResource {

	@EJB
	private RecipeRepository recipeRepository;

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Recipe> getAllRecipies() {
		List<Recipe> result = recipeRepository.getAll();

		return result;
	}

	@POST
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Recipe> getAvailableRecipies(@FormParam("id") String userId) {
		List<Recipe> result = new ArrayList<Recipe>();

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
	public void add(JAXBElement<Recipe> recipe) {
		recipeRepository.add(recipe.getValue());
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
