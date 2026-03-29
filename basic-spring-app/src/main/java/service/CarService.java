package service;


import dto.CarPatchDTO;
import dto.CarResponseDTO;
import dto.CarSaveDTO;
import exception.CarNotFoundException;
import lombok.RequiredArgsConstructor;
import mapper.CarMapper;
import model.Car;
import org.springframework.stereotype.Service;
import repository.CarRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarResponseDTO saveCar(CarSaveDTO carDTO) {
        Car car = carMapper.carDTOToCar(carDTO); // DTO -> ENTITY
        Car savedCar = carRepository.save(car);
        return carMapper.carToResponseDTO(savedCar); // ENTITY -> DTO
    }

    public List<CarResponseDTO> listCars() {
        return carRepository.findAll()
                .stream()
                .map(carMapper::carToResponseDTO)
                .collect(Collectors.toList());
    }

    public CarResponseDTO findCarById(long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
        return carMapper.carToResponseDTO(car);
    }

    public void deleteCar(Long id) {
        if (!carRepository.existsById(id)) {
            throw new CarNotFoundException(id);
        }
        carRepository.deleteById(id);
    }

    public CarResponseDTO replaceCar(long id, CarSaveDTO updatedCarDTO) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));

        Car updatedCar = carMapper.carDTOToCar(updatedCarDTO);
        updatedCar.setId(car.getId());

        Car savedCar = carRepository.save(updatedCar);
        return carMapper.carToResponseDTO(savedCar);
    }

    public CarResponseDTO upgradeCar(long id, CarPatchDTO patchDTO) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));

        carMapper.updateCarFromDTO(patchDTO, car);

        Car savedCar = carRepository.save(car);
        return carMapper.carToResponseDTO(savedCar);
    }
}