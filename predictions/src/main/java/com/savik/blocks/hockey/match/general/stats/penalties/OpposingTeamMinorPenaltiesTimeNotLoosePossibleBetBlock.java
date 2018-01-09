package com.savik.blocks.hockey.match.general.stats.penalties;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.OpposingTeamPenaltiesTimeNotLoosePossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class OpposingTeamMinorPenaltiesTimeNotLoosePossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public OpposingTeamMinorPenaltiesTimeNotLoosePossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData,
                                                                  Function<HockeyMatch, Period> period) {
        super(
                new OpposingTeamPenaltiesTimeNotLoosePossibleBet(
                        homeMatchData, guestMatchData, period
                ), ContainerType.OPPOSING_TEAM_MINOR_PENALTIES_TIME_NOT_LOOSE
        );
    }
}
