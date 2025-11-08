import file.handling.CsvExporter;
import file.handling.FilePropertyLoader;
import file.handling.JsonExporter;
import sensor.Sensor;
import sensor.SensorFactory;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FilePropertyLoader fileLoader = new FilePropertyLoader();
        List<Sensor> sensorList = SensorFactory.createSensors();

        if (fileLoader.getExportFormat().equals("json")) {
            new JsonExporter(fileLoader.getExportFileName()).writeFile(sensorList, 0);
        } else if (fileLoader.getExportFormat().equals("csv")) {
            new CsvExporter(fileLoader.getExportFileName()).writeFile(sensorList, 0);
        }
    }
}