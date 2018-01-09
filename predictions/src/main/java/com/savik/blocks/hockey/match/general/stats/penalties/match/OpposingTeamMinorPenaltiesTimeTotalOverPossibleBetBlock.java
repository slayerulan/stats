package com.savik.blocks.hockey.match.general.stats.penalties.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.OpposingTeamPenaltiesTimeTotalOverPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class OpposingTeamMinorPenaltiesTimeTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public OpposingTeamMinorPenaltiesTimeTotalOverPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new OpposingTeamPenaltiesTimeTotalOverPossibleBet(
                                homeMatchData, guestMatchData, HockeyMatch.MATCH, 6.5),
                        ContainerType.OVER_6_5
                ),
                new PossibleBetContainer<>(
                        new OpposingTeamPenaltiesTimeTotalOverPossibleBet(
                                homeMatchData, guestMatchData, HockeyMatch.MATCH, 7.5),
                        ContainerType.OVER_7_5
                ),
                new PossibleBetContainer<>(
                        new OpposingTeamPenaltiesTimeTotalOverPossibleBet(
                                homeMatchData, guestMatchData, HockeyMatch.MATCH, 8.5),
                        ContainerType.OVER_8_5
                )
                ), ContainerType.OPPOSING_TEAM_MINOR_PENALTIES_TIME_OVER
        );
    }
}
