package com.example.baggage_contracts.controllers;



import com.example.baggage_contracts.dto.PassengerDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "passengers", description = "Операции с пассажирами")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})
public interface PassengerApi {

    @Operation(summary = "Создать нового пассажира")
    @PostMapping(produces = "application/json", consumes = "application/json")
    ResponseEntity<EntityModel<PassengerDTO>> createPassenger(@RequestBody PassengerDTO passengerDTO);

    @Operation(summary = "Получить всех пассажиров")
    @GetMapping(produces = "application/json")
    CollectionModel<EntityModel<PassengerDTO>> getAllPassengers();

    @Operation(summary = "Получить пассажира по ID")
    @GetMapping(value = "/{id}", produces = "application/json")
    EntityModel<PassengerDTO> getPassengerById(@PathVariable Long id);

    @Operation(summary = "Удалить пассажира по ID")
    @DeleteMapping("/{id}")
    void deletePassenger(@PathVariable Long id);

    @Operation(summary = "Получить пассажиров по номеру рейса")
    @GetMapping(value = "/flights/{flightNumber}/passengers", produces = "application/json")
    List<PassengerDTO> getPassengersByFlight(@PathVariable String flightNumber);
}
