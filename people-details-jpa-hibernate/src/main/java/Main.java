import dao.*;
import entitymanager.EntityManagerUtil;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerUtil.entityManager();
        DAOInterface personDAO = new PersonDAO(entityManager);

        Person pityu = Person.builder()
                .firstName("János")
                .lastName("Pityu")
                .motherName("Pityu's mom")
                .fatherName("Pityu's dad")
                .birthDate(LocalDate.of(1999, 12, 1))
                .gender(Gender.MALE)
                .highestEducation(HighestEducation.BSC_DEGREE)
                .numOfChildren(65)
                .build();
        personDAO.create(pityu);

        System.out.println(personDAO.findByID(pityu.getId()));

        pityu.setNumOfChildren(2);
        pityu.setBirthDate(LocalDate.of(1978, 1, 1));
        personDAO.update(pityu);

        System.out.println(personDAO.findByID(pityu.getId()));


        List<Person> listPeople = personDAO.findAll();
        listPeople.forEach(System.out::println);

        personDAO.deleteById(11);

        entityManager.close();
    }
}
