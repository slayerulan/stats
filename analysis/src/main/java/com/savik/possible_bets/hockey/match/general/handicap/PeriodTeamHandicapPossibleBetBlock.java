package com.savik.possible_bets.hockey.match.general.handicap;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PeriodTeamHandicapPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodTeamHandicapPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(
                Arrays.asList(
                        new PossibleBetContainer<>(
                                new PeriodTeamHandicapPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, -2.5),
                                ContainerType.MINUS_2_5
                        ),
                        new PossibleBetContainer<>(
                                new PeriodTeamHandicapPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, -1.5),
                                ContainerType.MINUS_1_5
                        ),
                        new PossibleBetContainer<>(
                                new PeriodTeamHandicapPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, 1.5),
                                ContainerType.PLUS_1_5
                        ),
                        new PossibleBetContainer<>(
                                new PeriodTeamHandicapPossibleBet(homeMatchData, guestMatchData, HockeyMatch.MATCH, 2.5),
                                ContainerType.PLUS_2_5
                        )
                ), ContainerType.TEAM_HANDICAP
        );
    }
}
