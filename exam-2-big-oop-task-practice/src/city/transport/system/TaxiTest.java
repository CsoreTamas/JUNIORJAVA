package city.transport.system;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxiTest {
    @Test
    void shouldCalculateFreFee() {
        PrivateTransport electricTaxi = new Taxi(4, FuelType.ELECTRIC);
        PrivateTransport hybridTaxi = new Taxi(4, FuelType.HYBRID);
        PrivateTransport dieselTaxi = new Taxi(4, FuelType.DIESEL);
        PrivateTransport petrolTaxi = new Taxi(4, FuelType.PETROL);

        assertEquals("true", electricTaxi.ecoFriendlyLabel());
        assertEquals("true", hybridTaxi.ecoFriendlyLabel());
        assertEquals("false", dieselTaxi.ecoFriendlyLabel());
        assertEquals("false", petrolTaxi.ecoFriendlyLabel());

        assertEquals(14, electricTaxi.calculateFare(10));
    }
}
