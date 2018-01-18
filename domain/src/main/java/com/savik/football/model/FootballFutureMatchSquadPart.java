package com.savik.football.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    FootballTeamSquad squad;

    @JsonProperty("n of top 5 yc players")
    public Long nOfTop5YellowCardPlayers() {
        List<FootballSquadPlayerSeasonStats> top5TeamYCardsPlayers = getTop5YCPlayers();

        return top5TeamYCardsPlayers.stream().filter(p -> players.contains(p)).count();
    }

    @JsonProperty("average yc/gms from top 5 yc players")
    public Double averageYCFromTop5() {
        List<FootballSquadPlayerSeasonStats> top5TeamYCardsPlayers = getTop5YCPlayers();
        List<FootballSquadPlayerSeasonStats> fromTop5 = top5TeamYCardsPlayers.stream().filter(p -> players.contains(p)).collect(Collectors.toList());

        return fromTop5.stream().mapToDouble(st -> st.ycAverage()).average().orElse(0);
    }

    @JsonProperty("average match squad without from top 5 yc/gms")
    public Double averageYCWithoutTop5() {
        List<FootballSquadPlayerSeasonStats> top5TeamYCardsPlayers = getTop5YCPlayers();
        List<FootballSquadPlayerSeasonStats> fromTop5 = top5TeamYCardsPlayers.stream().filter(p -> players.contains(p)).collect(Collectors.toList());

        return players.stream()
                .filter(st -> !fromTop5.contains(st))
                .mapToDouble(st -> st.ycAverage()).average().orElse(0);
    }

    @JsonProperty("average match squad yc/gms")
    public Double averageYCSquad() {
        return players.stream().mapToDouble(st -> st.ycAverage()).average().getAsDouble();
    }

    @JsonProperty("less 5 games played")
    public Long less5GamesPlayed() {
        return players.stream().filter(st -> st.getGamesPlayed() <= 5).count();
    }


    private List<FootballSquadPlayerSeasonStats> getTop5YCPlayers() {
        return squad.getSquadPlayers().stream()
                .filter(st -> st.getGamesPlayed() > 5 && !st.getIsInjured() && !st.getIsSuspended())
                .sorted(Comparator.comparing(FootballSquadPlayerSeasonStats::ycAverage).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

}
