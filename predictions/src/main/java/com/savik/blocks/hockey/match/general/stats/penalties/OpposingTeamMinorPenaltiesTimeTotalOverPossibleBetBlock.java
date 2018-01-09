package com.savik.blocks.hockey.match.general.stats.penalties;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.OpposingTeamPenaltiesTimeTotalOverPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;
import java.util.function.Function;

public class OpposingTeamMinorPenaltiesTimeTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public OpposingTeamMinorPenaltiesTimeTotalOverPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData,
                                                                   Function<HockeyMatch, Period> period) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new OpposingTeamPenaltiesTimeTotalOverPossibleBet(
                                homeMatchData, guestMatchData, period, 0.5),
                        ContainerType.OVER_0_5
                ),
                new PossibleBetContainer<>(
                        new OpposingTeamPenaltiesTimeTotalOverPossibleBet(
                                homeMatchData, guestMatchData, period, 2.5),
                        ContainerType.OVER_2_5
                ),
                new PossibleBetContainer<>(
                        new OpposingTeamPenaltiesTimeTotalOverPossibleBet(
                                homeMatchData, guestMatchData, period, 6.5),
                        ContainerType.OVER_6_5
                ),
                new PossibleBetContainer<>(
                        new OpposingTeamPenaltiesTimeTotalOverPossibleBet(
                                homeMatchData, guestMatchData, period, 7.5),
                        ContainerType.OVER_7_5
                ),
                new PossibleBetContainer<>(
                        new OpposingTeamPenaltiesTimeTotalOverPossibleBet(
                                homeMatchData, guestMatchData, period, 8.5),
                        ContainerType.OVER_8_5
                )
                ), ContainerType.OPPOSING_TEAM_MINOR_PENALTIES_TIME_OVER
        );
    }
}
