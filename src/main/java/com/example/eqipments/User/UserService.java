package com.example.eqipments.User;

import com.example.eqipments.Exeption.DuplicateExeption;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMaper userMaper;

    public UserService(UserRepository userRepository,UserMaper userMaper) {
        this.userRepository = userRepository;
        this.userMaper = userMaper;
    }

    List<UserDto> findAll(){
        return   userRepository.findAll().stream()
                .map(userMaper::map).toList();

    }
    List<UserDto>findByLastName(String lastName){
        return userRepository.findByLastNameContainingIgnoreCase(lastName).stream().map(userMaper::map).toList();
    }
    Optional<UserDto> findBylastName(String lastName){
        return userRepository.findByLastNameIgnoreCase(lastName).map(userMaper::map);

    }
    UserDto addUser(UserDto userDto){
        Optional<User> byPesel = userRepository.findByPesel(userDto.getPesel());
        byPesel.ifPresent(p->{throw new DuplicateExeption();
        });

        User add = userMaper.map(userDto);
        User save = userRepository.save(add);
        return userMaper.map(save);
    }

}
