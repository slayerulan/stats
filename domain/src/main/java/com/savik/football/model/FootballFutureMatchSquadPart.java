package com.savik.football.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.savik.domain.Identifiable;
import lombok.*;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "football_future_match_squad_part_id_generator")
@EqualsAndHashCode
@Getter
public class FootballFutureMatchSquadPart extends Identifiable {

    @OneToMany(fetch = FetchType.EAGER)
    Set<FootballSquadPlayerSeasonStats> players;

    public FootballFutureMatchSquadPart(Set<FootballSquadPlayerSeasonStats> players) {
        this.players = players;
    }

    @Transient
    @Setter
    FootballTeamSquad squad;

    @JsonProperty
    public Long nOfTop5YellowCardPlayers() {
        List<FootballSquadPlayerSeasonStats> top5TeamYCardsPlayers = squad.getSquadPlayers().stream()
                .filter(st -> st.getGamesPlayed() > 5 && !st.getIsInjured() && !st.getIsSuspended())
                .sorted(Comparator.comparing(FootballSquadPlayerSeasonStats::ycAverage).reversed())
                .limit(5)
                .collect(Collectors.toList());

        return top5TeamYCardsPlayers.stream().filter(p -> players.contains(p)).count();
    }

}
