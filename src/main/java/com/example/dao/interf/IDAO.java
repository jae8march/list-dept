package com.example.dao.interf;

import java.util.List;

/**
 * Main interface for DAO.
 */
public interface IDAO<T>  {
    /**
     * Adds row in table if input entity is not already exist.
     * @param entity to add
     * @return true if was added
     */
    boolean add(T entity);

    /**
     * Updates the data for an entity in a table.
     * @param entity to be updated
     * @return true if the table has been updated
     */
    boolean update(T entity);

    /**
     * Removes an object by it's id.
     * @param key object to delete
     * @return Deleted object
     */
    T delete(String key);

    /**
     * Finds all data from table.
     * @return list of all data in table
     */
    List<T> findAll();
}
