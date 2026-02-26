package com.example.spring_boot_practice.exception;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(Long id) {
        super("Car not found with ID: " + id);
    }
}
