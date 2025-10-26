package dao;

import connector.enums.Gender;
import connector.enums.HighestEducation;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String motherName;
    private String fatherName;
    private Date birthDate;
    private Gender gender;
    private HighestEducation highestEducation;
    private int numberOfChildren;
}
