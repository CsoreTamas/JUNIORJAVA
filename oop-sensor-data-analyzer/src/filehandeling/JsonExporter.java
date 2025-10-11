package filehandeling;

import sensor.AbstractSensor;
import sensor.Reading;
import sensor.SensorAnalyzer;
import sensor.SensorType;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonExporter extends AbstractExporter {

    public JsonExporter(String fileName) {
        super(fileName);
    }

    @Override
    void writeSensors(FileWriter fileWriter, List<AbstractSensor> sensors) throws IOException {
        fileWriter.write("{\n");
        fileWriter.write("   \"sensors\":[\n");
        for (int i = 0; i < sensors.size(); i++) {
            AbstractSensor sensor = sensors.get(i);
            fileWriter.write("       {\n");
            fileWriter.write("         \"sensor.Sensor type\": \"" + sensor.getSensorType() + "\",\n");
            fileWriter.write("         \"sensor.Sensor ID\": \"" + sensor.getId() + "\",\n");
            fileWriter.write("         \"Readings\": [\n");
            List<Reading> readings = sensor.getReadings();
            for (int j = 0; j < readings.size(); j++) {
                Reading reading = readings.get(j);

                fileWriter.write("            {\n                \"Value\": " + reading.reading() + ",\n");
                fileWriter.write("                \"Time\": \"" + reading.timestamp() + "\" \n            }");
                if (j != readings.size() - 1) {
                    fileWriter.write(", ");
                }
                fileWriter.write("\n");
            }
            fileWriter.write("       ]\n");
            fileWriter.write("     }");
            if (i != sensors.size() - 1) {
                fileWriter.write(", ");
            }
            fileWriter.write("\n");
        }
        fileWriter.write("  ],\n");
    }

    @Override
    void writeAverage(FileWriter fileWriter, List<AbstractSensor> sensorList) throws IOException {
        fileWriter.write("\"Sensors average\": [\n");
        for (int i = 0; i < sensorList.size(); i++) {
            AbstractSensor sensor = sensorList.get(i);
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

    @Override
    void writeSensorAboveThreshold(FileWriter fileWriter, List<AbstractSensor> sensorList, double threshold) throws IOException {
        fileWriter.write("\"Sensors above threshold\": [\n");
        SensorType[] types = SensorType.values();
        for (int i = 0; i < types.length; i++) {
            SensorType type = types[i];
            List<AbstractSensor> aboveThreshold = SensorAnalyzer.getSensorsAboveSThreshold(sensorList, threshold, type);
            fileWriter.write("  {\n");
            fileWriter.write("    \"sensor type\" : " + "\"" + type + "\",\n");
            fileWriter.write("    \"above threshold\": [\n");
            for (int j = 0; j < aboveThreshold.size(); j++) {
                AbstractSensor sensor = aboveThreshold.get(j);
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

    @Override
    void writeSensorsWithHighestLatestReading(FileWriter fileWriter, List<AbstractSensor> sensorList) throws IOException {
        fileWriter.write("\"Sensors with highest readings\": [\n");
        SensorType[] types = SensorType.values();
        for (int i = 0; i < types.length; i++) {
            SensorType type = types[i];
            AbstractSensor sensor = SensorAnalyzer.getSensorWithHighestLatestReading(sensorList, type);

            fileWriter.write("   {\n");
            fileWriter.write("    \"sensor type\" : " + "\"" + sensor.getSensorType() + "\",\n");
            fileWriter.write("    \"sensor id\" : " + "\"" + sensor.getId() + "\",\n");
            fileWriter.write("    \"reading\" : {\n");
            List<Reading> reading = sensor.getReadings();
            fileWriter.write("        \"highest\" : {\n");
            fileWriter.write("              \"value\": " + reading.getFirst().reading() + ",\n");
            fileWriter.write("              \"time\" : " + "\"" + reading.getFirst().timestamp().toString() + "\"" + "\n");
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

    @Override
    void writeLatestReading(FileWriter fileWriter, List<AbstractSensor> sensorList) throws IOException {
        fileWriter.write("\"Sensors latest readings\": [\n");
        SensorType[] types = SensorType.values();
        boolean first = true;


            Map<AbstractSensor, Reading> latestReadings = SensorAnalyzer.getLatestReadingsGroupedByType(sensorList);

            for (Map.Entry<AbstractSensor, Reading> entry : latestReadings.entrySet()) {
                AbstractSensor key = entry.getKey();
                Reading reading = entry.getValue();
                String unit = getUnit(key.getSensorType());

                if (!first) {
                    fileWriter.write(",\n");
                } else {
                    first = false;
                }

                fileWriter.write("  {\n");
                fileWriter.write("    \"sensor type\" : " + "\"" + key.getSensorType() + "\",\n");
                fileWriter.write("    \"sensor id\" : " + "\"" + key.getId() + "\",\n");
                fileWriter.write("       \"reading\" : {" + "\n");
                fileWriter.write("          \"value\" : " + reading.reading() + ",\n");
                fileWriter.write("          \"unit\" : \"" + unit + "\",\n");
                fileWriter.write("          \"time\" : \"" + reading.timestamp() + "\"\n");
                fileWriter.write("        }\n");
                fileWriter.write("  }");
            }

        fileWriter.write("\n");
        fileWriter.write("]\n");
        fileWriter.write("}");
    }
}