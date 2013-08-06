package mykitchen.web.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import mykitchen.business.ProductBean;
import mykitchen.business.RecipeBean;
import mykitchen.business.UnitOfMeasureBean;
import mykitchen.model.Product;
import mykitchen.model.Recipe;
import mykitchen.model.UnitOfMeasure;
import mykitchen.web.utils.UserSessionHelper;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

@ManagedBean
@SessionScoped
public class RecipeManagedBean implements Serializable {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1L;

	private List<Recipe> recipes;

	private List<Product> products;
	private List<UnitOfMeasure> uoms;

	private Recipe selectedRecipe;

	@EJB
	private RecipeBean recipeBean;

	@EJB
	private ProductBean productBean;

	@EJB
	private UnitOfMeasureBean unitOfMeasureBean;

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
		System.err.println("recipes:" + recipes);
	}

	public void addRecipe() {
		selectedRecipe = new Recipe();
		selectedRecipe.getRecipeinfo().setAutor(UserSessionHelper.getUser());

		uoms = unitOfMeasureBean.getAll();
		products = productBean.getAllProducts();
		RequestContext.getCurrentInstance().execute("recipeDialog.show()");
	}

	public void editRecipe() {
		System.err.println("edit " + selectedRecipe);

		RequestContext.getCurrentInstance().execute("recipeDialog.show()");
	}

	public void deleteRecipe() {
		System.err.println("delete" + selectedRecipe);
		recipes.remove(selectedRecipe);
	}

	public void save() {
		System.out.println("save");
		System.out.println("Selected recipe" + selectedRecipe);

		recipeBean.putRecipe(selectedRecipe);

		RequestContext.getCurrentInstance().execute("recipeDialog.hide()");

		loadRecipes();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<UnitOfMeasure> getUoms() {
		return uoms;
	}

	public void setUoms(List<UnitOfMeasure> uoms) {
		this.uoms = uoms;
	}
}