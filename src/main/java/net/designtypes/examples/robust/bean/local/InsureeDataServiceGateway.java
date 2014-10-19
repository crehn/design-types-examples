package net.designtypes.examples.robust.bean.local;

import java.util.Calendar;

import javax.ejb.Local;

import net.designtypes.examples.robust.model.Gender;
import net.designtypes.examples.robust.model.InsureeData;

@Local
public class InsureeDataServiceGateway {
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(InsureeDataServiceGateway.class);

	public InsureeData getBy(String insureeNumber) {
		log.info("get insuree data [" + insureeNumber + "]");
		// get insuree data from some external service

		// dummy implementation:
		InsureeData result = new InsureeData(insureeNumber);
		Calendar dob = Calendar.getInstance();
		dob.set(1970, 02, 01);
		result.setBirthday(dob.getTime());
		result.setGender(Gender.FEMALE);
		return result;
	}
}
