package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.CarDTO;
import org.example.exception.CarNotFoundException;
import org.example.mapper.CarMapper;
import org.example.model.Car;
import org.example.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarDTO saveCar(CarDTO carDTO) {
        Car car = carMapper.carDTOToCar(carDTO); // DTO -> ENTITY
        Car savedCar = carRepository.save(car);
        return carMapper.carToCarDTO(savedCar); // ENTITY -> DTO
    }

    public List<CarDTO> listCars() {
        return carRepository.findAll()
                .stream()
                .map(carMapper::carToCarDTO)
                .collect(Collectors.toList());
    }

    public CarDTO findCarById(long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
        return carMapper.carToCarDTO(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public CarDTO replaceCar(long id, CarDTO updatedCarDTO) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));

        Car updatedCar = carMapper.carDTOToCar(updatedCarDTO);
        updatedCar.setId(car.getId());

        Car savedCar = carRepository.save(updatedCar);
        return carMapper.carToCarDTO(savedCar);
    }

    public CarDTO upgradeCar(long id, CarDTO carDTO) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));

        if (carDTO.getBrand() != null) {
            car.setBrand(carDTO.getBrand());
        }
        if (carDTO.getYear() != null) {
            car.setYear(carDTO.getYear());
        }
        if (carDTO.getModel() != null) {
            car.setModel(carDTO.getModel());
        }
        Car savedCar = carRepository.save(car);
        return carMapper.carToCarDTO(savedCar);
    }
}
