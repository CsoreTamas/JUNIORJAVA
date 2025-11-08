package sensor;

public class TemperatureSensor extends AbstractSensor implements Sensor {

    public TemperatureSensor(String id) {
        super(id);
    }

    @Override
    public SensorType getSensorType() {
        return SensorType.TEMPERATURE;
    }

    @Override
    public String toString() {
        return String.format("%s: %s = %s°C.", getSensorType(), getId(), getReadings());
    }
}
