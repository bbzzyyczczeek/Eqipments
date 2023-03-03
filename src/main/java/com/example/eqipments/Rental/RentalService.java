package com.example.eqipments.Rental;

import com.example.eqipments.Equipments.Equipments;
import com.example.eqipments.Equipments.EquipmentsRepository;
import com.example.eqipments.Exeption.NotFoundException;
import com.example.eqipments.User.UserRepository;
import com.example.eqipments.User.Users;
import org.springframework.stereotype.Service;

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
  /*  List<RentalDto>getUserEquipments(long id){
        return userRepository.findById(id).map(Users::getRentals)
                .orElseThrow().stream().map(rentalMapper::map).toList();

    }*/
    RentalDto rent(RentalDto rentalDto){
        Rental rental=new Rental();
        Optional<Rental>findIfAvabile=rentalRepository.findByEquipmentsIdAndStartIsNotNull(rentalDto.getEquipmentsId());
        findIfAvabile.ifPresent((e)->{throw new NotFoundException("To wyposażenie jest wypozyczone");
        });
        long userId= rentalDto.getUserId();

        Users users = userRepository.findById(rentalDto.getUserId())
                .orElseThrow(() -> new NotFoundException("Brak uzytkownika o id " + userId));
        rental.setUsers(users);

        long equipmentId=rentalDto.getEquipmentsId();
        Equipments equipments = equipmentsRepository.findById(rentalDto.getEquipmentsId())
                .orElseThrow(() -> new NotFoundException("Brak sprzetu o id " + equipmentId));
        rental.setEquipments(equipments);
        rental.setStart(LocalDate.now());
       // rental.setEndTime(0);
        Rental save = rentalRepository.save(rental);
        return rentalMapper.map(save);
    }
}
