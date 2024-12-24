package com.example.baggagev1.dtos;

import java.util.List;

public class PassengerDTO {
    private Long id;
    private String name;
    private String passportNumber;
    private String surname;
    private List<BaggageDTO> baggage;
    private String flight_id;

    public PassengerDTO() {
    }

    public PassengerDTO(Long id, String name, String passportNumber, List<BaggageDTO> baggage, String flight_id, String surname) {
        this.id = id;
        this.name = name;
        this.passportNumber = passportNumber;
        this.baggage = baggage;
        this.flight_id = flight_id;
        this.surname = surname;
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

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public List<BaggageDTO> getBaggage() {
        return baggage;
    }

    public void setBaggage(List<BaggageDTO> baggage) {
        this.baggage = baggage;
    }

    public String getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(String flight_id) {
        this.flight_id = flight_id;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
}