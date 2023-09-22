package repositories;

import models.Customer;

public class CustomerRepository  extends  CRUD_GENERIC<Customer>{


    public CustomerRepository(Class<Customer> cus) {
        super(cus);
    }




}
