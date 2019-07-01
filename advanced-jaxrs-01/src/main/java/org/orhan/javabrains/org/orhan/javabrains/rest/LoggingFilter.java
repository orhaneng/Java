package org.orhan.javabrains.rest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		System.out.println("response filter");
		System.out.println(responseContext.getHeaders());
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		System.out.println("request filter");
		System.out.println("headers:" + requestContext.getHeaders());

	}

}
