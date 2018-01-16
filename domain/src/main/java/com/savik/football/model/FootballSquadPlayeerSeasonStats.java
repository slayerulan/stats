package com.savik.football.model;

import com.savik.domain.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "football_squad_player_stats_id_generator")
@EqualsAndHashCode
@Builder
public class FootballSquadPlayeerSeasonStats extends Identifiable {

    @NotNull
    @OneToOne
    private FootballSquadPlayeer playeer;

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

}
