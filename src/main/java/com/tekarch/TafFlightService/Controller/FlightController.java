package com.tekarch.TafFlightService.Controller;

import com.tekarch.TafFlightService.DTO.FlightDTO;
import com.tekarch.TafFlightService.Service.FlightServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight-management")
@CrossOrigin(origins = "*")
public class FlightController {
    @Autowired
    private FlightServiceImpl flightServiceImpl;
    private static final Logger logger = LogManager.getLogger(FlightController.class);

    @PostMapping("/add")
    public ResponseEntity<FlightDTO> addFlight(@RequestBody FlightDTO flightDTO) {
        logger.info("Requesting to create new flight details for flight number " +flightDTO.getFlightNumber());
        return ResponseEntity.ok(flightServiceImpl.addFlight(flightDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDTO> getFlightById(@PathVariable Long id) {
        logger.info("Getting flight details for flight id "+ id);
        return ResponseEntity.ok(flightServiceImpl.getFlightById(id));
    }

    @GetMapping
    public ResponseEntity<List<FlightDTO>> getAllFlights() {
        logger.info("Requesting all flight details");
        return ResponseEntity.ok(flightServiceImpl.getAllFlights());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightDTO> updateFlight(@PathVariable Long id, @RequestBody FlightDTO flightDTO) {
        logger.info("Updating the flight details for flight number {}" + flightDTO.getFlightNumber());
        return ResponseEntity.ok(flightServiceImpl.updateFlight(id, flightDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        logger.info("Deleting the flight with flight id " + id);
        flightServiceImpl.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }
}
