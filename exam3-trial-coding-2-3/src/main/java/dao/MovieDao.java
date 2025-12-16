package dao;

import jakarta.persistence.EntityManager;
import model.Movie;

import java.util.List;
import java.util.Optional;

public class MovieDao extends AbstractDao implements Dao<Movie> {
    public MovieDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Movie movie) {
        executeTransaction(entityManager -> entityManager.persist(movie));
    }

    @Override
    public Optional<Movie> findById(long id) {
        return Optional.ofNullable(entityManager.find(Movie.class, id));
    }

    @Override
    public List<Movie> findAll() {
        return entityManager.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }

    @Override
    public void deleteById(long id) {
        executeTransaction(entityManager -> {
            Movie movie = entityManager.find(Movie.class, id);
            if (movie != null) {
                entityManager.remove(movie);
            } else {
                throw new NullPointerException("Movie has been not found");
            }
        });
    }
}
