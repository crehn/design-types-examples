package net.designtypes.examples.simple.base;

import org.joda.time.LocalDate;

public class SystemTimeGateway {
	
	public LocalDate now() {
		return new LocalDate();
	}

}
