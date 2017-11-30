package com.savik.result_block.hockey.general.total;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.bets.general.total.over.PeriodHomeOver;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


public class GeneralTotalBlock extends GeneralBetContainer {

    public GeneralTotalBlock(MatchData matchData) {
        super(Arrays.asList(
                new GeneralTotalOverBlock(),
                new GeneralTotalUnderBlock(),

                new PeriodTeamBetContainer<>(
                        Arrays.asList(
                                new PeriodTeamBetContainer<HockeyMatch>(
                                        new PeriodHomeOver(3.5),
                                        new PeriodGuestOver(3.5)
                                )
                        ), HockeyMatch.MATCH, matchData, ContainerType.TOTAL_OVER_FOR_TEAM
                )


        ), ContainerType.TOTAL);
    }
}
