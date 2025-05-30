
public class StoreApp {
    public static void main(String[] args) {
        Store store = new Store();

        Game counterStrike2 = new Game("Counter Strike 2", "Action", (double) 14990.0F, true);
        Game gta6 = new Game("GTA 6", "Action", (double) 39990.0F, false);
        Game hogwardsLegacy = new Game("Hogwards Legacy", "Role play", (double) 23990.0F, true);

        store.addGame(counterStrike2);
        store.addGame(gta6);
        store.addGame(hogwardsLegacy);

        Customer customer1 = new Customer("Harry Potter", (double) 100000.0F);
        Customer customer2 = new Customer("Jon Deer", (double) 10000.0F);

        store.addCustomer(customer1);
        store.addCustomer(customer2);

        store.listAvailableGames();

        store.sellGame("Counter Strike 2", "Jon Deer");

        store.sellGame("Hogwards Legacy", "Harry Potter");

        store.sellGame("GTA 6", "Harry Potter");

        store.sellGame("Counter Strike 1.6", "Jon Deer");

        store.listCustomers();
    }
}
