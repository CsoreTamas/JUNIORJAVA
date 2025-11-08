package entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class EntityManagerUtil {
    private static final EntityManagerFactory entityManFac = Persistence.createEntityManagerFactory("jpa-hib-stud-cour");

    public static EntityManager getEntityManager() {
        return entityManFac.createEntityManager();
    }
}
