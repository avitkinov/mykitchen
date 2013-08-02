package mykitchen.repositories;

import java.util.List;

import mykitchen.model.Product;
import mykitchen.model.Recipe;

public interface RecipeRepository extends BaseRepository<Recipe>{

	List<Recipe> getAvailableRecipes(List<Product> products);

	List<String> getAllImages();
}
