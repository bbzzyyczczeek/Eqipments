package com.example.eqipments.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByLastNameIgnoreCase(String lastName);
    List<User> findByLastNameContainingIgnoreCase(String lastName);
    Optional<User>findByPesel(String pesel);
}
