package sensor;

import java.util.List;
import java.util.Objects;

public class SensorWithSingleReading extends AbstractSensor {
    private final List<Reading> singleReading;
    private final SensorType sensorType;

    public SensorWithSingleReading(String id, SensorType sensorType, List<Reading> singleReading) {
        super(id);
        this.singleReading = singleReading;
        this.sensorType = sensorType;
    }

    @Override
    public List<Reading> getReadings() {
        return singleReading;
    }

    @Override
    public SensorType getSensorType() {
        return this.sensorType;
    }

    @Override
    public String toString() {
        return String.format("%s: %s = %s ", sensorType, getId(), getReadings());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SensorWithSingleReading that = (SensorWithSingleReading) o;
        return Objects.equals(singleReading, that.singleReading) && sensorType == that.sensorType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(singleReading, sensorType);
    }
}
