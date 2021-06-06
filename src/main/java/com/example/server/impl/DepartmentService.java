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
    DepartmentDAO departmentDao = connection.getDepartmentDao();

    /**
     * {@link IDepartmentService#findByName(String)}
     */
    @Override
    public int findByName(String expression) {
        return departmentDao.findAllDepartmentByName(expression);
    }

    /**
     * {@link IService#create(Object)}
     */
    @Override
    public boolean create(Department entity) {
        return departmentDao.addInDataBase(entity);
    }

    /**
     * {@link IService#update(Object)}
     */
    @Override
    public boolean update(Department entity) {
        return departmentDao.updateDataBase(entity);
    }

    /**
     * {@link IService#delete(Long)}
     */
    @Override
    public boolean delete(Long id) {
        return departmentDao.deleteFromDataBase(id);
    }

    /**
     * {@link IService#allData()}
     */
    @Override
    public Set<Department> allData() {
        return departmentDao.findAllFromDataBase();
    }


}
