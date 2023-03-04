package com.example.eqipments.Rental;

import com.example.eqipments.Equipments.Equipments;
import com.example.eqipments.Equipments.EquipmentsRepository;
import com.example.eqipments.Exeption.NotFoundException;
import com.example.eqipments.User.UserRepository;
import com.example.eqipments.User.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class RentalService {
    private final UserRepository userRepository;
    private final EquipmentsRepository equipmentsRepository;
    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;

    public RentalService(UserRepository userRepository, EquipmentsRepository equipmentsRepository,
                         RentalRepository rentalRepository, RentalMapper rentalMapper) {
        this.userRepository = userRepository;
        this.equipmentsRepository = equipmentsRepository;
        this.rentalRepository = rentalRepository;
        this.rentalMapper = rentalMapper;
    }

    RentalDto rent(RentalDto rentalDto){
        Rental rental=new Rental();
        Optional<Rental>findIfAvabile=rentalRepository.findByEquipmentsIdAndWyporzyczoneIsNotNull(rentalDto.getEquipmentsId());
        findIfAvabile.ifPresent((e)->{throw new NotFoundException("To wyposażenie jest wypozyczone");
        });
        long userId= rentalDto.getUserId();

        Users users = userRepository.findById(rentalDto.getUserId())
                .orElseThrow(() -> new NotFoundException("Brak uzytkownika o id " + userId));
        rental.setUsers(users);

        long equipmentId=rentalDto.getEquipmentsId();
        Equipments equipments = equipmentsRepository.findById(rentalDto.getEquipmentsId())
                .orElseThrow(() -> new NotFoundException("Brak sprzetu o id " + equipmentId));
        rental.setWyporzyczone("wyporzyczone");
        rental.setEquipments(equipments);
        rental.setStart(LocalDate.now());

        Rental save = rentalRepository.save(rental);
        return rentalMapper.map(save);
    }
@Transactional
    public LocalDate endRent(long id){
    Rental rental = rentalRepository.findByEquipmentsIdAndWyporzyczoneIsNotNull(id)
            .orElseThrow(()->new NotFoundException("Strzet jest na stanie"));


        LocalDate now = LocalDate.now();
        rental.setEndTime(now);
        rental.setWyporzyczone(null);
        return now;

    }
}
