import dto.CarPatchDTO;
import dto.CarResponseDTO;
import dto.CarSaveDTO;
import exception.CarNotFoundException;
import mapper.CarMapper;
import model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import repository.CarRepository;
import service.CarService;
import  org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;
    @Mock
    private CarMapper carMapper;
    @InjectMocks
    private CarService service;

    private Car car;
    private CarResponseDTO responseDTO;
    private CarSaveDTO saveDTO;


    @BeforeEach
    void setup() {
        car = new Car(1L, "Opel", "Astra H", 2006);
        responseDTO = new CarResponseDTO(1L, "Opel", "Astra H", 2006);
        saveDTO = new CarSaveDTO("Opel", "Astra H", 2006);
    }

    @Test
    void shouldReturnAllCars() {
        when(carRepository.findAll()).thenReturn(List.of(car));
        when(carMapper.carToResponseDTO(car)).thenReturn(responseDTO);

        List<CarResponseDTO> result = service.listCars();

        assertEquals(1, result.size());
        assertEquals("Opel", result.getFirst().brand());
        verify(carRepository).findAll();
    }

    @Test
    void shouldReturnCarByID() {
        when(carRepository.findById(1L)).thenReturn(Optional.of(car));
        when(carMapper.carToResponseDTO(car)).thenReturn(responseDTO);

        CarResponseDTO result = service.findCarById(1L);

        assertNotNull(result);
        assertEquals("Opel", result.brand());
        verify(carRepository).findById(1L);
    }

    @Test
    void shouldThrowCarNotFoundExceptionWhenCarNotFound() {
        when(carRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(CarNotFoundException.class, () -> service.findCarById(99L));

        verify(carRepository).findById(99L);
    }

    @Test
    void shouldSaveCar() {
        when(carMapper.carDTOToCar(saveDTO)).thenReturn(car);
        when(carRepository.save(car)).thenReturn(car);
        when(carMapper.carToResponseDTO(car)).thenReturn(responseDTO);

        CarResponseDTO result = service.saveCar(saveDTO);

        assertNotNull(result);
        assertEquals("Opel", result.brand());
        verify(carRepository).save(car);
    }

    @Test
    void shouldDeleteCar() {
        when(carRepository.existsById(1L)).thenReturn(true);

        service.deleteCar(1L);

        verify(carRepository).deleteById(1L);
    }

    @Test
    void shouldThrowCarNotFoundExceptionWhenDeletingNonExistingCar() {
        when(carRepository.existsById(99L)).thenReturn(false);

        assertThrows(CarNotFoundException.class, () -> service.deleteCar(99L));

        verify(carRepository, never()).deleteById(99L);
    }

    @Test
    void shouldReplaceCar() {
        when(carRepository.findById(1L)).thenReturn(Optional.of(car));
        when(carMapper.carDTOToCar(saveDTO)).thenReturn(car);
        when(carRepository.save(car)).thenReturn(car);
        when(carMapper.carToResponseDTO(car)).thenReturn(responseDTO);

        CarResponseDTO result = service.replaceCar(1L, saveDTO);

        assertNotNull(result);
        verify(carRepository).save(car);
    }

    @Test
    void shouldPatchCar() {
        CarPatchDTO patchDTO = new CarPatchDTO();
        patchDTO.setModel("Astra J");

        when(carRepository.findById(1L)).thenReturn(Optional.of(car));
        when(carRepository.save(car)).thenReturn(car);
        when(carMapper.carToResponseDTO(car)).thenReturn(responseDTO);

        CarResponseDTO result = service.upgradeCar(1L, patchDTO);

        assertNotNull(result);
        verify(carMapper).updateCarFromDTO(patchDTO, car);
        verify(carRepository).save(car);
    }
}
