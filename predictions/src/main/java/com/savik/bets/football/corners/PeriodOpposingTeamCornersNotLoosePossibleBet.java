package com.savik.bets.football.corners;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.corners.PeriodOpposingTeamCornersNotLooseSingleBlock;
import com.savik.blocks.football.corners.PeriodTeamCornersNotLooseSingleBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodOpposingTeamCornersNotLoosePossibleBet extends PossibleBet<FootballMatch> {
    public PeriodOpposingTeamCornersNotLoosePossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                        Function<FootballMatch, Period> function) {
        super(
                new PeriodOpposingTeamCornersNotLooseSingleBlock(function, homeMatchData),
                new PeriodTeamCornersNotLooseSingleBlock(function, guestMatchData)
        );
    }
}
