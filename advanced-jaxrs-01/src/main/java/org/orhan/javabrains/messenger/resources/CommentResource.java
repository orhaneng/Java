package org.orhan.javabrains.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {
	@GET 
	public String test() {
		return "new sub resource";
	}
	
	@GET
	@Path("/{commentId}")
	public String test2(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId) {
		return "method to return commentID:"+commentId+", messageid:"+messageId;
	}
}
