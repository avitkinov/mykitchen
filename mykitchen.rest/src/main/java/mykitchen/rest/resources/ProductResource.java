package mykitchen.rest.resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import mykitchen.model.Product;
import mykitchen.repositories.ProductRepository;

@Stateless
@LocalBean
@Path("/products")
public class ProductResource {

	@EJB
	private ProductRepository productRepository;

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Product> getAllRecipies() {
		List<Product> result = productRepository.getAll();

		return result;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void put(JAXBElement<Product> input) {
		Product product = input.getValue();

		if (product.getId() == 0) {
			productRepository.add(product);
		} else {
			productRepository.edit(product);
		}
	}
}
