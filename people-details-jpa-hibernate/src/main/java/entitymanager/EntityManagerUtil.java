package entitymanager;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;

public class EntityManagerUtil {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-hib-people");

    public static EntityManager entityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
