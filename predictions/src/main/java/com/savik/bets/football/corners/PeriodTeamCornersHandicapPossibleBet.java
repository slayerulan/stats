package com.savik.bets.football.corners;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.corners.PeriodOpposingTeamCornersHandicapBlock;
import com.savik.blocks.football.corners.PeriodTeamCornersHandicapBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodTeamCornersHandicapPossibleBet extends PossibleBet<FootballMatch> {
    public PeriodTeamCornersHandicapPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                Function<FootballMatch, Period> function, double amount) {
        super(
                new PeriodTeamCornersHandicapBlock(amount, function, homeMatchData),
                new PeriodOpposingTeamCornersHandicapBlock(amount, function, guestMatchData)
        );
    }
}
