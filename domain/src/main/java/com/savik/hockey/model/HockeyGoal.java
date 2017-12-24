package com.savik.hockey.model;

import com.savik.Goal;
import com.savik.Who;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import java.util.Comparator;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "hockey_goal_id_generator")
@EqualsAndHashCode(callSuper = true)
public class HockeyGoal extends Goal {

    public static Comparator<HockeyGoal> byTime = Comparator.comparingInt(HockeyGoal::getMinute).thenComparing(HockeyGoal::getSeconds);

    @NotNull
    @OneToOne
    HockeyTeam team;

    @NotNull
    Integer seconds;

    @Builder(toBuilder = true)
    public HockeyGoal(Integer minute, Who whoScored, HockeyTeam team, Integer seconds) {
        super(minute, whoScored);
        this.team = team;
        this.seconds = seconds;
    }
}
