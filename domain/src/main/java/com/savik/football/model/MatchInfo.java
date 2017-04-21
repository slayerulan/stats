package com.savik.football.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
@Builder
public class MatchInfo extends Identifiable {

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    Period firstPeriod;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    Period secondPeriod;

}
