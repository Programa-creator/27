package ua.hillel;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

@Path("/orders")
public class OrderController {
    private OrderRepository orderRepository = new OrderRepository();

    // методы для работы с заказами

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getOrderById(@PathParam("id") int id) {
        return orderRepository.getOrderById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrders() {
        List<Order> orders = OrderRepository.getAllOrders();

        return Response.ok(orders).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOrder(Order order) {
        OrderRepository.addOrder(order);

        URI uri = UriBuilder.fromResource(OrderController.class).path(String.valueOf(order.getId())).build();
        return Response.created(uri).build();
    }

}

