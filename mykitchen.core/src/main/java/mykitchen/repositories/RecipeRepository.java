package mykitchen.repositories;

import java.util.List;

import mykitchen.model.Recipe;
import mykitchen.model.UserProduct;

public interface RecipeRepository extends BaseRepository<Recipe>{

	List<Recipe> getAvailableRecipes(List<UserProduct> products);

	List<String> getAllImages();
}
