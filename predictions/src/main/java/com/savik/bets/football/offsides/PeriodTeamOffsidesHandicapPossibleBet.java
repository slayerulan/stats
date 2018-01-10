package com.savik.bets.football.offsides;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.offsides.PeriodOpposingTeamOffsidesHandicapBlock;
import com.savik.blocks.football.offsides.PeriodTeamOffsidesHandicapBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodTeamOffsidesHandicapPossibleBet extends PossibleBet<FootballMatch> {
    public PeriodTeamOffsidesHandicapPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                Function<FootballMatch, Period> function, double amount) {
        super(
                new PeriodTeamOffsidesHandicapBlock(amount, function, homeMatchData),
                new PeriodOpposingTeamOffsidesHandicapBlock(amount, function, guestMatchData)
        );
    }
}
