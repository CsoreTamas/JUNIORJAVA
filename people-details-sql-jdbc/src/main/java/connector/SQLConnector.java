package connector;

import connector.enums.Gender;
import connector.enums.HighestEducation;

import java.sql.*;

public record SQLConnector(String url, String username, String password) {
    public void getConnection() {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM person");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String motherName = rs.getString("mother_name");
                String fatherName = rs.getString("father_name");
                Date birthDate = rs.getDate("birth_date");
                Gender gender = Gender.valueOf(rs.getString("gender"));
                HighestEducation highestEducation = HighestEducation.valueOf(rs.getString("highest_education"));
                int num_of_children = rs.getInt("number_of_children");

                System.out.printf("""
                                ID: %s
                                First name: %s
                                Last name: %s
                                Mother name: %s
                                Father name: %s
                                Birth date: %tF
                                Gender: %s
                                Highest education: %s
                                Kids: %d
                                ---------------------------
                                """,
                        id, firstName, lastName, motherName, fatherName, birthDate, gender, highestEducation, num_of_children);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
