package com.example.eqipments.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserControler {
    private final UserService userService;

    public UserControler(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    ResponseEntity<List<UserDto>> allUsers(@RequestParam(required = false)@PathVariable String lastName){
        if (lastName==null) {
            return ResponseEntity.ok(userService.findAll());
        }
        return ResponseEntity.ok(userService.findByLastName(lastName).stream().toList());
    }
    @GetMapping("/{lastName}")
    ResponseEntity<UserDto> findByLastna(@PathVariable String lastName){
        return userService.findBylastName(lastName).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());


    }
}
