package com.java.restapis.repository;

import java.util.List;

public interface RepositoryContract<T> {
    List<T> getAll() throws Exception;

    T get(int id) throws Exception;

    boolean add(T data) throws Exception;

    boolean update(int id, T data) throws Exception;

    boolean delete(int id) throws Exception;
}
