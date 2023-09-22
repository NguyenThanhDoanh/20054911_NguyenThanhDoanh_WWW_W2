package services;

import models.Customer;
import repositories.CustomerRepository;


import java.util.List;

public class CustomerService {

    private final CustomerRepository customerDao;

    public CustomerService() {
        customerDao = new CustomerRepository(Customer.class);
    }

    public void createCustomer(Customer customer) {
        customerDao.create(customer);
    }

    public void updateCustomer(Customer customer) {
        customerDao.update(customer);
    }

    public boolean deleteCustomer(long customerId) {
        Customer customer = customerDao.findById(customerId);
        if (customer != null) {
            if(customerDao.delete(customer))
            {
                return true;
            }

        }
        return false;
    }

    public Customer getCustomerById(int customerId) {
        return customerDao.findById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

}
