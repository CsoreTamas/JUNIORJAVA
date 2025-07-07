import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonExport {
    private final String fileName;


    public JsonExport(String fileName) {
        this.fileName = fileName;
    }

    public void writeJson(List<Sensor> sensors, double threshold) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            writeSensorsJson(fileWriter, sensors);
            writeAverageJson(fileWriter, sensors);
            writeSensorAboveThresholdJson(fileWriter, sensors, threshold);
            writeSensorsWithHighestLatestReadingJson(fileWriter, sensors);
            writeLatestReadingJson(fileWriter, sensors);
        }
    }

    private void writeSensorsJson(FileWriter fileWriter, List<Sensor> sensorsList) throws IOException {
        fileWriter.write("{\n");
        fileWriter.write("   \"sensors\":[\n");
        for (int i = 0; i < sensorsList.size(); i++) {
            Sensor sensor = sensorsList.get(i);
            fileWriter.write("       {\n");
            fileWriter.write("         \"Sensor type\": \"" + sensor.getSensorType() + "\",\n");
            fileWriter.write("         \"Sensor ID\": \"" + sensor.getId() + "\",\n");
            fileWriter.write("         \"Readings\": [\n");
            List<Reading> readings = sensor.getReadings();
            for (int j = 0; j < readings.size(); j++) {
                Reading reading = readings.get(j);

                fileWriter.write("            {\n                \"Value\": " + reading.getReading() + ",\n");
                fileWriter.write("                \"Time\": \"" + reading.getTimestamp() + "\" \n            }");
                if (j != readings.size() - 1) {
                    fileWriter.write(", ");
                }
                fileWriter.write("\n");
            }
            fileWriter.write("       ]\n");
            fileWriter.write("     }");
            if (i != sensorsList.size() - 1) {
                fileWriter.write(", ");
            }
            fileWriter.write("\n");
        }
        fileWriter.write("  ],\n");
    }

    private void writeAverageJson(FileWriter fileWriter, List<Sensor> sensorList) throws IOException {
        fileWriter.write("\"Sensors average\": [\n");
        for (int i = 0; i < sensorList.size(); i++) {
            Sensor sensor = sensorList.get(i);
            fileWriter.write("  {\n");
            fileWriter.write("    \"sensor type\" : " + "\"" + sensor.getSensorType() + "\",\n");
            fileWriter.write("    \"sensor id\" : " + "\"" + sensor.getId() + "\",\n");
            fileWriter.write("    \"data\" : {\n");
            fileWriter.write("        \"average\" : " + SensorAnalyzer.getAverageOfReadings(sensor) + "\n");
            fileWriter.write("       }\n");
            fileWriter.write("  }");
            if (i != sensorList.size() - 1) {
                fileWriter.write(", \n");
            }
        }
        fileWriter.write("\n");
        fileWriter.write("],\n");
    }

    private void writeSensorAboveThresholdJson(FileWriter fileWriter, List<Sensor> sensorList, double threshold) throws IOException {

        fileWriter.write("\"Sensors above threshold\": [\n");
        SensorType[] types = SensorType.values();
        for (int i = 0; i < types.length; i++) {
            SensorType type = types[i];
            List<Sensor> aboveThreshold = SensorAnalyzer.getSensorsAboveSThreshold(sensorList, threshold, type);
            fileWriter.write("  {\n");
            fileWriter.write("    \"sensor type\" : " + "\"" + type + "\",\n");
            fileWriter.write("    \"above threshold\": [\n");
            for (int j = 0; j < aboveThreshold.size(); j++) {
                Sensor sensor = aboveThreshold.get(j);
                fileWriter.write("       {\n");
                fileWriter.write("         \"sensor id\" : " + "\"" + sensor.getId() + "\",\n");
                fileWriter.write("         \"value\" : " + sensor.getLatestReadingValue() + "\n");
                fileWriter.write("       }");
                if (j != aboveThreshold.size() - 1) {
                    fileWriter.write(",");
                }
                fileWriter.write("\n");
            }
            fileWriter.write("     ]\n");
            fileWriter.write("   }");
            if (i != types.length - 1) {
                fileWriter.write(",\n");
            }
            fileWriter.write("\n");
        }
        fileWriter.write("],\n");
    }

    private void writeSensorsWithHighestLatestReadingJson(FileWriter fileWriter, List<Sensor> sensorList) throws IOException {
        fileWriter.write("\"Sensors with highest readings\": [\n");
        SensorType[] types = SensorType.values();
        for (int i = 0; i < types.length; i++) {
            SensorType type = types[i];
            Sensor sensor = SensorAnalyzer.getSensorWithHighestLatestReading(sensorList, type);

            fileWriter.write("   {\n");
            fileWriter.write("    \"sensor type\" : " + "\"" + sensor.getSensorType() + "\",\n");
            fileWriter.write("    \"sensor id\" : " + "\"" + sensor.getId() + "\",\n");
            fileWriter.write("    \"reading\" : {\n");
            List<Reading> reading = sensor.getReadings();
            fileWriter.write("        \"highest\" : {\n");
            fileWriter.write("              \"value\": " + reading.getFirst().getReading() + ",\n");
            fileWriter.write("              \"time\" : " + "\"" + reading.getFirst().getTimestamp().toString() + "\"" + "\n");
            fileWriter.write("               }\n");
            fileWriter.write("        }\n");
            fileWriter.write("   }");

            if (i != types.length - 1) {
                fileWriter.write(", \n");
            }
        }
        fileWriter.write("\n");
        fileWriter.write("],\n");
    }

    private void writeLatestReadingJson(FileWriter fileWriter, List<Sensor> sensorList) throws IOException {
        fileWriter.write("\"Sensors latest readings\": [\n");
        SensorType[] types = SensorType.values();
        for (int i = 0; i < types.length; i++) {
            SensorType type = types[i];
            Map<SensorType, Reading> latestReadings = SensorAnalyzer.getLatestReadingsGroupedByType(sensorList, type);

            fileWriter.write("    {\n");
            fileWriter.write("    \"sensor type\" : " + "\"" + type + "\",\n");
            fileWriter.write("       \"reading\" : {" + "\n");

            //Map.Entry<> entry : xy.entrySet used for getting the Map 'Key' and the 'Value'!! 
            for (Map.Entry<SensorType, Reading> entry : latestReadings.entrySet()) {
                SensorType key = entry.getKey();
                Reading reading = entry.getValue();

                fileWriter.write("           \"latest\" : \"" + key + "\",\n");
                fileWriter.write("           \"time\" : \"" + reading.getTimestamp().toString() + "\"\n");
                fileWriter.write("        }\n");
                fileWriter.write("  }");
            }
            if (i != types.length - 1) {
                fileWriter.write(",\n");
            }
        }
        fileWriter.write("\n");
        fileWriter.write("]\n");
        fileWriter.write("}");
    }
}

