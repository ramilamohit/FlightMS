package com.tekarch.TafFlightService.Service.Interface;

import com.tekarch.TafFlightService.DTO.FlightDTO;

import java.util.List;

public interface FlightService {
    FlightDTO addFlight(FlightDTO flightDTO);
    FlightDTO getFlightById(Long id);
    List<FlightDTO> getAllFlights();
    FlightDTO updateFlight(Long id, FlightDTO flightDTO);
    void deleteFlight(Long id);
}
