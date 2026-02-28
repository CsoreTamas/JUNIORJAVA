package com.example.spring_boot_practice.controller;

import com.example.spring_boot_practice.dto.CarPatchDTO;
import com.example.spring_boot_practice.dto.CarResponseDTO;
import com.example.spring_boot_practice.dto.CarSaveDTO;
import com.example.spring_boot_practice.marker.Create;
import com.example.spring_boot_practice.marker.Put;
import com.example.spring_boot_practice.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("/{id}")
    public ResponseEntity<CarResponseDTO> getCar(@PathVariable("id") Long id) {
        return ResponseEntity.ok(carService.findCarByID(id));
    }

    @GetMapping
    public ResponseEntity<List<CarResponseDTO>> getAllCars() {
        return ResponseEntity.ok(carService.listAll());
    }

    @PostMapping
    public ResponseEntity<CarResponseDTO> createCar(@Validated(Create.class) @RequestBody CarSaveDTO carDTO) {
        return ResponseEntity.ok(carService.saveCar(carDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarResponseDTO> replaceCar(@Validated(Put.class) @PathVariable("id") Long id, @RequestBody CarSaveDTO carDTO) {
        return ResponseEntity.ok(carService.replaceCar(id, carDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CarResponseDTO> upgradeCar(@PathVariable("id") Long id, @RequestBody CarPatchDTO carDTO) {
        return ResponseEntity.ok(carService.upgradeCar(id, carDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("id") Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
