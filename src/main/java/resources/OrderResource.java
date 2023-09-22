package resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Order;
import services.OrderService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/orders")
public class OrderResource {
    OrderService orderService;

    public OrderResource() {
        orderService = new OrderService();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/insert")
    public Response insert(Order order) {
        orderService.createOrder(order);
        return Response.ok(order).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/update")
    public Response update(Order order) {
        orderService.updateOrder(order);
        return Response.ok(order).build();
    }

    @GET
    @Path("/get/{id}")
    @Produces("application/json")
    public Response getById(@PathParam("id") int id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(orderService.getOrderById(id));
        return Response.ok(json).build();
    }

    @GET
    @Path("/getall")
    @Produces("application/json")
    public Response getAll() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(orderService.getAllOrders());
        return Response.ok(json).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") int id) {
        if (orderService.deleteOrder(id)) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @POST
    @Path("/getbyday")
    @Produces("application/json")
    public Response getByDay(Order order) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(orderService.getByDay());
        return Response.ok(json).build();
    }
}

