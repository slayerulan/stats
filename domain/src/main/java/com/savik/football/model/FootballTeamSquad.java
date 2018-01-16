package com.savik.football.model;

import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Optionality;
import com.savik.Season;
import com.savik.domain.Identifiable;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "football_league_squad_id_generator")
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"team_id", "season", "championship"})
)
@EqualsAndHashCode
@Builder
@Setter
@Getter
public class FootballTeamSquad extends Identifiable {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @CollectionProperty(optionality = Optionality.OPTIONAL)
    Set<FootballSquadPlayeerSeasonStats> squadPlayers;

    @NotNull
    @Enumerated(EnumType.STRING)
    FootballChampionship championship;

    @NotNull
    @Enumerated(EnumType.STRING)
    Season season;

    @NotNull
    @OneToOne
    FootballTeam team;

}
