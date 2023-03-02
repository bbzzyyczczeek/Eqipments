package com.example.eqipments.User;

import com.example.eqipments.Exeption.DuplicatePeselExeption;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMaper userMaper;

    public UserService(UserRepository userRepository,UserMaper userMaper) {
        this.userRepository = userRepository;
        this.userMaper = userMaper;
    }

    Set<UserDto> findAll(){
        return   userRepository.findAll().stream()
                .map(userMaper::map).collect(Collectors.toSet());

    }
    Set<UserDto> findByLastName(String lastName){
        return userRepository.findByLastNameContainingIgnoreCase(lastName).stream().map(userMaper::map)
                .collect(Collectors.toSet());
    }
    Optional<UserDto> findBylastName(String lastName){
        return userRepository.findByLastNameIgnoreCase(lastName).map(userMaper::map);

    }
    UserDto addUser(UserDto userDto){
        Optional<Users> byPesel = userRepository.findByPesel(userDto.getPesel());
        byPesel.ifPresent(p->{throw new DuplicatePeselExeption();
        });

        Users add = userMaper.map(userDto);
        Users save = userRepository.save(add);
        return userMaper.map(save);
    }

}
