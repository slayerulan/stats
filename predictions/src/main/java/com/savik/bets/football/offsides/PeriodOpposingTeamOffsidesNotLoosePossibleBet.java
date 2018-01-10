package com.savik.bets.football.offsides;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.offsides.PeriodOpposingTeamOffsidesNotLooseSingleBlock;
import com.savik.blocks.football.offsides.PeriodTeamOffsidesNotLooseSingleBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodOpposingTeamOffsidesNotLoosePossibleBet extends PossibleBet<FootballMatch> {
    public PeriodOpposingTeamOffsidesNotLoosePossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                        Function<FootballMatch, Period> function) {
        super(
                new PeriodOpposingTeamOffsidesNotLooseSingleBlock(function, homeMatchData),
                new PeriodTeamOffsidesNotLooseSingleBlock(function, guestMatchData)
        );
    }
}
