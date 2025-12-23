package app;

import model.Movie;
import model.Rental;
import org.jline.reader.LineReader;
import service.MovieService;
import service.RentalService;


import java.util.List;
import java.util.Optional;

public record Application(MovieService movieService, RentalService rentalService, LineReader lineReader) {

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("App: ");
            System.out.println("1. Add Movie");
            System.out.println("2. Delete movie");
            System.out.println("3. List all movies");
            System.out.println("4. Find movie by ID");
            System.out.println("5. Add rental");
            System.out.println("6. Delete Rental");
            System.out.println("7. List all rentals");
            System.out.println("8. Find rental by ID");
            System.out.println("0. Exit");

            int input = Integer.parseInt(lineReader.readLine("Choose an option: "));

            switch (input) {
                case 1 -> addMovie();
                case 2 -> deleteMovie();
                case 3 -> listAllMovies();
                case 4 -> findMovie();
                case 5 -> addRental();
                case 6 -> deleteRental();
                case 7 -> listALlRentals();
                case 8 -> findRental();
                case 0 -> running = false;
                default -> System.out.println("Invalid input");
            }
        }

    }

    private void addMovie() {
        String genre = lineReader.readLine("Please enter the genre.");
        String title = lineReader.readLine("Please enter the title");
        movieService.addMovie(genre, title);
        System.out.println("Movie added successfully!!!");
    }

    private void deleteMovie() {
        long id = Long.parseLong(lineReader.readLine("Please enter the Movie's ID: "));
        movieService.deleteMovieByID(id);
        System.out.println("Delete went successfully!!!");
    }

    private void listAllMovies() {
        List<Movie> movies = movieService.listAllMovie();
        if (movies.isEmpty()) {
            System.out.print("No one movies has been found");
        } else {
            movies.forEach(System.out::println);
        }
    }

    private void findMovie() {
        long id = Long.parseLong(lineReader.readLine("Please enter the Movies ID: "));
        Optional<Movie> movie = movieService.findMovieById(id);
        System.out.println(movie);
    }

    private void addRental() {
        String name = lineReader.readLine("Please enter the name: ");
        long id = Long.parseLong(lineReader.readLine("Please enter the Movie's ID: "));
        rentalService.createRental(id, name);
        System.out.println("Rental added successfully");
    }

    private void deleteRental() {
        long id = Long.parseLong(lineReader.readLine("Please enter the rental's ID: "));
        rentalService.deleteRental(id);
        System.out.println("Delete went successfully!!!");
    }

    private void listALlRentals() {
        List<Rental> rentals = rentalService.listAllRental();
        if (rentals.isEmpty()) {
            System.out.print("No one rental has been found");
        } else {
            rentals.forEach(System.out::println);
        }
    }

    private void findRental() {
        long id = Long.parseLong(lineReader.readLine("Please enter the Rental's ID: "));
        Optional<Rental> rental = rentalService.findRentalById(id);
        System.out.println(rental);
    }
}
