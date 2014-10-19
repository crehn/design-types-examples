package net.designtypes.examples.powerful.gateway;

import net.designtypes.examples.powerful.model.Insuree;
import net.designtypes.examples.powerful.model.InsureeNumber;

public interface InsureeDataServiceGateway {

	Insuree getBy(InsureeNumber insureeNumber);
	
}
