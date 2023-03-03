package com.example.eqipments.Equipments;

import com.example.eqipments.User.Users;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Equipments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    private String description;
    @Column(unique = true)
    private String serialNumber;
    private String category;
    @ManyToOne
    private Users users;


    public Equipments() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipments that = (Equipments) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(description, that.description)
                && Objects.equals(serialNumber, that.serialNumber) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, serialNumber, category);
    }
}
