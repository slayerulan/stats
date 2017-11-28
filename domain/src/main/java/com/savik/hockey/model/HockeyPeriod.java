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
public class HockeyPeriod extends Period {


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @CollectionProperty(optionality = Optionality.OPTIONAL)
    Set<HockeyGoal> goals;

    @Builder(toBuilder = true)
    public HockeyPeriod(Integer homeScore, Integer guestScore, Integer totalScore, Winner winner, PeriodStatus periodStatus, Set<HockeyGoal> goals) {
        super(homeScore, guestScore, totalScore, winner, periodStatus);
        this.goals = goals;
    }
}
