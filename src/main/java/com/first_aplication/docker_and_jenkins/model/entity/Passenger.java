package com.first_aplication.docker_and_jenkins.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Column(unique = true)
    private String document;

    // preciso encontrar alguma forma de validar se o assento já foi reservado
    @NotNull
    private int chairNumber;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private LocalDate travelDate;

    @NotNull
    private boolean hasDespatchBag;

    @NotNull
    private ClassLevel classLevel;

}
