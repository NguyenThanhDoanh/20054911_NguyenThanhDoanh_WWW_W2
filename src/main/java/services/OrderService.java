package services;

import models.Order;
import repositories.OrderRepository;

import java.sql.Date;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.Map;

public class OrderService {

    private final OrderRepository OrderDao;

    public OrderService() {
        OrderDao = new OrderRepository(Order.class);
    }

    public void createOrder(Order Order) {
        OrderDao.create(Order);
    }

    public void updateOrder(Order Order) {
        OrderDao.update(Order);
    }

    public boolean deleteOrder(int OrderId) {
        Order Order = OrderDao.findById(OrderId);
        if (Order != null) {
            OrderDao.delete(Order);
            return true;
        }
        return false;
    }

    public Order getOrderById(int OrderId) {
        return OrderDao.findById(OrderId);
    }

    public List<Order> getAllOrders() {
        return OrderDao.findAll();
    }

    public Map<Date, Integer> getByDay(){
        return OrderDao.getByDay();
        }
    }


