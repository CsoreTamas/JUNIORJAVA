package com.example.spring_boot_practice;

import com.example.spring_boot_practice.dto.CarPatchDTO;
import com.example.spring_boot_practice.dto.CarResponseDTO;
import com.example.spring_boot_practice.dto.CarSaveDTO;
import com.example.spring_boot_practice.exception.CarNotFoundException;
import com.example.spring_boot_practice.mapper.CarMapper;
import com.example.spring_boot_practice.model.Car;
import com.example.spring_boot_practice.repository.CarRepository;
import com.example.spring_boot_practice.service.CarService;
import lombok.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CarServiceUnitTest {

    @Mock
    private CarMapper carMapper;
    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldSaveCar() {
        CarSaveDTO carSaveDTO = CarSaveDTO.builder().brand("Mazda").model("3").year(2015).build();
        Car entity = Car.builder().brand("Mazda").model("3").year(2015).build();
        Car savedCar = Car.builder().id(1L).brand("Mazda").model("3").year(2015).build();

        CarResponseDTO carResponseDTO = new CarResponseDTO(1L, "3", "Mazda", 2015);

        when(carMapper.carDtoToCar(carSaveDTO)).thenReturn(entity);
        when(carRepository.save(entity)).thenReturn(savedCar);
        when(carMapper.carToResponseDTO(savedCar)).thenReturn(carResponseDTO);

        CarResponseDTO result = carService.saveCar(carSaveDTO);

        assertEquals(1L, result.getId());
        assertEquals("Mazda", result.getBrand());
        assertEquals("3", result.getModel());
    }

    @Test
    void shouldListAllCars() {
        Car car1 = new Car(1L, "Astra H", "Opel", 2006);
        Car car2 = new Car(2L, "3", "Mazda", 2015);

        CarResponseDTO dto1 = new CarResponseDTO(1L, "Astra H", "Opel", 2006);
        CarResponseDTO dto2 = new CarResponseDTO(2L, "3", "Mazda", 2015);

        when(carRepository.findAll()).thenReturn(List.of(car1, car2));

        when(carMapper.carToResponseDTO(car1)).thenReturn(dto1);
        when(carMapper.carToResponseDTO(car2)).thenReturn(dto2);

        List<CarResponseDTO> resultList = carService.listAll();

        assertEquals(2, resultList.size());
        assertEquals("Mazda", resultList.get(1).getBrand());
        assertEquals("Opel", resultList.get(0).getBrand());


        //verify() is Mockito checks that mock method was called (and optionally how many times during the test.
        //It doesn't check the return value, just that the interaction happened.
        //(verify(carMapper, times(1)).carToResponseDTO(car1);)
        verify(carRepository).findAll();
        verify(carMapper).carToResponseDTO(car1);
        verify(carMapper).carToResponseDTO(car2);
    }

    @Test
    void shouldFindCarByID() {
        Car car = new Car(1L, "Opel", "Astra H", 2006);
        CarResponseDTO carResponseDTO = new CarResponseDTO(1L, "Astra H", "Opel", 2006);

        when(carRepository.findById(1L)).thenReturn(Optional.of(car));
        when(carMapper.carToResponseDTO(car)).thenReturn(carResponseDTO);

        CarResponseDTO result = carService.findCarByID(1L);

        assertEquals(1L, result.getId());
        assertEquals("Opel", result.getBrand());
        assertEquals("Astra H", result.getModel());

        verify(carRepository).findById(1L);
        verify(carMapper).carToResponseDTO(car);
    }

    @Test
    void shouldThrowExceptionWhenCanFindCarByID() {
        when(carRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(CarNotFoundException.class, () -> carService.findCarByID(1L));

        verify(carRepository).findById(1L);
    }

    @Test
    void shouldReplaceCar() {
        CarSaveDTO saveDTO = CarSaveDTO.builder().brand("BMW").model("X7").year(2020).build();

        Car existingCar = new Car(1L, "Mazda", "3", 2015);

        Car updatedCar = new Car(1L, "BMW", "X7", 2020);

        CarResponseDTO carResponseDTO = new CarResponseDTO(1L, "X7", "BMW", 2020);

        when(carRepository.findById(1L)).thenReturn(Optional.of(existingCar));
        when(carMapper.carDtoToCar(saveDTO)).thenReturn(updatedCar);
        when(carRepository.save(updatedCar)).thenReturn(updatedCar);
        when(carMapper.carToResponseDTO(updatedCar)).thenReturn(carResponseDTO);

        CarResponseDTO resultCar = carService.replaceCar(1L, saveDTO);

        assertEquals(1L, resultCar.getId());
        assertEquals("BMW", resultCar.getBrand());
        assertEquals("X7", resultCar.getModel());
        assertEquals(2020, resultCar.getYear());

        verify(carRepository).findById(1L);
        verify(carMapper).carDtoToCar(saveDTO);
        verify(carRepository).save(updatedCar);
        verify(carMapper).carToResponseDTO(updatedCar);
    }

    @Test
    void shouldThrowExceptionWhenNoCarToReplace() {
        CarSaveDTO saveDTO = CarSaveDTO.builder().brand("BMW").model("X7").year(2020).build();
        when(carRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(CarNotFoundException.class, () -> carService.replaceCar(1L, saveDTO));

        verify(carRepository).findById(1L);
    }

    @Test
    void shouldUpgradeCar() {
        Car existingCar = new Car(1L, "BMW", "X7", 2020);

        CarPatchDTO patchDTO = new CarPatchDTO();
        patchDTO.setYear(1999);

        Car updatedCar = new Car(1L, "BMW", "X7", 1999);

        CarResponseDTO responseDTO = new CarResponseDTO(1L, "X7", "BMW", 1999);

        when(carRepository.findById(1L)).thenReturn(Optional.of(existingCar));
        when(carRepository.save(existingCar)).thenReturn(updatedCar);
        when(carMapper.carToResponseDTO(updatedCar)).thenReturn(responseDTO);

        CarResponseDTO result = carService.upgradeCar(1L, patchDTO);

        assertEquals(1L, result.getId());
        assertEquals("BMW", result.getBrand());
        assertEquals(1999, result.getYear());
        assertEquals("X7", result.getModel());

        verify(carRepository).findById(1L);
        verify(carRepository).save(existingCar);
        verify(carMapper).carToResponseDTO(updatedCar);
    }

    @Test
    void shouldThrowExceptionWhenNoCarToUpgrade() {
        CarPatchDTO patchDTO = new CarPatchDTO();
        patchDTO.setBrand("E234234");

        when(carRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(CarNotFoundException.class, () -> carService.upgradeCar(1L, patchDTO));

        verify(carRepository).findById(1L);
    }

    @Test
    void shouldDeleteExistingCar() {
        Car existingCar = new Car(1L, "BMW", "X7", 2020);

        when(carRepository.findById(1L)).thenReturn(Optional.of(existingCar));

        assertDoesNotThrow(() -> carService.deleteCar(1L));

        verify(carRepository).findById(1L);
        verify(carRepository).delete(existingCar);
    }

    @Test
    void shouldThrowExceptionWhenNoCarToDelete() {
        when(carRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(CarNotFoundException.class, () -> carService.deleteCar(1L));

        verify(carRepository).findById(1L);
        verify(carRepository, never()).delete(any(Car.class));
    }
}
