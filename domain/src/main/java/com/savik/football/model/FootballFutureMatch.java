package com.savik.football.model;

import com.savik.FutureMatch;
import com.savik.Season;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = "myscoreCode"),
        indexes = @Index(columnList = "myscoreCode")
)
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "football_future_match_id_generator")
@Data
public class FootballFutureMatch extends FutureMatch<FootballTeam> {

    @NotNull
    @Enumerated(EnumType.STRING)
    FootballChampionship championship;

    @Builder
    public FootballFutureMatch(FootballTeam homeTeam, FootballTeam guestTeam, String myscoreCode, Season season, LocalDateTime date, FootballChampionship championship) {
        super(homeTeam, guestTeam, myscoreCode, season, date);
        this.championship = championship;
    }

    @Override
    public String getChampionshipString() {
        return championship.toString();
    }
}
