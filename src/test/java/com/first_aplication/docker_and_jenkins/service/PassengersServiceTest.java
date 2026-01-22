package com.first_aplication.docker_and_jenkins.service;

import com.first_aplication.docker_and_jenkins.model.dto.PassengerDTO;
import com.first_aplication.docker_and_jenkins.model.entity.Passenger;
import com.first_aplication.docker_and_jenkins.model.mapper.PassengerMapper;
import com.first_aplication.docker_and_jenkins.repository.PassengerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static com.first_aplication.docker_and_jenkins.mocks.PassengerMocks.PASSENGER;
import static com.first_aplication.docker_and_jenkins.mocks.PassengerMocks.PASSENGER_DTO;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PassengersServiceTest {

    @InjectMocks
    private PassengerService passengerService;

    @Mock
    private PassengerRepository passengerRepository;

    @Mock
    private PassengerMapper passengerMapper;

    @Test
    public void given_CreatePost_when_ValidData_then_RequestShouldReturnAnObject() {
        when(passengerMapper.toPassenger(any(PassengerDTO.class))).thenReturn(PASSENGER);
        when(passengerMapper.toPassengerDTO(any(Passenger.class))).thenReturn(PASSENGER_DTO);

        when(passengerRepository.save(any(Passenger.class))).thenReturn(PASSENGER);

        PassengerDTO passengerDTO = passengerService.createPassenger(PASSENGER_DTO);

        assertThat(passengerDTO.birthDate()).isEqualTo(PASSENGER_DTO.birthDate());
        assertThat(passengerDTO.name()).isEqualTo(PASSENGER_DTO.name());
    }

    @Test
    public void given_ListedAllPosts_when_HasData_then_RequestShouldReturnAnObjects() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(PASSENGER);
        when(passengerRepository.findAll()).thenReturn(passengers);

        List<PassengerDTO> passengerDTOs = passengerService.getAllPassengers();
        assertThat(passengerDTOs.size()).isEqualTo(1);
    }
}
