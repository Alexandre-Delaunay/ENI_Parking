package com.example.eni_parking.dao;

import java.io.Serializable;
import java.util.List;

public interface IDao<T extends Serializable> {
    /**
     * Get one element by Id
     * @param id
     * @return
     */
    public T getById(final int id);

    /**
     * Get all elements
     * @return
     */
    public List<T> getList();

    /**
     * Update one element
     * @param t
     * @return
     */
    public int update(final T t);

    /**
     * Insert one element
     * @param t
     * @return
     */
    public int insert(final T t);

    /**
     * Delete one element
     * @param t
     * @return
     */
    public int delete (final T t);
}
