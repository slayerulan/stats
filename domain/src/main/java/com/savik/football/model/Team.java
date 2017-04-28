package com.savik.football.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.savik.domain.Identifiable;
import lombok.*;

/**
 * @author Savushkin Yauheni
 * @since 10.04.2017
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team extends Identifiable {

    @NotNull
    @Enumerated(EnumType.STRING)
    Championship championship;

    @NotNull
    String name;

}
