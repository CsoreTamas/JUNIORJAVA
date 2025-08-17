package city.transport.system;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TramTest {
    @Test
    void shouldCalculateFreFee() {
        PublicTransport electricTram = new Tram(100, FuelType.ELECTRIC);
        PublicTransport hybridTram = new Tram(100, FuelType.HYBRID);
        PublicTransport dieselTram = new Tram(100, FuelType.DIESEL);
        PublicTransport petrolTram = new Tram(100, FuelType.PETROL);

        assertEquals("true", electricTram.ecoFriendlyLabel());
        assertEquals("true", hybridTram.ecoFriendlyLabel());
        assertEquals("false", dieselTram.ecoFriendlyLabel());
        assertEquals("false", petrolTram.ecoFriendlyLabel());

        assertEquals(2.5, electricTram.calculateFare(10));
    }
}
