package org.orhan.javabrains.messagebodywriter;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//http://localhost:8080/advanced-jaxrs-01/webapi/testmessagebodywriter
@Path("testmessagebodywriter")
public class DateResourceMessageBodyWriter {

	//use accept,  text/shortdate or text/plain
	@GET
	@Produces(value = { MediaType.TEXT_PLAIN, "text/shortdate" })
	public Date testMethod() {
		return Calendar.getInstance().getTime();
	}
}