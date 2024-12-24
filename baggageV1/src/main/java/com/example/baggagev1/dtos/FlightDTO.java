package com.example.baggagev1.dtos;

import com.example.baggagev1.enums.BaggageLineEnum;
import com.example.baggagev1.enums.TerminalEnum;

import java.util.List;

public class FlightDTO {
    private String flightNumber;
    private String departure;
    private String arrival;
    private BaggageLineEnum baggageLine;
    private TerminalEnum terminal;
    private List<PassengerDTO> passengers;

    public FlightDTO() {
    }

    public FlightDTO(String flightNumber, String departure, String arrival, BaggageLineEnum baggageLine, TerminalEnum terminal, List<PassengerDTO> passengers) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.baggageLine = baggageLine;
        this.terminal = terminal;
        this.passengers = passengers;
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
}