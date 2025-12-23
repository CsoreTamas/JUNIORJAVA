import tables.*;
import validator.CourseCodeValidator;
import validator.StudentIDValidator;
import validator.Validator;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        University university = University.getInstance();
        Validator<Course> courseCodeValidator = new CourseCodeValidator();
        Validator<Enrollable> studentIDValidator = new StudentIDValidator();

        Professor professorPista = new Professor("Pista Norbert", Faculty.MECHANICAL, 15);
        Professor professorJohn = new Professor("John Deer", Faculty.COMPUTER_SCIENCE, 3);

        university.hireProfessor(professorPista);
        university.hireProfessor(professorJohn);

        Enrollable jozsi = new Student("Jozsi Péter", "12345678", "MECHANICAL");
        Enrollable gereble = new Student("Gereble János", "87654321", "COMPUTER_SCIENCE");
        Enrollable falseStudentIdJános = new Student("The ID is not valid János", "876543210", "COMPUTER_SCIENCE");

        Course mechanicalCourse = new Course("MCH-001", "Mechanical course with Pista Norbert", professorPista, new HashSet<>());
        Course computerScience = new Course("CMP-001", "Computer science", professorJohn, new HashSet<>());

        Enrollable bela = new Researcher("Bela Bela", "mechanical", 2);

        university.offerCourse(mechanicalCourse);
        university.offerCourse(computerScience);

        university.admitEnrollable(jozsi);
        university.admitEnrollable(gereble);
        university.admitEnrollable(bela);
        university.admitEnrollable(falseStudentIdJános);

        for (Course course : university.getCourses()) {
            if (!courseCodeValidator.isValid(course)) {
                continue;
            }
            for (Enrollable enrollable : university.getParticipants()) {
                if (enrollable instanceof Student student && studentIDValidator.isValid(enrollable)) {
                    course.enrollParticipant(student);
                } else if (enrollable instanceof Researcher) {
                    course.enrollParticipant(enrollable);
                }
            }
        }

        System.out.println("Participants in MCH-001");
        for (Enrollable enrollable : university.getParticipantsOfCourse(mechanicalCourse)) {
            if (enrollable instanceof Student student) {
                System.out.println(student.getName());
            } else if (enrollable instanceof Researcher researcher) {
                System.out.println(researcher.getName());
            }
        }

        System.out.println("Courses taught by Pista Norbert:");
        for (Course course1 : university.getCoursesByProfessor(professorPista)) {
            System.out.println(course1.getCourseName());
        }
    }
}
