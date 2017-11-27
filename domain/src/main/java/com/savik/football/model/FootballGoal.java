package com.savik.football.model;

import com.savik.Goal;
import com.savik.Who;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 * @author Savushkin Yauheni
 * @since 10.04.2017
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "football_goal_id_generator")
@EqualsAndHashCode(callSuper = true)
public class FootballGoal extends Goal {

    @NotNull
    @OneToOne
    FootballTeam team;

    @Builder(toBuilder = true)
    public FootballGoal(Integer minute, Who whoScored, FootballTeam team) {
        super(minute, whoScored);
        this.team = team;
    }
}
