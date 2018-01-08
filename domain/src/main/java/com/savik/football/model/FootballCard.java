package com.savik.football.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.savik.Who;
import com.savik.domain.Identifiable;
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
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "football_card_id_generator")
@EqualsAndHashCode
public class FootballCard extends Identifiable {

    @NotNull
    Integer minute;

    @NotNull
    @OneToOne
    FootballTeam team;

    @NotNull
    @Enumerated(EnumType.STRING)
    Who who;

    @NotNull
    @Enumerated(EnumType.STRING)
    Type type;

    public enum Type {
        YELLOW,
        RED,
        YELLOW_RED
    }

    @Override
    public String toString() {
        return "card{" + ", team=" + team + ", type=" + type + '}';
    }
}
