package org.example.logs.models;

import java.time.LocalDateTime;


import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.Column;

import java.util.UUID;

@Table("passenger_flight_logs")
public class PassengerFlightLog {
    @PrimaryKey
    @Column("id")
    private UUID id;

    @Column("flight_number")
    private String flightNumber;

    @Column("departure")
    private LocalDateTime departure;

    @Column("arrival")
    private LocalDateTime arrival;

    @Column("baggage_line")
    private String baggageLine;

    @Column("terminal")
    private String terminal;

    @Column("passenger_id")
    private Integer passengerId;

    @Column("name")
    private String name;

    @Column("passport_number")
    private String passportNumber;

    @Column("surname")
    private String surname;

    @Column("baggage")
    private String baggage;

    @Column("flight_id")
    private String flightId;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

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

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
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
