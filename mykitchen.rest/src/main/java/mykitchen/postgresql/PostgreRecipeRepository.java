package mykitchen.postgresql;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import mykitchen.model.Product;
import mykitchen.model.Recipe;
import mykitchen.repositories.RecipeRepository;

@Stateless
public class PostgreRecipeRepository extends PostgreBaseRepository<Recipe> implements RecipeRepository {

	public List<Recipe> getAvailableRecipes(List<Product> products) {
		return null;
	}

	public List<String> getAllImages() {
		List<String> result;
		
		TypedQuery<String> query = entityManager.createQuery("SELECT r.image FROM Recipe r", String.class);
		result = query.getResultList();
	   System.out.println(result);
		return result;
	}

}