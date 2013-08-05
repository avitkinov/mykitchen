package mykitchen.business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ws.rs.core.MediaType;

import mykitchen.model.Recipe;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;


@Stateless
public class RestufulRecipeBean implements RecipeBean {

	private static final String RESTFUL_SERVER = "http://localhost:8080/mykitchen.rest";
	private WebResource resource;
	
	@PostConstruct
	private void init(){
		Client client = Client.create();
		resource = client.resource(RESTFUL_SERVER);
	}
	
	@Override
	public List<Recipe> getAllRecipes() {		
		List<Recipe> response = resource.path("recipes").accept(MediaType.APPLICATION_XML).get(new GenericType<List<Recipe>>() {});
		
		return response;
	}

	@Override
	public Recipe getRecipe(Long id) {		
		return resource.path("recipes").accept(MediaType.APPLICATION_XML).get(new GenericType<Recipe>(){});
	}

	@Override
	public void putRecipe(Recipe recipe) {
	    ClientResponse response = resource.path("recipes").type(MediaType.APPLICATION_XML)
	        .put(ClientResponse.class, recipe);
	    System.out.println(response.getStatus());
	}

	@Override
	public List<String> getAllRecipeImages() {
		String response = resource.path("recipes").path("images").accept(MediaType.TEXT_PLAIN).get(String.class);
		
		List<String> result = new ArrayList<String>();
		
		String[] splitedImages = response.split("!");
		
		for (String imagePath : splitedImages) {
			result.add(imagePath);
		}
		
		return result;
	}

}
