package com.savik.hockey.model;

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
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "hockey_future_match_id_generator")
@Data
public class HockeyFutureMatch extends FutureMatch<HockeyTeam> {



    @NotNull
    @Enumerated(EnumType.STRING)
    HockeyChampionship championship;

    @Builder
    public HockeyFutureMatch(HockeyTeam homeTeam, HockeyTeam guestTeam, String myscoreCode, Season season, LocalDateTime date, HockeyChampionship championship) {
        super(homeTeam, guestTeam, myscoreCode, season, date);
        this.championship = championship;
    }
}
