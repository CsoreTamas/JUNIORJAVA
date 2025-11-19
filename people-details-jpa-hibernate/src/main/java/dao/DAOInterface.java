package dao;

import java.util.List;
import java.util.Optional;

public interface DAOInterface<T> {
    void create(T type);

    Optional<T> findByID(int id);

    List<T> findAll();

    void update(T type);

    void deleteById(int id);
}
