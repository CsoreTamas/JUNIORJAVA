package controller;

import dto.CarPatchDTO;
import dto.CarResponseDTO;
import dto.CarSaveDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CarService;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<CarResponseDTO>> getAllCars() {
        return ResponseEntity.ok(carService.listCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponseDTO> getCarByID(@PathVariable("id") Long id) {
        return ResponseEntity.ok(carService.findCarById(id));
    }

    @PostMapping
    public ResponseEntity<CarResponseDTO> createCar(@Valid @RequestBody CarSaveDTO carDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.saveCar(carDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarResponseDTO> putCar(@PathVariable("id") Long id, @Valid @RequestBody CarSaveDTO carDTO) {
        return ResponseEntity.ok(carService.replaceCar(id, carDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CarResponseDTO> patchCar(@PathVariable("id") Long id, @Valid @RequestBody CarPatchDTO carDTO) {
        return ResponseEntity.ok(carService.upgradeCar(id, carDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("id") Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}