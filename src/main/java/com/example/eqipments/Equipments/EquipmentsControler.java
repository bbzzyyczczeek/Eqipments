package com.example.eqipments.Equipments;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class EquipmentsControler {
    private final EquipmentsService service;

    public EquipmentsControler(EquipmentsService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<EquipmentsDto>>findAll(@RequestParam(required = false)@PathVariable String name) {
        if (name == null) {
            return ResponseEntity.ok(service.all());
        }
      return   ResponseEntity.ok(service.findByNameContaining(name).stream().toList());

    }
    @GetMapping("/names")
    List<String>allCategoty(){
        return service.findByCategoty();
    }
    @PostMapping
    ResponseEntity<EquipmentsDto>addEquipment(@RequestBody EquipmentsDto dto){
        EquipmentsDto save = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);

    }

}
