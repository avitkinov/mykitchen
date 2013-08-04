package mykitchen.business;

import java.util.List;

import mykitchen.model.Recipe;

public interface RecipeBean {

	List<Recipe> getAllRecipes();
	
	Recipe getRecipe(Long id);
	
	void putRecipe(Recipe recipe);

	List<String> getAllRecipeImages();
}
