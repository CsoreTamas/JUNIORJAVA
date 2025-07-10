public class HumiditySensor extends AbstractSensor implements Sensor {

    public HumiditySensor(String id) {
        super(id);
    }

    @Override
    public SensorType getSensorType() {
        return SensorType.HUMIDITY;
    }

    @Override
    public String toString() {
        return String.format("%s: %s = %s%%.", getSensorType(), getId(), getReadings());
    }
}
