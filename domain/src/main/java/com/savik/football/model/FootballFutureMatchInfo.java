package com.savik.football.model;

import com.savik.domain.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "football_future_match_info_id_generator")
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = "myscoreCode"),
        indexes = @Index(columnList = "myscoreCode")
)
@Getter
public class FootballFutureMatchInfo extends Identifiable {

    @NotNull
    String myscoreCode;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    FootballFutureMatchSquad homeTeam;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    FootballFutureMatchSquad guestTeam;

    public void setHomeSquad(FootballTeamSquad squad) {
        homeTeam.setSquad(squad);
    }

    public void setGuestSquad(FootballTeamSquad squad) {
        guestTeam.setSquad(squad);
    }


}
