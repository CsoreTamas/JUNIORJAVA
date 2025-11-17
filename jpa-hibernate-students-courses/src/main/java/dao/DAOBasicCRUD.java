package dao;

import java.util.List;

public interface DAOBasicCRUD<T> {
    void create(T type);

    void update(T type);

    T findById(int id);

    List<T> findAll();

    void delete(int id);
}
