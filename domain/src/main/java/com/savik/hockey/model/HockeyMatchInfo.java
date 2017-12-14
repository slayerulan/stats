package com.savik.hockey.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.savik.domain.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 * @author Savushkin Yauheni
 * @since 10.04.2017
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "hockey_match_info_id_generator")
@Getter
public class HockeyMatchInfo extends Identifiable {

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    HockeyPeriod match;

    @OneToOne(cascade = CascadeType.ALL)
    HockeyPeriod firstPeriod;

    @OneToOne(cascade = CascadeType.ALL)
    HockeyPeriod secondPeriod;

    @OneToOne(cascade = CascadeType.ALL)
    HockeyPeriod thirdPeriod;

    @OneToOne(cascade = CascadeType.ALL)
    HockeyPeriod overtime;

    @Override
    @JsonValue
    public String toString() {
        return "{" +
                "m=" + match +
                ", " + firstPeriod +
                ", " + secondPeriod +
                ", " + thirdPeriod +
                '}';
    }
}
