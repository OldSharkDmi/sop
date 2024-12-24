package com.example.baggage_contracts.controllers;

import com.example.baggage_contracts.dto.BaggageDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name = "baggage", description = "Управление багажом")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации данных"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})
@RequestMapping("/baggage")
public interface BaggageApi {

    @Operation(summary = "Создать запись о багаже")
    @PostMapping
    ResponseEntity<EntityModel<BaggageDTO>> createBaggage(@Valid @RequestBody BaggageDTO baggageDTO);

    @Operation(summary = "Получить данные о багаже по ID")
    @GetMapping("/{id}")
    EntityModel<BaggageDTO> getBaggage(@PathVariable Long id);

    @Operation(summary = "Получить список всех записей о багаже")
    @GetMapping
    CollectionModel<EntityModel<BaggageDTO>> getAllBaggage();

    @Operation(summary = "Удалить запись о багаже по ID")
    @DeleteMapping("/{id}")
    void deleteBaggage(@PathVariable Long id);
}
