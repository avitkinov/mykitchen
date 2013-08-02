package mykitchen.business;

import java.util.List;

import mykitchen.model.Recipe;

public interface RecipeBean {

	List<Recipe> getAllRecipes();
	
	Recipe getRecipe(Long id);
	
	void addRecipe(Recipe recipe);

	List<String> getAllRecipeImages();
}
