package org.example.logs.mappers;

import org.example.logs.models.PassengerFlightDTO;
import org.example.logs.models.PassengerFlightLog;
import org.modelmapper.ModelMapper;

public class PassengerFlightMapper {

    private final ModelMapper modelMapper;

    public PassengerFlightMapper() {
        this.modelMapper = new ModelMapper();
    }

    public PassengerFlightLog toEntity(PassengerFlightDTO dto) {
        PassengerFlightLog log = modelMapper.map(dto, PassengerFlightLog.class);
        return log;
    }
}
