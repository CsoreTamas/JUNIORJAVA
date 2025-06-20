import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StoreTest {
    @Test
    void shouldListAvailableGames() {
        Store store = new Store();
        Game counterStrike2 = new Game("Counter Strike 2", "Action", (double) 14990.0F, true);
        Game gta6 = new Game("GTA 6", "Action", (double) 39990.0F, false);
        Game hogwardsLegacy = new Game("Hogwards Legacy", "Role play", (double) 23990.0F, true);
        store.addGame(counterStrike2);
        store.addGame(gta6);
        store.addGame(hogwardsLegacy);
        List<Game> expected = List.of(counterStrike2, hogwardsLegacy);

        Assertions.assertEquals(expected, store.listAvailableGames());
    }

    @Test
    void shouldFindGameByTitle() {
        Store store = new Store();
        Game gta6 = new Game("GTA 6", "Action", (double) 39990.0F, false);
        store.addGame(gta6);

        Assertions.assertEquals(gta6, store.findGameByTitle("GTA 6"));
    }

    @Test
    void shouldFindCustomerByName() {
        Store store = new Store();
        Customer tomi = new Customer();
        store.addCustomer(tomi);
        tomi.setName("Tomi");

        Assertions.assertEquals(tomi, store.findCustomerByName("Tomi"));
    }

    @Test
    void shouldSellGame() {
        Store store = new Store();
        Game cs2 = new Game("cs2", "action", 10000, true);
        Customer tomi = new Customer("tomi", 10000);

        store.addGame(cs2);
        store.addCustomer(tomi);

        store.sellGame("cs2", "tomi");

        Assertions.assertTrue(tomi.getOwnedGames().contains(cs2));
        Assertions.assertEquals(0, tomi.getWalletBalance());
    }

    @Test
    void shouldListCustomers() {
        Store store = new Store();
        Customer jani = new Customer("jani", 10000);
        Customer tomi = new Customer("tomi", 10);
        Customer pityu = new Customer("pityu", 321);
        store.addCustomer(jani);
        store.addCustomer(tomi);
        store.addCustomer(pityu);

        List<Customer> customers = List.of(jani, tomi, pityu);

        Assertions.assertEquals(customers, store.listCustomers());
    }
}
