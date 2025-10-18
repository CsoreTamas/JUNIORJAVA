package webshop_menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public record BasicQueries(Connection connection) {

    void countDistinctProduct() throws SQLException {
        String query = "SELECT COUNT(*) FROM shop_item;";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int numOfProd = rs.getInt(1);
                System.out.printf("Number of distinct products: %d", numOfProd);
            }
        }
    }

    void CountAllProductsExcludeZeroQuantity() throws SQLException {
        String query = "SELECT COUNT(*) FROM shop_item WHERE quantity > 0;";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int numOfProdExZero = rs.getInt(1);
                System.out.printf("Number of products exclude zero: %d", numOfProdExZero);
            }
        }
    }

    void sumOfQuantities() throws SQLException {
        String query = "SELECT SUM(quantity) FROM shop_item;";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int sumOfQuantity = rs.getInt(1);
                System.out.printf("Quantity: %d", sumOfQuantity);
            }
        }
    }

    void getAvgPrice() throws SQLException {
        String query = "SELECT AVG(item_price) AS avg_price FROM shop_item;";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                double averagePrice = rs.getDouble("avg_price");
                System.out.printf("Average price: %.2f", averagePrice);
            }
        }
    }

    void getWeightedAvgPrice() throws SQLException {
        String query = "SELECT SUM(item_price * quantity) / SUM(quantity) AS weighted_avg_price FROM shop_item WHERE item_price > 0 AND quantity > 0;";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                double weightedAvgPrice = rs.getDouble("weighted_avg_price");
                System.out.printf("Weighted average price: %.2f", weightedAvgPrice);
            }
        }
    }

    void getMostExpensiveAndCheapestProd() throws SQLException {
        String query = "SELECT" +
                       "(SELECT item_name FROM shop_item ORDER BY item_price DESC LIMIT 1) AS most_expensive,\n" +
                       "(SELECT item_name FROM shop_item ORDER BY item_price LIMIT 1) AS cheapest;";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String mostExpensive = rs.getString("most_expensive");
                String cheapest = rs.getString("cheapest");
                System.out.printf("Most expensive: %s\nCheapest: %s", mostExpensive, cheapest);
            }
        }
    }

    void getOldestAddedProd() throws SQLException {
        String query = "SELECT item_name FROM shop_item ORDER BY date_added LIMIT 1;";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String oldestProd = rs.getString(1);
                System.out.printf("Oldest product: %s", oldestProd);
            }
        }
    }

    void getNewestAddedProd() throws SQLException {
        String query = "SELECT item_name FROM shop_item ORDER BY date_added DESC LIMIT 1;";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String newestProd = rs.getString(1);
                System.out.printf("Newest product: %s", newestProd);
            }
        }
    }
}
