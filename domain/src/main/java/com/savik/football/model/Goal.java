package com.savik.football.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import domain.Identifiable;
import lombok.*;

/**
 * @author Savushkin Yauheni
 * @since 10.04.2017
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
public class Goal extends Identifiable {

    @NotNull
    Integer minute;

    @NotNull
    @OneToOne
    Team team;

    @NotNull
    @Enumerated(EnumType.STRING)
    Who whoScored;

}
