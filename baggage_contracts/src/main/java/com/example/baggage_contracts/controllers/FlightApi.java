package com.example.baggage_contracts.controllers;


import com.example.baggage_contracts.dto.FlightDTO;
import com.example.baggage_contracts.dto.PassengerDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@Tag(name = "flights", description = "Управление рейсами")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации данных"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})
@RequestMapping("/flights")
public interface FlightApi {

    @Operation(summary = "Создать новый рейс")
    @PostMapping
    ResponseEntity<EntityModel<FlightDTO>> createFlight(@Valid @RequestBody FlightDTO flightDTO);

    @Operation(summary = "Получить данные рейса по его номеру")
    @GetMapping("/{flightNumber}")
    EntityModel<FlightDTO> getFlight(@PathVariable String flightNumber);

    @Operation(summary = "Получить список всех рейсов")
    @GetMapping
    CollectionModel<EntityModel<FlightDTO>> getAllFlights();

    @Operation(summary = "Удалить рейс по его номеру")
    @DeleteMapping("/{flightNumber}")
    void deleteFlight(@PathVariable String flightNumber);

    @Operation(summary = "Добавить пассажира на рейс")
    @PostMapping("/{flightNumber}/passengers")
    ResponseEntity<PassengerDTO> addPassengerToFlight(@PathVariable String flightNumber, @Valid @RequestBody PassengerDTO passengerDTO);
}

