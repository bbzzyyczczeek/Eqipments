package com.example.eqipments.Equipments;

import org.springframework.stereotype.Service;

import java.util.List;

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
    List<EquipmentsDto>findByNameContaining(String name){
        return repository.findByNameContaining(name).stream().map(maper::map).toList();
    }
    EquipmentsDto save(EquipmentsDto dto){
        Equipments mapedDto = maper.map(dto);
        Equipments save = repository.save(mapedDto);
        return maper.map(save);
    }
    List<String>findByCategoty(){
        return repository.findAll().stream().map(Equipments::getCategory).toList();
    }
}
