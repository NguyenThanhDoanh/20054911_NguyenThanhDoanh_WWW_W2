package repositories;

import models.Employee;

public class EmployeeRepository  extends  CRUD_GENERIC<Employee>{


    public EmployeeRepository(Class<Employee> cus) {
        super(cus);
    }




}
