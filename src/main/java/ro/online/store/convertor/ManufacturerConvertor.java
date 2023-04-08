package ro.online.store.convertor;

import ro.online.store.dto.ManufacturerDTO;
import ro.online.store.dto.ManufacturerInfoDTO;
import ro.online.store.entity.ManufacturerEntity;

public class ManufacturerConvertor {

    public static ManufacturerEntity map(ManufacturerDTO manufacturerDTO){
        return new ManufacturerEntity(
                manufacturerDTO.getFirstName(),
                manufacturerDTO.getLastName());
    }

    public static ManufacturerDTO map(ManufacturerEntity manufacturerEntity){
        return new ManufacturerDTO(
                manufacturerEntity.getFirstName(),
                manufacturerEntity.getLastName());
    }

    public static ManufacturerInfoDTO mapInfoDTO(ManufacturerEntity manufacturerEntity){
        return new ManufacturerInfoDTO(
                manufacturerEntity.getId(),
                manufacturerEntity.getFirstName(),
                manufacturerEntity.getLastName());
    }
}
