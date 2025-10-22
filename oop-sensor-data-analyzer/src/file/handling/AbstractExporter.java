package file.handling;

import sensor.AbstractSensor;
import sensor.Sensor;
import sensor.SensorType;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class AbstractExporter {
    private final String fileName;

    AbstractExporter(String fileName) {
        this.fileName = fileName;
    }

    public void writeFile(List<Sensor> sensors, double threshold) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            writeSensors(fileWriter, sensors);
            writeAverage(fileWriter, sensors);
            writeSensorAboveThreshold(fileWriter, sensors, threshold);
            writeSensorsWithHighestLatestReading(fileWriter, sensors);
            writeLatestReading(fileWriter, sensors);
        }
    }

    public String getUnit(SensorType sensorType) {
        return switch (sensorType) {
            case SensorType.TEMPERATURE -> "°C";
            case SensorType.HUMIDITY -> "%";
            case SensorType.CO2 -> "kg";
        };
    }

    abstract void writeSensors(FileWriter fileWriter, List<Sensor> sensors) throws IOException;

    abstract void writeAverage(FileWriter fileWriter, List<Sensor> sensors) throws IOException;

    abstract void writeSensorAboveThreshold(FileWriter fileWriter, List<Sensor> sensors, double threshold) throws IOException;

    abstract void writeSensorsWithHighestLatestReading(FileWriter fileWriter, List<Sensor> sensors) throws IOException;

    abstract void writeLatestReading(FileWriter fileWriter, List<Sensor> sensors) throws IOException;
}
