package mykitchen.web.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mykitchen.business.ProductBean;
import mykitchen.model.Product;

import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class ProductManagedBean implements Serializable {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1L;

	private List<Product> products;

	private Product selectedProduct;

	@EJB
	private ProductBean productBean;

	@PostConstruct
	public void init() {
		loadProducts();
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public void loadProducts() {
		products = productBean.getAllProducts();
	}

	public void addProduct() {
		selectedProduct = new Product();

		RequestContext.getCurrentInstance().execute("productDialog.show()");
	}

	public void editProduct() {
		RequestContext.getCurrentInstance().execute("productDialog.show()");
	}

	public void deleteProduct() {
		products.remove(selectedProduct);
	}

	public void save() {
		productBean.putProduct(selectedProduct);

		RequestContext.getCurrentInstance().execute("productDialog.hide()");

		loadProducts();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}