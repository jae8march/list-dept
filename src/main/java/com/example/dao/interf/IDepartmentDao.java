package com.example.dao.interf;

import com.example.entity.Department;

/**
 * Interface for DepartmentDAO.
 */
public interface IDepartmentDao extends IDao<Department> {
    /**
     * Finds all matches by name.
     * @param expression name of department
     * @return count of matches
     */
    int findAllDepartmentByName(String expression);
}
