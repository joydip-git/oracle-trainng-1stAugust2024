package com.hibernateapps.repository;

import java.util.List;

public interface RepositoryContract<T> {
    boolean add(T data);

    boolean update(int id, T data);

    boolean delete(int id);

    List<T> getAll();

    T get(int id);
}
