package com.first_aplication.docker_and_jenkins.service;

import com.first_aplication.docker_and_jenkins.model.dto.PassengerDTO;
import com.first_aplication.docker_and_jenkins.model.entity.Passenger;
import com.first_aplication.docker_and_jenkins.model.mapper.PassengerMapper;
import com.first_aplication.docker_and_jenkins.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    private PassengerRepository passengerRepository;
    private PassengerMapper  passengerMapper;

    @Autowired
    public void setPassengerRepository(PassengerRepository passengerRepository,  PassengerMapper passengerMapper) {
        this.passengerRepository = passengerRepository;
        this.passengerMapper = passengerMapper;
    }

    public PassengerDTO createPassenger(PassengerDTO passengerDTO) {
        Passenger passenger = passengerMapper.toPassenger(passengerDTO);
        passenger = passengerRepository.save(passenger);
        return passengerMapper.toPassengerDTO(passenger);
    }

    public List<PassengerDTO> getAllPassengers() {
        return passengerRepository.findAll().stream().map(passengerMapper::toPassengerDTO).toList();
    }
}
