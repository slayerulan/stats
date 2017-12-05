package com.savik.result_block.hockey.match.general.total;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.bets.general.total.over.PeriodHomeOver;
import com.savik.bets.general.total.under.PeriodGuestUnder;
import com.savik.bets.general.total.under.PeriodHomeUnder;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralTeamTotalUnderBlock extends PeriodTeamBetContainer {

    public GeneralTeamTotalUnderBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new PeriodTeamBetContainer<HockeyMatch>(
                                new PeriodHomeUnder(2.5),
                                new PeriodGuestUnder(2.5),
                                UNDER_2_5
                        ),
                        new PeriodTeamBetContainer<HockeyMatch>(
                                new PeriodHomeUnder(3.5),
                                new PeriodGuestUnder(3.5),
                                UNDER_3_5

                        ),
                        new PeriodTeamBetContainer<HockeyMatch>(
                                new PeriodHomeUnder(4.5),
                                new PeriodGuestUnder(4.5),
                                UNDER_4_5

                        )
                ), HockeyMatch.MATCH, matchData, ContainerType.TOTAL_UNDER_FOR_TEAM
        );

    }
}
