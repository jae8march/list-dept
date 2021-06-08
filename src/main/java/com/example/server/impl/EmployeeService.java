package com.example.server.impl;

import com.example.server.inerf.IService;
import com.example.dao.connection.SingletonConnection;
import com.example.dao.impl.EmployeeDAO;
import com.example.entity.Employee;
import com.example.server.inerf.IEmployeeService;
import java.util.Set;

/**
 * Employee service for working with a database
 */
public class EmployeeService implements IEmployeeService {
    SingletonConnection connection = SingletonConnection.getInstance();

    /**
     * {@link IEmployeeService#findByEmail(String)}
     */
    @Override
    public int findByEmail(String expression) {
        EmployeeDAO employeeDao = connection.getEmployeeDao();
        return employeeDao.findAllEmployeeByEmail(expression);
    }

    /**
     * {@link IEmployeeService#findFromDept(Long)}
     */
    @Override
    public Set<Employee> findFromDept(Long id) {
        EmployeeDAO employeeDao = connection.getEmployeeDao();
        return employeeDao.findEmployees(id);
    }

    /**
     * {@link IEmployeeService#deleteEmployeesFromDept(Long)}
     */
    @Override
    public boolean deleteEmployeesFromDept(Long id) {
        EmployeeDAO employeeDao = connection.getEmployeeDao();
        return employeeDao.deleteFromDepartment(id);
    }

    /**
     * {@link IService#create(Object)}
     */
    @Override
    public boolean create(Employee entity) {
        EmployeeDAO employeeDao = connection.getEmployeeDao();
        return employeeDao.addInDataBase(entity);
    }

    /**
     * {@link IService#update(Object)}
     */
    @Override
    public boolean update(Employee entity) {
        EmployeeDAO employeeDao = connection.getEmployeeDao();
        return employeeDao.updateDataBase(entity);
    }

    /**
     * {@link IService#delete(Long)}
     */
    @Override
    public Employee delete(Long id) {
        EmployeeDAO employeeDao = connection.getEmployeeDao();
        Employee employee = this.findEntity(id);
        employeeDao.deleteFromDataBase(id);
        return employee;
    }

    /**
     * {@link IService#allData()}
     */
    @Override
    public Set<Employee> allData() {
        EmployeeDAO employeeDao = connection.getEmployeeDao();
        return employeeDao.findAllFromDataBase();
    }


    /**
     * {@link IService#findEntity(Long)}
     */
    @Override
    public Employee findEntity(Long id) {
        EmployeeDAO employeeDao = connection.getEmployeeDao();
        return employeeDao.findByIdInDataBase(id);
    }
}
