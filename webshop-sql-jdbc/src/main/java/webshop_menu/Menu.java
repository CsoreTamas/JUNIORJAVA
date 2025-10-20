package webshop_menu;

import loader.PropertiesLoader;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import webshop_menu.add_item.AddItemWithCurrentDate;
import webshop_menu.add_item.AddItemWithCustomDate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Menu {
    public static void start() {
        try {
            LineReader lineReader = LineReaderBuilder.builder().build();
            PropertiesLoader propertiesLoader = new PropertiesLoader();
            Connection connection = DriverManager.getConnection(propertiesLoader.getUrl(), propertiesLoader.getUserName(), propertiesLoader.getPassword());
            BasicQueries basicQueries = new BasicQueries(connection);

            menu(connection, lineReader, basicQueries);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void menu(Connection connection, LineReader lineReader, BasicQueries basicQueries) throws SQLException {
        System.out.print("""
                Please select:
                1 - Distinct product
                2 - Count all product excluding zero quantity
                3 - Get average price
                4 - Get weighted average price
                5 - Get most expensive and cheapest product
                6 - Get oldest product
                7 - Get newest product
                8 - Add a product with the current date
                9 - Add a product with a custom date
                10 - Delete a product by name
                11 - Upgrade a product's name
                12 - List all your product
                """);

        String input = lineReader.readLine("Enter your choice: ");
        int choice = Integer.parseInt(input);

        switch (choice) {
            case 1 -> basicQueries.countDistinctProduct();
            case 2 -> basicQueries.CountAllProductsExcludeZeroQuantity();
            case 3 -> basicQueries.getAvgPrice();
            case 4 -> basicQueries.getWeightedAvgPrice();
            case 5 -> basicQueries.getMostExpensiveAndCheapestProd();
            case 6 -> basicQueries.getOldestAddedProd();
            case 7 -> basicQueries.getNewestAddedProd();
            case 8 -> AddItemWithCurrentDate.addItemCurrentDate(lineReader, connection);
            case 9 -> AddItemWithCustomDate.addItemCustomDate(connection, lineReader);
            case 10 -> DeleteItemByName.deleteItemByName(connection, lineReader);
            case 11 -> UpdateItemNameById.updateItemNameById(connection, lineReader);
            case 12 -> ListProduct.listAllProduct();
        }
    }
}
