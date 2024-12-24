package com.example.baggagev1.controllers;

import com.example.baggagev1.dtos.PassengerDTO;
import com.example.baggagev1.services.PassengerService;
import com.example.baggagev1.components.HAL.PassengerModelAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @Autowired
    private PassengerModelAssembler assembler;

    @PostMapping
    public ResponseEntity<EntityModel<PassengerDTO>> createPassenger(@RequestBody PassengerDTO passengerDTO) {
        PassengerDTO createdPassenger = passengerService.save(passengerDTO);
        return ResponseEntity.created(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PassengerController.class).getPassengerById(createdPassenger.getId())).toUri())
                .body(assembler.toModel(createdPassenger));
    }

    @GetMapping
    public CollectionModel<EntityModel<PassengerDTO>> getAllPassengers() {
        List<EntityModel<PassengerDTO>> passengers = StreamSupport.stream(passengerService.findAll().spliterator(), false)
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(passengers,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PassengerController.class).getAllPassengers()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<PassengerDTO> getPassengerById(@PathVariable Long id) {
        PassengerDTO passengerDTO = passengerService.findById(id);
        return assembler.toModel(passengerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
        passengerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/flights/{flightNumber}/passengers")
    public List<PassengerDTO> getPassengersByFlight(@PathVariable String flightNumber) {
        return passengerService.findPassengersByFlight(flightNumber);
    }




}