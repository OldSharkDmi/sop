package com.example.baggagev1.services;

import com.example.baggagev1.dtos.AddPassengerDTO;
import com.example.baggagev1.dtos.BaggageDTO;
import com.example.baggagev1.dtos.PassengerDTO;
import com.example.baggagev1.mappers.BaggageMapper;
import com.example.baggagev1.mappers.PassengerMapper;
import com.example.baggagev1.models.Passenger;
import com.example.baggagev1.repositories.BaggageRepository;
import com.example.baggagev1.repositories.FlightRepository;
import com.example.baggagev1.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private BaggageRepository baggageRepository;

    public PassengerDTO save(PassengerDTO passengerDTO) {
        Passenger passenger = PassengerMapper.toEntity(passengerDTO, flightRepository);
        Passenger savedPassenger = passengerRepository.save(passenger);
        return PassengerMapper.toDTO(savedPassenger);
    }

    public PassengerDTO findById(Long id) {
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Passenger not found"));
        return PassengerMapper.toDTO(passenger);
    }

    public List<PassengerDTO> findAll() {
        return StreamSupport.stream(passengerRepository.findAll().spliterator(), false)
                .map(PassengerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        passengerRepository.deleteById(id);
    }

    public List<PassengerDTO> findPassengersByFlight(String flightNumber) {
        return passengerRepository.findPassengersByFlight(flightNumber).stream()
                .map(PassengerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<BaggageDTO> findBaggageByPassengerId(Long passengerId) {
        return baggageRepository.findByPassengerId(passengerId).stream()
                .map(BaggageMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PassengerDTO addPassenger(AddPassengerDTO addPassengerDto) {

        PassengerDTO newPassenger = new PassengerDTO();
        newPassenger.setName(addPassengerDto.getName());
        newPassenger.setSurname(addPassengerDto.getSurname());
        newPassenger.setPassportNumber(addPassengerDto.getPassportNumber());
        newPassenger.setBaggage(addPassengerDto.getBaggage());
        newPassenger.setFlight_id(addPassengerDto.getFlight_id());

        Passenger passengerEntity = PassengerMapper.toEntity(newPassenger, flightRepository);
        Passenger savedPassenger = passengerRepository.save(passengerEntity);
        return PassengerMapper.toDTO(savedPassenger);
    }



}