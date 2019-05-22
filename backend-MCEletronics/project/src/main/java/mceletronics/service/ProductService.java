
package mceletronics.service;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import mceletronics.entities.Product;
import mceletronics.repositories.ProductDAO;

import com.sun.jersey.core.header.FormDataContentDisposition;
//import com.sun.jersey.*;
//import org.glassfish.jersey.media.multipart.*;
import com.sun.jersey.multipart.FormDataParam;

import java.io.InputStream;
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

@Path("/products")
public class ProductService {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Product> getProducts(){
		return ProductDAO.getAllProducts();
	}


	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getProduct(@PathParam("id") int id) {
		 return Response.status(Status.OK).entity(ProductDAO.getProduct(id)).build();
	}

	@GET 
	@Path("/search")
	@Produces({ MediaType.APPLICATION_JSON})
	public Product getProductByName(@QueryParam("name")String name) {
		return ProductDAO.getProductByName(name);
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON})
	@Consumes(MediaType.MULTIPART_FORM_DATA)   
	public Product addProduct(@FormDataParam("image") InputStream uploadedInputStream,
			@FormDataParam("name") String name, @FormDataParam("category") String category,
			@FormDataParam("price") Double price, @FormDataParam("quantity") Integer quantity,
			@FormDataParam("description") String description) {
		
		return ProductDAO.addProduct(name, category, price, quantity, description,uploadedInputStream );
	}


	@PUT
	@Path("/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({ MediaType.APPLICATION_JSON})
	public Product updateUser(@PathParam("id") int id, @FormDataParam("image") InputStream uploadedInputStream,
			@FormDataParam("image") FormDataContentDisposition contentDispositionHeader,
			@FormDataParam("name") String name, @FormDataParam("category") String category,
			@FormDataParam("price") Double price, @FormDataParam("quantity") Integer quantity,
			@FormDataParam("description") String description) {
		 {
		
		if(contentDispositionHeader.getFileName() == null) {
//			return UserDAO.updateUser(id, name, password, null);
			return ProductDAO.updateProduct(id, name, category, price, quantity, description, null);
		} else {
			return ProductDAO.updateProduct(id, name, category, price, quantity, description, uploadedInputStream);
		}
	}
}
	@DELETE
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteProduct(@PathParam("id") int id) {
		ProductDAO.deleteProduct(id);
	}
	

}
