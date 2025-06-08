import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoreTest {
    @Test
    void shouldFindGameByTitle() {
        Game minecraft = new Game("Minecraft", "Donno", 5500, true);
        Game clashOfClans = new Game("Clash Of Clans", "Strategi", 0, true);
        Game snapszer = new Game("Snapszer", "Card game", 2000, false);

        Store store = new Store();
        store.addGame(clashOfClans);
        store.addGame(minecraft);
        store.addGame(snapszer);

        Assertions.assertEquals(minecraft, store.findGameByTitle("Minecraft"));
    }

    @Test
    void shouldFindCustomerByName() {
        Customer pityu = new Customer("Pityu", 10000);
        Customer mari = new Customer("Mari", 20000);
        Customer pisti = new Customer("Pista", 15000);

        Store store = new Store();
        store.addCustomer(pisti);
        store.addCustomer(pityu);
        store.addCustomer(mari);

        Assertions.assertEquals(pityu, store.findCustomerByName("Pityu"));
    }
}
