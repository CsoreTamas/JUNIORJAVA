package menu;

import dao.Person;
import dao.DAO;
import dao.DAOInterface;
import service.PersonService;
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
            PropertiesLoader propertiesLoader = PropertiesLoader.getInstance();
            Connection connection = DriverManager.getConnection(propertiesLoader.getUrl(), propertiesLoader.getUserName(), propertiesLoader.getPassword());
            DAOInterface<Person> personDAO = new DAO(connection);
            PersonService personService = new PersonService(personDAO, lineReader);
            createMenu(lineReader, personService);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createMenu(LineReader lineReader, PersonService personService) throws SQLException {
        System.out.println("""
                Select:
                1 - Create person
                2 - Read person
                3 - Update person
                4 - Delete person
                5 - List people
                """);

        String input = lineReader.readLine("Enter your choice: ");
        switch (Integer.parseInt(input)) {
            case 1 -> personService.getInputForCreate();
            case 2 -> personService.getInputForFind();
            case 3 -> personService.getInputForUpdate();
            case 4 -> personService.getInputForDelete();
            case 5 -> personService.findAll();
        }
    }
}
