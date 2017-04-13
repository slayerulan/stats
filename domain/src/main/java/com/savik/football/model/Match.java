package com.savik.football.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import domain.Identifiable;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Match extends Identifiable {

    @NotNull
    @OneToOne
    MatchInfo matchInfo;

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
