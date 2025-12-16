package service;

import dao.Dao;
import model.Movie;
import model.Rental;

import java.util.List;
import java.util.Optional;

public record RentalService(Dao<Rental> rentalDao, Dao<Movie> movieDao) {
    public void createRental(long movieId, String customerName) {
        Optional<Movie> movie = movieDao.findById(movieId);
        if (movie.isEmpty()) {
            throw new RuntimeException("Can't rent a movie which is not exist.");
        }
        if (!movie.get().isAvailable()) {
            throw new RuntimeException("Movie is currently unavailable for rent");
        }
        Rental rental = Rental.builder()
                .customerName(customerName)
                .movie(movie.get())
                .build();

        rentalDao.save(rental);

        movie.get().setAvailable(false);
        movieDao.save(movie.get());
    }

    public void deleteRental(long id) {
        rentalDao.deleteById(id);
    }

    public List<Rental> listAllRental() {
        return rentalDao.findAll();
    }

    public Optional<Rental> findRentalById(long id) {
        return rentalDao.findById(id);
    }
}
