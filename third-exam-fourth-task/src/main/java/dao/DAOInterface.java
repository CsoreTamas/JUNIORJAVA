package dao;

import java.util.List;
import java.util.Optional;

public interface DAOInterface<T> {
    Optional<T> findById(long id);

    List<T> findAll();

    void save(T t);

    void deleteById(long id);
}
