package com.example.baggagev1.components.HAL;


import com.example.baggagev1.controllers.PassengerController;
import com.example.baggagev1.dtos.PassengerDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class PassengerModelAssembler implements RepresentationModelAssembler<PassengerDTO, EntityModel<PassengerDTO>> {

    @Override
    public EntityModel<PassengerDTO> toModel(PassengerDTO passengerDTO) {
        return EntityModel.of(passengerDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PassengerController.class).getPassengerById(passengerDTO.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PassengerController.class).getAllPassengers()).withRel("passengers"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PassengerController.class).deletePassenger(passengerDTO.getId())).withRel("delete"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PassengerController.class).createPassenger(null)).withRel("add"));
    }
}
