package com.example.baggagev1.mappers;

import com.example.baggagev1.dtos.BaggageDTO;
import com.example.baggagev1.models.Baggage;
import com.example.baggagev1.models.Passenger;

import java.util.List;
import java.util.stream.Collectors;

public interface BaggageMapper {
    public static Baggage toEntity(BaggageDTO baggageDTO, Passenger passenger) {
        Baggage baggage = new Baggage();
        baggage.setId(baggageDTO.getId());
        baggage.setPassenger(passenger);
        baggage.setWeight(baggageDTO.getWeight());
        baggage.setStatus(baggageDTO.getStatus());
        return baggage;
    }

    public static BaggageDTO toDTO(Baggage baggage) {
        BaggageDTO baggageDTO = new BaggageDTO();
        baggageDTO.setId(baggage.getId());
        baggageDTO.setPassengerId(baggage.getPassenger().getId());
        baggageDTO.setWeight(baggage.getWeight());
        baggageDTO.setStatus(baggage.getStatus());
        return baggageDTO;
    }

    public static List<Baggage> toEntityList(List<BaggageDTO> baggageDTOs, Passenger passenger) {
        return baggageDTOs.stream().map(dto -> toEntity(dto, passenger)).collect(Collectors.toList());
    }

    public static List<BaggageDTO> toDTOList(List<Baggage> baggageList) {
        return baggageList.stream().map(BaggageMapper::toDTO).collect(Collectors.toList());
    }
}