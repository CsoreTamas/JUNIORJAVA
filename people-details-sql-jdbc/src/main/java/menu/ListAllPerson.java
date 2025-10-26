package menu;

import connector.SQLConnector;
import loader.PropertiesLoader;

public class ListAllPerson {
    public void list() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        SQLConnector sqlConnector = new SQLConnector(
                propertiesLoader.getUrl(),
                propertiesLoader.getUserName(),
                propertiesLoader.getPassword()
        );
        sqlConnector.getConnection();
    }
}
