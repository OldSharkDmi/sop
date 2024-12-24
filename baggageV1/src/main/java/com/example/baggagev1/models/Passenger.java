package com.example.baggagev1.models;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String passport;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = true)
    private Flight flight;

    @OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Baggage> baggageList;

    public Passenger() {
    }

    public Passenger(Long id, String name, String surname, String passport, String phone, Flight flight, List<Baggage> baggageList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.passport = passport;
        this.phone = phone;
        this.flight = flight;
        this.baggageList = baggageList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<Baggage> getBaggageList() {
        return baggageList;
    }

    public void setBaggageList(List<Baggage> baggageList) {
        this.baggageList = baggageList;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passport='" + passport + '\'' +
                ", phone='" + phone + '\'' +
                ", flight=" + flight +
                ", baggageList=" + baggageList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(id, passenger.id) &&
                Objects.equals(name, passenger.name) &&
                Objects.equals(surname, passenger.surname) &&
                Objects.equals(passport, passenger.passport) &&
                Objects.equals(phone, passenger.phone) &&
                Objects.equals(flight, passenger.flight) &&
                Objects.equals(baggageList, passenger.baggageList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, passport, phone, flight, baggageList);
    }
}