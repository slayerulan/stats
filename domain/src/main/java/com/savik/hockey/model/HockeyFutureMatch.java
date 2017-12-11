package com.savik.hockey.model;

import com.savik.Season;
import com.savik.domain.Identifiable;
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
@Builder
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = "myscoreCode"),
        indexes = @Index(columnList = "myscoreCode")
)
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "hockey_future_match_id_generator")
@Data
public class HockeyFutureMatch extends Identifiable {

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