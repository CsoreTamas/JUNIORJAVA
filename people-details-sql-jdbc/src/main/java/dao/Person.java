package dao;

import enums.Gender;
import enums.HighestEducation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Data
@AllArgsConstructor
public class Person {
    private int id;
    private final String firstName;
    private final String lastName;
    private final String motherName;
    private final String fatherName;
    private final LocalDate birthDate;
    private final Gender gender;
    private final HighestEducation highestEducation;
    private final int numberOfChildren;

    public Person(String firstName, String lastName, String motherName, String fatherName, LocalDate birthDate, Gender gender, HighestEducation highestEducation, int numberOfChildren) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.highestEducation = highestEducation;
        this.numberOfChildren = numberOfChildren;
    }
}
