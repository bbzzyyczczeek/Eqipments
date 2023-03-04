package com.example.eqipments.Rental;

import com.example.eqipments.Equipments.Equipments;
import com.example.eqipments.User.Users;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

import java.time.LocalDate;



@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate start;

    private LocalDate endTime ;
    private  String wyporzyczone;

   @ManyToOne
 //  @JoinColumn(name = "wyporzyczalacy",referencedColumnName = "lastName")
  private   Users users;
   @ManyToOne
   private Equipments equipments;

    public Rental() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public String getWyporzyczone() {
        return wyporzyczone;
    }

    public void setWyporzyczone(String wyporzyczone) {
        this.wyporzyczone = wyporzyczone;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Equipments getEquipments() {
        return equipments;
    }

    public void setEquipments(Equipments equipments) {
        this.equipments = equipments;
    }
}
