package com.example.baggagev1.dtos;

import com.example.baggagev1.enums.BaggageLineEnum;
import com.example.baggagev1.enums.TerminalEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PassengerFlightDTO {
    @JsonProperty("flight_number")
    private String flightNumber;

    @JsonProperty("departure")
    private String departure;

    @JsonProperty("arrival")
    private String arrival;

    @JsonProperty("baggage_line")
    private BaggageLineEnum baggageLine;

    @JsonProperty("terminal")
    private TerminalEnum terminal;

    @JsonProperty("passengers")
    private List<PassengerDTO> passengers;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("passport_number")
    private String passportNumber;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("baggage")
    private List<BaggageDTO> baggage;

    @JsonProperty("flight_id")
    private String flight_id;

    public PassengerFlightDTO() {
    }

    public PassengerFlightDTO(String flightNumber, String departure, String arrival, BaggageLineEnum baggageLine, TerminalEnum terminal, List<PassengerDTO> passengers, Long id, String name, String passportNumber, String surname, List<BaggageDTO> baggage, String flight_id) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.baggageLine = baggageLine;
        this.terminal = terminal;
        this.passengers = passengers;
        this.id = id;
        this.name = name;
        this.passportNumber = passportNumber;
        this.surname = surname;
        this.baggage = baggage;
        this.flight_id = flight_id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public BaggageLineEnum getBaggageLine() {
        return baggageLine;
    }

    public void setBaggageLine(BaggageLineEnum baggageLine) {
        this.baggageLine = baggageLine;
    }

    public TerminalEnum getTerminal() {
        return terminal;
    }

    public void setTerminal(TerminalEnum terminal) {
        this.terminal = terminal;
    }

    public List<PassengerDTO> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerDTO> passengers) {
        this.passengers = passengers;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
    @Override
    public String toString() {
        return "PassengerFlightDTO{" +
                "flightNumber='" + flightNumber + '\'' +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", baggageLine=" + baggageLine +
                ", terminal=" + terminal +
                ", passengers=" + passengers +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", surname='" + surname + '\'' +
                ", baggage=" + baggage +
                ", flight_id='" + flight_id + '\'' +
                '}';
    }
}