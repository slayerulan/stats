package com.savik.blocks.football.match.corners;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.corners.PeriodTeamCornersTotalOverPossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;
import java.util.function.Function;

public class TeamCornersTotalOverPossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public TeamCornersTotalOverPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData, Function<FootballMatch, Period> period) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodTeamCornersTotalOverPossibleBet(homeMatchData, guestMatchData, period, 2.5),
                        ContainerType.OVER_2_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamCornersTotalOverPossibleBet(homeMatchData, guestMatchData, period, 3.5),
                        ContainerType.OVER_3_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamCornersTotalOverPossibleBet(homeMatchData, guestMatchData, period, 4.5),
                        ContainerType.OVER_4_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamCornersTotalOverPossibleBet(homeMatchData, guestMatchData, period, 5.5),
                        ContainerType.OVER_5_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamCornersTotalOverPossibleBet(homeMatchData, guestMatchData, period, 6.5),
                        ContainerType.OVER_6_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamCornersTotalOverPossibleBet(homeMatchData, guestMatchData, period, 7.5),
                        ContainerType.OVER_7_5
                )
                ), ContainerType.TEAM_TOTAL_OVER
        );
    }
}
