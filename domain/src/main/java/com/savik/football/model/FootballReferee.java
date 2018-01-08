package com.savik.football.model;

import com.savik.domain.Identifiable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "football_referee_id_generator")
@EqualsAndHashCode
public class FootballReferee extends Identifiable {

    @NotNull
    @Setter
    protected String name;

}
