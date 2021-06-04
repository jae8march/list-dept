package com.example.server.inerf;

import com.example.entity.Employee;

import java.util.List;

/**
 * Interface service for EmployeeDAO
 */
public interface IEmployeeService extends IService<Employee> {
    /**
     * Finds list with employee
     * @param name of department
     * @return list with employee from department
     */
    List<Employee> findFromDepartment(String name);

    /**
     * Delete all employees from department
     * @param name of department
     * @return true if delete all employees
     */
    boolean deleteEmployeesFromDepartment(String name);
}
