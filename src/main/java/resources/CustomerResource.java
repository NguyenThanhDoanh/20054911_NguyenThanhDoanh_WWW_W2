package resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Customer;
import services.CustomerService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;


@Path("/customers")
public class CustomerResource {
    CustomerService cusService;

    public CustomerResource()  {
       cusService = new CustomerService();
    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/insert")
    public Response insert(Customer customer) {

        cusService.createCustomer(customer);
        return Response.ok(customer).build();
    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/update")
    public Response update(Customer customer) {
        cusService.updateCustomer(customer);
        return Response.ok(customer).build();
    }
    @GET
    @Path("/get/{id}")
    @Consumes("application/json")
    public Response getById(@PathParam("id") int id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(cusService.getCustomerById(id));
        return Response.ok(json).build();
    }
    @GET
    @Path("/getall")
    @Produces("application/json")
    public Response getById() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(cusService.getAllCustomers());
        return Response.ok(json).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") long id)
    {
        if(cusService.deleteCustomer(id))
        {
            return Response.ok().build();
        }
        return Response.status(Response.Status.FOUND).build();
    }

}
