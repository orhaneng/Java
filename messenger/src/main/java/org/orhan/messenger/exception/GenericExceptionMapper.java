package org.orhan.messenger.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.orhan.messenger.model.ErrorMessage;

//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 500, "link");
		return Response.status(Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).entity(errorMessage)
				.build();
	}

}
