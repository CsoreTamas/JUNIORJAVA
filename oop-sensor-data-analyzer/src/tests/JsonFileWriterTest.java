package tests;

import file.handling.AbstractExporter;
import file.handling.JsonExporter;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import sensor.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonFileWriterTest {
    List<Sensor> sensorList;

    @BeforeEach
    void setup() {
        sensorList = new ArrayList<>();

        AbstractSensor co2Kitchen = new CO2Sensor("Kitchen");
        co2Kitchen.addReading(new Reading(0.1, LocalTime.of(22, 0)));
        sensorList.add(co2Kitchen);

        AbstractSensor co2Garage = new CO2Sensor("Garage");
        co2Garage.addReading(new Reading(0.2, LocalTime.of(8, 0)));
        sensorList.add(co2Garage);

        AbstractSensor co2Toilet = new CO2Sensor("Toilet");
        co2Toilet.addReading(new Reading(0.32, LocalTime.of(18, 0)));
        sensorList.add(co2Toilet);

        AbstractSensor tempGarage = new TemperatureSensor("Garage");
        tempGarage.addReading(new Reading(24, LocalTime.of(8, 0)));
        sensorList.add(tempGarage);

        AbstractSensor tempInside = new TemperatureSensor("Inside");
        tempInside.addReading(new Reading(25, LocalTime.of(18, 0)));
        sensorList.add(tempInside);

        AbstractSensor tempOutside = new TemperatureSensor("Outside");
        tempOutside.addReading(new Reading(27, LocalTime.of(8, 0)));
        sensorList.add(tempOutside);

        AbstractSensor humGarage = new HumiditySensor("Garage");
        humGarage.addReading(new Reading(36.4, LocalTime.of(18, 0)));
        sensorList.add(humGarage);

        AbstractSensor humInside = new HumiditySensor("Inside");
        humInside.addReading(new Reading(40.4, LocalTime.of(18, 0)));
        sensorList.add(humInside);

        AbstractSensor humOutside = new HumiditySensor("Outside");
        humOutside.addReading(new Reading(50, LocalTime.of(8, 0)));
        sensorList.add(humOutside);
    }

    @Test
    void shouldWriteSensorsData(@TempDir Path tempDir) throws IOException {
        File tempFile = tempDir.resolve("sensors.json").toFile();

        AbstractExporter jsonExporter = new JsonExporter(tempFile.getAbsolutePath());

        jsonExporter.writeFile(sensorList, 0.0);

        List<String> actualJson = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(tempFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                actualJson.add(line.trim());
            }
        }

        List<String> expectedJson = List.of(
                "{",
                "\"sensors\":[",
                "{",
                "\"sensor.Sensor type\": \"CO2\",",
                "\"sensor.Sensor ID\": \"Kitchen\",",
                "\"Readings\": [",
                "{",
                "\"Value\": 0.1,",
                "\"Time\": \"22:00\"",
                "}",
                "]",
                "},",
                "{",
                "\"sensor.Sensor type\": \"CO2\",",
                "\"sensor.Sensor ID\": \"Garage\",",
                "\"Readings\": [",
                "{",
                "\"Value\": 0.2,",
                "\"Time\": \"08:00\"",
                "}",
                "]",
                "},",
                "{",
                "\"sensor.Sensor type\": \"CO2\",",
                "\"sensor.Sensor ID\": \"Toilet\",",
                "\"Readings\": [",
                "{",
                "\"Value\": 0.32,",
                "\"Time\": \"18:00\"",
                "}",
                "]",
                "},",
                "{",
                "\"sensor.Sensor type\": \"TEMPERATURE\",",
                "\"sensor.Sensor ID\": \"Garage\",",
                "\"Readings\": [",
                "{",
                "\"Value\": 24.0,",
                "\"Time\": \"08:00\"",
                "}",
                "]",
                "},",
                "{",
                "\"sensor.Sensor type\": \"TEMPERATURE\",",
                "\"sensor.Sensor ID\": \"Inside\",",
                "\"Readings\": [",
                "{",
                "\"Value\": 25.0,",
                "\"Time\": \"18:00\"",
                "}",
                "]",
                "},",
                "{",
                "\"sensor.Sensor type\": \"TEMPERATURE\",",
                "\"sensor.Sensor ID\": \"Outside\",",
                "\"Readings\": [",
                "{",
                "\"Value\": 27.0,",
                "\"Time\": \"08:00\"",
                "}",
                "]",
                "},",
                "{",
                "\"sensor.Sensor type\": \"HUMIDITY\",",
                "\"sensor.Sensor ID\": \"Garage\",",
                "\"Readings\": [",
                "{",
                "\"Value\": 36.4,",
                "\"Time\": \"18:00\"",
                "}",
                "]",
                "},",
                "{",
                "\"sensor.Sensor type\": \"HUMIDITY\",",
                "\"sensor.Sensor ID\": \"Inside\",",
                "\"Readings\": [",
                "{",
                "\"Value\": 40.4,",
                "\"Time\": \"18:00\"",
                "}",
                "]",
                "},",
                "{",
                "\"sensor.Sensor type\": \"HUMIDITY\",",
                "\"sensor.Sensor ID\": \"Outside\",",
                "\"Readings\": [",
                "{",
                "\"Value\": 50.0,",
                "\"Time\": \"08:00\"",
                "}",
                "]",
                "}",
                "],",
                "\"Sensors average\": [",
                "{",
                "\"sensor type\" : \"CO2\",",
                "\"sensor id\" : \"Kitchen\",",
                "\"data\" : {",
                "\"average\" : 0.1",
                "}",
                "},",
                "{",
                "\"sensor type\" : \"CO2\",",
                "\"sensor id\" : \"Garage\",",
                "\"data\" : {",
                "\"average\" : 0.2",
                "}",
                "},",
                "{",
                "\"sensor type\" : \"CO2\",",
                "\"sensor id\" : \"Toilet\",",
                "\"data\" : {",
                "\"average\" : 0.32",
                "}",
                "},",
                "{",
                "\"sensor type\" : \"TEMPERATURE\",",
                "\"sensor id\" : \"Garage\",",
                "\"data\" : {",
                "\"average\" : 24.0",
                "}",
                "},",
                "{",
                "\"sensor type\" : \"TEMPERATURE\",",
                "\"sensor id\" : \"Inside\",",
                "\"data\" : {",
                "\"average\" : 25.0",
                "}",
                "},",
                "{",
                "\"sensor type\" : \"TEMPERATURE\",",
                "\"sensor id\" : \"Outside\",",
                "\"data\" : {",
                "\"average\" : 27.0",
                "}",
                "},",
                "{",
                "\"sensor type\" : \"HUMIDITY\",",
                "\"sensor id\" : \"Garage\",",
                "\"data\" : {",
                "\"average\" : 36.4",
                "}",
                "},",
                "{",
                "\"sensor type\" : \"HUMIDITY\",",
                "\"sensor id\" : \"Inside\",",
                "\"data\" : {",
                "\"average\" : 40.4",
                "}",
                "},",
                "{",
                "\"sensor type\" : \"HUMIDITY\",",
                "\"sensor id\" : \"Outside\",",
                "\"data\" : {",
                "\"average\" : 50.0",
                "}",
                "}",
                "],",
                "\"Sensors above threshold\": [",
                "{",
                "\"sensor type\" : \"CO2\",",
                "\"above threshold\": [",
                "{",
                "\"sensor id\" : \"Kitchen\",",
                "\"value\" : 0.1",
                "},",
                "{",
                "\"sensor id\" : \"Garage\",",
                "\"value\" : 0.2",
                "},",
                "{",
                "\"sensor id\" : \"Toilet\",",
                "\"value\" : 0.32",
                "}",
                "]",
                "},",
                "",
                "{",
                "\"sensor type\" : \"TEMPERATURE\",",
                "\"above threshold\": [",
                "{",
                "\"sensor id\" : \"Garage\",",
                "\"value\" : 24.0",
                "},",
                "{",
                "\"sensor id\" : \"Inside\",",
                "\"value\" : 25.0",
                "},",
                "{",
                "\"sensor id\" : \"Outside\",",
                "\"value\" : 27.0",
                "}",
                "]",
                "},",
                "",
                "{",
                "\"sensor type\" : \"HUMIDITY\",",
                "\"above threshold\": [",
                "{",
                "\"sensor id\" : \"Garage\",",
                "\"value\" : 36.4",
                "},",
                "{",
                "\"sensor id\" : \"Inside\",",
                "\"value\" : 40.4",
                "},",
                "{",
                "\"sensor id\" : \"Outside\",",
                "\"value\" : 50.0",
                "}",
                "]",
                "}",
                "],",
                "\"Sensors with highest readings\": [",
                "{",
                "\"sensor type\" : \"CO2\",",
                "\"sensor id\" : \"Toilet\",",
                "\"reading\" : {",
                "\"highest\" : {",
                "\"value\": 0.32,",
                "\"time\" : \"18:00\"",
                "}",
                "}",
                "},",
                "{",
                "\"sensor type\" : \"TEMPERATURE\",",
                "\"sensor id\" : \"Outside\",",
                "\"reading\" : {",
                "\"highest\" : {",
                "\"value\": 27.0,",
                "\"time\" : \"08:00\"",
                "}",
                "}",
                "},",
                "{",
                "\"sensor type\" : \"HUMIDITY\",",
                "\"sensor id\" : \"Outside\",",
                "\"reading\" : {",
                "\"highest\" : {",
                "\"value\": 50.0,",
                "\"time\" : \"08:00\"",
                "}",
                "}",
                "}",
                "],",
                "\"Sensors latest readings\": [",
                "{",
                "\"sensor type\" : \"CO2\",",
                "\"sensor id\" : \"Kitchen\",",
                "\"reading\" : {",
                "\"value\" : 0.1,",
                "\"unit\" : \"kg\",",
                "\"time\" : \"22:00\"",
                "}",
                "},",
                "{",
                "\"sensor type\" : \"CO2\",",
                "\"sensor id\" : \"Garage\",",
                "\"reading\" : {",
                "\"value\" : 0.2,",
                "\"unit\" : \"kg\",",
                "\"time\" : \"08:00\"",
                "}",
                "},",
                "{",
                "\"sensor type\" : \"CO2\",",
                "\"sensor id\" : \"Toilet\",",
                "\"reading\" : {",
                "\"value\" : 0.32,",
                "\"unit\" : \"kg\",",
                "\"time\" : \"18:00\"",
                "}",
                "},",
                "{",
                "\"sensor type\" : \"TEMPERATURE\",",
                "\"sensor id\" : \"Garage\",",
                "\"reading\" : {",
                "\"value\" : 24.0,",
                "\"unit\" : \"°C\",",
                "\"time\" : \"08:00\"",
                "}",
                "},",
                "{",
                "\"sensor type\" : \"TEMPERATURE\",",
                "\"sensor id\" : \"Inside\",",
                "\"reading\" : {",
                "\"value\" : 25.0,",
                "\"unit\" : \"°C\",",
                "\"time\" : \"18:00\"",
                "}",
                "},",
                "{",
                "\"sensor type\" : \"TEMPERATURE\",",
                "\"sensor id\" : \"Outside\",",
                "\"reading\" : {",
                "\"value\" : 27.0,",
                "\"unit\" : \"°C\",",
                "\"time\" : \"08:00\"",
                "}",
                "},",
                "{",
                "\"sensor type\" : \"HUMIDITY\",",
                "\"sensor id\" : \"Garage\",",
                "\"reading\" : {",
                "\"value\" : 36.4,",
                "\"unit\" : \"%\",",
                "\"time\" : \"18:00\"",
                "}",
                "},",
                "{",
                "\"sensor type\" : \"HUMIDITY\",",
                "\"sensor id\" : \"Inside\",",
                "\"reading\" : {",
                "\"value\" : 40.4,",
                "\"unit\" : \"%\",",
                "\"time\" : \"18:00\"",
                "}",
                "},",
                "{",
                "\"sensor type\" : \"HUMIDITY\",",
                "\"sensor id\" : \"Outside\",",
                "\"reading\" : {",
                "\"value\" : 50.0,",
                "\"unit\" : \"%\",",
                "\"time\" : \"08:00\"",
                "}",
                "}",
                "]",
                "}"
        );

        SoftAssertions.assertSoftly(softly -> {
            for (int i = 0; i < expectedJson.size(); i++) {
                softly.assertThat(actualJson.get(i))
                        .as("Fail at line %d", i)
                        .isEqualTo(expectedJson.get(i));
            }
        });
    }
}
