package service;

import dao.Person;
import dao.PersonDAOInterface;
import enums.Gender;
import enums.HighestEducation;
import org.jline.reader.LineReader;

import java.sql.Date;
import java.time.LocalDate;

public record PersonService(PersonDAOInterface<Person> personDAO, LineReader lineReader) {

    public void getInputForCreate() {
        personDAO.create(getInputForCreatingPerson());
    }

    public void getInputForFind() {
        String idInput = lineReader.readLine("Please enter your id: ");
        int id = Integer.parseInt(idInput);
        personDAO.findById(id);
    }

    public void getInputForUpdate() {
        String input = lineReader.readLine("Please enter your id: ");
        int id = Integer.parseInt(input);
        Person updatedPerson = getInputForCreatingPerson();
        updatedPerson.setId(id);
        personDAO.update(updatedPerson);
    }

    public void getInputForDelete() {
        String input = lineReader.readLine("Please enter your id: ");
        int id = Integer.parseInt(input);
        personDAO.deleteById(id);
    }

    public void findAll() {
        personDAO.findAll();
    }

    private Person getInputForCreatingPerson() {
        String firstName = lineReader.readLine("Please enter your first name: ");
        String lastName = lineReader.readLine("Please enter your last name: ");
        String motherName = lineReader.readLine("Please enter your mother's name: ");
        String fatherName = lineReader.readLine("Please enter your father's name: ");
        String dateInput = lineReader.readLine("Please enter your birth date (YYYY-MM-DD): ");
        LocalDate birthDate = Date.valueOf(dateInput).toLocalDate();

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

        return new Person(firstName, lastName, motherName, fatherName, birthDate, gender, highestEducation, numOfChildren);
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
}
