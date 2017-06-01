package com.savik.football.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "future_match_id_generator")
@Data
public class FutureMatch extends Identifiable {

    @NotNull
    @OneToOne
    Team homeTeam;

    @NotNull
    @OneToOne
    Team guestTeam;

    @NotNull
    @Enumerated(EnumType.STRING)
    Championship championship;

    @NotNull
    @Enumerated(EnumType.STRING)
    Season season;

    @NotNull
    LocalDateTime date;

    @NotNull
    String myscoreCode;
}
