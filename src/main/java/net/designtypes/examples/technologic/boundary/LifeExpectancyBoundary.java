package net.designtypes.examples.technologic.boundary;

import javax.inject.Inject;
import javax.ws.rs.*;

import net.designtypes.examples.my.api.LifeExpectancy;
import net.designtypes.examples.my.control.LifeExpectancyFacade;
import net.designtypes.examples.my.model.InsureeNumber;

@Path("/insurees")
public class LifeExpectancyBoundary {
	
	@Inject
	private LifeExpectancyFacade facade;
	
	@GET
	@Path("/{insureeNumber}/lifeExpectancy")
	public LifeExpectancy getLifeExpectancy(@PathParam("insureeNumber") InsureeNumber insureeNumber) {
		return new LifeExpectancy(facade.getResidualLifeExpecantcy(insureeNumber));
	}
}
