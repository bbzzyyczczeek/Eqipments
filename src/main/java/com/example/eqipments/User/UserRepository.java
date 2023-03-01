package com.example.eqipments.User;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByLastNameIgnoreCase(String lastName);
    Set<User> findByLastNameContainingIgnoreCase(String lastName);
    Optional<User>findByPesel(String pesel);
}
