package mykitchen.postgresql;

import javax.ejb.Stateless;

import mykitchen.model.RecipeIngredient;
import mykitchen.repositories.RecipeIngredientRepository;

@Stateless
public class PostgreRecipeIngredientRepository extends
		PostgreBaseRepository<RecipeIngredient> implements RecipeIngredientRepository{



}
