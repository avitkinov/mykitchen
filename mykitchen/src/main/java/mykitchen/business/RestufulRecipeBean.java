package mykitchen.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.core.MediaType;

import mykitchen.model.Recipe;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;


@Stateless
public class RestufulRecipeBean implements RecipeBean {

	@Override
	public List<Recipe> getAllRecipes() {
		Client client = Client.create(); 
		String uri = "http://localhost:8080/mykitchen.rest/recipes"; 
		WebResource resource = client.resource(uri); 
		
		List<Recipe> response = resource.accept("application/xml").get(new GenericType<List<Recipe>>() {});
		for (Recipe recipe : response) {
			System.out.println(recipe);
		}
		return response;
	}

	@Override
	public Recipe getRecipe(Long id) {
		System.out.println("Get recipe with id:" + id);
		Client client = Client.create(); 
		String uri = "http://localhost:8080/mykitchen.rest/recipes"; 
		WebResource resource = client.resource(uri).path(id.toString()); 
		
		Recipe response = resource.accept("application/xml").get(new GenericType<Recipe>(){});
		
		return response;
	}

	@Override
	public void addRecipe(Recipe recipe) {

	}

	@Override
	public List<String> getAllRecipeImages() {
		Client client = Client.create(); 
		String uri = "http://localhost:8080/mykitchen.rest/recipes/images"; 
		WebResource resource = client.resource(uri); 
		
		String response = resource.accept(MediaType.TEXT_PLAIN).get(String.class);
		
		List<String> result = new ArrayList<String>();
		
		String[] splitedImages = response.split("!");
		
		for (String imagePath : splitedImages) {
			result.add(imagePath);
		}
		
		return result;
	}

}
