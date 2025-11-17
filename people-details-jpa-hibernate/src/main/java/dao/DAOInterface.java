package dao;

import java.util.List;

public interface DAOInterface {
    void create(Person person);

    Person findByID(int id);

    List<Person> findAll();

    void update(Person person);

    void deleteById(int id);
}
