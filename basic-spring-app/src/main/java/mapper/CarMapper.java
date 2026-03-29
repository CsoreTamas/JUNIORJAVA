package mapper;

import dto.CarPatchDTO;
import dto.CarResponseDTO;
import dto.CarSaveDTO;
import model.Car;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CarMapper {
    Car carDTOToCar(CarSaveDTO carDTO);

    CarResponseDTO carToResponseDTO(Car car);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCarFromDTO(CarPatchDTO patchDTO, @MappingTarget Car car);
}