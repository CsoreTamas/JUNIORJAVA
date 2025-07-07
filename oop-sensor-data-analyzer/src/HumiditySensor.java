public class HumiditySensor extends Sensor implements Sensors {

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
