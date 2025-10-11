package sensor;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSensor implements Sensor {
    private final String id;
    private final List<Reading> readings = new ArrayList<>();

    public AbstractSensor(String id) {
        this.id = id;
    }

    public abstract SensorType getSensorType();

    public Double getLatestReadingValue() {
        if (readings.isEmpty()) {
            System.err.println("You don't have any readings.");
            return null;
        }
        return readings.getLast().reading();
    }


    public Reading getLatestReading() {
        if (readings.isEmpty()) {
            System.err.println("You don't have any readings.");
            return null;
        }
        return readings.getLast();
    }

    public String getId() {
        return id;
    }

    public List<Reading> getReadings() {
        return readings;
    }

    public void addReading(Reading reading) {
        readings.add(reading);
    }
}
