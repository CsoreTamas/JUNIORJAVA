package sensor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SensorFactory {
    public static LocalTime morning = LocalTime.of(8, 0);
    public static LocalTime noon = LocalTime.of(12, 0);
    public static LocalTime evening = LocalTime.of(22, 0);

    public static AbstractSensor tempInSide;
    public static AbstractSensor tempOutSide;
    public static AbstractSensor tempGarage;

    public static AbstractSensor humInSide;
    public static AbstractSensor humOutSide;
    public static AbstractSensor humGarage;

    public static AbstractSensor co2Garage;
    public static AbstractSensor co2Kitchen;
    public static AbstractSensor co2Toilet;

    public static List<Sensor> createSensors() {

        List<Sensor> sensorList = new ArrayList<>();

        tempInSide = new TemperatureSensor("In side");
        tempInSide.addReading(new Reading(29.5, morning));
        tempInSide.addReading(new Reading(25.2, noon));
        tempInSide.addReading(new Reading(20.2, evening));
        sensorList.add(tempInSide);

        tempOutSide = new TemperatureSensor("Out side");
        tempOutSide.addReading(new Reading(26.3, morning));
        tempOutSide.addReading(new Reading(35.4, noon));
        tempOutSide.addReading(new Reading(23.8, evening));
        sensorList.add(tempOutSide);

        tempGarage = new TemperatureSensor("Garage");
        tempGarage.addReading(new Reading(27.1, morning));
        tempGarage.addReading(new Reading(29.8, noon));
        tempGarage.addReading(new Reading(22.7, evening));
        sensorList.add(tempGarage);

        humInSide = new HumiditySensor("In side");
        humInSide.addReading(new Reading(45.4, morning));
        humInSide.addReading(new Reading(40.9, noon));
        humInSide.addReading(new Reading(34.0, evening));
        sensorList.add(humInSide);

        humOutSide = new HumiditySensor("Out side");
        humOutSide.addReading(new Reading(60.1, morning));
        humOutSide.addReading(new Reading(55.4, noon));
        humOutSide.addReading(new Reading(58.2, evening));
        sensorList.add(humOutSide);

        humGarage = new HumiditySensor("Garage");
        humGarage.addReading(new Reading(40.1, morning));
        humGarage.addReading(new Reading(50.7, noon));
        humGarage.addReading(new Reading(55.3, evening));
        sensorList.add(humGarage);

        co2Garage = new CO2Sensor("Garage");
        co2Garage.addReading(new Reading(0.1, morning));
        co2Garage.addReading(new Reading(0.2, noon));
        co2Garage.addReading(new Reading(0.15, evening));
        sensorList.add(co2Garage);

        co2Kitchen = new CO2Sensor("Kitchen");
        co2Kitchen.addReading(new Reading(0.1, morning));
        co2Kitchen.addReading(new Reading(0.13, noon));
        co2Kitchen.addReading(new Reading(0.15, evening));
        sensorList.add(co2Kitchen);

        co2Toilet = new CO2Sensor("Toilet");
        co2Toilet.addReading(new Reading(0.2, morning));
        co2Toilet.addReading(new Reading(0.25, noon));
        co2Toilet.addReading(new Reading(0.30, evening));
        sensorList.add(co2Toilet);

        return sensorList;
    }

}

