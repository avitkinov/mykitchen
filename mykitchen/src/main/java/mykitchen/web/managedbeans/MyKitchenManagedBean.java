package mykitchen.web.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import mykitchen.business.RecipeBean;
import mykitchen.model.Recipe;

import org.primefaces.event.FlowEvent;

@ManagedBean
@SessionScoped
public class MyKitchenManagedBean implements Serializable {

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
		loadRecipes();
		selectedRecipe = new Recipe();
		System.err.println(selectedRecipe);
	}

	public Recipe getSelectedRecipe() {
		return selectedRecipe;
	}

	public void setSelectedRecipe(Recipe selectedRecipe) {
		System.err.println("Set selected recipe" + selectedRecipe);
		this.selectedRecipe = selectedRecipe;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public String onFlowProcess(FlowEvent event) {
		System.out.println("*****" + selectedRecipe);
		return event.getNewStep();
	}

	public void loadRecipes() {
		recipes = recipeBean.getAllRecipes();
		System.err.println("recipes:" + recipes);
	}

	public void addRecipe() {
		selectedRecipe = new Recipe();
		System.err.println("add" + selectedRecipe);
	}

	public void editRecipe() {
		System.err.println("edit " + selectedRecipe);
	}

	public void deleteRecipe() {
		System.err.println("delete" + selectedRecipe);
		recipes.remove(selectedRecipe);
	}

	public void save(ActionEvent actionEvent) {
		System.out.println("save");
		System.out.println("Selected recipe" + selectedRecipe);
		recipeBean.putRecipe(selectedRecipe);
		
		loadRecipes();
	}
}