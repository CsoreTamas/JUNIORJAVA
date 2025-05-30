import java.util.ArrayList;
import java.util.List;

public class Store {
    private final List<Game> availableGames = new ArrayList();
    private final List<Customer> registeredCustomers = new ArrayList();

    public void addGame(Game game) {
        this.availableGames.add(game);
    }

    public void addCustomer(Customer customer) {
        this.registeredCustomers.add(customer);
    }

    public void listAvailableGames() {
        System.out.println("Available games:");

        for(Game game : this.availableGames) {
            System.out.print(game);
        }

    }

    public Game findGameByTitle(String title) {
        for(Game game : this.availableGames) {
            if (game.getTitle().equals(title)) {
                return game;
            }
        }

        return null;
    }

    public void sellGame(String gameTitle, String customerName) {
        Game game = this.findGameByTitle(gameTitle);
        Customer customer = this.findCustomerByName(customerName);
        customer.purchaseGame(game);
    }

    public Customer findCustomerByName(String name) {
        for(Customer customer : this.registeredCustomers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }

        return null;
    }

    public void listCustomers() {
        System.out.println("Registered customers:");

        for(Customer customer : this.registeredCustomers) {
            System.out.print(customer);
        }

    }
}
