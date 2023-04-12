package ua.hillel;

import java.util.ArrayList;
import java.util.List;


public class OrderRepository {

    private static List<Order> orders = new ArrayList<>();
    private int nextId = 1;

    public Order getById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getAll() {
        return orders;
    }

    public Order add(Order order) {
        order.setId(nextId++);
        orders.add(order);
        return order;
    }
    public Order getOrderById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }
    public OrderRepository() {
        orders = new ArrayList<>();
    }
    public static List<Order> getAllOrders() {
        return orders;
    }

    public static void addOrder(Order order) {
        orders.add(order);
    }
}


