package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.AllArgsConstructor;

import java.util.function.Consumer;

@AllArgsConstructor
public abstract class AbstractDao {
    final EntityManager entityManager;

    void executeTransaction(Consumer<EntityManager> entityManagerConsumer) {
        EntityTransaction tr = entityManager.getTransaction();
        try {
            tr.begin();
            entityManagerConsumer.accept(entityManager);
            tr.commit();
        } catch (RuntimeException e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            throw e;
        }
    }
}
