package com.example.eqipments.User;

import org.springframework.stereotype.Service;

@Service
public class UserMaper {
    Users map(UserDto dto){
        Users user =new Users();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPesel(dto.getPesel());
        user.setTelephoneNumber(dto.getTelephoneNumber());
        return user;
    }
    UserDto map(Users user){
        UserDto dto=new UserDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPesel(user.getPesel());
        dto.setTelephoneNumber(user.getTelephoneNumber());
        return dto;

    }
}
