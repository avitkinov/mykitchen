package mykitchen.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ws.rs.core.MediaType;

import mykitchen.model.Product;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

@Stateless
public class RestfulProductBean implements ProductBean {

	private static final String RESTFUL_SERVER = "http://localhost:8080/mykitchen.rest";
	private WebResource resource;

	@PostConstruct
	private void init() {
		Client client = Client.create();
		resource = client.resource(RESTFUL_SERVER);
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> response = resource.path("products")
				.accept(MediaType.APPLICATION_XML)
				.get(new GenericType<List<Product>>() {
				});

		return response;
	}

	@Override
	public Product getProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int putProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

}
