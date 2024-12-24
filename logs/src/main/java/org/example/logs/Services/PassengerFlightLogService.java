package org.example.logs.Services;

import org.example.logs.models.PassengerFlightDTO;
import org.example.logs.models.PassengerFlightLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import java.util.UUID;

@Service
public class PassengerFlightLogService {

    @Autowired
    private CassandraTemplate cassandraTemplate;

    @RabbitListener(queues = "passengerFlightQueue")
    public void listenToQueue(PassengerFlightDTO passengerFlightDTO) {
        saveToCassandra(passengerFlightDTO);
    }

    private void saveToCassandra(PassengerFlightDTO passengerFlightDTO) {
        try {
            PassengerFlightLog log = new PassengerFlightLog();
            log.setId(UUID.randomUUID());
            log.setFlightNumber(passengerFlightDTO.getFlightNumber());
            log.setDeparture(passengerFlightDTO.getDeparture());
            log.setArrival(passengerFlightDTO.getArrival());
            log.setBaggageLine(passengerFlightDTO.getBaggageLine());
            log.setTerminal(passengerFlightDTO.getTerminal());
            log.setPassengerId(passengerFlightDTO.getId());
            log.setName(passengerFlightDTO.getName());
            log.setPassportNumber(passengerFlightDTO.getPassportNumber());
            log.setSurname(passengerFlightDTO.getSurname());
            log.setBaggage(passengerFlightDTO.getBaggage());
            log.setFlightId(passengerFlightDTO.getFlightId());

            System.out.println("Attempting to save to Cassandra: " + log);

            cassandraTemplate.insert(log);

            PassengerFlightLog savedLog = cassandraTemplate.selectOneById(PassengerFlightLog.class, PassengerFlightLog.class);
            System.out.println("Saved log in Cassandra: " + savedLog);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error saving to Cassandra: " + e.getMessage());
        }
    }

}