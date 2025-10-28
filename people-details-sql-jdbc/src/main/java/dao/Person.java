package dao;

import enums.Gender;
import enums.HighestEducation;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String motherName;
    private String fatherName;
    private LocalDate birthDate;
    private Gender gender;
    private HighestEducation highestEducation;
    private int numberOfChildren;

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
