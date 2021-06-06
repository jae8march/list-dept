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
    EmployeeDAO employeeDao = connection.getEmployeeDao();

    /**
     * {@link IEmployeeService#findByEmail(String)}
     */
    @Override
    public int findByEmail(String expression) {
        return employeeDao.findAllEmployeeByEmail(expression);
    }

    /**
     * {@link IEmployeeService#findFromDept(Long)}
     */
    @Override
    public Set<Employee> findFromDept(Long id) {
        return employeeDao.findEmployees(id);
    }

    /**
     * {@link IEmployeeService#deleteEmployeesFromDept(Long)}
     */
    @Override
    public boolean deleteEmployeesFromDept(Long id) {
        return employeeDao.deleteFromDepartment(id);
    }

    /**
     * {@link IService#create(Object)}
     */
    @Override
    public boolean create(Employee entity) {
        return employeeDao.addInDataBase(entity);
    }

    /**
     * {@link IService#update(Object)}
     */
    @Override
    public boolean update(Employee entity) {
        return employeeDao.updateDataBase(entity);
    }

    /**
     * {@link IService#delete(Long)}
     */
    @Override
    public boolean delete(Long id) {
        return employeeDao.deleteFromDataBase(id);
    }

    /**
     * {@link IService#allData()}
     */
    @Override
    public Set<Employee> allData() {
        return employeeDao.findAllFromDataBase();
    }
}
