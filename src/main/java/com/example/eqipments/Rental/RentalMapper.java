package com.example.eqipments.Rental;

import com.example.eqipments.Equipments.Equipments;
import com.example.eqipments.User.Users;
import org.springframework.stereotype.Service;

@Service
public class RentalMapper {

    RentalDto map(Rental rental){
        RentalDto dto=new RentalDto();
        Users users =rental.getUsers();
        dto.setId(rental.getId());
        dto.setStart(rental.getStart());
        dto.setEndTime(rental.getEndTime());
        dto.setWyporzyczone(rental.getWyporzyczone());
        dto.setUserId(users.getId());
        Equipments equipments=rental.getEquipments();
        dto.setEquipmentsId(equipments.getId());
        return dto;

    }
}
