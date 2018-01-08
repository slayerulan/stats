package com.savik.football.model;

import com.savik.Match;
import com.savik.Period;
import com.savik.Season;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.function.Function;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = "myscoreCode"),
        indexes = @Index(columnList = "myscoreCode")
)
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "football_match_id_generator")
@Data
public class FootballMatch extends Match {

    public static final Function<FootballMatch, Period> MATCH = match -> match.matchInfo.getMatch();
    public static final Function<FootballMatch, Period> FIRST_PERIOD = match -> match.matchInfo.getFirstPeriod();
    public static final Function<FootballMatch, Period> SECOND_PERIOD = match -> match.matchInfo.getSecondPeriod();

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    FootballMatchInfo matchInfo;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    FootballBookieStats bookieStats;

    @NotNull
    @OneToOne
    FootballTeam homeTeam;

    @NotNull
    @OneToOne
    FootballTeam guestTeam;

    @NotNull
    @Enumerated(EnumType.STRING)
    FootballChampionship championship;

    @NotNull
    @Enumerated(EnumType.STRING)
    Season season;

    @NotNull
    LocalDateTime date;

    @NotNull
    String myscoreCode;

    @OneToOne
    FootballReferee referee;
}
