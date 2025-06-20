import java.util.ArrayList;
import java.util.List;

public class Store {
    private final List<Game> availableGames = new ArrayList<>();
    private final List<Customer> registeredCustomers = new ArrayList<>();

    public void addGame(Game game) {
        this.availableGames.add(game);
    }

    public void addCustomer(Customer customer) {
        this.registeredCustomers.add(customer);
    }

    public List<Game> listAvailableGames() {
        System.out.println("Available games:");
        List<Game> result = new ArrayList<>();
        for (Game game : this.availableGames) {
            if (game.isInStock()) {
                result.add(game);
            }
        }
        return result;
    }

    public Game findGameByTitle(String title) {
        for (Game game : this.availableGames) {
            if (game.getTitle().equals(title)) {
                return game;
            }
        }

        return null;
    }

    public Customer findCustomerByName(String name) {
        for (Customer customer : this.registeredCustomers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }

        return null;
    }

    public void sellGame(String gameTitle, String customerName) {
        Game game = this.findGameByTitle(gameTitle);
        Customer customer = this.findCustomerByName(customerName);
        customer.purchaseGame(game);
    }

    public List<Customer> listCustomers() {
        System.out.println("Registered customers:");
        List<Customer> result = new ArrayList<>();
        for (Customer customer : this.registeredCustomers) {
            result.add(customer);
            System.out.println(customer);
        }
        return result;
    }
}
