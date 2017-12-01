package com.savik.result_block.hockey.match.general.total;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.bets.general.total.over.PeriodHomeOver;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.FIRST_PERIOD_TOTAL_OVER;
import static com.savik.ContainerType.SECOND_PERIOD_TOTAL_OVER;
import static com.savik.ContainerType.THIRD_PERIOD_TOTAL_OVER;


public class GeneralTotalBlock extends GeneralBetContainer {

    public GeneralTotalBlock(MatchData matchData) {
        super(Arrays.asList(
                new GeneralTotalOverBlock(),
                new GeneralTotalUnderBlock(),
                new GeneralPeriodTotalOverBlock(HockeyMatch.FIRST_PERIOD, FIRST_PERIOD_TOTAL_OVER),
                new GeneralPeriodTotalOverBlock(HockeyMatch.SECOND_PERIOD, SECOND_PERIOD_TOTAL_OVER),
                new GeneralPeriodTotalOverBlock(HockeyMatch.THIRD_PERIOD, THIRD_PERIOD_TOTAL_OVER),

                new PeriodTeamBetContainer<>(
                        Arrays.asList(
                                new PeriodTeamBetContainer<HockeyMatch>(
                                        new PeriodHomeOver(2.5),
                                        new PeriodGuestOver(2.5)
                                ),
                                new PeriodTeamBetContainer<HockeyMatch>(
                                        new PeriodHomeOver(3.5),
                                        new PeriodGuestOver(3.5)
                                ),
                                new PeriodTeamBetContainer<HockeyMatch>(
                                        new PeriodHomeOver(4.5),
                                        new PeriodGuestOver(4.5)
                                )
                        ), HockeyMatch.MATCH, matchData, ContainerType.TOTAL_OVER_FOR_TEAM
                ),

                new PeriodTeamBetContainer<>(
                        Arrays.asList(
                                new PeriodTeamBetContainer<HockeyMatch>(
                                        new PeriodHomeOver(2.5),
                                        new PeriodGuestOver(2.5)
                                ),
                                new PeriodTeamBetContainer<HockeyMatch>(
                                        new PeriodHomeOver(3.5),
                                        new PeriodGuestOver(3.5)
                                ),
                                new PeriodTeamBetContainer<HockeyMatch>(
                                        new PeriodHomeOver(4.5),
                                        new PeriodGuestOver(4.5)
                                )
                        ), HockeyMatch.MATCH, matchData, ContainerType.TOTAL_UNDER_FOR_TEAM
                )


        ), ContainerType.TOTAL);
    }
}
