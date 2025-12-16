package dao;

import jakarta.persistence.EntityManager;
import model.Rental;

import java.util.List;
import java.util.Optional;

public class RentalDao extends AbstractDao implements Dao<Rental> {

    public RentalDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Rental rental) {
        executeTransaction(entityManager -> entityManager.persist(rental));
    }

    @Override
    public Optional<Rental> findById(long id) {
        return Optional.ofNullable(entityManager.find(Rental.class, id));
    }

    @Override
    public List<Rental> findAll() {
        return entityManager.createQuery("SELECT r FROM Rental r", Rental.class).getResultList();
    }

    @Override
    public void deleteById(long id) {
        executeTransaction(entityManager -> {
            Rental rental = entityManager.find(Rental.class, id);
            if (rental != null) {
                entityManager.remove(rental);
            } else {
                throw new NullPointerException("Rental has been not found");
            }
        });
    }
}
