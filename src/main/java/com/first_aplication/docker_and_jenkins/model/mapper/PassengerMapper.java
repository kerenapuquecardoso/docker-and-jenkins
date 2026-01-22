package com.first_aplication.docker_and_jenkins.model.mapper;

import com.first_aplication.docker_and_jenkins.model.dto.PassengerDTO;
import com.first_aplication.docker_and_jenkins.model.entity.Passenger;
import org.springframework.stereotype.Component;

@Component
public class PassengerMapper {

    public Passenger toPassenger( PassengerDTO passengerDTO) {
       return Passenger.builder()
                .name(passengerDTO.name())
                .document(passengerDTO.document())
                .chairNumber(passengerDTO.chairNumber())
                .classLevel(passengerDTO.classLevel())
                .birthDate(passengerDTO.birthDate())
                .travelDate(passengerDTO.travelDate())
                .hasDespatchBag(passengerDTO.hasDespatchBag())
                .build();
    }

    public PassengerDTO toPassengerDTO( Passenger passenger) {
        return PassengerDTO.builder()
                .id(passenger.getId())
                .name(passenger.getName())
                .document(passenger.getDocument())
                .chairNumber(passenger.getChairNumber())
                .classLevel(passenger.getClassLevel())
                .birthDate(passenger.getBirthDate())
                .travelDate(passenger.getTravelDate())
                .hasDespatchBag(passenger.isHasDespatchBag())
                .build();
    }
}
