package com.example.eqipments.Equipments;

import com.example.eqipments.User.User;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Equipments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToMany
    Set<User> users;
}
