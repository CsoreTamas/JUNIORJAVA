import app.Application;
import dao.Dao;
import dao.MovieDao;
import dao.RentalDao;
import jakarta.persistence.EntityManager;
import model.Movie;
import model.Rental;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import service.MovieService;
import service.RentalService;
import util.EntityManagerUtil;

public class Main {
    public static void main(String[] args) {
        LineReader lineReader = LineReaderBuilder.builder().build();
        EntityManager entityManager = EntityManagerUtil.createEntityManager();
        Dao<Movie> movieDao = new MovieDao(entityManager);
        Dao<Rental> rentalDao = new RentalDao(entityManager);

        MovieService movieService = new MovieService(movieDao, rentalDao);
        RentalService rentalService = new RentalService(rentalDao, movieDao);

        Application application = new Application(movieService, rentalService, lineReader);

        application.start();
    }
}
