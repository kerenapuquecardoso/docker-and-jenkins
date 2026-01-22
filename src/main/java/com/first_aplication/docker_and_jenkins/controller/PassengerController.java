package com.first_aplication.docker_and_jenkins.controller;

import com.first_aplication.docker_and_jenkins.model.dto.PassengerDTO;
import com.first_aplication.docker_and_jenkins.service.PassengerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    private PassengerService  passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PassengerDTO addPassenger(@Valid @RequestBody PassengerDTO passengerDTO) {
        return passengerService.createPassenger(passengerDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PassengerDTO> getAllPassengers() {
        return passengerService.getAllPassengers();
    }
}
