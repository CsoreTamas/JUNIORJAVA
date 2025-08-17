import city.transport.system.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Transport> transports = List.of(
                new Bus(50, FuelType.ELECTRIC),
                new Taxi(4, FuelType.PETROL),
                new Tram(150, FuelType.ELECTRIC)
        );

        for (Transport transport : transports) {
            System.out.println(transport);
        }
    }
}