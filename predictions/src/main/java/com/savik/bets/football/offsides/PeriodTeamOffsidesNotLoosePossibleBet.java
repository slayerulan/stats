package com.savik.bets.football.offsides;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.offsides.PeriodOpposingTeamOffsidesNotLooseSingleBlock;
import com.savik.blocks.football.offsides.PeriodTeamOffsidesNotLooseSingleBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodTeamOffsidesNotLoosePossibleBet extends PossibleBet<FootballMatch> {
    public PeriodTeamOffsidesNotLoosePossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                Function<FootballMatch, Period> function) {
        super(
                new PeriodTeamOffsidesNotLooseSingleBlock(function, homeMatchData),
                new PeriodOpposingTeamOffsidesNotLooseSingleBlock(function, guestMatchData)
        );
    }
}
