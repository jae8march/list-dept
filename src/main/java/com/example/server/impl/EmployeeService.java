package com.example.server.impl;

import com.example.dao.connection.SingletonConnection;
import com.example.dao.impl.EmployeeDAO;
import com.example.entity.Employee;
import com.example.server.inerf.IEmployeeService;
import com.example.server.inerf.IService;
import java.util.Set;

/**
 * Employee service for working with a database
 */
public class EmployeeService implements IEmployeeService {
    SingletonConnection connection = SingletonConnection.getInstance();

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
        long count = this.findMaxId() + 1;
        return employeeDao.addInDataBase(entity, count);
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

    /**
     * {@link IService#findMaxId()}
     */
    @Override
    public Long findMaxId() {
        EmployeeDAO employeeDao = connection.getEmployeeDao();
        return employeeDao.findMaxIdInDataBase();
    }

    /**
     * {@link IService#isUniqueExpression(String)}
     */
    @Override
    public boolean isUniqueExpression(String expression) {
        EmployeeDAO employeeDao = connection.getEmployeeDao();
        int count = employeeDao.findCountByExpressionInDataBase(expression);
        return count == 0;
    }
}
