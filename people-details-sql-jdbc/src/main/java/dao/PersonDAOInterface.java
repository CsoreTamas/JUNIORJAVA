package dao;

public interface PersonDAOInterface<T> {

    void findAll();

    void create(T type);

    void findById(int id);

    void update(T type);

    void deleteById(int id);
}
