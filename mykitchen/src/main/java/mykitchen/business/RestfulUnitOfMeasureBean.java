package mykitchen.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ws.rs.core.MediaType;

import mykitchen.model.UnitOfMeasure;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

@Stateless
public class RestfulUnitOfMeasureBean implements UnitOfMeasureBean {

	private static final String RESTFUL_SERVER = "http://localhost:8080/mykitchen.rest";
	private WebResource resource;

	@PostConstruct
	private void init() {
		Client client = Client.create();
		resource = client.resource(RESTFUL_SERVER);
	}

	@Override
	public List<UnitOfMeasure> getAll() {
		List<UnitOfMeasure> response = resource.path("uom")
				.accept(MediaType.APPLICATION_XML)
				.get(new GenericType<List<UnitOfMeasure>>() {
				});

		return response;
	}

	@Override
	public UnitOfMeasure getUOM(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int putUOM(UnitOfMeasure uom) {
		// TODO Auto-generated method stub
		return 0;
	}

}
