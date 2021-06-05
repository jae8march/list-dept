package com.example.dao.interf;

import com.example.entity.Employee;

import java.util.Set;

/**
 * Interface for EmployeeDAO.
 */
public interface IEmployeeDao extends IDao<Employee> {
    /**
     * Finds list with employee.
     * @param id of employee
     * @return list with employee from department
     */
    Set<Employee> findEmployees(Long id);

    /**
     * Delete all employees from department
     * @param id of department
     * @return true if the operation was successful
     */
    boolean deleteFromDepartment(Long id);
}
