package com.example.spring_boot_practice.mapper;

import com.example.spring_boot_practice.dto.CarResponseDTO;
import com.example.spring_boot_practice.dto.CarSaveDTO;
import com.example.spring_boot_practice.model.Car;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-26T12:11:09+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Eclipse Adoptium)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public CarSaveDTO carToCarDTO(Car car) {
        if ( car == null ) {
            return null;
        }

        CarSaveDTO carSaveDTO = new CarSaveDTO();

        carSaveDTO.setId( car.getId() );
        carSaveDTO.setBrand( car.getBrand() );
        carSaveDTO.setModel( car.getModel() );
        carSaveDTO.setYear( car.getYear() );

        return carSaveDTO;
    }

    @Override
    public Car carDtoToCar(CarSaveDTO carDTO) {
        if ( carDTO == null ) {
            return null;
        }

        Car car = new Car();

        car.setId( carDTO.getId() );
        car.setBrand( carDTO.getBrand() );
        car.setModel( carDTO.getModel() );
        if ( carDTO.getYear() != null ) {
            car.setYear( carDTO.getYear() );
        }

        return car;
    }

    @Override
    public CarResponseDTO carToResponseDTO(Car car) {
        if ( car == null ) {
            return null;
        }

        CarResponseDTO carResponseDTO = new CarResponseDTO();

        carResponseDTO.setId( car.getId() );
        carResponseDTO.setModel( car.getModel() );
        carResponseDTO.setBrand( car.getBrand() );
        carResponseDTO.setYear( car.getYear() );

        return carResponseDTO;
    }
}
