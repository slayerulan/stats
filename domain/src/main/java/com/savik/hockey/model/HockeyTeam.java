package com.savik.hockey.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.savik.Team;
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
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "hockey_team_id_generator")
@EqualsAndHashCode(callSuper = true)
public class HockeyTeam extends Team {

    @NotNull
    @Enumerated(EnumType.STRING)
    HockeyChampionship championship;

    @Builder(toBuilder = true)
    public HockeyTeam(String name, HockeyChampionship championship) {
        super(name);
        this.championship = championship;
    }

    @JsonValue
    @Override
    public String toString() {
        return name;
    }
}
