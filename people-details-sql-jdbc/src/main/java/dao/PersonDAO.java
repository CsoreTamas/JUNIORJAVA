package dao;

import connector.enums.Gender;
import connector.enums.HighestEducation;
import org.jline.reader.LineReader;
import org.jline.reader.UserInterruptException;

import java.sql.*;


public record PersonDAO(Connection connection, LineReader lineReader) implements PersonDAOInterface {
    @Override
    public void create() {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO `people`.`person` (first_name, last_name, mother_name, father_name, birth_date, gender, highest_education, number_of_children)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );
            getData(ps);
            if (ps.executeUpdate() > 0) {
                System.out.println("Successfully added.");
            } else {
                System.out.println("Failed to add.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void getData(PreparedStatement ps) throws SQLException {
        String firstName = lineReader.readLine("Please enter your first name: ");
        String lastName = lineReader.readLine("Please enter your last name: ");
        String motherName = lineReader.readLine("Please enter your mother's name: ");
        String fatherName = lineReader.readLine("Please enter your father's name: ");
        String dateInput = lineReader.readLine("Please enter your birth date (YYYY-MM-DD): ");
        Date birthDate = Date.valueOf(dateInput);

        for (Gender gender : Gender.values()) {
            System.out.println(gender.ordinal() + 1 + ". " + gender);
        }

        Gender gender = null;
        while (gender == null) {
            String genderInput = lineReader.readLine("Please chose 1-3: ");
            gender = getGender(Integer.parseInt(genderInput));
        }

        for (HighestEducation education : HighestEducation.values()) {
            System.out.println(education.ordinal() + 1 + ". " + education);
        }

        HighestEducation highestEducation = null;
        while (highestEducation == null) {
            String highestEducationInput = lineReader.readLine("Please chose 1-6: ");
            highestEducation = getEducation(Integer.parseInt(highestEducationInput));
        }

        String inputNumOfChildren = lineReader.readLine("How many children you have?: ");
        int numOfChildren = Integer.parseInt(inputNumOfChildren);

        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setString(3, motherName);
        ps.setString(4, fatherName);
        ps.setDate(5, birthDate);
        ps.setString(6, gender.toString());
        ps.setString(7, highestEducation.toString());
        ps.setInt(8, numOfChildren);
    }

    private Gender getGender(int input) {
        return switch (input) {
            case 1 -> Gender.MALE;
            case 2 -> Gender.FEMALE;
            case 3 -> Gender.OTHER;
            default -> {
                System.out.println("Invalid input default -> OTHER");
                yield Gender.OTHER;
            }
        };
    }

    private HighestEducation getEducation(int input) {
        return switch (input) {
            case 1 -> HighestEducation.ELEMENTARY_SCHOOL;
            case 2 -> HighestEducation.HIGH_SCHOOL;
            case 3 -> HighestEducation.VOCATIONAL_TRAINING;
            case 4 -> HighestEducation.BSC_DEGREE;
            case 5 -> HighestEducation.MSC_DEGREE;
            case 6 -> HighestEducation.PHD;
            default -> {
                System.out.println("Invalid input default ->");
                yield HighestEducation.ELEMENTARY_SCHOOL;
            }
        };
    }

    @Override
    public void read() {
        try {
            String idInput = lineReader.readLine("Please enter your id: ");
            int id = Integer.parseInt(idInput);
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM person WHERE id = ?");
            ps.setInt(1, Integer.parseInt(idInput));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String motherName = rs.getString("mother_name");
                String fatherName = rs.getString("father_name");
                Date birthDate = rs.getDate("birth_date");
                Gender gender = Gender.valueOf(rs.getString("gender"));
                HighestEducation highestEducation = HighestEducation.valueOf(rs.getString("highest_education"));
                int numOfChildren = rs.getInt("number_of_children");

                System.out.println(new Person(
                        id,
                        firstName,
                        lastName,
                        motherName,
                        fatherName,
                        birthDate,
                        gender,
                        highestEducation,
                        numOfChildren
                ));
            } else {
                System.err.printf("No person found with ID: %d", id);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update() {
        try {
            String input = lineReader.readLine("Please enter your id: ");
            int id = Integer.parseInt(input);
            PreparedStatement ps = connection.prepareStatement("UPDATE person SET first_name = ?, last_name = ?, mother_name = ?, father_name = ?, birth_date = ?, gender = ?, highest_education = ?, number_of_children = ? WHERE id = ?");
            getData(ps);
            ps.setInt(9, id);
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
    public void delete() {
        try {
            String input = lineReader.readLine("Please enter your id: ");
            int id = Integer.parseInt(input);
            PreparedStatement ps = connection.prepareStatement("DELETE FROM person WHERE id = ?");
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
