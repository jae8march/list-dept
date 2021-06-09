package com.example.dao.interf;

import com.example.entity.Department;

/**
 * Interface for DepartmentDAO.
 */
public interface IDepartmentDao extends IDao<Department> {
    /**
     * Finds an object by a expression column in a table.
     * @param expression key
     * @return count of rows wit
     */
    int findCountByPhoneInDataBase(String expression);
}
