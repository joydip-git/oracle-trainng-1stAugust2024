package oracle.springboot.apps.userservice.services;

import java.util.List;

public interface ServiceContract<T, TId> {
    T add(T data);

    T update(TId id, T data);

    boolean delete(TId id);

    List<T> getAll();

    T get(TId id);
}
