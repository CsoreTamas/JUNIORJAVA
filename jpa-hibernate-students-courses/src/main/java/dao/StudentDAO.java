package dao;

import tables.Student;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;


import java.util.List;

@AllArgsConstructor
public class StudentDAO implements DAOBasicCurd<Student> {
    private EntityManager em;

    @Override
    public void create(Student student) {
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
    }

    @Override
    public void update(Student student) {
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }

    @Override
    public Student read(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> readAll() {
        return em.createQuery("SELECT c FROM Student c", Student.class).getResultList();
    }

    @Override
    public void delete(int id) {
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        em.remove(student);
        em.getTransaction().commit();
    }
}
