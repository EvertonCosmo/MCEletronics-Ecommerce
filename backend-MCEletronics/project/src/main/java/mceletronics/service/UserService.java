package mceletronics.service;


import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import com.sun.jersey.multipart.FormDataParam;

import mceletronics.entities.User;
import mceletronics.repositories.UserDAO;



@Path("/users")
public class UserService {

	 @GET
	    @Produces({ MediaType.APPLICATION_JSON })
	    public List<User> getUsers() {
	        return UserDAO.getAllUsers();
	    }
	 
	    // Controle da resposta (status code, mensagem)
	    @GET
	    @Path("/{id}")
	    @Produces({ MediaType.APPLICATION_JSON})
	    public Response getUser(@PathParam("id") int id) {
	        return Response.status(Status.OK).entity(UserDAO.getUser(id)).build();
	    }
	 
	    @GET
	    @Path("/search")
	    @Produces({ MediaType.APPLICATION_JSON})
	    public User getUserByName(@QueryParam("username") String username) {
	        return UserDAO.getUserByUsername(username);
	    }
	 
	    @POST
	    @Produces({ MediaType.APPLICATION_JSON})
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	    public Response addUser( @FormDataParam("username") String username, @FormDataParam("password") String password) {
	               
	        if(username == null || password == null || username.equals("null") || password.equals("null")) {
	            return Response.status(400).build();
	        }
	       
	        return Response.status(Status.OK).entity(UserDAO.addUser(username, password)).build();
	    }
	 
	    @PUT
	    @Path("/{id}")
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	    @Produces({ MediaType.APPLICATION_JSON })
	    public User updateUser(@PathParam("id") int id,
	            @FormDataParam("username") String username, @FormDataParam("password") String password) {
	       
//	        if(contentDispositionHeader.getFileName() == null) {
	            return UserDAO.updateUser(id, username, password);   
//	        } else {
//	            return UserDAO.updateUser(id, username, password, uploadedInputStream);
//	        }
	    }
	 
	    @DELETE
	    @Path("/{id}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public void deleteUser(@PathParam("id") int id) {
	        UserDAO.deleteUser(id);
	    }
}