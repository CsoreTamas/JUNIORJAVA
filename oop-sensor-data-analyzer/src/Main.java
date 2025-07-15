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
        for (AbstractSensor sensor : sensorList) {
            System.out.println(sensor);
        }

        double tempAverage = SensorAnalyzer.getAverageOfReadings(SensorFactory.tempInSide);
        System.out.printf("%s in side: %.2f°C%n", SensorFactory.tempInSide.getSensorType(), tempAverage);

        double humAverage = SensorAnalyzer.getAverageOfReadings(SensorFactory.humGarage);
        System.out.printf("%s garage: %.2f%%%n", SensorFactory.humGarage.getSensorType(), humAverage);

        double co2Average = SensorAnalyzer.getAverageOfReadings(SensorFactory.co2Toilet);
        System.out.printf("%s toilet: %.2fkg%n", SensorFactory.co2Toilet.getSensorType(), co2Average);

        System.out.println("threshold humidity");
        List<AbstractSensor> thresholdSensorsHumidity = SensorAnalyzer.getSensorsAboveSThreshold(sensorList, 55, SensorType.HUMIDITY);
        for (
                AbstractSensor sensor : thresholdSensorsHumidity) {
            System.out.println(sensor);
        }

        System.out.println("threshold temperature");
        List<AbstractSensor> thresholdSensorsTemperature = SensorAnalyzer.getSensorsAboveSThreshold(sensorList, 20, SensorType.TEMPERATURE);
        for (AbstractSensor sensor : thresholdSensorsTemperature) {
            System.out.println(sensor);
        }

        System.out.println("threshold co2");
        List<AbstractSensor> thresholdSensorsCO2 = SensorAnalyzer.getSensorsAboveSThreshold(sensorList, 0.2, SensorType.CO2);
        for (AbstractSensor sensor : thresholdSensorsCO2) {
            System.out.println(sensor);
        }

        System.out.println("highest hum sensor");
        AbstractSensor highestSensorsHum = SensorAnalyzer.getSensorWithHighestLatestReading(sensorList, SensorType.HUMIDITY);
        System.out.println(highestSensorsHum);

        System.out.println("highest temp sensor");
        AbstractSensor highestSensorsTemp = SensorAnalyzer.getSensorWithHighestLatestReading(sensorList, SensorType.TEMPERATURE);
        System.out.println(highestSensorsTemp);

        System.out.println("highest co2 sensor");
        AbstractSensor highestSensorCO2 = SensorAnalyzer.getSensorWithHighestLatestReading(sensorList, SensorType.CO2);
        System.out.println(highestSensorCO2);

        System.out.println("get latest reading hum");
        Map<SensorType, Reading> humLatestRead = SensorAnalyzer.getLatestReadingsGroupedByType(sensorList, SensorType.HUMIDITY);
        System.out.println(humLatestRead);

        System.out.println("get latest reading temp");
        Map<SensorType, Reading> tempLatestRead = SensorAnalyzer.getLatestReadingsGroupedByType(sensorList, SensorType.TEMPERATURE);
        System.out.println(tempLatestRead);

        System.out.println("get latest reading co2");
        Map<SensorType, Reading> co2LatestRead = SensorAnalyzer.getLatestReadingsGroupedByType(sensorList, SensorType.CO2);
        System.out.println(co2LatestRead);


        CsvExporter csvExport = new CsvExporter("src/resources/application.properties");
        csvExport.writeCsvFiles(sensorList, 0.2);

        JsonExporter jsonExport = new JsonExporter("src/resources/json");
        jsonExport.writeJson(sensorList, 0.2);
         */
    }
}