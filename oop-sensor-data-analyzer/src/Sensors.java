import java.util.List;

public interface Sensors {
    String getId();

    SensorType getSensorType();

    List<Reading> getReadings();

    Reading getLatestReading();
}
