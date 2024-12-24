package com.example.baggagev1.components.HAL;

import com.example.baggagev1.controllers.BaggageController;
import com.example.baggagev1.controllers.PassengerController;
import com.example.baggagev1.dtos.BaggageDTO;
import com.example.baggagev1.dtos.PassengerDTO;
import com.example.baggagev1.models.Baggage;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class BaggageModelAssembler implements RepresentationModelAssembler<BaggageDTO, EntityModel<BaggageDTO>> {

    @Override
    public EntityModel<BaggageDTO> toModel(BaggageDTO baggageDTO) {
        return EntityModel.of(baggageDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BaggageController.class).getBaggage(baggageDTO.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BaggageController.class).getAllBaggage()).withRel("baggage"));
    }
}