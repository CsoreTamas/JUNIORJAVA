import java.io.IOException;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class CsvExporter {
    private final String fileName;

    public CsvExporter(String fileName) {
        this.fileName = fileName;
    }

    public void writeCsv(List<AbstractSensor> sensors, double threshold) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            writeReadingsCsv(fileWriter, sensors);
            writeAveragesCsv(fileWriter, sensors);
            writeSensorsAboveThreshold(fileWriter, sensors, threshold);
            writeHighestReadingCsv(fileWriter, sensors);
            writeLatestReadingCsv(fileWriter, sensors);
        }
    }

    private void writeReadingsCsv(FileWriter fileWriter, List<AbstractSensor> sensors) throws IOException {
        fileWriter.write("SensorType|SensorID|ReadingValue|ReadingTime" + "\n");

        for (AbstractSensor sensor : sensors) {
            fileWriter.write("\n");
            for (Reading reading : sensor.getReadings()) {
                String line = String.format("%s|%s|%.2f|%s %n", sensor.getSensorType(), sensor.getId(), reading.getReading(), reading.getTimestamp());
                fileWriter.write(line);
            }
        }
    }

    private void writeAveragesCsv(FileWriter fileWriter, List<AbstractSensor> sensors) throws IOException {
        fileWriter.write("\nAverage of readings: \n");
        for (AbstractSensor sensor : sensors) {
            double average = SensorAnalyzer.getAverageOfReadings(sensor);
            String unit = getUnit(sensor.getSensorType());
            fileWriter.write(String.format("AVERAGE: %s|%s|%.2f%s \n", sensor.getSensorType(), sensor.getId(), average, unit));
        }
    }

    private void writeSensorsAboveThreshold(FileWriter fileWriter, List<AbstractSensor> sensors, double threshold) throws IOException {
        fileWriter.write("\nSensors above threshold: \n");
        SensorType[] types = SensorType.values();
        for (SensorType type : types) {
            List<AbstractSensor> sensorsAboveThreshold = SensorAnalyzer.getSensorsAboveSThreshold(sensors, threshold, type);
            for (AbstractSensor sensor : sensorsAboveThreshold) {
                String unit = getUnit(type);
                fileWriter.write(String.format("%s: %s %s %s\n", sensor.getSensorType(), sensor.getId(), sensor.getReadings(), unit));
            }
        }
    }

    private void writeHighestReadingCsv(FileWriter fileWriter, List<AbstractSensor> sensors) throws IOException {
        fileWriter.write("\nHighest latest readings :\n");
        for (SensorType type : SensorType.values()) {
            AbstractSensor highestSensor = SensorAnalyzer.getSensorWithHighestLatestReading(sensors, type);
            String unit = getUnit(type);
            fileWriter.write(String.format("%s%s\n", highestSensor, unit));
        }
    }

    private void writeLatestReadingCsv(FileWriter fileWriter, List<AbstractSensor> sensors) throws IOException {
        fileWriter.write("\nLatest readings :\n");
        for (SensorType type : SensorType.values()) {
            Map<SensorType, Reading> latestReadings = SensorAnalyzer.getLatestReadingsGroupedByType(sensors, type);
            fileWriter.write(String.format("%s\n", latestReadings));
        }
    }

    private String getUnit(SensorType sensorType) {
        String unit = "";
        return switch (sensorType) {
            case TEMPERATURE -> unit = "°C";
            case HUMIDITY -> unit = "%";
            case CO2 -> unit = "kg";
        };
    }
}