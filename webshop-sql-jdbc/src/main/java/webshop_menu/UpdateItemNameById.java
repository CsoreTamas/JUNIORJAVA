package webshop_menu;

import org.jline.reader.LineReader;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateItemNameById {
    static void updateItemNameById(Connection connection, LineReader lineReader) {
        try {
            String input = lineReader.readLine("Please enter the item id: ");
            int id = Integer.parseInt(input);

            String newName = lineReader.readLine("Please enter the new name");

            String query = "UPDATE shop_item SET item_name = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newName);
            ps.setInt(2, id);

            if (ps.executeUpdate() > 0) {
                System.out.println("Product name successfully changed");
            } else {
                System.out.println("No product found with the given id");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
