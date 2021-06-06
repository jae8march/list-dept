package com.example.dao.connection;

import com.example.dao.impl.DepartmentDAO;
import com.example.dao.impl.EmployeeDAO;

import java.sql.Connection;

/**
 * Singleton to create and work with one instance of connection in connection pool and DAO.
 */
public class SingletonConnection {
    private static SingletonConnection instance;

    /**
     * Static method for getting a connection instance.
     */
    public static Connection getConnection() {
        return ConnectionPool.getHikariConnection();
    }

    public static SingletonConnection getInstance() {
        if (instance == null) {
            instance = new SingletonConnection();
        }
        return instance;
    }

    /** Getters for Dao. */
    public EmployeeDAO getEmployeeDao() {
        return new EmployeeDAO(getConnection());
    }

    public DepartmentDAO getDepartmentDao() {
        return new DepartmentDAO(getConnection());
    }
}
