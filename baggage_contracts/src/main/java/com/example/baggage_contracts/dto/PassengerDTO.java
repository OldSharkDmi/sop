package com.example.baggage_contracts.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record PassengerDTO(
        @NotNull
        Long id,
        @Size(min = 2, max = 50)
         String name,
        @Size   (min = 2, max = 50)
         String surname,
        @Size(min = 14, max = 14)
        String passportNumber,
        @NotNull
       List<BaggageDTO> baggage,
         String flight_id)
{


}
