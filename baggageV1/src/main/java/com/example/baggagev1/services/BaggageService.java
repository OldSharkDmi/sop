package com.example.baggagev1.services;

import com.example.baggagev1.dtos.BaggageDTO;
import com.example.baggagev1.enums.BaggageStatusEnum;
import com.example.baggagev1.mappers.BaggageMapper;
import com.example.baggagev1.models.Baggage;
import com.example.baggagev1.models.Passenger;
import com.example.baggagev1.repositories.BaggageRepository;
import com.example.baggagev1.repositories.PassengerRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BaggageService {
    @Autowired
    private BaggageRepository baggageRepository;
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public BaggageDTO save(BaggageDTO baggageDTO) {
        Passenger passenger = passengerRepository.findById(baggageDTO.getPassengerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Passenger not found"));
        Baggage baggage = BaggageMapper.toEntity(baggageDTO, passenger);
        Baggage savedBaggage = baggageRepository.save(baggage);
        return BaggageMapper.toDTO(savedBaggage);
    }

    public BaggageDTO findById(Long id) {
        Baggage baggage = baggageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Baggage not found"));
        return BaggageMapper.toDTO(baggage);
    }

    public Iterable<BaggageDTO> findAll() {
        return StreamSupport.stream(baggageRepository.findAll().spliterator(), false)
                .map(BaggageMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        baggageRepository.deleteById(id);
    }


    public BaggageDTO updateBaggageStatus(Long baggageId, BaggageStatusEnum newStatus) {
        Baggage baggage = baggageRepository.findById(baggageId)
                .orElseThrow(() -> new RuntimeException("Baggage not found"));

        baggage.setStatus(newStatus);
        baggageRepository.save(baggage);

        // Отправляем уведомление
        rabbitTemplate.convertAndSend("baggageExchange", "baggage.status.change", baggage);

        return BaggageMapper.toDTO(baggage);
    }
}