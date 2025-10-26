package menu;

import dao.PersonDAO;
import loader.PropertiesLoader;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Menu {
    public static void start() {
        try {
            LineReader lineReader = LineReaderBuilder.builder().build();
            PropertiesLoader propertiesLoader = new PropertiesLoader();
            Connection connection = DriverManager.getConnection(propertiesLoader.getUrl(), propertiesLoader.getUserName(), propertiesLoader.getPassword());
            PersonDAO personDAO = new PersonDAO(connection, lineReader);
            ListAllPerson listAllPerson = new ListAllPerson();
            menu(lineReader, personDAO, listAllPerson);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void menu(LineReader lineReader, PersonDAO personDAO, ListAllPerson listAllPerson) {
        System.out.println("""
                Select:
                1 - Create person
                2 - Read person
                3 - Update person
                4 - Delete person
                5 - List peoples
                """);

        String input = lineReader.readLine("Enter your choice: ");
        switch (Integer.parseInt(input)) {
            case 1 -> personDAO.create();
            case 2 -> personDAO.read();
            case 3 -> personDAO.update();
            case 4 -> personDAO.delete();
            case 5 -> listAllPerson.list();
        }
    }
}
