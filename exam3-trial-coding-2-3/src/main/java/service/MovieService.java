package service;

import dao.Dao;
import model.Movie;
import model.Rental;

import java.util.List;
import java.util.Optional;

public record MovieService(Dao<Movie> movieDao, Dao<Rental> rentalDao) {
    public void addMovie(String genre, String title) {
        Movie movie = Movie.builder()
                .title(title)
                .genre(genre)
                .available(true)
                .build();

        movieDao.save(movie);
    }

    public void deleteMovieByID(long id) {
        movieDao.deleteById(id);
    }

    public List<Movie> listAllMovie() {
        return movieDao.findAll();
    }

    public Optional<Movie> findMovieById(long id) {
        return movieDao.findById(id);
    }
}
