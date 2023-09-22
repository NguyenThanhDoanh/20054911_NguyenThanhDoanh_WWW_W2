package repositories;

import models.Order;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OrderRepository extends CRUD_GENERIC<Order>{

    public OrderRepository(Class<Order> entityClass) {
        super(entityClass);
    }
    public Map<Date, Integer> getByDay() {
        List<Object[]> results = em.createNamedQuery("Order.findByDay", Object[].class).getResultList();
        Map<Date, Integer> resultMap = new HashMap<>();

        for (Object[] result : results) {
            Timestamp timestamp = (Timestamp) result[0];
            int orderCount = ((Number) result[1]).intValue();
            java.util.Date utilDate = new java.util.Date(timestamp.getTime());
            Date sqlDate = new Date(utilDate.getTime());

            resultMap.put(sqlDate, orderCount);
        }

        return resultMap;
    }
}
