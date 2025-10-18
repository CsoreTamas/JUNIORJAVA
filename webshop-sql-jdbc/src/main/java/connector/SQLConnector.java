package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public record SQLConnector(String url, String username, String password) {

    public void getConnection() {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM shop_item";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("item_name");
                int price = resultSet.getInt("item_price");
                int quantity = resultSet.getInt("quantity");
                String date = resultSet.getString("date_added");

                System.out.printf("ID: %d\nNAME: %s\nPRICE: %d\nQUANTITY: %d\nDATE:%s\n------------\n"
                        , id, name, price, quantity, date);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
