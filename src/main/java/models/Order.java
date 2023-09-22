package models;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")
@NamedQueries(
        @NamedQuery(name = "Order.findByDay", query = "SELECT orderDate, COUNT(orderId) AS total_orders FROM Order GROUP BY orderDate ORDER BY orderDate")


)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;



    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;
    @Column(name = "order_date")
    private Date orderDate;
    // Constructors, getters, and setters
    public Order() {
    }


    public Order(Long orderId, Employee employee, Customer customer, Date orderDate) {
        this.orderId = orderId;
        this.employee = employee;
        this.customer = customer;
        this.orderDate = orderDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", employee=" + employee +
                ", customer=" + customer +
                '}';
    }
}
