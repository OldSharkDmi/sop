package com.example.baggagev1.repositories;

import com.example.baggagev1.models.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<Flight, String> {
}