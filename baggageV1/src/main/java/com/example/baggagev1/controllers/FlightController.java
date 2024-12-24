package com.example.baggagev1.controllers;

import com.example.baggagev1.dtos.FlightDTO;
import com.example.baggagev1.dtos.PassengerDTO;
import com.example.baggagev1.services.FlightService;
import com.example.baggagev1.components.HAL.FlightModelAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightModelAssembler assembler;

    @PostMapping
    public ResponseEntity<EntityModel<FlightDTO>> createFlight(@RequestBody FlightDTO flightDTO) {
        FlightDTO createdFlight = flightService.save(flightDTO);
        return ResponseEntity.created(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FlightController.class).getFlight(createdFlight.getFlightNumber())).toUri())
                .body(assembler.toModel(createdFlight));
    }

    @GetMapping("/{flightNumber}")
    public EntityModel<FlightDTO> getFlight(@PathVariable String flightNumber) {
        FlightDTO flightDTO = flightService.findById(flightNumber);
        return assembler.toModel(flightDTO);
    }

    @GetMapping
    public CollectionModel<EntityModel<FlightDTO>> getAllFlights() {
        List<EntityModel<FlightDTO>> flights = ((List<FlightDTO>) flightService.findAll()).stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(flights,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FlightController.class).getAllFlights()).withSelfRel());
    }

    @DeleteMapping("/{flightNumber}")
    public void deleteFlight(@PathVariable String flightNumber) {
        flightService.delete(flightNumber);
    }

    @PostMapping("/{flightNumber}/passengers")
    public ResponseEntity<PassengerDTO> addPassengerToFlight(@PathVariable String flightNumber, @RequestBody PassengerDTO passengerDTO) {
        PassengerDTO addedPassenger = flightService.addPassengerToFlight(flightNumber, passengerDTO);
        return ResponseEntity.ok(addedPassenger);
    }
}