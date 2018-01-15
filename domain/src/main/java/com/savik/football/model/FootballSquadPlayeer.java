package com.savik.football.model;

import com.savik.domain.Identifiable;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "football_squad_player_id_generator")
@EqualsAndHashCode
@Builder
public class FootballSquadPlayeer extends Identifiable {

    @NotNull
    private String name;

    @NotNull
    private Integer gamesPlayed;

    @NotNull
    private Integer goalsScored;

    @NotNull
    private Integer yellowCardsAmount;

    @NotNull
    private Integer redCardsAmount;

    @NotNull
    private Boolean isInjured;

    @NotNull
    private Boolean isSuspended;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FootballSquadPlayeer that = (FootballSquadPlayeer) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name);
    }
}
