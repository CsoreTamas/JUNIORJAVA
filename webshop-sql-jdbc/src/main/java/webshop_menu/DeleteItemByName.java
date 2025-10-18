package webshop_menu;

import org.jline.reader.LineReader;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteItemByName {
    static void deleteItemByName(Connection connection, LineReader lineReader) {
        try {
            String name = lineReader.readLine("Please enter the item name: ");

            String query = "DELETE FROM shop_item WHERE item_name = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);

            if (ps.executeUpdate() > 0) {
                System.out.println("Product deleted successfully");
            } else {
                System.out.println("Delete failed");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
