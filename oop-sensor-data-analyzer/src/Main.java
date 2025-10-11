import sensor.AbstractSensor;
import filehandeling.CsvExporter;
import filehandeling.FilePropertyLoader;
import filehandeling.JsonExporter;
import sensor.SensorFactory;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FilePropertyLoader fileLoader = new FilePropertyLoader();
        List<AbstractSensor> sensorList = SensorFactory.createSensors();

        if (fileLoader.getExportFormat().equals("json")) {
            new JsonExporter(fileLoader.getExportFileName()).writeFile(sensorList, 0);
        } else if (fileLoader.getExportFormat().equals("csv")) {
            new CsvExporter(fileLoader.getExportFileName()).writeFile(sensorList, 0);
        }

/*
        for (sensor.AbstractSensor sensor : sensorList) {
            System.out.println(sensor);
        }

        double tempAverage = sensor.SensorAnalyzer.getAverageOfReadings(sensor.SensorFactory.tempInSide);
        System.out.printf("%s in side: %.2f°C%n", sensor.SensorFactory.tempInSide.getSensorType(), tempAverage);

        double humAverage = sensor.SensorAnalyzer.getAverageOfReadings(sensor.SensorFactory.humGarage);
        System.out.printf("%s garage: %.2f%%%n", sensor.SensorFactory.humGarage.getSensorType(), humAverage);

        double co2Average = sensor.SensorAnalyzer.getAverageOfReadings(sensor.SensorFactory.co2Toilet);
        System.out.printf("%s toilet: %.2fkg%n", sensor.SensorFactory.co2Toilet.getSensorType(), co2Average);

        System.out.println("threshold humidity");
        List<sensor.AbstractSensor> thresholdSensorsHumidity = sensor.SensorAnalyzer.getSensorsAboveSThreshold(sensorList, 55, sensor.SensorType.HUMIDITY);
        for (
                sensor.AbstractSensor sensor : thresholdSensorsHumidity) {
            System.out.println(sensor);
        }

        System.out.println("threshold temperature");
        List<sensor.AbstractSensor> thresholdSensorsTemperature = sensor.SensorAnalyzer.getSensorsAboveSThreshold(sensorList, 20, sensor.SensorType.TEMPERATURE);
        for (sensor.AbstractSensor sensor : thresholdSensorsTemperature) {
            System.out.println(sensor);
        }

        System.out.println("threshold co2");
        List<sensor.AbstractSensor> thresholdSensorsCO2 = sensor.SensorAnalyzer.getSensorsAboveSThreshold(sensorList, 0.2, sensor.SensorType.CO2);
        for (sensor.AbstractSensor sensor : thresholdSensorsCO2) {
            System.out.println(sensor);
        }

        System.out.println("highest hum sensor");
        sensor.AbstractSensor highestSensorsHum = sensor.SensorAnalyzer.getSensorWithHighestLatestReading(sensorList, sensor.SensorType.HUMIDITY);
        System.out.println(highestSensorsHum);

        System.out.println("highest temp sensor");
        sensor.AbstractSensor highestSensorsTemp = sensor.SensorAnalyzer.getSensorWithHighestLatestReading(sensorList, sensor.SensorType.TEMPERATURE);
        System.out.println(highestSensorsTemp);

        System.out.println("highest co2 sensor");
        sensor.AbstractSensor highestSensorCO2 = sensor.SensorAnalyzer.getSensorWithHighestLatestReading(sensorList, sensor.SensorType.CO2);
        System.out.println(highestSensorCO2);

        System.out.println("get latest reading hum");
        Map<sensor.SensorType, sensor.Reading> humLatestRead = sensor.SensorAnalyzer.getLatestReadingsGroupedByType(sensorList, sensor.SensorType.HUMIDITY);
        System.out.println(humLatestRead);

        System.out.println("get latest reading temp");
        Map<sensor.SensorType, sensor.Reading> tempLatestRead = sensor.SensorAnalyzer.getLatestReadingsGroupedByType(sensorList, sensor.SensorType.TEMPERATURE);
        System.out.println(tempLatestRead);

        System.out.println("get latest reading co2");
        Map<sensor.SensorType, sensor.Reading> co2LatestRead = sensor.SensorAnalyzer.getLatestReadingsGroupedByType(sensorList, sensor.SensorType.CO2);
        System.out.println(co2LatestRead);


        filehandeling.CsvExporter csvExport = new filehandeling.CsvExporter("src/resources/application.properties");
        csvExport.writeCsvFiles(sensorList, 0.2);

        filehandeling.JsonExporter jsonExport = new filehandeling.JsonExporter("src/resources/json");
        jsonExport.writeJson(sensorList, 0.2);
         */
    }
}