package com.example.baggagev1.mappers;

import com.example.baggagev1.dtos.FlightDTO;
import com.example.baggagev1.models.Flight;
import com.example.baggagev1.repositories.FlightRepository;

public class FlightMapper {
    public static Flight toEntity(FlightDTO flightDTO, FlightRepository flightRepository) {
        Flight flight = new Flight();
        flight.setFlightNumber(flightDTO.getFlightNumber());
        flight.setDeparture(flightDTO.getDeparture());
        flight.setArrival(flightDTO.getArrival());
        flight.setBaggageLine(flightDTO.getBaggageLine());
        flight.setTerminal(flightDTO.getTerminal());
        flight.setPassengers(PassengerMapper.toEntityList(flightDTO.getPassengers(), flightRepository));
        return flight;
    }

    public static FlightDTO toDTO(Flight flight) {
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setFlightNumber(flight.getFlightNumber());
        flightDTO.setDeparture(flight.getDeparture());
        flightDTO.setArrival(flight.getArrival());
        flightDTO.setBaggageLine(flight.getBaggageLine());
        flightDTO.setTerminal(flight.getTerminal());
        flightDTO.setPassengers(PassengerMapper.toDTOList(flight.getPassengers()));
        return flightDTO;
    }
}