package com.example.spring_boot_practice.mapper;

import com.example.spring_boot_practice.dto.CarPatchDTO;
import com.example.spring_boot_practice.dto.CarResponseDTO;
import com.example.spring_boot_practice.dto.CarSaveDTO;
import com.example.spring_boot_practice.model.Car;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-28T17:06:08+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Eclipse Adoptium)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public CarSaveDTO carToCarDTO(Car car) {
        if ( car == null ) {
            return null;
        }

        CarSaveDTO.CarSaveDTOBuilder carSaveDTO = CarSaveDTO.builder();

        carSaveDTO.id( car.getId() );
        carSaveDTO.brand( car.getBrand() );
        carSaveDTO.model( car.getModel() );
        carSaveDTO.year( car.getYear() );

        return carSaveDTO.build();
    }

    @Override
    public Car carDtoToCar(CarSaveDTO carDTO) {
        if ( carDTO == null ) {
            return null;
        }

        Car.CarBuilder car = Car.builder();

        car.id( carDTO.getId() );
        car.brand( carDTO.getBrand() );
        car.model( carDTO.getModel() );
        if ( carDTO.getYear() != null ) {
            car.year( carDTO.getYear() );
        }

        return car.build();
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

    @Override
    public void updateCarFromDTO(CarPatchDTO dto, Car car) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getBrand() != null ) {
            car.setBrand( dto.getBrand() );
        }
        if ( dto.getModel() != null ) {
            car.setModel( dto.getModel() );
        }
        if ( dto.getYear() != null ) {
            car.setYear( dto.getYear() );
        }
    }
}
