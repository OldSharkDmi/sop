package com.example.baggagev1.dtos;

import java.util.List;

public class AddPassengerDTO {

    private String name;
    private String surname;
    private String passportNumber;
    private List<BaggageDTO> baggage;
    private String flight_id;



    public AddPassengerDTO() {
    }

    public AddPassengerDTO(String name, String surname, String passportNumber, List<BaggageDTO> baggage, String flight_id) {
        this.name = name;
        this.surname = surname;
        this.passportNumber = passportNumber;
        this.baggage = baggage;
        this.flight_id = flight_id;
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
}