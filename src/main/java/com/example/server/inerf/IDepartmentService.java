package com.example.server.inerf;

import com.example.entity.Department;

/**
 * Interface service for DepartmentDAO.
 */
public interface IDepartmentService extends IService<Department> {
    /**
     * Finds all matches by name.
     * @param expression name of department
     * @return true, if found at least one match
     */
    int findByName(String expression);
}
