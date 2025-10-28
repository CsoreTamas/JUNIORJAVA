package dao;

import enums.Gender;
import enums.HighestEducation;
import lombok.AllArgsConstructor;
import org.jline.reader.UserInterruptException;

import java.sql.*;
import java.time.LocalDate;

@AllArgsConstructor
public class PersonDAO implements PersonDAOInterface<Person> {
    private Connection connection;

    @Override
    public void findAll() {
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM person");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String motherName = rs.getString("mother_name");
                String fatherName = rs.getString("father_name");
                LocalDate birthDate = rs.getDate("birth_date").toLocalDate();
                Gender gender = Gender.valueOf(rs.getString("gender"));
                HighestEducation highestEducation = HighestEducation.valueOf(rs.getString("highest_education"));
                int numberOfChildren = rs.getInt("number_of_children");

                System.out.printf("""
                                ID: %s
                                First name: %s
                                Last name: %s
                                Mother name: %s
                                Father name: %s
                                Birth date: %s
                                Gender: %s
                                Highest education: %s
                                Kids: %d
                                ---------------------------
                                """,
                        id, firstName, lastName, motherName, fatherName, birthDate, gender, highestEducation, numberOfChildren);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Person person) {
        try (PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO `people`.`person` (first_name, last_name, mother_name, father_name, birth_date, gender, highest_education, number_of_children)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
        )) {
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setString(3, person.getMotherName());
            ps.setString(4, person.getFatherName());
            ps.setObject(5, person.getBirthDate());
            ps.setString(6, person.getGender().name());
            ps.setString(7, person.getHighestEducation().name());
            ps.setInt(8, person.getNumberOfChildren());

            if (ps.executeUpdate() > 0) {
                System.out.println("Create was successfully.");
            } else {
                System.out.println("Create failed");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void findById(int id) {
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM person WHERE id = ?");
             ResultSet rs = ps.executeQuery()) {

            ps.setInt(1, id);
            if (rs.next()) {
                System.out.println(
                        new Person(
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("mother_name"),
                                rs.getString("father_name"),
                                rs.getDate("birth_date").toLocalDate(),
                                Gender.valueOf(rs.getString("gender")),
                                HighestEducation.valueOf(rs.getString("highest_education")),
                                rs.getInt("number_of_children")));
            } else {
                System.err.printf("No person found with ID: %d", id);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Person person) {
        try (PreparedStatement ps = connection.prepareStatement("UPDATE person SET first_name = ?, last_name = ?, mother_name = ?, father_name = ?, birth_date = ?, gender = ?, highest_education = ?, number_of_children = ? WHERE id = ?")) {
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setString(3, person.getMotherName());
            ps.setString(4, person.getFatherName());
            ps.setObject(5, person.getBirthDate());
            ps.setString(6, person.getGender().name());
            ps.setString(7, person.getHighestEducation().name());
            ps.setInt(8, person.getNumberOfChildren());
            ps.setInt(9, person.getId());

            if (ps.executeUpdate() > 0) {
                System.out.println("Update went successfully");
            } else {
                System.out.println("Update failed");
            }
        } catch (UserInterruptException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM person WHERE id = ?")) {
            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {
                System.out.println("Delete went successfully");
            } else {
                System.out.println("Delete failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
