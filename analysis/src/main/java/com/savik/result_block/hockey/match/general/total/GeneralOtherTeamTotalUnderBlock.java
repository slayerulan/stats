package com.savik.result_block.hockey.match.general.total;

import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.total.under.PeriodGuestUnder;
import com.savik.bets.general.total.under.PeriodHomeUnder;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralOtherTeamTotalUnderBlock extends PeriodTeamBetContainer {

    public GeneralOtherTeamTotalUnderBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new PeriodTeamBetContainer<HockeyMatch>(
                                new PeriodGuestUnder(2.5),
                                new PeriodHomeUnder(2.5),
                                UNDER_2_5
                        ),
                        new PeriodTeamBetContainer<HockeyMatch>(
                                new PeriodGuestUnder(3.5),
                                new PeriodHomeUnder(3.5),
                                UNDER_3_5

                        ),
                        new PeriodTeamBetContainer<HockeyMatch>(
                                new PeriodGuestUnder(4.5),
                                new PeriodHomeUnder(4.5),
                                UNDER_4_5

                        )
                ), HockeyMatch.MATCH, matchData, OTHER_TEAM_TOTAL_UNDER
        );

    }
}
