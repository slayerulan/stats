package com.savik.football.model;

import com.savik.domain.Identifiable;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "football_squad_player_stats_id_generator")
@EqualsAndHashCode
@Builder
@Getter
public class FootballSquadPlayeerSeasonStats extends Identifiable {

    @NotNull
    @OneToOne
    private FootballSquadPlayeer player;

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

    public Double ycAverage() {
        if(gamesPlayed == 0) {
            return 0.;
        }
        return BigDecimal.valueOf(yellowCardsAmount / (double) gamesPlayed)
                .setScale(3, RoundingMode.HALF_UP)
                .doubleValue();
    }

    @Override
    public String toString() {
        return "{" +
                "player=" + player +
                ", gms=" + gamesPlayed +
                ", y crds=" + yellowCardsAmount +
                '}';
    }
}
