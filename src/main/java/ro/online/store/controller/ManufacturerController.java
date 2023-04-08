package ro.online.store.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.online.store.dto.ManufacturerDTO;
import ro.online.store.dto.ManufacturerInfoDTO;
import ro.online.store.service.ManufacturerService;

import java.util.List;

@Controller
@RequestMapping("/api/manufacturer")
@ControllerAdvice
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @PostMapping("/create")
    public ResponseEntity<ManufacturerInfoDTO> create(@RequestBody @Valid ManufacturerDTO manufacturerDTO){
        return ResponseEntity.ok(manufacturerService.createManufacturer(manufacturerDTO));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ManufacturerInfoDTO> findManufacturerById (@PathVariable Integer id){
        return ResponseEntity.ok(manufacturerService.getManufacturerById(id));
    }

    @GetMapping("/find_all")
    public ResponseEntity<List<ManufacturerInfoDTO>> findAll (){
        return ResponseEntity.ok(manufacturerService.findAllManufacturers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id){
        if(manufacturerService.deleteById(id)){
            return ResponseEntity.ok(Boolean.TRUE);
        }
        return ResponseEntity.notFound().build();
    }




}
