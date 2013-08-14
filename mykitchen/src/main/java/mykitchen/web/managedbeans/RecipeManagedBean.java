package mykitchen.web.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import mykitchen.business.ProductBean;
import mykitchen.business.RecipeBean;
import mykitchen.business.UnitOfMeasureBean;
import mykitchen.model.Product;
import mykitchen.model.Recipe;
import mykitchen.model.RecipeIngredient;
import mykitchen.model.UnitOfMeasure;
import mykitchen.web.utils.UserSessionHelper;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;

@ManagedBean
@ViewScoped
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
		selectedRecipe = new Recipe();
		selectedRecipe.getRecipeinfo().setAutor(UserSessionHelper.getUser());

		uoms = unitOfMeasureBean.getAll();
		products = productBean.getAllProducts();
		RequestContext.getCurrentInstance().execute("recipeDialog.show()");
	}

	public void editRecipe() {
		System.err.println("edit " + selectedRecipe);

		uoms = unitOfMeasureBean.getAll();
		products = productBean.getAllProducts();
		//RequestContext.getCurrentInstance().execute("wiz.loadStep (wiz.cfg.steps [0], true)");
		RequestContext.getCurrentInstance().execute("recipeDialog.show()");
		//RequestContext.getCurrentInstance().execute("");
	}

	public void deleteRecipe() {
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

	public void addIngredient() {
		System.out.println("add ingredient");
		selectedRecipe.getIngredients().add(new RecipeIngredient());
	}
	
	public void onEdit(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Car Edited", ((RecipeIngredient) event.getObject()).toString());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
      
    public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Car Cancelled", ((RecipeIngredient) event.getObject()).toString());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
}