package com.savik.football.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.savik.Season;
import com.savik.domain.Identifiable;
import lombok.*;

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
public class FootballMatch extends Identifiable {

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
}
