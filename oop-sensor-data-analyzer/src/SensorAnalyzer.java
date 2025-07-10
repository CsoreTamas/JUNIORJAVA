import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorAnalyzer {

    public static double getAverageOfReadings(AbstractSensor sensor) {
        List<Reading> readings = sensor.getReadings();
        double sum = 0;
        int divider = 0;
        for (Reading reading : readings) {
            sum += reading.getReading();
            divider++;
        }
        return sum / divider;
    }

    public static List<AbstractSensor> getSensorsAboveSThreshold(List<AbstractSensor> sensors, double threshold, SensorType sensorType) {
        List<AbstractSensor> result = new ArrayList<>();
        for (AbstractSensor sensor : sensors) {
            if (sensor.getSensorType() == sensorType) {
                double latest = sensor.getLatestReadingValue();
                if (latest > threshold) {
                    result.add(sensor);
                }
            }
        }
        return result;
    }

    public static AbstractSensor getSensorWithHighestLatestReading(List<AbstractSensor> sensors, SensorType sensorType) {
        AbstractSensor resultSensor = null;
        Reading maxReading = null;

        for (AbstractSensor sensor : sensors) {
            if (sensor.getSensorType() == sensorType) {
                for (Reading reading : sensor.getReadings()) {
                    if (maxReading == null || reading.getReading() > maxReading.getReading()) {
                        resultSensor = sensor;
                        maxReading = reading;
                    }
                }
            }
        }
        List<Reading> singleReading = new ArrayList<>();
        singleReading.add(maxReading);
        assert resultSensor != null;

        return new SensorWithSingleReading(resultSensor.getId(), sensorType, singleReading);
    }

    public static Map<SensorType, Reading> getLatestReadingsGroupedByType(List<AbstractSensor> sensors, SensorType sensorType) {
        Map<SensorType, Reading> latestReadings = new HashMap<>();
        for (AbstractSensor sensor : sensors) {
            Reading latest = sensor.getLatestReading();
            if (sensor.getSensorType() == sensorType) {
                latestReadings.put(sensor.getSensorType(), latest);
            }
        }
        return latestReadings;
    }
}
