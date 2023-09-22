package resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Product;  // Đảm bảo đã import lớp Product từ gói models
import services.ProductService;  // Đảm bảo đã import lớp ProductService từ gói services
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/products")
public class ProductResource {
    ProductService productService;

    public ProductResource() {
        productService = new ProductService();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/insert")
    public Response insert(Product product) {
        productService.createProduct(product);
        return Response.ok(product).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/update")
    public Response update(Product product) {
        productService.updateProduct(product);
        return Response.ok(product).build();
    }

    @GET
    @Path("/get/{id}")
    @Produces("application/json")
    public Response getById(@PathParam("id") int id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(productService.getProductById(id));
        return Response.ok(json).build();
    }

    @GET
    @Path("/getall")
    @Produces("application/json")
    public Response getAll() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(productService.getAllProducts());
        return Response.ok(json).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") long id) {
        if (productService.deleteProduct(id)) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}

