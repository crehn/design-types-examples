package net.designtypes.examples.my.boundary;

import javax.inject.Inject;
import javax.ws.rs.*;

import lombok.extern.slf4j.Slf4j;
import net.designtypes.examples.my.api.LifeExpectancy;
import net.designtypes.examples.my.control.LifeExpectancyFacade;
import net.designtypes.examples.my.model.InsureeNumber;

@Slf4j
@Path("/insurees")
public class LifeExpectancyBoundary {
	
	@Inject
	private LifeExpectancyFacade facade;
	
	@GET
	@Path("/{insureeNumber}/lifeExpectancy")
	public LifeExpectancy getLifeExpectancy(@PathParam("insureeNumber") InsureeNumber insureeNumber) {
		log.info("get life expectency for insuree [{}]", insureeNumber);
		LifeExpectancy result = new LifeExpectancy(facade.getResidualLifeExpecantcy(insureeNumber));
		log.info("got life expectency for insuree [{}]: {}", insureeNumber, result);
		return result;
	}
}
