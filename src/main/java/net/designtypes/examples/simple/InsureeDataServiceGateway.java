package net.designtypes.examples.simple;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsureeDataServiceGateway {
	private static final Logger log = LoggerFactory.getLogger(InsureeDataServiceGateway.class);
	
	public InsureeData getBy(String insureeNumber) {
		log.info("get insuree data [{}]", insureeNumber);
		// get insuree data from some external service
		
		// dummy implementation:
		InsureeData result = new InsureeData(insureeNumber);
		result.setBirthday(new LocalDate(1970, 01, 01));
		result.setMale(false);
		return result;
	}
}
