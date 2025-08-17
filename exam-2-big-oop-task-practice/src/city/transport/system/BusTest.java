package city.transport.system;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BusTest {
    @Test
    void shouldCalculateFreFee() {
        PublicTransport electricBus = new Bus(80, FuelType.ELECTRIC);
        PublicTransport hybridBus = new Bus(80, FuelType.HYBRID);
        PublicTransport dieselBus = new Bus(80, FuelType.DIESEL);
        PublicTransport petrolBus = new Bus(80, FuelType.PETROL);

        assertEquals("true", electricBus.ecoFriendlyLabel());
        assertEquals("true", hybridBus.ecoFriendlyLabel());
        assertEquals("false", dieselBus.ecoFriendlyLabel());
        assertEquals("false", petrolBus.ecoFriendlyLabel());

        assertEquals(3.5, electricBus.calculateFare(10));
    }
}

