package resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.OrderDetail;
import services.OrderDetailService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/orderdetails")
public class OrderDetailResource {
    OrderDetailService orderDetailService;

    public OrderDetailResource() {
        orderDetailService = new OrderDetailService();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/insert")
    public Response insert(OrderDetail orderDetail) {
        orderDetailService.createOrderDetail(orderDetail);
        return Response.ok(orderDetail).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/update")
    public Response update(OrderDetail orderDetail) {
        orderDetailService.updateOrderDetail(orderDetail);
        return Response.ok(orderDetail).build();
    }

    @GET
    @Path("/get/{id}")
    @Produces("application/json")
    public Response getById(@PathParam("id") int id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(orderDetailService.getOrderDetailById(id));
        return Response.ok(json).build();
    }

    @GET
    @Path("/getall")
    @Produces("application/json")
    public Response getAll() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(orderDetailService.getAllOrderDetails());
        return Response.ok(json).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") int id) {
        if (orderDetailService.deleteOrderDetail(id)) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
