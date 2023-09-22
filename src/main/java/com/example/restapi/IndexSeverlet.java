package com.example.restapi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexSeverlet extends HttpServlet {
    Client clientBuilder;
    @Override
    public void init() throws ServletException {
        super.init();
        clientBuilder = ClientBuilder.newClient();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter=resp.getWriter();
        printWriter.println("<form action='/restapi/index' method='post'>");
        printWriter.println("<input type='text' name='get'>");
        printWriter.println("<input type='submit' value='submit'>");
        printWriter.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String id = req.getParameter("hello");
        PrintWriter printWriter = resp.getWriter();
        WebTarget wt1 = clientBuilder.target("http://localhost:8080/restapi/api/customer/get")
                .path(id);
        Response response = wt1.request().accept(MediaType.TEXT_PLAIN).get();
        String result = response.readEntity(String.class);
        printWriter.println(result);
    }

}
