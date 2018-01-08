package com.savik.bets.football.corners;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.corners.PeriodOpposingTeamCornersHandicapBlock;
import com.savik.blocks.football.corners.PeriodTeamCornersHandicapBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodOpposingTeamCornersHandicapPossibleBet extends PossibleBet<FootballMatch> {
    public PeriodOpposingTeamCornersHandicapPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                        Function<FootballMatch, Period> function, double amount) {
        super(
                new PeriodOpposingTeamCornersHandicapBlock(amount, function, homeMatchData),
                new PeriodTeamCornersHandicapBlock(amount, function, guestMatchData)
        );
    }
}
