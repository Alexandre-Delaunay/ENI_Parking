package com.example.eni_parking.dao;

import java.util.List;

interface DAO<T> {
    /**
     * Get one element by Id
     * @param id
     * @return
     */
    public T getById(int id);

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
    public int update(T t);

    /**
     * Insert one element
     * @param t
     * @return
     */
    public int insert(T t);

    /**
     * Delete one element
     * @param t
     * @return
     */
    public int delete (T t);
}
