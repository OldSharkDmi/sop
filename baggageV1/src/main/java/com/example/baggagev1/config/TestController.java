package com.example.baggagev1.config;

import com.example.baggagev1.dtos.BaggageDTO;
import com.example.baggagev1.dtos.PassengerFlightDTO;
import com.example.baggagev1.enums.BaggageStatusEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.baggagev1.enums.BaggageLineEnum.LINE_1;
import static com.example.baggagev1.enums.TerminalEnum.A;


@RestController
public class BaggageControllerRun {
    private final RabbitMQSender rabbitMQSender;
    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;
    private final BaggageRepository baggageRepository;

    public BaggageController(RabbitMQSender rabbitMQSender,
                             FlightRepository flightRepository,
                             PassengerRepository passengerRepository,
                             BaggageRepository baggageRepository) {
        this.rabbitMQSender = rabbitMQSender;
        this.flightRepository = flightRepository;
        this.passengerRepository = passengerRepository;
        this.baggageRepository = baggageRepository;
    }

    @PostMapping("/createBaggageWithPassengerAndFlight")
    public ResponseEntity<String> createBaggageWithPassengerAndFlight(@RequestBody BaggageCreationRequest request) {

        Flight flight = new Flight();
        flight.setFlightNumber(request.getFlightNumber());
        flight.setDeparture(request.getDeparture());
        flight.setArrival(request.getArrival());
        flight.setTerminal(request.getTerminal());
        flight.setBaggageLine(request.getBaggageLine());
        flightRepository.save(flight);

        Passenger passenger = new Passenger();
        passenger.setName(request.getPassengerName());
        passenger.setSurname(request.getPassengerSurname());
        passenger.setPassportNumber(request.getPassportNumber());
        passenger.setFlight(flight);
        passengerRepository.save(passenger);


        Baggage baggage = new Baggage();
        baggage.setWeight(request.getWeight());
        baggage.setStatus(BaggageStatusEnum.REGISTERED);
        baggage.setPassenger(passenger);
        baggageRepository.save(baggage);


        BaggageDTO baggageDTO = new BaggageDTO();
        baggageDTO.setId(baggage.getId());
        baggageDTO.setPassengerId(passenger.getId());
        baggageDTO.setWeight(baggage.getWeight());
        baggageDTO.setStatus(baggage.getStatus());
        rabbitMQSender.sendBaggage(baggageDTO);

        PassengerFlightDTO passengerFlightDTO = new PassengerFlightDTO();
        passengerFlightDTO.setFlightNumber(flight.getFlightNumber());
        passengerFlightDTO.setDeparture(flight.getDeparture().toString());
        passengerFlightDTO.setArrival(flight.getArrival().toString());
        passengerFlightDTO.setFlight_id(flight.getId().toString());
        passengerFlightDTO.setName(passenger.getName());
        passengerFlightDTO.setSurname(passenger.getSurname());
        passengerFlightDTO.setPassportNumber(passenger.getPassportNumber());
        passengerFlightDTO.setId(passenger.getId());
        rabbitMQSender.sendPassengerFlight(passengerFlightDTO);

        return ResponseEntity.ok("Baggage, Passenger, and Flight created and messages sent!");
    }
}

