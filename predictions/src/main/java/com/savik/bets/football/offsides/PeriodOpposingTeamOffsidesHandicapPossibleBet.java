package com.savik.bets.football.offsides;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.offsides.PeriodOpposingTeamOffsidesHandicapBlock;
import com.savik.blocks.football.offsides.PeriodTeamOffsidesHandicapBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodOpposingTeamOffsidesHandicapPossibleBet extends PossibleBet<FootballMatch> {
    public PeriodOpposingTeamOffsidesHandicapPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                        Function<FootballMatch, Period> function, double amount) {
        super(
                new PeriodOpposingTeamOffsidesHandicapBlock(amount, function, homeMatchData),
                new PeriodTeamOffsidesHandicapBlock(amount, function, guestMatchData)
        );
    }
}
