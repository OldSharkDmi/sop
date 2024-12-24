package com.example.baggage_contracts.dto;

import com.example.baggage_contracts.enums.BaggageLineEnum;
import com.example.baggage_contracts.enums.TerminalEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record FlightDTO (
        @NotNull
        String flightNumber,
        @NotEmpty
        String departure,
        @NotEmpty
        String arrival,
        @NotEmpty
        BaggageLineEnum baggageLine,
        @NotEmpty
        TerminalEnum terminal,
        @NotNull
        List<PassengerDTO> passengers
){
}
