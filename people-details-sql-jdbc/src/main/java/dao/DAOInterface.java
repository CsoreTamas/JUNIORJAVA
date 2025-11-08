package dao;

import java.util.List;
import java.util.Optional;

public interface DAOInterface<T> {

    List<T> findAll();

    void create(T type);

    Optional<T> findById(int id);

    void update(T type);

    void deleteById(int id);
}
