package tests;

import filehandeling.AbstractExporter;
import filehandeling.CsvExporter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import sensor.*;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CsvFileWriterTest {
    private List<AbstractSensor> sensorList;

    @BeforeEach
    void setup() {
        sensorList = new ArrayList<>();

        AbstractSensor co2Kitchen = new CO2Sensor("Kitchen");
        co2Kitchen.addReading(new Reading(0.1, LocalTime.of(8, 0)));
        co2Kitchen.addReading(new Reading(0.3, LocalTime.of(18, 0)));
        sensorList.add(co2Kitchen);

        AbstractSensor co2Garage = new CO2Sensor("Garage");
        co2Garage.addReading(new Reading(0.2, LocalTime.of(8, 0)));
        co2Garage.addReading(new Reading(0.15, LocalTime.of(18, 0)));
        sensorList.add(co2Garage);

        AbstractSensor co2Toilet = new CO2Sensor("Toilet");
        co2Toilet.addReading(new Reading(0.18, LocalTime.of(8, 0)));
        co2Toilet.addReading(new Reading(0.32, LocalTime.of(18, 0)));
        sensorList.add(co2Toilet);

        AbstractSensor tempGarage = new TemperatureSensor("Garage");
        tempGarage.addReading(new Reading(24, LocalTime.of(8, 0)));
        tempGarage.addReading(new Reading(30, LocalTime.of(18, 0)));
        sensorList.add(tempGarage);

        AbstractSensor tempInside = new TemperatureSensor("Inside");
        tempInside.addReading(new Reading(20, LocalTime.of(8, 0)));
        tempInside.addReading(new Reading(25, LocalTime.of(18, 0)));
        sensorList.add(tempInside);

        AbstractSensor tempOutside = new TemperatureSensor("Outside");
        tempOutside.addReading(new Reading(27, LocalTime.of(8, 0)));
        tempOutside.addReading(new Reading(35, LocalTime.of(18, 0)));
        sensorList.add(tempOutside);

        AbstractSensor humGarage = new HumiditySensor("Garage");
        humGarage.addReading(new Reading(34, LocalTime.of(8, 0)));
        humGarage.addReading(new Reading(36.4, LocalTime.of(18, 0)));
        sensorList.add(humGarage);

        AbstractSensor humInside = new HumiditySensor("Inside");
        humInside.addReading(new Reading(30, LocalTime.of(8, 0)));
        humInside.addReading(new Reading(40.4, LocalTime.of(18, 0)));
        sensorList.add(humInside);

        AbstractSensor humOutside = new HumiditySensor("Outside");
        humOutside.addReading(new Reading(50, LocalTime.of(8, 0)));
        humOutside.addReading(new Reading(55.3, LocalTime.of(18, 0)));
        sensorList.add(humOutside);
    }

    @Test
    void shouldWriteSensorsData(@TempDir Path tempDir) throws IOException {
        File tempFile = tempDir.resolve("sensors.csv").toFile();

        AbstractExporter csvExporter = new CsvExporter(tempFile.getAbsolutePath());

        csvExporter.writeFile(sensorList, 0.01);

        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(tempFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        }

        assertFalse(lines.isEmpty());
        assertEquals("sensor.SensorType|SensorID|ReadingValue|ReadingTime", lines.getFirst());
        assertTrue(lines.get(1).isEmpty());
        assertEquals("CO2|Kitchen|0,10kg|08:00 ", lines.get(2));
        assertEquals("CO2|Kitchen|0,30kg|18:00 ", lines.get(3));
        assertTrue(lines.get(4).isEmpty());
        assertEquals("CO2|Garage|0,20kg|08:00 ", lines.get(5));
        assertEquals("CO2|Garage|0,15kg|18:00 ", lines.get(6));
        assertTrue(lines.get(7).isEmpty());
        assertEquals("CO2|Toilet|0,18kg|08:00 ", lines.get(8));
        assertEquals("CO2|Toilet|0,32kg|18:00 ", lines.get(9));
        assertTrue(lines.get(10).isEmpty());
        assertEquals("TEMPERATURE|Garage|24,00°C|08:00 ", lines.get(11));
        assertEquals("TEMPERATURE|Garage|30,00°C|18:00 ", lines.get(12));
        assertTrue(lines.get(13).isEmpty());
        assertEquals("TEMPERATURE|Inside|20,00°C|08:00 ", lines.get(14));
        assertEquals("TEMPERATURE|Inside|25,00°C|18:00 ", lines.get(15));
        assertTrue(lines.get(16).isEmpty());
        assertEquals("TEMPERATURE|Outside|27,00°C|08:00 ", lines.get(17));
        assertEquals("TEMPERATURE|Outside|35,00°C|18:00 ", lines.get(18));
        assertTrue(lines.get(19).isEmpty());
        assertEquals("HUMIDITY|Garage|34,00%|08:00 ", lines.get(20));
        assertEquals("HUMIDITY|Garage|36,40%|18:00 ", lines.get(21));
        assertTrue(lines.get(22).isEmpty());
        assertEquals("HUMIDITY|Inside|30,00%|08:00 ", lines.get(23));
        assertEquals("HUMIDITY|Inside|40,40%|18:00 ", lines.get(24));
        assertTrue(lines.get(25).isEmpty());
        assertEquals("HUMIDITY|Outside|50,00%|08:00 ", lines.get(26));
        assertEquals("HUMIDITY|Outside|55,30%|18:00 ", lines.get(27));
        assertTrue(lines.get(28).isEmpty());
        assertEquals("Average of readings: ", lines.get(29));
        assertEquals("CO2|Kitchen|0,20kg ", lines.get(30));
        assertEquals("CO2|Garage|0,18kg ", lines.get(31));
        assertEquals("CO2|Toilet|0,25kg ", lines.get(32));
        assertEquals("TEMPERATURE|Garage|27,00°C ", lines.get(33));
        assertEquals("TEMPERATURE|Inside|22,50°C ", lines.get(34));
        assertEquals("TEMPERATURE|Outside|31,00°C ", lines.get(35));
        assertEquals("HUMIDITY|Garage|35,20% ", lines.get(36));
        assertEquals("HUMIDITY|Inside|35,20% ", lines.get(37));
        assertEquals("HUMIDITY|Outside|52,65% ", lines.get(38));
        assertTrue(lines.get(39).isEmpty());
        assertEquals("Sensors above threshold: ", lines.get(40));
        assertEquals("CO2|Kitchen|0,10kg|08:00", lines.get(41));
        assertEquals("CO2|Kitchen|0,30kg|18:00", lines.get(42));
        assertEquals("CO2|Garage|0,20kg|08:00", lines.get(43));
        assertEquals("CO2|Garage|0,15kg|18:00", lines.get(44));
        assertEquals("CO2|Toilet|0,18kg|08:00", lines.get(45));
        assertEquals("CO2|Toilet|0,32kg|18:00", lines.get(46));
        assertEquals("TEMPERATURE|Garage|24,00°C|08:00", lines.get(47));
        assertEquals("TEMPERATURE|Garage|30,00°C|18:00", lines.get(48));
        assertEquals("TEMPERATURE|Inside|20,00°C|08:00", lines.get(49));
        assertEquals("TEMPERATURE|Inside|25,00°C|18:00", lines.get(50));
        assertEquals("TEMPERATURE|Outside|27,00°C|08:00", lines.get(51));
        assertEquals("TEMPERATURE|Outside|35,00°C|18:00", lines.get(52));
        assertEquals("HUMIDITY|Garage|34,00%|08:00", lines.get(53));
        assertEquals("HUMIDITY|Garage|36,40%|18:00", lines.get(54));
        assertEquals("HUMIDITY|Inside|30,00%|08:00", lines.get(55));
        assertEquals("HUMIDITY|Inside|40,40%|18:00", lines.get(56));
        assertEquals("HUMIDITY|Outside|50,00%|08:00", lines.get(57));
        assertEquals("HUMIDITY|Outside|55,30%|18:00", lines.get(58));
        assertTrue(lines.get(59).isEmpty());
        assertEquals("Highest latest readings :", lines.get(60));
        assertEquals("CO2|Toilet|0,32kg|18:00", lines.get(61));
        assertEquals("TEMPERATURE|Outside|35,00°C|18:00", lines.get(62));
        assertEquals("HUMIDITY|Outside|55,30%|18:00", lines.get(63));
        assertTrue(lines.get(64).isEmpty());
        assertEquals("Latest readings :", lines.get(65));
        assertEquals("CO2|Kitchen|0,30kg|18:00", lines.get(66));
        assertEquals("CO2|Garage|0,15kg|18:00", lines.get(67));
        assertEquals("CO2|Toilet|0,32kg|18:00", lines.get(68));
        assertEquals("TEMPERATURE|Garage|30,00°C|18:00", lines.get(69));
        assertEquals("TEMPERATURE|Inside|25,00°C|18:00", lines.get(70));
        assertEquals("TEMPERATURE|Outside|35,00°C|18:00", lines.get(71));
        assertEquals("HUMIDITY|Garage|36,40%|18:00", lines.get(72));
        assertEquals("HUMIDITY|Inside|40,40%|18:00", lines.get(73));
        assertEquals("HUMIDITY|Outside|55,30%|18:00", lines.get(74));
    }
}
