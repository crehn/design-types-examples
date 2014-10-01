package net.designtypes.examples.my.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import net.designtypes.examples.my.control.AgeIsUnknownException;

public class AgeIsUnknownExceptionMapper implements ExceptionMapper<AgeIsUnknownException> {
	
	@Override
	public Response toResponse(AgeIsUnknownException e) {
		return Response.status(Status.CONFLICT).entity(e.getMessage()).build();
	}

}
