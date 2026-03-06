package com.example.spring_boot_practice.service;

import com.example.spring_boot_practice.annotation.TrackTime;
import com.example.spring_boot_practice.dto.CarPatchDTO;
import com.example.spring_boot_practice.dto.CarResponseDTO;
import com.example.spring_boot_practice.dto.CarSaveDTO;
import com.example.spring_boot_practice.exception.CarNotFoundException;
import com.example.spring_boot_practice.mapper.CarMapper;
import com.example.spring_boot_practice.model.Car;
import com.example.spring_boot_practice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarMapper carMapper;
    private final CarRepository carRepository;

    // SAVE,
    // LIST ONE CAR,
    // LIST ALL CARS,
    // UPDATE,
    // PATCH (UPDATE)
    // DELETE

    public CarResponseDTO saveCar(CarSaveDTO carSaveDTO) {
        Car car = carMapper.carDtoToCar(carSaveDTO);
        Car savedCar = carRepository.save(car);
        return carMapper.carToResponseDTO(savedCar);
    }

    @TrackTime
    public List<CarResponseDTO> listAll() {
        return carRepository.findAll()
                .stream()
                .map(carMapper::carToResponseDTO)
                .collect(Collectors.toList());
    }

    // Returns a single page of entities using explicit 'page' and 'size' params.
    // Useful for simple pagination.
    // You manually control which page to fetch and how many times per page.
    // Ideal for small projects or quick REST endpoints without complex sorting.
    // GET --> /car/page?page=1&size=8
    @TrackTime
    public Page<CarResponseDTO> listEveryCars(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Car> cars = carRepository.findAllWithPage(pageable);

        return cars.map(carMapper::carToResponseDTO);
    }

    // Returns page of entities using String's Pageable abstraction.
    // Pageable automatically handles page number, - size, and sorting based on request params.
    // More flexible than explicit page/size because, you can sort multiple fields.
    // GET --> /car/pageable?page=1&size=10&sort=brand,asc&sort=id,desc
    @TrackTime
    public Page<CarResponseDTO> listAllCarsWithPageable(Pageable pageable) {
        return carRepository
                .findAllWithPageable(pageable)
                .map(carMapper::carToResponseDTO);
    }


    public CarResponseDTO findCarByID(long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
        return carMapper.carToResponseDTO(car);
    }

    public CarResponseDTO replaceCar(long id, CarSaveDTO carSaveDTO) {
        Car car = carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(id));

        Car updatedCar = carMapper.carDtoToCar(carSaveDTO);
        updatedCar.setId(car.getId());

        Car savedCar = carRepository.save(updatedCar);
        return carMapper.carToResponseDTO(savedCar);
    }

    public CarResponseDTO upgradeCar(long id, CarPatchDTO carPatchDTO) {
        Car car = carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(id));

        carMapper.updateCarFromDTO(carPatchDTO, car);

        Car savedCar = carRepository.save(car);
        return carMapper.carToResponseDTO(savedCar);
    }

    public void deleteCar(long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
        carRepository.delete(car);
    }
}
