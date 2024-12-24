/*
package com.example.baggagev1.components.resolvers;

import com.example.baggagev1.dtos.FlightDTO;
import com.example.baggagev1.services.FlightService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent
public class FlightDataFetcher {

    @Autowired
    private FlightService flightService;

    @DgsQuery
    public FlightDTO getFlightByNumber(@InputArgument String flightNumber) {
        return flightService.findById(flightNumber);
    }
}*/
