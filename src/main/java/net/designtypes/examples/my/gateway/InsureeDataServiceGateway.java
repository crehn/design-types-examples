package net.designtypes.examples.my.gateway;

import static net.designtypes.examples.my.model.Gender.*;
import lombok.extern.slf4j.Slf4j;
import net.designtypes.examples.my.model.Insuree;
import net.designtypes.examples.my.model.InsureeNumber;

import org.joda.time.LocalDate;

@Slf4j
public class InsureeDataServiceGateway {

	public Insuree getBy(InsureeNumber insureeNumber) {
		log.info("get insuree [{}]", insureeNumber);
		// get insuree data from some external service

		// dummy implementation:
		return Insuree.builder() //
				.insureeNumber(insureeNumber) //
				.birthday(new LocalDate(1970, 01, 01)) //
				.gender(FEMALE) //
				.build();
	}
}
