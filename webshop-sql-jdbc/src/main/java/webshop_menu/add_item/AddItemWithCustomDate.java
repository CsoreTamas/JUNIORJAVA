package webshop_menu.add_item;

import org.jline.reader.LineReader;

import java.sql.*;

public class AddItemWithCustomDate {
    public static void addItemCustomDate(Connection connection, LineReader lineReader) {
        try {
            String name = lineReader.readLine("Please enter the item name: ");

            String inputPrice = lineReader.readLine("Please enter the price: ");
            int price = Integer.parseInt(inputPrice);

            String inputQuantity = lineReader.readLine("Please enter the quantity: ");
            int quantity = Integer.parseInt(inputQuantity);

            String date = lineReader.readLine("Please enter the date (YYYY-MM-DD): ");
            Timestamp timestamp = Timestamp.valueOf(date);

            String query = "INSERT INTO shop_item (item_name, item_price, quantity, date_added) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setInt(3, quantity);
            ps.setTimestamp(4, timestamp);

            if (ps.executeUpdate() > 0) {
                System.out.println("New product added successfully");
            } else {
                System.out.println("Failed to add new product");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
