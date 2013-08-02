package mykitchen.web.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mykitchen.business.RecipeBean;
import mykitchen.model.Recipe;

import org.primefaces.event.FlowEvent;

@ManagedBean
@SessionScoped
public class RecipeManagedBean implements Serializable {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1L;

	private List<Recipe> recipes;

	private Recipe selectedRecipe;

	@EJB
	private RecipeBean recipeBean;

	@PostConstruct
	public void init() {
		recipes = recipeBean.getAllRecipes();

	}

	public Recipe getSelectedRecipe() {
		return selectedRecipe;
	}

	public void setSelectedRecipe(Recipe selectedRecipe) {
		this.selectedRecipe = selectedRecipe;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public String onFlowProcess(FlowEvent event) {
		return event.getNewStep();
	}
	
	public String viewRecipeDetails(){
		System.out.println("Click");
		
		return null;
	}
}