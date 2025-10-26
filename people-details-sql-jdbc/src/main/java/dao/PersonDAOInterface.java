package dao;

import java.sql.SQLException;

public interface PersonDAOInterface {
    void create();

    void read();

    void update() throws SQLException;

    void delete();
}
