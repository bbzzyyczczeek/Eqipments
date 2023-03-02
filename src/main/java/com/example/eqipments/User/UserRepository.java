package com.example.eqipments.User;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByLastNameIgnoreCase(String lastName);
    Set<Users> findByLastNameContainingIgnoreCase(String lastName);
    Optional<Users>findByPesel(String pesel);
}
