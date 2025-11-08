package tests;

import file.handling.AbstractExporter;
import file.handling.CsvExporter;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import sensor.*;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CsvFileWriterTest {
    private List<Sensor> sensorList;

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
        SoftAssertions.assertSoftly(softly -> {

            softly.assertThat(lines).isNotEmpty();
            softly.assertThat(lines.getFirst()).isEqualTo("sensor.SensorType|SensorID|ReadingValue|ReadingTime");
            softly.assertThat(lines.get(1)).isEmpty();
            softly.assertThat(lines.get(2)).isEqualTo("CO2|Kitchen|0,10kg|08:00 ");
            softly.assertThat(lines.get(3)).isEqualTo("CO2|Kitchen|0,30kg|18:00 ");
            softly.assertThat(lines.get(4)).isEmpty();

            softly.assertThat(lines.get(5)).isEqualTo("CO2|Garage|0,20kg|08:00 ");
            softly.assertThat(lines.get(6)).isEqualTo("CO2|Garage|0,15kg|18:00 ");
            softly.assertThat(lines.get(1)).isEmpty();
            softly.assertThat(lines.get(8)).isEqualTo("CO2|Toilet|0,18kg|08:00 ");
            softly.assertThat(lines.get(9)).isEqualTo("CO2|Toilet|0,32kg|18:00 ");
            softly.assertThat(lines.get(10)).isEmpty();
            softly.assertThat(lines.get(11)).isEqualTo("TEMPERATURE|Garage|24,00°C|08:00 ");
            softly.assertThat(lines.get(12)).isEqualTo("TEMPERATURE|Garage|30,00°C|18:00 ");
            softly.assertThat(lines.get(13)).isEmpty();
            softly.assertThat(lines.get(14)).isEqualTo("TEMPERATURE|Inside|20,00°C|08:00 ");
            softly.assertThat(lines.get(15)).isEqualTo("TEMPERATURE|Inside|25,00°C|18:00 "); //todo
            softly.assertThat(lines.get(16)).isEmpty();
            softly.assertThat(lines.get(17)).isEqualTo("TEMPERATURE|Outside|27,00°C|08:00 ");
            softly.assertThat(lines.get(18)).isEqualTo("TEMPERATURE|Outside|35,00°C|18:00 ");
            softly.assertThat(lines.get(19)).isEmpty();
            softly.assertThat(lines.get(20)).isEqualTo("HUMIDITY|Garage|34,00%|08:00 ");
            softly.assertThat(lines.get(21)).isEqualTo("HUMIDITY|Garage|36,40%|18:00 ");
            softly.assertThat(lines.get(22)).isEmpty();
            softly.assertThat(lines.get(23)).isEqualTo("HUMIDITY|Inside|30,00%|08:00 ");
            softly.assertThat(lines.get(24)).isEqualTo("HUMIDITY|Inside|40,40%|18:00 ");
            softly.assertThat(lines.get(25)).isEmpty();
            softly.assertThat(lines.get(26)).isEqualTo("HUMIDITY|Outside|50,00%|08:00 ");
            softly.assertThat(lines.get(27)).isEqualTo("HUMIDITY|Outside|55,30%|18:00 ");
            softly.assertThat(lines.get(28)).isEmpty();
            softly.assertThat(lines.get(29)).isEqualTo("Average of readings: ");
            softly.assertThat(lines.get(30)).isEqualTo("CO2|Kitchen|0,20kg ");
            softly.assertThat(lines.get(31)).isEqualTo("CO2|Garage|0,18kg ");
            softly.assertThat(lines.get(32)).isEqualTo("CO2|Toilet|0,25kg ");
            softly.assertThat(lines.get(33)).isEqualTo("TEMPERATURE|Garage|27,00°C ");
            softly.assertThat(lines.get(34)).isEqualTo("TEMPERATURE|Inside|22,50°C ");
            softly.assertThat(lines.get(35)).isEqualTo("TEMPERATURE|Outside|31,00°C ");
            softly.assertThat(lines.get(36)).isEqualTo("HUMIDITY|Garage|35,20% ");
            softly.assertThat(lines.get(37)).isEqualTo("HUMIDITY|Inside|35,20% ");
            softly.assertThat(lines.get(38)).isEqualTo("HUMIDITY|Outside|52,65% ");
            softly.assertThat(lines.get(39)).isEmpty();
            softly.assertThat(lines.get(40)).isEqualTo("Sensors above threshold: ");
            softly.assertThat(lines.get(41)).isEqualTo("CO2|Kitchen|0,10kg|08:00");
            softly.assertThat(lines.get(42)).isEqualTo("CO2|Kitchen|0,30kg|18:00");
            softly.assertThat(lines.get(43)).isEqualTo("CO2|Garage|0,20kg|08:00");
            softly.assertThat(lines.get(44)).isEqualTo("CO2|Garage|0,15kg|18:00");
            softly.assertThat(lines.get(45)).isEqualTo("CO2|Toilet|0,18kg|08:00");
            softly.assertThat(lines.get(46)).isEqualTo("CO2|Toilet|0,32kg|18:00");
            softly.assertThat(lines.get(47)).isEqualTo("TEMPERATURE|Garage|24,00°C|08:00");
            softly.assertThat(lines.get(48)).isEqualTo("TEMPERATURE|Garage|30,00°C|18:00");
            softly.assertThat(lines.get(49)).isEqualTo("TEMPERATURE|Inside|20,00°C|08:00");
            softly.assertThat(lines.get(50)).isEqualTo("TEMPERATURE|Inside|25,00°C|18:00");
            softly.assertThat(lines.get(51)).isEqualTo("TEMPERATURE|Outside|27,00°C|08:00");
            softly.assertThat(lines.get(52)).isEqualTo("TEMPERATURE|Outside|35,00°C|18:00");
            softly.assertThat(lines.get(53)).isEqualTo("HUMIDITY|Garage|34,00%|08:00");
            softly.assertThat(lines.get(54)).isEqualTo("HUMIDITY|Garage|36,40%|18:00");
            softly.assertThat(lines.get(55)).isEqualTo("HUMIDITY|Inside|30,00%|08:00");
            softly.assertThat(lines.get(56)).isEqualTo("HUMIDITY|Inside|40,40%|18:00");
            softly.assertThat(lines.get(57)).isEqualTo("HUMIDITY|Outside|50,00%|08:00");
            softly.assertThat(lines.get(58)).isEqualTo("HUMIDITY|Outside|55,30%|18:00");
            softly.assertThat(lines.get(59)).isEmpty();
            softly.assertThat(lines.get(60)).isEqualTo("Highest latest readings :");
            softly.assertThat(lines.get(61)).isEqualTo("CO2|Toilet|0,32kg|18:00");
            softly.assertThat(lines.get(62)).isEqualTo("TEMPERATURE|Outside|35,00°C|18:00");
            softly.assertThat(lines.get(63)).isEqualTo("HUMIDITY|Outside|55,30%|18:00");
            softly.assertThat(lines.get(64)).isEmpty();
            softly.assertThat(lines.get(65)).isEqualTo("Latest readings :");
            softly.assertThat(lines.get(66)).isEqualTo("CO2|Kitchen|0,30kg|18:00");
            softly.assertThat(lines.get(67)).isEqualTo("CO2|Garage|0,15kg|18:00");
            softly.assertThat(lines.get(68)).isEqualTo("CO2|Toilet|0,32kg|18:00");
            softly.assertThat(lines.get(69)).isEqualTo("TEMPERATURE|Garage|30,00°C|18:00");
            softly.assertThat(lines.get(70)).isEqualTo("TEMPERATURE|Inside|25,00°C|18:00");
            softly.assertThat(lines.get(71)).isEqualTo("TEMPERATURE|Outside|35,00°C|18:00");
            softly.assertThat(lines.get(72)).isEqualTo("HUMIDITY|Garage|36,40%|18:00");
            softly.assertThat(lines.get(73)).isEqualTo("HUMIDITY|Inside|40,40%|18:00");
            softly.assertThat(lines.get(74)).isEqualTo("HUMIDITY|Outside|55,30%|18:00");
        });
    }
}
