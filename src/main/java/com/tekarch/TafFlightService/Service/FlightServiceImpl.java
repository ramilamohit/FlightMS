package com.tekarch.TafFlightService.Service;

import com.tekarch.TafFlightService.DTO.FlightDTO;
import com.tekarch.TafFlightService.Service.Interface.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Value("${datastore.service.url}")
    private String datastoreServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public FlightDTO addFlight(FlightDTO flightDTO) {
        String url = datastoreServiceUrl + "/flights";
        return restTemplate.postForObject(url, flightDTO, FlightDTO.class);
    }

    @Override
    public FlightDTO getFlightById(Long id) {
        String url = datastoreServiceUrl + "/flights/" + id;
        return restTemplate.getForObject(url, FlightDTO.class);
    }

    @Override
    public List<FlightDTO> getAllFlights() {
        String url = datastoreServiceUrl + "/flights";
        FlightDTO[] flights = restTemplate.getForObject(url, FlightDTO[].class);
        return Arrays.asList(flights);
    }

    @Override
    public FlightDTO updateFlight(Long id, FlightDTO flightDTO) {
        String url = datastoreServiceUrl + "/flights/" + id;
        restTemplate.put(url, flightDTO);
        return flightDTO;
    }

    @Override
    public void deleteFlight(Long id) {
        String url = datastoreServiceUrl + "/flights/" + id;
        restTemplate.delete(url);
    }
}
