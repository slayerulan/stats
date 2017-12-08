package com.savik.blocks.hockey.match.general.handicap;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.general.handicap.PeriodOpposingTeamHandicapPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PeriodOpposingTeamHandicapPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodOpposingTeamHandicapPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new PeriodOpposingTeamHandicapPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, -2.5),
                                ContainerType.MINUS_2_5
                        ),
                        new PossibleBetContainer<>(
                                new PeriodOpposingTeamHandicapPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, -1.5),
                                ContainerType.MINUS_1_5
                        ),
                        new PossibleBetContainer<>(
                                new PeriodOpposingTeamHandicapPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, 1.5),
                                ContainerType.PLUS_1_5
                        ),
                        new PossibleBetContainer<>(
                                new PeriodOpposingTeamHandicapPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, 2.5),
                                ContainerType.PLUS_2_5
                        )
                ), ContainerType.OPPOSING_TEAM_HANDICAP
        );
    }
}
