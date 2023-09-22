package resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.ProductPrice;
import services.ProductPriceService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/productprices")
public class ProductPriceResource {
    ProductPriceService productPriceService;

    public ProductPriceResource() {
        productPriceService = new ProductPriceService();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/insert")
    public Response insert(ProductPrice productPrice) {
        productPriceService.createProductPrice(productPrice);
        return Response.ok(productPrice).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/update")
    public Response update(ProductPrice productPrice) {
        productPriceService.updateProductPrice(productPrice);
        return Response.ok(productPrice).build();
    }

    @GET
    @Path("/get/{id}")
    @Produces("application/json")
    public Response getById(@PathParam("id") int id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(productPriceService.getProductPriceById(id));
        return Response.ok(json).build();
    }

    @GET
    @Path("/getall")
    @Produces("application/json")
    public Response getAll() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(productPriceService.getAllProductPrices());
        return Response.ok(json).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") int id) {
        if (productPriceService.deleteProductPrice(id)) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
