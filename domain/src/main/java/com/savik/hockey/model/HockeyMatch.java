package com.savik.hockey.model;

import com.savik.Match;
import com.savik.Period;
import com.savik.Season;
import com.savik.domain.Identifiable;
import com.savik.football.model.FootballBookieStats;
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
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "hockey_match_id_generator")
@Data
public class HockeyMatch extends Match {

    public static final Function<HockeyMatch, Period> MATCH = hockeyMatch -> hockeyMatch.getMatchInfo().getMatch();
    public static final Function<HockeyMatch, Period> FIRST_PERIOD = hockeyMatch -> hockeyMatch.getMatchInfo().getFirstPeriod();
    public static final Function<HockeyMatch, Period> SECOND_PERIOD = hockeyMatch -> hockeyMatch.getMatchInfo().getSecondPeriod();
    public static final Function<HockeyMatch, Period> THIRD_PERIOD = hockeyMatch -> hockeyMatch.getMatchInfo().getThirdPeriod();


    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    HockeyMatchInfo matchInfo;

    @OneToOne(cascade = CascadeType.ALL)
    HockeyBookieStats bookieStats;

    @NotNull
    @OneToOne
    HockeyTeam homeTeam;

    @NotNull
    @OneToOne
    HockeyTeam guestTeam;

    @NotNull
    @Enumerated(EnumType.STRING)
    HockeyChampionship championship;

    @NotNull
    @Enumerated(EnumType.STRING)
    Season season;

    @NotNull
    LocalDateTime date;

    @NotNull
    String myscoreCode;
}
