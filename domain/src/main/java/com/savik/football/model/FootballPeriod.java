package com.savik.football.model;

import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Optionality;
import com.savik.Period;
import com.savik.Winner;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Savushkin Yauheni
 * @since 10.4.17
 */
@Entity
@Getter
@NoArgsConstructor
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "football_period_id_generator")
public class FootballPeriod extends Period<FootballGoal> {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @CollectionProperty(optionality = Optionality.OPTIONAL)
    Set<FootballGoal> goals;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @CollectionProperty(optionality = Optionality.OPTIONAL)
    Set<FootballCard> cards;

    Integer homeCorners;

    Integer guestCorners;

    Integer homeHits;

    Integer guestHits;

    Integer homeHitsOnTarget;

    Integer guestHitsOnTarget;

    Integer homePossession;

    Integer guestPossession;

    Integer homeOffsides;

    Integer guestOffsides;

    Integer homeFouls;

    Integer guestFouls;

    @Builder(toBuilder = true)
    public FootballPeriod(Integer homeScore, Integer guestScore, Integer totalScore, Winner winner, PeriodStatus periodStatus, Set<FootballGoal> goals, Set<FootballCard> cards, Integer homeCorners, Integer guestCorners, Integer homeHits, Integer guestHits, Integer homeHitsOnTarget, Integer guestHitsOnTarget, Integer homePossession, Integer guestPossession, Integer homeOffsides, Integer guestOffsides, Integer homeFouls, Integer guestFouls) {
        super(homeScore, guestScore, totalScore, winner, periodStatus);
        this.goals = goals;
        this.cards = cards;
        this.homeCorners = homeCorners;
        this.guestCorners = guestCorners;
        this.homeHits = homeHits;
        this.guestHits = guestHits;
        this.homeHitsOnTarget = homeHitsOnTarget;
        this.guestHitsOnTarget = guestHitsOnTarget;
        this.homePossession = homePossession;
        this.guestPossession = guestPossession;
        this.homeOffsides = homeOffsides;
        this.guestOffsides = guestOffsides;
        this.homeFouls = homeFouls;
        this.guestFouls = guestFouls;
    }



}
