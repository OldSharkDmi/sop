package com.example.baggage_contracts.dto;

import com.example.baggage_contracts.enums.BaggageStatusEnum;
import jakarta.validation.constraints.NotNull;

public record BaggageDTO(
        @NotNull
        Long id,
        @NotNull

        Long passengerId,
        @NotNull

        double weight,
        @NotNull

        BaggageStatusEnum status
) {
}
