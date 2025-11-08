package dao;

import java.util.List;

public interface DAOBasicCRUD<T> {
    void create(T type);

    void update(T type);

    T read(int id);

    List<T> readAll();

    void delete(int id);
}
