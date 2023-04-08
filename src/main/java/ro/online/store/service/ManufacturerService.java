package ro.online.store.service;

import ro.online.store.convertor.ManufacturerConvertor;
import ro.online.store.dto.ManufacturerDTO;
import ro.online.store.dto.ManufacturerInfoDTO;
import ro.online.store.entity.ManufacturerEntity;
import ro.online.store.exception.ManufacturerCustomException;
import ro.online.store.repository.ManufacturerRepository;

import java.util.ArrayList;
import java.util.List;

public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public ManufacturerInfoDTO createManufacturer(ManufacturerDTO manufacturerDTO) {
        ManufacturerEntity manufacturerToSave = ManufacturerConvertor.map(manufacturerDTO);
        ManufacturerEntity savedManufacturer = manufacturerRepository.save(manufacturerToSave);
        return ManufacturerConvertor.mapInfoDTO(savedManufacturer);
    }

    public ManufacturerInfoDTO getManufacturerById(Integer id) {
        ManufacturerEntity manufacturerEntity = manufacturerRepository
                .findById(id)
                .orElseThrow(() -> new ManufacturerCustomException("Could not find a manufacturer for id: " + id));
    return ManufacturerConvertor.mapInfoDTO(manufacturerEntity);
    }

    public List<ManufacturerInfoDTO> findAllManufacturers () {
        List<ManufacturerEntity> manufacturerEntityList = new ArrayList<>();
        manufacturerRepository.findAll().forEach(manufacturerEntity -> manufacturerEntityList.add(manufacturerEntity));

        return manufacturerEntityList.stream().map(manufacturerEntity -> ManufacturerConvertor.mapInfoDTO(manufacturerEntity)).toList();
    }

    public Boolean deleteById(Integer id) {
        try {
            manufacturerRepository.deleteById(id);
            return Boolean.TRUE;
        }
        catch (Exception e){
            System.out.println("Couldn't find this manufacturer to delete.");
            return Boolean.FALSE;
        }
    }
}
