package com.example.eqipments.User;


import jakarta.persistence.*;


import java.util.Objects;

@Entity
//@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String pesel;
    private String telephoneNumber;
  //  @OneToMany(mappedBy = "users")
 //  List<Rental>rentals;


    public Users() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

  /*  public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users user = (Users) o;
        return id == user.id && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(pesel, user.pesel) && Objects.equals(telephoneNumber, user.telephoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, pesel, telephoneNumber);
    }
}
