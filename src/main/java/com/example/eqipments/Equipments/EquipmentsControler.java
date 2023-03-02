package com.example.eqipments.Equipments;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Set;

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
      return   ResponseEntity.ok(service.findByNameOrSerialNumber(name).stream().toList());

    }
    @GetMapping("/category")
    Set<String> allCategoty(){
        return service.findByCategoty();
    }
    @GetMapping("/{id}")
    ResponseEntity<EquipmentsDto>findById(@PathVariable long id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    ResponseEntity<EquipmentsDto>addEquipment(@RequestBody EquipmentsDto dto){
        EquipmentsDto save = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);

    }

}
