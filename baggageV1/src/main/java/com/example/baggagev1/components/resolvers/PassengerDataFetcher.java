package com.example.baggagev1.components.resolvers;

import com.example.baggagev1.dtos.AddPassengerDTO;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.example.baggagev1.dtos.PassengerDTO;
import com.example.baggagev1.services.PassengerService;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@DgsComponent
public class PassengerDataFetcher {

    private static final Logger logger = LoggerFactory.getLogger(PassengerDataFetcher.class);

    private final PassengerService passengerService;

    @Autowired
    public PassengerDataFetcher(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @DgsQuery
    public List<PassengerDTO> getAllPassengers() {
        logger.info("Fetching all passengers");
        List<PassengerDTO> passengers = passengerService.findAll();
        logger.info("Fetched {} passengers", passengers.size());
        return passengers;
    }
    @DgsMutation
    public PassengerDTO addPassenger(@InputArgument AddPassengerDTO addPassengerDto) {
        logger.info("Adding new passenger: {}", addPassengerDto);
        PassengerDTO newPassenger = passengerService.addPassenger(addPassengerDto);
        logger.info("Added new passenger with ID: {}", newPassenger.getId());
        return newPassenger;
    }
}