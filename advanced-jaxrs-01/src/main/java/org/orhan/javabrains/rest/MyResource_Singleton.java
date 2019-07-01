package org.orhan.javabrains.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//@Singleton   normally when we call jax-rs service, it creates new instance.
//If we dont want new instance, we can use singleton.
//http://localhost:8080/advanced-jaxrs-01/webapi/testsingleton
@Path("testsingleton")
@Singleton
public class MyResource_Singleton {
	
	private int count;
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		count=count+1;
		return "count="+count;
	}
}
