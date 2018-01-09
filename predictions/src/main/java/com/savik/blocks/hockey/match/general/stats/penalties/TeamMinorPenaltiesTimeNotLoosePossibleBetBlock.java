package com.savik.blocks.hockey.match.general.stats.penalties;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.TeamPenaltiesTimeNotLoosePossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class TeamMinorPenaltiesTimeNotLoosePossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public TeamMinorPenaltiesTimeNotLoosePossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData,
                                                          Function<HockeyMatch, Period> period) {
        super(
                new TeamPenaltiesTimeNotLoosePossibleBet(
                        homeMatchData, guestMatchData, period
                ), ContainerType.TEAM_MINOR_PENALTIES_TIME_NOT_LOOSE
        );
    }
}
