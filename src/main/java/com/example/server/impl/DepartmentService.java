package com.example.server.impl;

import com.example.dao.connection.SingletonConnection;
import com.example.dao.impl.DepartmentDAO;
import com.example.entity.Department;
import com.example.server.inerf.IDepartmentService;
import com.example.server.inerf.IService;

import java.util.Set;

/**
 * Department service for working with a database
 */
public class DepartmentService implements IDepartmentService {
    SingletonConnection connection = SingletonConnection.getInstance();

    /**
     * {@link IService#create(Object)}
     */
    @Override
    public boolean create(Department entity) {
        DepartmentDAO departmentDao = connection.getDepartmentDao();
        long count = this.findMaxId() + 1;
        return departmentDao.addInDataBase(entity, count);
    }

    /**
     * {@link IService#update(Object)}
     */
    @Override
    public boolean update(Department entity) {
        DepartmentDAO departmentDao = connection.getDepartmentDao();
        return departmentDao.updateDataBase(entity);
    }

    /**
     * {@link IService#delete(Long)}
     */
    @Override
    public Department delete(Long id) {
        DepartmentDAO departmentDao = connection.getDepartmentDao();
        Department department = this.findEntity(id);
        departmentDao.deleteFromDataBase(id);
        return department;
    }

    /**
     * {@link IService#allData()}
     */
    @Override
    public Set<Department> allData() {
        DepartmentDAO departmentDao = connection.getDepartmentDao();
        return departmentDao.findAllFromDataBase();
    }

    /**
     * {@link IService#findEntity(Long)}
     */
    @Override
    public Department findEntity(Long id) {
        DepartmentDAO departmentDao = connection.getDepartmentDao();
        return departmentDao.findByIdInDataBase(id);
    }

    /**
     * {@link IService#findMaxId()}
     */
    @Override
    public Long findMaxId() {
        DepartmentDAO departmentDao = connection.getDepartmentDao();
        return departmentDao.findMaxIdInDataBase();
    }

    /**
     * {@link IService#isUniqueExpression(String)}
     */
    @Override
    public boolean isUniqueExpression(String expression) {
        DepartmentDAO departmentDao = connection.getDepartmentDao();
        int count = departmentDao.findCountByExpressionInDataBase(expression);
        return count == 0;
    }
}
