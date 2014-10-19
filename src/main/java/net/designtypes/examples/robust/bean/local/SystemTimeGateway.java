package net.designtypes.examples.robust.bean.local;

import java.util.Date;

import javax.ejb.Local;

@Local
public class SystemTimeGateway {

	public Date now() {
		return new Date();
	}
	
}
