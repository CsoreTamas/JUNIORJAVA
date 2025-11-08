import dao.CourseDAO;
import dao.DAOBasicCRUD;
import dao.StudentDAO;
import entitymanager.EntityManagerUtil;
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


        DAOBasicCRUD<Course> courseDAO = new CourseDAO(entityManager);
        DAOBasicCRUD<Student> studentDAO = new StudentDAO(entityManager);

        Course javaCourse = courseDAO.findById(1);

        Student student = new Student("tamas", "peter", "petittamas@example.com", javaCourse);
        javaCourse.addStudent(student);

        studentDAO.create(student);

        Student tamasPeter = studentDAO.findById(6);
        tamasPeter.setEmail("emailhasbeenchanged@example.com");
        studentDAO.update(tamasPeter);

        courseDAO.delete(2);
    }
}
