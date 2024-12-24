package org.example.logs.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import java.time.LocalDateTime;

public class PassengerFlightDTO {

    private String flightNumber;
    private LocalDateTime departure;
    private LocalDateTime arrival;
    private String baggageLine;
    private String terminal;
    private Integer id; // ID пассажира
    private String name;
    private String passportNumber;
    private String surname;
    private String baggage; // Статус багажа
    private String flightId; // ID рейса



    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public String getBaggageLine() {
        return baggageLine;
    }

    public void setBaggageLine(String baggageLine) {
        this.baggageLine = baggageLine;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBaggage() {
        return baggage;
    }

    public void setBaggage(String baggage) {
        this.baggage = baggage;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }
}
