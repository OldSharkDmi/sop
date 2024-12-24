package com.example.baggagev1.mappers;

import com.example.baggagev1.dtos.BaggageDTO;
import com.example.baggagev1.dtos.PassengerDTO;
import com.example.baggagev1.models.Flight;
import com.example.baggagev1.models.Passenger;
import com.example.baggagev1.repositories.FlightRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PassengerMapper {
    public static Passenger toEntity(PassengerDTO dto, FlightRepository flightRepository) {
        Passenger passenger = new Passenger();
        passenger.setId(dto.getId());
        passenger.setName(dto.getName());
        passenger.setPassport(dto.getPassportNumber());


        if (dto.getFlight_id() != null) {
            Flight flight = flightRepository.findById(dto.getFlight_id()).orElse(null);
            passenger.setFlight(flight);
        }
        return passenger;
    }

    public static PassengerDTO toDTO(Passenger passenger) {
        PassengerDTO dto = new PassengerDTO();
        dto.setId(passenger.getId());
        dto.setName(passenger.getName());
        dto.setPassportNumber(passenger.getPassport());

        dto.setFlight_id(passenger.getFlight() != null ? passenger.getFlight().getFlightNumber() : null);

        if (passenger.getBaggageList() != null) {
            dto.setBaggage(passenger.getBaggageList().stream()
                    .map(baggage -> {
                        BaggageDTO baggageDTO = new BaggageDTO();
                        baggageDTO.setId(baggage.getId());
                        baggageDTO.setPassengerId(passenger.getId());
                        baggageDTO.setWeight(baggage.getWeight());
                        baggageDTO.setStatus(baggage.getStatus());
                        return baggageDTO;
                    })
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public static List<Passenger> toEntityList(List<PassengerDTO> dtoList, FlightRepository flightRepository) {
        return dtoList.stream()
                .map(dto -> toEntity(dto, flightRepository))
                .collect(Collectors.toList());
    }

    public static List<PassengerDTO> toDTOList(List<Passenger> entityList) {
        return entityList.stream()
                .map(PassengerMapper::toDTO)
                .collect(Collectors.toList());
    }
}