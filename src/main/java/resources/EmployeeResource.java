package resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import models.Employee;
import services.EmployeeService;

@Path("/employees")
public class EmployeeResource {
    EmployeeService empService;

    public EmployeeResource() {
        this.empService = new EmployeeService();
    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/insert")
    public Response insert(Employee employee) {

        empService.createEmployee(employee);
        return Response.ok(employee).build();
    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/update")
    public Response update(Employee employee) {
        empService.updateEmployee(employee);
        return Response.ok(employee).build();
    }
    @GET
    @Path("/get/{id}")
    @Produces("application/json")
    public Response getById(@PathParam("id") int id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(empService.getEmployeeById(id));
        return Response.ok(json).build();
    }
    @GET
    @Path("/getall")
    @Produces("application/json")
    public Response getById() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(empService.getAllEmployees());
        return Response.ok(json).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") long id)
    {
        if(empService.deleteEmployee(id))
        {
            return Response.ok().build();
        }
        return Response.status(Response.Status.FOUND).build();
    }
}
