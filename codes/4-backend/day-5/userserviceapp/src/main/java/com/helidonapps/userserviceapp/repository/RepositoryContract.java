package com.helidonapps.userserviceapp.repository;

import java.util.List;

public interface RepositoryContract<T, TId> {
    List<T> getAll();

    T get(TId id);

    T add(T data);

    T update(TId id, T data);

    T delete(TId id);
}
