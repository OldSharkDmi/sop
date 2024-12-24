package com.example.baggagev1.components.HAL;

import com.example.baggagev1.controllers.FlightController;
import com.example.baggagev1.controllers.PassengerController;
import com.example.baggagev1.dtos.FlightDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class FlightModelAssembler implements RepresentationModelAssembler<FlightDTO, EntityModel<FlightDTO>> {

    @Override
    public EntityModel<FlightDTO> toModel(FlightDTO flightDTO) {
        return EntityModel.of(flightDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FlightController.class).getFlight(flightDTO.getFlightNumber())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PassengerController.class).getPassengersByFlight(flightDTO.getFlightNumber())).withRel("passengers"));
    }
}