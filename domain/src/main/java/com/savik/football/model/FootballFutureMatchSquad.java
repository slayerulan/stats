package com.savik.football.model;

import com.savik.domain.Identifiable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "football_future_match_squad_id_generator")
@EqualsAndHashCode
@Getter
public class FootballFutureMatchSquad extends Identifiable {

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    FootballFutureMatchSquadPart lineUps;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    FootballFutureMatchSquadPart substitutions;

    public void setSquad(FootballTeamSquad squad) {
        lineUps.setSquad(squad);
        substitutions.setSquad(squad);
    }


}
