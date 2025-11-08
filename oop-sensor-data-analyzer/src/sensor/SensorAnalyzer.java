package sensor;

import java.util.*;

public class SensorAnalyzer {

    public static double getAverageOfReadings(Sensor sensor) {
        List<Reading> readings = sensor.getReadings();
        double sum = 0;
        int divider = 0;
        for (Reading reading : readings) {
            sum += reading.reading();
            divider++;
        }
        return sum / divider;
    }

    public static List<Sensor> getSensorsAboveSThreshold(List<Sensor> sensors, double threshold, SensorType sensorType) {
        List<Sensor> result = new ArrayList<>();
        for (Sensor sensor : sensors) {
            if (sensor.getSensorType() == sensorType) {
                double latest = sensor.getLatestReadingValue();
                if (latest > threshold) {
                    result.add(sensor);
                }
            }
        }
        return result;
    }

    public static Sensor getSensorWithHighestLatestReading(List<Sensor> sensors, SensorType sensorType) {
        Sensor resultSensor = null;
        Reading maxReading = null;

        for (Sensor sensor : sensors) {
            if (sensor.getSensorType() == sensorType) {
                for (Reading reading : sensor.getReadings()) {
                    if (maxReading == null || reading.reading() > maxReading.reading()) {
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

    public static Map<Sensor, Reading> getLatestReadingsGroupedByType(List<Sensor> sensors) {
        Map<Sensor, Reading> latestReadings = new LinkedHashMap<>();
        for (Sensor sensor : sensors) {
            Reading latest = sensor.getLatestReading();
            if (latest != null) {
                latestReadings.put(sensor, latest);
            }
        }
        return latestReadings;
    }
}
