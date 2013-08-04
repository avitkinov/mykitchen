package mykitchen.web.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

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
		loadRecipes();
		selectedRecipe = new Recipe();
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

	public void loadRecipes() {
		recipes = recipeBean.getAllRecipes();
	}

	public void addRecipe() {
		System.out.println("add");
		selectedRecipe = new Recipe();
	}

	public void editRecipe() {
		System.out.println("edit");
	}

	public void deleteRecipe() {
		recipes.remove(selectedRecipe);
		System.out.println("delete");
	}

	public void save(ActionEvent actionEvent) {
		System.out.println("save");

		recipeBean.putRecipe(selectedRecipe);
		
		loadRecipes();
	}
}