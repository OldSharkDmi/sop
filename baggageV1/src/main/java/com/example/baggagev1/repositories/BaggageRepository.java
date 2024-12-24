package com.example.baggagev1.repositories;

import com.example.baggagev1.models.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaggageRepository extends JpaRepository<Baggage, Long> {
        List<Baggage> findByPassengerId(Long passengerId);
}