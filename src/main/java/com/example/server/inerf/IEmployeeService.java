package com.example.server.inerf;

import com.example.entity.Employee;

import java.util.List;

/**
 * Interface service for EmployeeDAO
 */
public interface IEmployeeService extends IService<Employee> {
    /**
     * Finds list with employee
     * @param id department
     * @return list with employee from department
     */
    List<Employee> findFromDepartment(Long id);
}
