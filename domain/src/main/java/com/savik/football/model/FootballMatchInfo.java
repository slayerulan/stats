package com.savik.football.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonValue;
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
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "football_match_info_id_generator")
@Getter
public class FootballMatchInfo extends Identifiable {

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    FootballPeriod match;

    @OneToOne(cascade = CascadeType.ALL)
    FootballPeriod firstPeriod;

    @OneToOne(cascade = CascadeType.ALL)
    FootballPeriod secondPeriod;

    @Override
    @JsonValue
    public String toString() {
        return "{" +
                "m=" + match +
                "h1=, " + firstPeriod +
                "h2=, " + secondPeriod +
                '}';
    }

}
