package com.example.baggagev1.controllers;

import com.example.baggagev1.dtos.BaggageDTO;
import com.example.baggagev1.models.Baggage;
import com.example.baggagev1.services.BaggageService;
import com.example.baggagev1.components.HAL.BaggageModelAssembler;
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
@RequestMapping("/baggage")
public class BaggageController {
    @Autowired
    private BaggageService baggageService;

    @Autowired
    private BaggageModelAssembler assembler;

    @PostMapping
    public ResponseEntity<EntityModel<BaggageDTO>> createBaggage(@RequestBody BaggageDTO baggageDTO) {
        BaggageDTO createdBaggage = baggageService.save(baggageDTO);
        return ResponseEntity.created(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BaggageController.class).getBaggage(createdBaggage.getId())).toUri())
                .body(assembler.toModel(createdBaggage));
    }

    @GetMapping("/{id}")
    public EntityModel<BaggageDTO> getBaggage(@PathVariable Long id) {
        BaggageDTO baggageDTO = baggageService.findById(id);
        return assembler.toModel(baggageDTO);
    }

    @GetMapping
    public CollectionModel<EntityModel<BaggageDTO>> getAllBaggage() {
        List<EntityModel<BaggageDTO>> baggageList = StreamSupport.stream(baggageService.findAll().spliterator(), false)
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(baggageList,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BaggageController.class).getAllBaggage()).withSelfRel());
    }

    @DeleteMapping("/{id}")
    public void deleteBaggage(@PathVariable Long id) {
        baggageService.delete(id);
    }
}
