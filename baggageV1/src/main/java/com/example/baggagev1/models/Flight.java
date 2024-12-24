package com.example.baggagev1.models;

import com.example.baggagev1.enums.BaggageLineEnum;
import com.example.baggagev1.enums.TerminalEnum;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Flight {
    @Id
    private String flightNumber;

    private String departure;

    private String arrival;

    @Enumerated(EnumType.STRING)
    private BaggageLineEnum baggageLine;

    @Enumerated(EnumType.STRING)
    private TerminalEnum terminal;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Passenger> passengers;

    public Flight() {
    }

    public Flight(String flightNumber, String departure, String arrival, BaggageLineEnum baggageLine, TerminalEnum terminal, List<Passenger> passengers) {
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

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", baggageLine=" + baggageLine +
                ", terminal=" + terminal +
                ", passengers=" + passengers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(flightNumber, flight.flightNumber) &&
                Objects.equals(departure, flight.departure) &&
                Objects.equals(arrival, flight.arrival) &&
                baggageLine == flight.baggageLine &&
                terminal == flight.terminal &&
                Objects.equals(passengers, flight.passengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, departure, arrival, baggageLine, terminal, passengers);
    }
}