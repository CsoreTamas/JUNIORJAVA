package file.handling;

import sensor.*;

import java.io.IOException;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

public class CsvExporter extends AbstractExporter {

    public CsvExporter(String fileName) {
        super(fileName);
    }

    @Override
    void writeSensors(FileWriter fileWriter, List<Sensor> sensors) throws IOException {
        fileWriter.write("sensor.SensorType|SensorID|ReadingValue|ReadingTime" + "\n");
        for (Sensor sensor : sensors) {
            String unit = getUnit(sensor.getSensorType());
            fileWriter.write("\n");
            for (Reading reading : sensor.getReadings()) {
                fileWriter.write(String.format("%s|%s|%.2f%s|%s %n",
                        sensor.getSensorType(),
                        sensor.getId(),
                        reading.reading(),
                        unit,
                        reading.timestamp()));
            }
        }
    }

    @Override
    void writeAverage(FileWriter fileWriter, List<Sensor> sensors) throws IOException {
        fileWriter.write("\nAverage of readings: \n");
        for (Sensor sensor : sensors) {
            double average = SensorAnalyzer.getAverageOfReadings(sensor);
            String unit = getUnit(sensor.getSensorType());
            fileWriter.write(String.format("%s|%s|%.2f%s \n",
                    sensor.getSensorType(),
                    sensor.getId(),
                    average,
                    unit));
        }
    }

    @Override
    void writeSensorAboveThreshold(FileWriter fileWriter, List<Sensor> sensors, double threshold) throws IOException {
        fileWriter.write("\nSensors above threshold: \n");


        for (Sensor sensor : sensors) {
            String unit = getUnit(sensor.getSensorType());
            for (Reading reading : sensor.getReadings()) {
                double value = reading.reading();
                String formatedReading = String.format("%.2f", value);
                if (value > threshold) {
                    fileWriter.write(String.format("%s|%s|%s%s|%s\n",
                            sensor.getSensorType(),
                            sensor.getId(),
                            formatedReading,
                            unit,
                            reading.timestamp()));
                }
            }
        }
    }

    @Override
    void writeSensorsWithHighestLatestReading(FileWriter fileWriter, List<Sensor> sensors) throws IOException {
        fileWriter.write("\nHighest latest readings :\n");
        for (SensorType type : SensorType.values()) {
            String unit = getUnit(type);

            Sensor highestSensor = SensorAnalyzer.getSensorWithHighestLatestReading(sensors, type);
            for (Reading reading : highestSensor.getReadings()) {
                double value = reading.reading();
                String formatedReading = String.format("%.2f", value);
                fileWriter.write(String.format("%s|%s|%s%s|%s\n",
                        highestSensor.getSensorType(),
                        highestSensor.getId(),
                        formatedReading,
                        unit,
                        reading.timestamp()));
            }
        }
    }

    @Override
    void writeLatestReading(FileWriter fileWriter, List<Sensor> sensors) throws IOException {
        fileWriter.write("\nLatest readings :\n");

        Map<Sensor, Reading> latestReadings = SensorAnalyzer.getLatestReadingsGroupedByType(sensors);

        for (Map.Entry<Sensor, Reading> entry : latestReadings.entrySet()) {
            Sensor sensor = entry.getKey();
            Reading reading = entry.getValue();

            String formatedReading = String.format("%.2f", reading.reading());
            String unit = getUnit(sensor.getSensorType());

            fileWriter.write(String.format("%s|%s|%s%s|%s\n",
                    sensor.getSensorType(),
                    sensor.getId(),
                    formatedReading,
                    unit,
                    reading.timestamp()));
        }
    }
}


