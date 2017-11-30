package com.savik.hockey.model;

import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Optionality;
import com.savik.Period;
import com.savik.Winner;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "hockey_period_id_generator")
public class HockeyPeriod extends Period<HockeyGoal> {


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @CollectionProperty(optionality = Optionality.OPTIONAL)
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

    @Builder(toBuilder = true)

    public HockeyPeriod(Integer homeScore, Integer guestScore, Integer totalScore, Winner winner, PeriodStatus periodStatus, Set<HockeyGoal> goals, Integer homeShotsOnTarget, Integer guestShotsOnTarget, Integer homeShotHandedGoals, Integer guestShotHandedGoals, Integer homePowerplayGoals, Integer guestPowerplayGoals, Integer homePenaltiesTime, Integer guestPenaltiesTime) {
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
    }
}
