package com.example.spring_boot_practice.mapper;


import com.example.spring_boot_practice.dto.CarResponseDTO;
import com.example.spring_boot_practice.dto.CarSaveDTO;
import com.example.spring_boot_practice.model.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarSaveDTO carToCarDTO(Car car);

    Car carDtoToCar(CarSaveDTO carDTO);

    CarResponseDTO carToResponseDTO(Car car);

}
