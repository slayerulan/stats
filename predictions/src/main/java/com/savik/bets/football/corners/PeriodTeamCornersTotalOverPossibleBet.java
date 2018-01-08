package com.savik.bets.football.corners;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.corners.PeriodOpposingTeamCornersTotalOverBlock;
import com.savik.blocks.football.corners.PeriodTeamCornersTotalOverBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodTeamCornersTotalOverPossibleBet extends PossibleBet<FootballMatch> {
    public PeriodTeamCornersTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                 Function<FootballMatch, Period> function, double amount) {
        super(
                new PeriodTeamCornersTotalOverBlock(amount, function, homeMatchData),
                new PeriodOpposingTeamCornersTotalOverBlock(amount, function, guestMatchData)
        );
    }
}
