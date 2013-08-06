package mykitchen.business;

import java.util.List;

import mykitchen.model.Product;

public interface ProductBean {
	List<Product> getAllProducts();

	Product getProduct(Long id);

	int putProduct(Product product);

}
