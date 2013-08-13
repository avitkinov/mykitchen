package mykitchen.postgresql;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import mykitchen.model.Recipe;
import mykitchen.model.RecipeIngredient;
import mykitchen.model.UserProduct;
import mykitchen.repositories.RecipeRepository;

@Stateless
public class PostgreRecipeRepository extends PostgreBaseRepository<Recipe>
		implements RecipeRepository {

	public List<Recipe> getAvailableRecipes(List<UserProduct> products) {
		List<Recipe> result = new ArrayList<>();
		List<Recipe> allRecipes = getAll();

		for (Recipe recipe : allRecipes) {
			List<RecipeIngredient> ingredients = recipe.getIngredients();

			int successConter = 0;

			for (RecipeIngredient ingredient : ingredients) {
				for (UserProduct userProduct : products) {
					if (userProduct.getProduct().getId() == ingredient
							.getProduct().getId()
							&& userProduct.getQuantity() >= ingredient
									.getQuantity()) {
						successConter++;
						break;
					}
				}

			}

			if (successConter == ingredients.size()) {
				result.add(recipe);
			}
		}

		return result;
	}

	public List<String> getAllImages() {
		TypedQuery<String> query = entityManager.createQuery(
				"SELECT r.image FROM Recipe r", String.class);

		return query.getResultList();
	}
}