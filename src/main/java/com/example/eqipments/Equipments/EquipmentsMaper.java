package com.example.eqipments.Equipments;

import org.springframework.stereotype.Service;

@Service
public class EquipmentsMaper {
    Equipments map(EquipmentsDto dto){
        Equipments equipments =new Equipments();
        equipments.setId(dto.getId());
        equipments.setName(dto.getName());
        equipments.setDescription(dto.getDescription());
        equipments.setSerialNumber(dto.getSerialNumber());
        equipments.setCategory(dto.getCategory());
        return equipments;
    }
    EquipmentsDto map(Equipments equipments){
        EquipmentsDto dto=new EquipmentsDto();
        dto.setId(equipments.getId());
        dto.setName(equipments.getName());
        dto.setDescription(equipments.getDescription());
        dto.setSerialNumber(equipments.getSerialNumber());
        dto.setCategory(equipments.getCategory());
        return dto;
    }
}
