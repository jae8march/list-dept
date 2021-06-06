package com.example.dao.impl;

import com.example.dao.impl.decorator.AbstractDecoratorDao;
import com.example.dao.interf.IDao;
import com.example.dao.interf.IEmployeeDao;
import com.example.dao.interf.Mapper;
import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.util.constants.Column;
import com.example.util.constants.QueriesSql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Set;

public class EmployeeDAO extends AbstractDecoratorDao<Employee> implements IEmployeeDao {
    private final Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
        super.mapperFromSql = mapperFromSql;
    }

    /**
     * {@link IDao#addInDataBase(Object)}
     */
    @Override
    public boolean addInDataBase(Employee entity) {
        try(PreparedStatement statement = connection.prepareStatement(QueriesSql.SQL_CREATE_EMPLOYEE)) {

            statement.setLong(1,findCount(connection, QueriesSql.SQL_COUNT_ROW_EMPLOYEE) + 1);
            statement.setString(2, entity.getName());
            statement.setDate(3, Date.valueOf(entity.getBirthDate()));
            statement.setString(4, entity.getEmail());
            statement.setInt(5, entity.getYearsWorking());
            statement.setLong(6, entity.getDepartment().getId());

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
    public boolean updateDataBase(Employee entity) {
        try (PreparedStatement statement = connection.prepareStatement(QueriesSql.SQL_UPDATE_EMPLOYEE)) {
            statement.setString(1, entity.getName());
            statement.setDate(2, Date.valueOf(entity.getBirthDate()));
            statement.setString(3, entity.getEmail());
            statement.setInt(4, entity.getYearsWorking());
            statement.setLong(5, entity.getDepartment().getId());
            statement.setLong(6, entity.getId());

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
        return statementWithParameter(connection, id, QueriesSql.SQL_DELETE_EMPLOYEE);
    }

    /**
     * {@link IEmployeeDao#deleteFromDepartment(Long)}
     */
    @Override
    public boolean deleteFromDepartment(Long id) {
        return statementWithParameter(connection, id, QueriesSql.SQL_DELETE_EMPLOYEES_FROM_DEPARTMENT);
    }

    /**
     * {@link IEmployeeDao#findAllEmployeeByEmail(String)}
     */
    @Override
    public int findAllEmployeeByEmail(String expression) {
        return findCountByExpression(connection, expression, QueriesSql.SQL_EMPLOYEE_EMAIL);
    }

    /**
     * {@link IDao#findAllFromDataBase()}
     */
    @Override
    public Set<Employee> findAllFromDataBase() {
        return findAll(connection, QueriesSql.SQL_ALL_EMPLOYEE);
    }

    /**
     * {@link IEmployeeDao#findEmployees(Long)}
     */
    @Override
    public Set<Employee> findEmployees(Long id) {
        return findAll(connection, QueriesSql.SQL_ALL_EMPLOYEE_FROM_DEPARTMENT);
    }

    /**
     * Mapper for creating Employee from a ResultSet.
     * {@link Mapper#map(Object)}
     */
    private Mapper<ResultSet, Employee> mapperFromSql = (ResultSet resultSet) -> {
        Employee employee = new Employee();
        Department department = new Department();
        try {
            employee.setId(resultSet.getLong(Column.EMPLOYEE_ID));
            employee.setName(resultSet.getString(Column.EMPLOYEE_NAME));
            employee.setBirthDate(LocalDate.parse(resultSet.getString(Column.EMPLOYEE_BIRTH)));
            employee.setEmail(resultSet.getString(Column.EMPLOYEE_EMAIL));
            employee.setYearsWorking(resultSet.getInt(Column.EMPLOYEE_YEARS_WORKING));
            department.setId(resultSet.getLong(Column.DEPARTMENT_ID));
            employee.setDepartment(department);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return employee;
    };
}
