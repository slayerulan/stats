package com.savik.bets.football.corners;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.corners.PeriodOpposingTeamCornersNotLooseSingleBlock;
import com.savik.blocks.football.corners.PeriodTeamCornersNotLooseSingleBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodTeamCornersNotLoosePossibleBet extends PossibleBet<FootballMatch> {
    public PeriodTeamCornersNotLoosePossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                Function<FootballMatch, Period> function) {
        super(
                new PeriodTeamCornersNotLooseSingleBlock(function, homeMatchData),
                new PeriodOpposingTeamCornersNotLooseSingleBlock(function, guestMatchData)
        );
    }
}
