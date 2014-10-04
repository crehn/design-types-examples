package net.designtypes.examples.technologic.api;

import static javax.ws.rs.core.Response.Status.*;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import net.designtypes.examples.my.control.AgeIsUnknownException;

public class AgeIsUnknownExceptionMapper implements ExceptionMapper<AgeIsUnknownException> {

	@Override
	public Response toResponse(AgeIsUnknownException e) {
		return Response.status(CONFLICT).entity(e.getMessage()).build();
	}
	
}
