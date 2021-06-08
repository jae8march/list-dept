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

/**
 * Extending class DepartmentDAO for working with a table 'dept'.
 */
public class DepartmentDAO extends AbstractDecoratorDao<Department> implements IDepartmentDao {
    private final Connection connection;

    public DepartmentDAO(Connection connection) {
        this.connection = connection;
        super.mapperFromSql = mapper;
        super.connection = connection;
    }

    /**
     * {@link IDao#addInDataBase(Object, Long)}
     */
    @Override
    public boolean addInDataBase(Department entity, Long id) {
        try (PreparedStatement statement = connection.prepareStatement(QueriesSql.SQL_CREATE_DEPARTMENT)) {
            statement.setLong(1, id);
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getNumber());

            statement.executeUpdate();

            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
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
        return statementWithParameter(id, QueriesSql.SQL_DELETE_DEPARTMENT);
    }

    /**
     * {@link IDao#findAllFromDataBase()}
     */
    @Override
    public Set<Department> findAllFromDataBase() {
        return findAll(QueriesSql.SQL_ALL_DEPARTMENT);
    }

    /**
     * {@link IDao#findByIdInDataBase(Long)}
     */
    @Override
    public Department findByIdInDataBase(Long id) {
        return findById(QueriesSql.SQL_FIND_BY_ID_DEPARTMENT, id, new Department());
    }

    /**
     * {@link IDao#findCountInDataBase()}
     */
    @Override
    public Long findCountInDataBase() {
        return findCount(QueriesSql.SQL_COUNT_ROW_DEPARTMENT);
    }

    /**
     * {@link IDao#findCountByExpressionInDataBase(String)}
     */
    @Override
    public int findCountByExpressionInDataBase(String expression) {
        return findCountByExpression(expression, QueriesSql.SQL_FIND_BY_NAME_DEPARTMENT);
    }

    /**
     * Mapper for creating Department from ResultSet.
     * {@link Mapper#map(Object)}
     */
    private Mapper<ResultSet, Department> mapper = (ResultSet resultSet) -> {
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
