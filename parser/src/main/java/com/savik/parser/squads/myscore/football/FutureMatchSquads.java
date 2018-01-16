package com.savik.parser.squads.myscore.football;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class FutureMatchSquads {

    private Set<FutureMatchSquadPlayer> homePlayers;

    private Set<FutureMatchSquadPlayer> guestPlayers;

    public Set<FutureMatchSquadPlayer> getHomeLineUpPlayers() {
        return homePlayers.stream().filter(p -> p.getIsLineUp()).collect(Collectors.toSet());
    }

    public Set<FutureMatchSquadPlayer> getHomeSubstitutions() {
        return homePlayers.stream().filter(p -> !p.getIsLineUp()).collect(Collectors.toSet());
    }

    public Set<FutureMatchSquadPlayer> getGuestLineUpPlayers() {
        return guestPlayers.stream().filter(p -> p.getIsLineUp()).collect(Collectors.toSet());
    }

    public Set<FutureMatchSquadPlayer> getGuestSubstitutions() {
        return guestPlayers.stream().filter(p -> !p.getIsLineUp()).collect(Collectors.toSet());
    }
}
