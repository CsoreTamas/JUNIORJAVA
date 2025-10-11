package sensor;

import java.util.List;

public interface Sensor {
    String getId();

    SensorType getSensorType();

    List<Reading> getReadings();

    Reading getLatestReading();
}
