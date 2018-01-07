package com.savik.snooker.model;

import com.codiform.moo.annotation.Optionality;
import com.codiform.moo.annotation.Property;
import com.savik.Match;
import com.savik.Season;
import com.savik.Winner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = "myscoreCode"),
        indexes = @Index(columnList = "myscoreCode")
)
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "snooker_match_id_generator")
@Getter
public class SnookerMatch extends Match {


    @OneToOne(cascade = CascadeType.ALL)
    SnookerBookieStats bookieStats;

    @NotNull
    @OneToOne
    SnookerTeam homeTeam;

    @NotNull
    @OneToOne
    SnookerTeam guestTeam;

    @NotNull
    @Enumerated(EnumType.STRING)
    SnookerChampionship championship;

    @NotNull
    @Enumerated(EnumType.STRING)
    Season season;

    @NotNull
    LocalDateTime date;

    @NotNull
    String myscoreCode;

    @Property(optionality = Optionality.OPTIONAL)
    protected Integer homeScore;

    @Property(optionality = Optionality.OPTIONAL)
    protected Integer guestScore;

    @Property(optionality = Optionality.OPTIONAL)
    protected Integer totalScore;

    @Enumerated(EnumType.STRING)
    @Property(optionality = Optionality.OPTIONAL)
    protected Winner winner;
}
