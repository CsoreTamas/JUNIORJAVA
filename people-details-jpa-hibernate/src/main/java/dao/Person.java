package dao;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "person")
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @Column(name = "first_name")
    private String firstName;
    @NonNull
    @Column(name = "last_name")
    private String lastName;
    @NonNull
    @Column(name = "mother_name")
    private String motherName;
    @NonNull
    @Column(name = "father_name")
    private String fatherName;
    @NonNull
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "highest_education")
    private HighestEducation highestEducation;
    @NonNull
    @Column(name = "number_of_children")
    private int numOfChildren;
}
