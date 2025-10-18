package webshop_menu;

import connector.SQLConnector;
import loader.PropertiesLoader;

public class ListProduct {
    static void listAllProduct() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        SQLConnector sqlConnector = new SQLConnector(
                propertiesLoader.getUrl(),
                propertiesLoader.getUserName(),
                propertiesLoader.getPassword()
        );
        sqlConnector.getConnection();
    }
}
