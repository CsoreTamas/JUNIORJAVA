package dao;

import tables.Course;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CourseDAO implements DAOBasicCurd<Course> {
    private EntityManager em;

    @Override
    public void create(Course course) {
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
    }

    @Override
    public void update(Course course) {
        em.getTransaction().begin();
        em.merge(course);
        em.getTransaction().commit();
    }

    @Override
    public Course read(int id) {
        return em.find(Course.class, id);
    }

    @Override
    public List<Course> readAll() {
        return em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    @Override
    public void delete(int id) {
        em.getTransaction().begin();
        Course course = em.find(Course.class, id);
        em.remove(course);
        em.getTransaction().commit();
    }
}
