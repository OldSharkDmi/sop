package com.example.baggagev1.repositories;

import com.example.baggagev1.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    @Query("SELECT p FROM Passenger p WHERE p.flight.flightNumber = :flightNumber")
    List<Passenger> findPassengersByFlight(@Param("flightNumber") String flightNumber);
}