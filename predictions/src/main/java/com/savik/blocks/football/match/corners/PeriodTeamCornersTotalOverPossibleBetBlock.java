package com.savik.blocks.football.match.corners;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.corners.PeriodTeamCornersTotalOverPossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class PeriodTeamCornersTotalOverPossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public PeriodTeamCornersTotalOverPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodTeamCornersTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 2.5),
                        ContainerType.OVER_2_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamCornersTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 3.5),
                        ContainerType.OVER_3_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamCornersTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 4.5),
                        ContainerType.OVER_4_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamCornersTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 5.5),
                        ContainerType.OVER_5_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamCornersTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 6.5),
                        ContainerType.OVER_6_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamCornersTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 7.5),
                        ContainerType.OVER_7_5
                )
                ), ContainerType.TEAM_TOTAL_OVER
        );
    }
}