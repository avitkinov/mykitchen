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
import mykitchen.business.UserBean;
import mykitchen.model.Product;
import mykitchen.model.Recipe;
import mykitchen.model.UnitOfMeasure;
import mykitchen.model.User;
import mykitchen.model.UserProduct;
import mykitchen.web.utils.UserSessionHelper;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

@ManagedBean
@ViewScoped
public class MyKitchenManagedBean implements Serializable {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1L;

	private User loggedUser;

	private List<Product> products;

	private List<UnitOfMeasure> uoms;

	private List<Recipe> availableRecipes;

	private Recipe selectedRecipe;

	@EJB
	private UserBean userBean;
	@EJB
	private ProductBean productBean;
	@EJB
	private UnitOfMeasureBean unitOfMeasureBean;
	@EJB
	private RecipeBean recipeBean;

	@PostConstruct
	public void init() {
		loggedUser = UserSessionHelper.getUser();
		loadEntities();
	}

	public void loadEntities() {
		products = productBean.getAllProducts();
		uoms = unitOfMeasureBean.getAll();
	}

	public List<Product> getProducts() {
		return products;
	}

	public List<UnitOfMeasure> getUoms() {
		return uoms;
	}

	public void addProduct() {
		loggedUser.getProducts().add(new UserProduct());
		// selectedProduct = new UserProduct();
		// RequestContext.getCurrentInstance().execute("productDialog.show()");
	}

	public void editProduct() {
		loadEntities();

		RequestContext.getCurrentInstance().execute("productDialog.show()");
	}

	public void save() {

	}

	public User getLoggedUser() {
		return loggedUser;
	}

	public void loadAvailableRecipes() {
		availableRecipes = recipeBean.getAvailableRecipe(loggedUser.getId());
		
	}

	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Car Edited",
				((UserProduct) event.getObject()).getProduct().getName());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Car Cancelled",
				((UserProduct) event.getObject()).getProduct().getName());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<Recipe> getAvailableRecipes() {
		return availableRecipes;
	}

	public Recipe getSelectedRecipe() {
		return selectedRecipe;
	}

	public void setSelectedRecipe(Recipe selectedRecipe) {
		this.selectedRecipe = selectedRecipe;
	}

}