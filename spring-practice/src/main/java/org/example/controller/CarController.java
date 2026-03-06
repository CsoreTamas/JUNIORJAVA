package org.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.dto.CarDTO;
import org.example.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return ResponseEntity.ok(carService.listCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarByID(@PathVariable("id") Long id) {
        return ResponseEntity.ok(carService.findCarById(id));
    }

    @PostMapping
    public ResponseEntity<CarDTO> createCar(@Valid @RequestBody CarDTO carDTO) {
        return ResponseEntity.ok(carService.saveCar(carDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDTO> putCar(@PathVariable("id") Long id, @Valid @RequestBody CarDTO carDTO) {
        return ResponseEntity.ok(carService.replaceCar(id, carDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CarDTO> patchCar(@PathVariable("id") Long id, @Valid @RequestBody CarDTO carDTO) {
        return ResponseEntity.ok(carService.upgradeCar(id, carDTO));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("id") Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
