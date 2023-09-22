package resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.ProductImage;
import services.ProductImageService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/productimages")
public class ProductImageResource {
    ProductImageService productImageService;

    public ProductImageResource() {
        productImageService = new ProductImageService();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/insert")
    public Response insert(ProductImage productImage) {
        productImageService.createProductImage(productImage);
        return Response.ok(productImage).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/update")
    public Response update(ProductImage productImage) {
        productImageService.updateProductImage(productImage);
        return Response.ok(productImage).build();
    }

    @GET
    @Path("/get/{id}")
    @Produces("application/json")
    public Response getById(@PathParam("id") int id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(productImageService.getProductImageById(id));
        return Response.ok(json).build();
    }

    @GET
    @Path("/getall")
    @Produces("application/json")
    public Response getAll() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(productImageService.getAllProductImages());
        return Response.ok(json).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") int id) {
        if (productImageService.deleteProductImage(id)) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
