package mykitchen.business;

import java.util.List;

import mykitchen.model.Recipe;

public interface RecipeBean {

	List<Recipe> getAllRecipes();

	Recipe getRecipe(Long id);

	int putRecipe(Recipe recipe);

	List<String> getAllRecipeImages();
	
	List<Recipe> getAvailableRecipe(Long userId);
}
