package com.example.spring_boot_practice.seeder;

import com.example.spring_boot_practice.model.Car;
import com.example.spring_boot_practice.repository.CarRepository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CarDataLoader implements CommandLineRunner {

    private final CarRepository carRepository;
    private final Faker faker = new Faker();

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (carRepository.count() > 100) {
            return;
        }
        log.info("Seeding 100.000 cars..");

        int totalAmount = 100_000;
        int batchSize = 10_000;
        int batches = totalAmount / batchSize;

        for (int i = 0; i < batches; i++) {
            List<Car> cars = new ArrayList<>(batchSize);
            for (int j = 0; j < batchSize; j++) {
                Car car = new Car();
                car.setBrand(faker.vehicle().manufacturer());
                car.setModel(faker.vehicle().model());
                car.setYear(faker.number().numberBetween(1900, Year.now().getValue()));
                cars.add(car);
            }
            carRepository.saveAll(cars);
            carRepository.flush();
            log.info("Saved: {}", (i + 1) * 10_000);
        }
        log.info("COMPLETEEEE!!");
    }
}
