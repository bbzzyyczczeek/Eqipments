package com.example.eqipments.Equipments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface EquipmentsRepository extends JpaRepository<Equipments,Long> {

    List<Equipments> findAll();

    List<Equipments>findAllByNameContaining(String name);

    Optional<Equipments>findBySerialNumber(String serialNumber);


}
