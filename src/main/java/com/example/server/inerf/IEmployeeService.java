package com.example.server.inerf;

import com.example.entity.Employee;

import java.util.Set;

/**
 * Interface service for EmployeeDAO.
 */
public interface IEmployeeService extends IService<Employee> {
    /**
     * Finds all matches by email.
     * @param expression email of employee
     * @return true, if found at least one match
     */
    int findByEmail(String expression);

    /**
     * Finds list with employee.
     * @param id of department
     * @return list with employee from department
     */
    Set<Employee> findFromDept(Long id);

    /**
     * Delete all employees from department.
     * @param id of department
     * @return true if delete all employees
     */
    boolean deleteEmployeesFromDept(Long id);
}
