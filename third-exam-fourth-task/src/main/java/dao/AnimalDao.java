package dao;

import jakarta.persistence.EntityManager;
import model.Animal;

import java.util.List;
import java.util.Optional;

public class AnimalDao extends AbstractDao implements DAOInterface<Animal> {

    public AnimalDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Optional<Animal> findById(long id) {
        return Optional.ofNullable(entityManager.find(Animal.class, id));
    }

    @Override
    public List<Animal> findAll() {
        return entityManager.createQuery("SELECT a FROM Animal a", Animal.class).getResultList();
    }

    @Override
    public void save(Animal animal) {
        executeTransaction(entityManager -> entityManager.persist(animal));
    }

    @Override
    public void deleteById(long id) {
        executeTransaction(entityManager -> {
            Animal animal = entityManager.find(Animal.class, id);
            if (animal != null) {
                entityManager.remove(animal);
            } else {
                throw new NullPointerException("Animal has been not found");
            }
        });
    }
}
