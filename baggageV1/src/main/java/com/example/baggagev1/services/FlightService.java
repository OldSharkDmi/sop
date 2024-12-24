package com.example.baggagev1.services;

import com.example.baggagev1.dtos.FlightDTO;
import com.example.baggagev1.dtos.PassengerDTO;
import com.example.baggagev1.mappers.FlightMapper;
import com.example.baggagev1.mappers.PassengerMapper;
import com.example.baggagev1.models.Flight;
import com.example.baggagev1.models.Passenger;
import com.example.baggagev1.repositories.FlightRepository;
import com.example.baggagev1.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private PassengerRepository passengerRepository;

    public PassengerDTO addPassengerToFlight(String flightNumber, PassengerDTO passengerDTO) {
        Flight flight = flightRepository.findById(flightNumber)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found"));
        Passenger passenger = PassengerMapper.toEntity(passengerDTO, flightRepository);
        passenger.setFlight(flight);
        Passenger savedPassenger = passengerRepository.save(passenger);
        return PassengerMapper.toDTO(savedPassenger);
    }

    public FlightDTO save(FlightDTO flightDTO) {
        Flight flight = FlightMapper.toEntity(flightDTO, flightRepository);
        Flight savedFlight = flightRepository.save(flight);
        return FlightMapper.toDTO(savedFlight);
    }

    public FlightDTO findById(String flightNumber) {
        Flight flight = flightRepository.findById(flightNumber)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found"));
        return FlightMapper.toDTO(flight);
    }

    public Iterable<FlightDTO> findAll() {
        return StreamSupport.stream(flightRepository.findAll().spliterator(), false)
                .map(FlightMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void delete(String flightNumber) {
        flightRepository.deleteById(flightNumber);
    }
}