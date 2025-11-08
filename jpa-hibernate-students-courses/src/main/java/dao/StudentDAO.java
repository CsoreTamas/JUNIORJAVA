package dao;

import jakarta.persistence.EntityTransaction;
import tables.Course;
import tables.Student;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;


import java.util.List;

@AllArgsConstructor
public class StudentDAO implements DAOBasicCRUD<Student> {
    private EntityManager entityManager;

    @Override
    public void create(Student student) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(student);
            transaction.commit();
        } catch (RuntimeException exception) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw exception;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void update(Student student) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(student);
            transaction.commit();
        } catch (RuntimeException exception) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw exception;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Student read(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> readAll() {
        return entityManager.createQuery("SELECT c FROM Student c", Student.class).getResultList();
    }

    @Override
    public void delete(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Student student = entityManager.find(Student.class, id);
            entityManager.remove(student);
            transaction.commit();
        } catch (RuntimeException exception) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw exception;
        } finally {
            entityManager.close();
        }
    }
}
