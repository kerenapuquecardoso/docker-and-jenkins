package com.first_aplication.docker_and_jenkins.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.first_aplication.docker_and_jenkins.model.entity.ClassLevel;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PassengerDTO(
        Long id,

        @NotNull
        String name,

        @NotNull
        String document,

        @NotNull
        int chairNumber,

        @JsonFormat(pattern = "dd/MM/yyyy")
        @NotNull
        LocalDate birthDate,

        @JsonFormat(pattern = "dd/MM/yyyy")
        @NotNull
        @FutureOrPresent(message = "The date must be in the present or the future!")
        LocalDate travelDate,

        @NotNull
        boolean hasDespatchBag,

        @NotNull
        ClassLevel classLevel


) {
}

