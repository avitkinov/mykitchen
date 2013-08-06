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

import mykitchen.model.UnitOfMeasure;
import mykitchen.repositories.UnitOfMeasureRepository;

@Stateless
@LocalBean
@Path("/uom")
public class UnitOfMeasureResource {

	@EJB
	private UnitOfMeasureRepository unitOfMeasureRepository;

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<UnitOfMeasure> getAllRecipies() {
		List<UnitOfMeasure> result = unitOfMeasureRepository.getAll();

		return result;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void put(JAXBElement<UnitOfMeasure> input) {
		UnitOfMeasure unitOfMeasure = input.getValue();

		if (unitOfMeasure.getId() == 0) {
			unitOfMeasureRepository.add(unitOfMeasure);
		} else {
			unitOfMeasureRepository.edit(unitOfMeasure);
		}
	}
}
