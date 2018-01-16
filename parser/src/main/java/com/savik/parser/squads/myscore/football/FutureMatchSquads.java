package com.savik.parser.squads.myscore.football;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class FutureMatchSquads {

    private Set<FutureMatchSquadPlayer> homePlayers;

    private Set<FutureMatchSquadPlayer> guestPlayers;

}
