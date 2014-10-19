package net.designtypes.examples.powerful.gateway.impl;

import static net.designtypes.examples.powerful.model.Gender.*;
import net.designtypes.examples.powerful.gateway.InsureeDataServiceGateway;
import net.designtypes.examples.powerful.model.Insuree;
import net.designtypes.examples.powerful.model.InsureeNumber;
import net.designtypes.examples.technologic.lib.Logged;

import org.joda.time.LocalDate;

@Logged
public class InsureeDataServiceGatewayImpl implements InsureeDataServiceGateway {
	
	@Override
	public Insuree getBy(InsureeNumber insureeNumber) {
		// get insuree data from some external service
		
		// dummy implementation:
		Insuree insuree = new Insuree(insureeNumber);
		insuree.setBirthday(new LocalDate(1970, 01, 01));
		insuree.setGender(FEMALE);
		return insuree;
	}
}
