package dao;

import jakarta.persistence.EntityManager;
import model.Adoption;

import java.util.List;
import java.util.Optional;

public class AdoptionDao extends AbstractDao implements DAOInterface<Adoption> {
    public AdoptionDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Optional<Adoption> findById(long id) {
        return Optional.ofNullable(entityManager.find(Adoption.class, id));
    }

    @Override
    public List<Adoption> findAll() {
        return entityManager.createQuery("Select a FROM Adoption a", Adoption.class).getResultList();
    }

    @Override
    public void save(Adoption adoption) {
        executeTransaction(entityManager -> entityManager.persist(adoption));
    }

    @Override
    public void deleteById(long id) {
        executeTransaction(entityManager -> {
            Adoption adoption = entityManager.find(Adoption.class, id);
            if (adoption != null) {
                entityManager.remove(adoption);
            } else {
                throw new NullPointerException("Adoption has been not found");
            }
        });
    }
}

