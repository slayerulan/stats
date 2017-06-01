package com.savik.football.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.savik.domain.Identifiable;
import lombok.*;

/**
 * @author Savushkin Yauheni
 * @since 10.04.2017
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "goal_id_generator")
@EqualsAndHashCode
public class FootballGoal extends Identifiable {

    @NotNull
    Integer minute;

    @NotNull
    @OneToOne
    FootballTeam team;

    @NotNull
    @Enumerated(EnumType.STRING)
    Who whoScored;

}
