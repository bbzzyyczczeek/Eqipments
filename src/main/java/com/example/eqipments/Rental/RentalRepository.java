package com.example.eqipments.Rental;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface RentalRepository extends JpaRepository<Rental,Long> {
    Optional<Rental>findByEquipmentsIdAndStartIsNotNull(long id);
    Optional<Rental>findByEquipments_IdAndEndTimeIsNotNull(long id);
}
