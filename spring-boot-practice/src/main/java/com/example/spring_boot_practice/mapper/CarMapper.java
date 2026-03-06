package com.example.spring_boot_practice.mapper;


import com.example.spring_boot_practice.dto.CarPatchDTO;
import com.example.spring_boot_practice.dto.CarResponseDTO;
import com.example.spring_boot_practice.dto.CarSaveDTO;
import com.example.spring_boot_practice.model.Car;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarSaveDTO carToCarDTO(Car car);

    Car carDtoToCar(CarSaveDTO carDTO);

    CarResponseDTO carToResponseDTO(Car car);

    //@BeanMapping is a MapStruct annotation that yoi use to set
    //the behavior of specific mapping method.
    //.IGNORE -> If the filed is null than stays null!
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    //@MappingTarget -> Don't create a new Car obj, modify the existing one.
    void updateCarFromDTO(CarPatchDTO dto, @MappingTarget Car car);
}
