package net.designtypes.examples.powerful.gateway.impl;

import net.designtypes.examples.powerful.gateway.SystemTimeGateway;

import org.joda.time.LocalDate;

public class SystemTimeGatewayImpl implements SystemTimeGateway {

	@Override
	public LocalDate now() {
		return new LocalDate();
	}
	
}
