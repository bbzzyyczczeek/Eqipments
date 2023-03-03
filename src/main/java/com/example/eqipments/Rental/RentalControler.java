package com.example.eqipments.Rental;

import com.example.eqipments.Exeption.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rent")
public class RentalControler {
    private final RentalService rentalService;

    public RentalControler(RentalService rentalService) {
        this.rentalService = rentalService;
    }
   /* @GetMapping("{id}")
    ResponseEntity<List<RentalDto>>getAsigment(@PathVariable long id){
      return  ResponseEntity.ok(rentalService.getUserEquipments(id).stream().toList());
    }*/
    @PostMapping
    ResponseEntity<RentalDto>rent(@RequestBody RentalDto rentalDto){
        RentalDto save;
        try {
            save=rentalService.rent(rentalDto);
        }catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(save.getId())
                .toUri();
        return ResponseEntity.created(uri).body(save);

    }
}
