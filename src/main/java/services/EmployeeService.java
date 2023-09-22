package services;

import models.Employee;
import repositories.EmployeeRepository;

import java.util.List;

public class EmployeeService {

    private final EmployeeRepository EmployeeDao;

    public EmployeeService() {
        EmployeeDao = new EmployeeRepository(Employee.class);
    }

    public void createEmployee(Employee Employee) {
        EmployeeDao.create(Employee);
    }

    public void updateEmployee(Employee Employee) {
        EmployeeDao.update(Employee);
    }

    public boolean deleteEmployee(long EmployeeId) {
        Employee Employee = EmployeeDao.findById(EmployeeId);
        if (Employee != null) {
            EmployeeDao.delete(Employee);
            return true;
        }
        return false;
    }

    public Employee getEmployeeById(int EmployeeId) {
        return EmployeeDao.findById(EmployeeId);
    }

    public List<Employee> getAllEmployees() {
        return EmployeeDao.findAll();
    }

}
