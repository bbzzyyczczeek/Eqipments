package com.example.eqipments.Equipments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface EquipmentsRepository extends JpaRepository<Equipments,Long> {

    List<Equipments> findAll();
    List<Equipments>findByNameContaining(String name);

}
