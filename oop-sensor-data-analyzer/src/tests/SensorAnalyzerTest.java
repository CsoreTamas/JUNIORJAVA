package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import sensor.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SensorAnalyzerTest {
    @Test
    void shouldGetAverageOfReadings() {

        AbstractSensor tempActualSensor = new TemperatureSensor("temp sensor");
        tempActualSensor.addReading(new Reading(20, LocalTime.of(8, 0)));
        tempActualSensor.addReading(new Reading(10, LocalTime.of(9, 0)));
        tempActualSensor.addReading(new Reading(15, LocalTime.of(10, 0)));
        tempActualSensor.addReading(new Reading(25, LocalTime.of(11, 0)));
        tempActualSensor.addReading(new Reading(30, LocalTime.of(12, 0)));

        assertEquals(20, SensorAnalyzer.getAverageOfReadings(tempActualSensor));
    }

    @Test
    void shouldListSensorsAboveThreshold() {
        List<AbstractSensor> sensorList = new ArrayList<>();

        AbstractSensor humSensorInSide = new HumiditySensor("Inside");
        humSensorInSide.addReading(new Reading(50, LocalTime.of(12, 0)));
        sensorList.add(humSensorInSide);

        AbstractSensor humSensorOutSide = new HumiditySensor("Outside");
        humSensorOutSide.addReading(new Reading(75, LocalTime.of(12, 0)));
        sensorList.add(humSensorOutSide);

        AbstractSensor humSensorFarAway = new HumiditySensor("Faraway");
        humSensorFarAway.addReading(new Reading(63, LocalTime.of(12, 0)));
        sensorList.add(humSensorFarAway);

        List<AbstractSensor> expectedList = List.of(humSensorOutSide, humSensorFarAway);

        assertEquals(expectedList, SensorAnalyzer.getSensorsAboveSThreshold(sensorList, 50, SensorType.HUMIDITY));
    }

    @Test
    void shouldSearchHighestReaderSensor() {
        List<AbstractSensor> sensors = new ArrayList<>();

        AbstractSensor tempIn = new TemperatureSensor("tempin");
        tempIn.addReading(new Reading(20, LocalTime.of(12, 0)));
        sensors.add(tempIn);

        AbstractSensor tempOut = new TemperatureSensor("tempout");
        tempOut.addReading(new Reading(21, LocalTime.of(12, 0)));
        sensors.add(tempOut);

        AbstractSensor tempAnywhere = new TemperatureSensor("anywhere");
        tempAnywhere.addReading(new Reading(22, LocalTime.of(12, 0)));
        sensors.add(tempAnywhere);

        List<Reading> expectedList = new ArrayList<>();
        AbstractSensor expected = new SensorWithSingleReading("anywhere", SensorType.TEMPERATURE, expectedList);
        Reading reading = new Reading(22, LocalTime.of(12, 0));
        expectedList.add(reading);

        assertEquals(expected, SensorAnalyzer.getSensorWithHighestLatestReading(sensors, SensorType.TEMPERATURE));
    }

    @Test
    void shouldGetTheLatestReadingByType() {
        LocalTime morning = LocalTime.of(8, 0);
        LocalTime noon = LocalTime.of(12, 0);
        LocalTime evening = LocalTime.of(22, 0);

        List<AbstractSensor> sensorList = new ArrayList<>();

        AbstractSensor tempInSide = new TemperatureSensor("In side");
        tempInSide.addReading(new Reading(29.5, morning));
        tempInSide.addReading(new Reading(25.2, noon));
        tempInSide.addReading(new Reading(20.2, evening));
        sensorList.add(tempInSide);

        AbstractSensor tempOutSide = new TemperatureSensor("Out side");
        tempOutSide.addReading(new Reading(26.3, morning));
        tempOutSide.addReading(new Reading(35.4, noon));
        tempOutSide.addReading(new Reading(23.8, evening));
        sensorList.add(tempOutSide);

        AbstractSensor humInSide = new HumiditySensor("In side");
        humInSide.addReading(new Reading(45.4, morning));
        humInSide.addReading(new Reading(40.9, noon));
        humInSide.addReading(new Reading(34.0, evening));
        sensorList.add(humInSide);

        AbstractSensor humOutSide = new HumiditySensor("Out side");
        humOutSide.addReading(new Reading(60.1, morning));
        humOutSide.addReading(new Reading(55.4, noon));
        humOutSide.addReading(new Reading(58.2, evening));
        sensorList.add(humOutSide);

        AbstractSensor co2Kitchen = new CO2Sensor("Kitchen");
        co2Kitchen.addReading(new Reading(0.1, morning));
        co2Kitchen.addReading(new Reading(0.13, noon));
        co2Kitchen.addReading(new Reading(0.15, evening));
        sensorList.add(co2Kitchen);

        AbstractSensor co2Toilet = new CO2Sensor("Toilet");
        co2Toilet.addReading(new Reading(0.2, morning));
        co2Toilet.addReading(new Reading(0.25, noon));
        co2Toilet.addReading(new Reading(0.30, evening));
        sensorList.add(co2Toilet);

        Map<SensorType, Reading> expectedHashMap = new HashMap<>();
        expectedHashMap.put(SensorType.TEMPERATURE, new Reading(23.8, evening));
        expectedHashMap.put(SensorType.HUMIDITY, new Reading(58.2, evening));
        expectedHashMap.put(SensorType.CO2, new Reading(0.3, evening));

        Map<AbstractSensor, Reading> latestReadings = SensorAnalyzer.getLatestReadingsGroupedByType(sensorList);

        Map<SensorType, Reading> actualHashMap = new HashMap<>();
        for (Map.Entry<AbstractSensor, Reading> entry : latestReadings.entrySet()) {
            AbstractSensor sensor = entry.getKey();
            Reading reading = entry.getValue();
            SensorType type = sensor.getSensorType();

            actualHashMap.put(type, reading);
        }

        assertEquals(expectedHashMap, actualHashMap);
    }
}
