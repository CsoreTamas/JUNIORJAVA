import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {
    @Test
    void shouldAddFounds() {
        Customer customer = new Customer();
        customer.addFounds(10.0);
        Assertions.assertEquals(10.0, customer.getWalletBalance());
    }

    @Test
    void shouldCanBePurchased() {
        Game counterStrike2 = new Game("Counter Strike 2", "Action", (double) 14990.0F, true);
        Customer tomi = new Customer();
        List<Game> tomisGames = new ArrayList<>();
        tomi.setOwnedGames(tomisGames);
        tomi.setWalletBalance(20000.0);
        Assertions.assertTrue(tomi.purchaseGame(counterStrike2));
    }

    @Test
    void shouldNotCanBePurchasedIsNotInStock() {
        Game counterStrike2 = new Game("Counter Strike 2", "Action", (double) 14990.0F, false);
        Customer tomi = new Customer();
        Assertions.assertFalse(tomi.purchaseGame(counterStrike2));
    }

    @Test
    void shouldNotCanBePurchasedDoesNotExist() {
        Customer jani = new Customer();
        Assertions.assertFalse(jani.purchaseGame(null));
    }

    @Test
    void shouldNotCanBePurchasedNotEnoughMoney() {
        Game counterStrike2 = new Game("Counter Strike 2", "Action", (double) 14990.0F, true);
        Customer tomi = new Customer();
        tomi.setWalletBalance(10000.0);
        Assertions.assertFalse(tomi.purchaseGame(counterStrike2));
    }
}
