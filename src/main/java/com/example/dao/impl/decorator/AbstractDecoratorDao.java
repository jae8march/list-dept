package com.example.dao.impl.decorator;

import com.example.dao.interf.Mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Abstract class, for implementing decorator pattern for DAO.
 * Allows you to dynamically add new functionality to objects, wrapping them in "wrappers",
 * reuse methods for working with the database, adding to them only a query, entities and a connection to the database.
 * @param <T> type of entity
 */
public abstract class AbstractDecoratorDao<T> {
    protected Mapper<ResultSet, T> mapperFromSql;

    /**
     * Finds all in table.
     * @param connection to database
     * @param queries to table
     * @return set of entities from database, table
     */
    protected Set<T> findAll(Connection connection, String queries) {
        Set<T> set = new LinkedHashSet<>();
        try (PreparedStatement statement = connection.prepareStatement(queries)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                set.add(mapperFromSql.map(resultSet));
            }

            resultSet.close();
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return set;
    }

    /**
     * Delete data from database.
     * @param connection to database
     * @param id of key in table
     * @param queries to table
     * @return true, if object was deleted from database
     */
    protected boolean statementWithParameter(Connection connection, Long id, String queries) {
        try (PreparedStatement statement = connection.prepareStatement(queries)) {
            statement.setLong(1, id);

            statement.executeQuery();

            connection.close();
        } catch (SQLException exception) {
            return false;
        }
        return true;
    }

    /**
     * Delete data from database.
     * @param connection to database
     * @param expression of key in table
     * @param queries to table
     * @return true, if object was deleted from database
     */
    protected int findCountByExpression(Connection connection, String expression, String queries) {
        int count = 0;
        try (PreparedStatement statement = connection.prepareStatement(queries)) {
            statement.setString(1, expression);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }

            resultSet.close();
            connection.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return count;
    }

    /**
     * Finds count rows in table.
     * @param connection to database
     * @param queries to table
     * @return count of rows
     */
    protected Long findCount(Connection connection, String queries) {
        long count = 0;
        try (PreparedStatement statement = connection.prepareStatement(queries)) {
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getLong("count");
            }

            resultSet.close();
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return count;
    }

    /**
     * Find entity by id table.
     * @param connection to database
     * @param queries to table
     * @param id of entity
     * @return entity
     */
    protected T findById(Connection connection, String queries, Long id, T entity) {
        try (PreparedStatement statement = connection.prepareStatement(queries)){
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            entity = mapperFromSql.map(resultSet);

            resultSet.close();
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return entity;
    }
}
