package mykitchen.web.managedbeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;

import mykitchen.business.RecipeBean;
import mykitchen.model.Recipe;
import mykitchen.model.User;
import mykitchen.web.utils.UserSessionHelper;

import org.primefaces.event.FlowEvent;

@ManagedBean
@SessionScoped
public class AdminManagedBean implements Serializable {

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

	public void navigate(PhaseEvent event) throws IOException {
		User loggedUser = UserSessionHelper.getUser();
		
		if (!loggedUser.isAdmin()) {
			UserSessionHelper.redirect("mykitchen");
		}
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

	public String viewRecipeDetails() {
		return null;
	}
}