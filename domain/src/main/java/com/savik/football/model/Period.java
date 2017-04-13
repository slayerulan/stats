package com.savik.football.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import domain.Identifiable;
import lombok.*;

/**
 * @author Savushkin Yauheni
 * @since 10.4.17
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Period extends Identifiable {

    @NotNull
    @Enumerated(EnumType.STRING)
    PeriodStatus periodStatus;

    @NotNull
    Integer homeScore;

    @NotNull
    Integer guestScore;

    @NotNull
    Integer totalScore;

    @NotNull
    @Enumerated(EnumType.STRING)
    Winner winner;

    @NotNull
    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Goal> goals;

    @NotNull
    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Card> cards;

    @NotNull
    Integer homeCorners;

    @NotNull
    Integer guestCorners;

    @NotNull
    Integer homeHits;

    @NotNull
    Integer guestHits;

    @NotNull
    Integer homePossession;

    @NotNull
    Integer guestPossession;

    @NotNull
    Integer homeOffsides;

    @NotNull
    Integer guestOffsides;

    @NotNull
    Integer homeFouls;

    @NotNull
    Integer guestFouls;

    enum PeriodStatus {
        FIRST,
        SECOND,
        MATCH
    }
}
