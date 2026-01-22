package com.first_aplication.docker_and_jenkins.mocks;

import com.first_aplication.docker_and_jenkins.model.dto.PassengerDTO;
import com.first_aplication.docker_and_jenkins.model.entity.ClassLevel;
import com.first_aplication.docker_and_jenkins.model.entity.Passenger;

import java.time.LocalDate;

public class PassengerMocks {
    public static final LocalDate DATE = LocalDate.now();
    public static final LocalDate BORN =  LocalDate.of(2000, 11, 19);
    public static final LocalDate DATE_WRONG = LocalDate.of(2025, 11, 19);
    public static final Passenger PASSENGER = new Passenger(1L, "Afonso", "123.999.029-03", 13, BORN, DATE, true, ClassLevel.ECONOMY);
    public static final PassengerDTO PASSENGER_DTO = new PassengerDTO(1L, "Afonso", "123.999.029-03", 13, BORN, DATE, true, ClassLevel.ECONOMY);
}
