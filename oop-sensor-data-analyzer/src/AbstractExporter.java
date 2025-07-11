import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class AbstractExporter {
    private final String fileName;

    AbstractExporter(String fileName) {
        this.fileName = fileName;
    }

    public void writeFile(List<AbstractSensor> sensors, double threshold) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            writeSensors(fileWriter, sensors);
            writeAverage(fileWriter, sensors);
            writeSensorAboveThreshold(fileWriter, sensors, threshold);
            writeSensorsWithHighestLatestReading(fileWriter, sensors);
            writeLatestReading(fileWriter, sensors);
        }
    }

    abstract void writeSensors(FileWriter fileWriter, List<AbstractSensor> sensors) throws IOException;

    abstract void writeAverage(FileWriter fileWriter, List<AbstractSensor> sensors) throws IOException;

    abstract void writeSensorAboveThreshold(FileWriter fileWriter, List<AbstractSensor> sensors, double threshold) throws IOException;

    abstract void writeSensorsWithHighestLatestReading(FileWriter fileWriter, List<AbstractSensor> sensors) throws IOException;

    abstract void writeLatestReading(FileWriter fileWriter, List<AbstractSensor> sensors) throws IOException;
}
