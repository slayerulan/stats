package com.savik;


import com.savik.domain.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@MappedSuperclass
public abstract class Match extends Identifiable {

    public abstract BookieStats getBookieStats();

    public abstract Team getHomeTeam();

    public abstract Team getGuestTeam();

    public Who getTeamStatus(Team team) {
        if (team.equals(getHomeTeam())) {
            return Who.HOME;
        } else if (team.equals(getGuestTeam())) {
            return Who.GUEST;
        }
        return Who.UNKNOWN;
    }
}
