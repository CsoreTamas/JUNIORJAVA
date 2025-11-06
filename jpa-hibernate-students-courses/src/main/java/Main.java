import dao.CourseDAO;
import dao.DAOBasicCurd;
import dao.StudentDAO;
import entitymananger.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import tables.Course;
import tables.Student;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        List<Course> courses = entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList();
        for (Course c : courses) {
            System.out.println(c.getName() + " " + c.getStudentList().size());
        }

        List<Course> courses1 = entityManager.createQuery("SELECT DISTINCT c FROM Course c JOIN FETCH c.studentList", Course.class).getResultList();
        for (Course c : courses1) {
            System.out.println(c.getName() + " " + c.getStudentList().size());
        }

        Course javaCourse = entityManager.find(Course.class, 1);

        entityManager.getTransaction().begin();

        Student student = new Student("tamas", "peter", "petittamas@example.com", javaCourse);
        javaCourse.addStudent(student);

        entityManager.persist(student);

        Student tamasPeter = entityManager.find(Student.class, 6);
        tamasPeter.setEmail("emailhasbeenchanged@example.com");

        Course courseDelete = entityManager.find(Course.class, 2);
        entityManager.remove(courseDelete);

        entityManager.getTransaction().commit();
    }
}
