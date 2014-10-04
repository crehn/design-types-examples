package net.designtypes.examples.technologic.gateway;

import static net.designtypes.examples.my.model.Gender.*;
import net.designtypes.examples.my.model.Insuree;
import net.designtypes.examples.my.model.InsureeNumber;
import net.designtypes.examples.technologic.lib.Logged;

import org.joda.time.LocalDate;

@Logged
public class InsureeDataServiceGateway {
	
	public Insuree getBy(InsureeNumber insureeNumber) {
		// get insuree data from some external service
		
		// dummy implementation:
		return Insuree.builder() //
				.insureeNumber(insureeNumber) //
				.birthday(new LocalDate(1970, 01, 01)) //
				.gender(FEMALE) //
				.build();
	}
}
