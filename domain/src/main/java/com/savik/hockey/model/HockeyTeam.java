package com.savik.hockey.model;

import com.savik.domain.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 * @author Savushkin Yauheni
 * @since 10.04.2017
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "hockey_team_id_generator")
@EqualsAndHashCode
public class HockeyTeam extends Identifiable {

    @NotNull
    @Enumerated(EnumType.STRING)
    HockeyChampionship championship;

    @NotNull
    String name;

}