package com.savik.hockey.model;

import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Optionality;
import com.codiform.moo.annotation.Property;
import com.fasterxml.jackson.annotation.JsonValue;
import com.savik.Period;
import com.savik.Winner;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Savushkin Yauheni
 * @since 10.4.17
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "hockey_period_id_generator")
public class HockeyPeriod extends Period<HockeyGoal> {


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @CollectionProperty(optionality = Optionality.OPTIONAL)
    @Setter
    Set<HockeyGoal> goals;

    Integer homeShotsOnTarget;

    Integer guestShotsOnTarget;

    // в меньшинстве
    Integer homeShotHandedGoals;

    Integer guestShotHandedGoals;

    // в большинстве
    Integer homePowerplayGoals;

    Integer guestPowerplayGoals;


    Integer homePenaltiesTime;

    Integer guestPenaltiesTime;

    @Property(optionality = Optionality.OPTIONAL)
    Integer homeMinorPenaltiesAmount;

    @Property(optionality = Optionality.OPTIONAL)
    Integer guestMinorPenaltiesAmount;

    @Builder(toBuilder = true)
    public HockeyPeriod(Integer homeScore, Integer guestScore, Integer totalScore, Winner winner,
                        PeriodStatus periodStatus, Set<HockeyGoal> goals, Integer homeShotsOnTarget,
                        Integer guestShotsOnTarget, Integer homeShotHandedGoals, Integer guestShotHandedGoals,
                        Integer homePowerplayGoals, Integer guestPowerplayGoals, Integer homePenaltiesTime,
                        Integer guestPenaltiesTime, Integer homeMinorPenaltiesAmount, Integer guestMinorPenaltiesAmount) {
        super(homeScore, guestScore, totalScore, winner, periodStatus);
        this.goals = goals;
        this.homeShotsOnTarget = homeShotsOnTarget;
        this.guestShotsOnTarget = guestShotsOnTarget;
        this.homeShotHandedGoals = homeShotHandedGoals;
        this.guestShotHandedGoals = guestShotHandedGoals;
        this.homePowerplayGoals = homePowerplayGoals;
        this.guestPowerplayGoals = guestPowerplayGoals;
        this.homePenaltiesTime = homePenaltiesTime;
        this.guestPenaltiesTime = guestPenaltiesTime;
        this.homeMinorPenaltiesAmount = homeMinorPenaltiesAmount;
        this.guestMinorPenaltiesAmount = guestMinorPenaltiesAmount;
    }

    @Override
    @JsonValue
    public String toString() {
        return "{" + homeScore + "-" + guestScore + ", pen=(" + homeMinorPenaltiesAmount + "-" + guestMinorPenaltiesAmount + ")}";
    }

    @Override
    public int getMinuteFromStart(int minute) {
        if (periodStatus == PeriodStatus.FIRST) {
            return minute;
        } else if (periodStatus == PeriodStatus.SECOND) {
            return minute - 20;
        } else if (periodStatus == PeriodStatus.THIRD) {
            return minute - 40;
        }
        throw new IllegalStateException("status = " + periodStatus);
    }
}
