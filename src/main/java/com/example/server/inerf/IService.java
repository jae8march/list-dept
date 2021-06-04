package com.example.server.inerf;

import java.util.List;

/**
 * Main Service
 */
public interface IService<T> {
    /**
     * Deletes object by id.
     * @param key o object
     * @return true if object was deleted
     */
    boolean delete(String key);

    /**
     * Add new entity in database.
     * @param entity
     * @return true if object was created
     */
    boolean create(T entity);

    /**
     * Adds row in table if input entity is not already exist.
     * @param entity to add
     * @return true if was added
     */
    boolean add(T entity);

    /**
     * Finds all data from table
     * @return list with T
     */
    List<T> allData();
}
