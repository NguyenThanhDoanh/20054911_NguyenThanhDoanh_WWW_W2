package services;

import models.OrderDetail;
import repositories.OrderDetailRepository;

import java.util.List;

public class OrderDetailService {

    private final OrderDetailRepository OrderDetailDao;

    public OrderDetailService() {
        OrderDetailDao = new OrderDetailRepository(OrderDetail.class);
    }

    public void createOrderDetail(OrderDetail OrderDetail) {
        OrderDetailDao.create(OrderDetail);
    }

    public void updateOrderDetail(OrderDetail OrderDetail) {
        OrderDetailDao.update(OrderDetail);
    }

    public boolean deleteOrderDetail(int OrderDetailId) {
        OrderDetail OrderDetail = OrderDetailDao.findById(OrderDetailId);
        if (OrderDetail != null) {
            OrderDetailDao.delete(OrderDetail);
            return true;
        }
        return false;
    }

    public OrderDetail getOrderDetailById(int OrderDetailId) {
        return OrderDetailDao.findById(OrderDetailId);
    }

    public List<OrderDetail> getAllOrderDetails() {
        return OrderDetailDao.findAll();
    }

}
