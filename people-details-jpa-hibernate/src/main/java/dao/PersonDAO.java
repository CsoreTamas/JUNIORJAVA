package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public record PersonDAO(EntityManager entityManager) implements DAOInterface<Person> {
    @Override
    public void create(Person person) {
        executeTransaction(entityManager -> entityManager.persist(person));
    }

    @Override
    public Optional<Person> findByID(int id) {
        return Optional.ofNullable(entityManager.find(Person.class, id));
    }

    @Override
    public List<Person> findAll() {
        return entityManager.createQuery("SELECT p FROM Person p ", Person.class).getResultList();
    }

    @Override
    public void update(Person person) {
        executeTransaction(entityManager -> entityManager.merge(person));
    }

    @Override
    public void deleteById(int id) {
        executeTransaction(entityManager -> {
            Person person = entityManager.find(Person.class, id);
            if (person != null) {
                entityManager.remove(person);
            } else {
                throw new NullPointerException(String.format("Person with %d not foud!", id));
            }
        });
    }

    private void executeTransaction(Consumer<EntityManager> entityManagerConsumer) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManagerConsumer.accept(entityManager);
            transaction.commit();
        } catch (RuntimeException exception) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw exception;
        }
    }
}
