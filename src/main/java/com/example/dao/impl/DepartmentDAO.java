package com.example.dao.impl;

import com.example.dao.impl.decorator.AbstractDecoratorDao;
import com.example.dao.interf.IDao;
import com.example.dao.interf.IDepartmentDao;
import com.example.dao.interf.Mapper;
import com.example.entity.Department;
import com.example.util.constants.Column;
import com.example.util.constants.QueriesSql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class DepartmentDAO extends AbstractDecoratorDao<Department> implements IDepartmentDao {
    private final Connection connection;

    public DepartmentDAO(Connection connection) {
        this.connection = connection;
        super.mapperFromSql = mapperFromSql;
    }

    /**
     * {@link IDao#addInDataBase(Object)}
     */
    @Override
    public boolean addInDataBase(Department entity) {
        try(PreparedStatement statement = connection.prepareStatement(QueriesSql.SQL_CREATE_DEPARTMENT)) {

            statement.setLong(1,findCount(connection, QueriesSql.SQL_COUNT_ROW_DEPARTMENT) + 1);
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getNumber());

            statement.executeQuery();
            connection.close();
        } catch (SQLException exception) {
            return false;
        }
        return true;
    }

    /**
     * {@link IDao#updateDataBase(Object)}
     */
    @Override
    public boolean updateDataBase(Department entity) {
        try (PreparedStatement statement = connection.prepareStatement(QueriesSql.SQL_UPDATE_DEPARTMENT)) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getNumber());
            statement.setLong(3, entity.getId());

            statement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    /**
     * {@link IDao#deleteFromDataBase(Long)}
     */
    @Override
    public boolean deleteFromDataBase(Long id) {
        return statementWithParameter(connection, id, QueriesSql.SQL_DELETE_DEPARTMENT);
    }

    /**
     * {@link IDepartmentDao#findAllDepartmentByName(String)}
     */
    @Override
    public int findAllDepartmentByName(String expression) {
        return findCountByExpression(connection, expression, QueriesSql.SQL_DEPARTMENT_NAME);
    }

    /**
     * {@link IDao#findAllFromDataBase()}
     */
    @Override
    public Set<Department> findAllFromDataBase() {
        return findAll(connection, QueriesSql.SQL_ALL_DEPARTMENT);
    }

    /**
     * Mapper for creating Department from ResultSet.
     * {@link Mapper#map(Object)}
     */
    private Mapper<ResultSet, Department> mapperFromSql = (ResultSet resultSet) -> {
        Department department = new Department();
        try {
            department.setId(resultSet.getLong(Column.DEPARTMENT_ID));
            department.setName(resultSet.getString(Column.DEPARTMENT_NAME));
            department.setNumber(resultSet.getString(Column.DEPARTMENT_PHONE_NUMBER));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return department;
    };
}
