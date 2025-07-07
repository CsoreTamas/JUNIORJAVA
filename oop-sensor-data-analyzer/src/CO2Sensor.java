public class CO2Sensor extends Sensor {

    public CO2Sensor(String id) {
        super(id);
    }

    @Override
    public SensorType getSensorType() {
        return SensorType.CO2;
    }

    @Override
    public String toString() {
        return String.format("%s: %s = %skg.", getSensorType(), getId(), getReadings());
    }
}
