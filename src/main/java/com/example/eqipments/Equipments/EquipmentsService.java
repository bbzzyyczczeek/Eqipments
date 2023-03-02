package com.example.eqipments.Equipments;

import com.example.eqipments.Exeption.DuplicateSerialNumberException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EquipmentsService {
    private final EquipmentsRepository repository;
    private final EquipmentsMaper maper;

    public EquipmentsService(EquipmentsRepository repository, EquipmentsMaper maper) {
        this.repository = repository;
        this.maper = maper;
    }
    List<EquipmentsDto>all(){
        return repository.findAll().stream().map(maper::map).toList();
    }
    List<EquipmentsDto>findByNameOrSerialNumber(String name){
        return repository.findAllByNameContaining(name).stream().map(maper::map).toList();
    }
    EquipmentsDto save(EquipmentsDto dto){
        Optional<Equipments> bySerialNumber = repository.findBySerialNumber(dto.getSerialNumber());
        bySerialNumber.ifPresent(n->{throw new DuplicateSerialNumberException();
        });
        Equipments mapedDto = maper.map(dto);
        Equipments save = repository.save(mapedDto);
        return maper.map(save);
    }
    Set<String> findByCategoty(){
        return repository.findAll().stream().map(Equipments::getCategory).collect(Collectors.toSet());
    }
    Optional<EquipmentsDto>findById(long id){
        return repository.findById(id).map(maper::map);
    }
}
