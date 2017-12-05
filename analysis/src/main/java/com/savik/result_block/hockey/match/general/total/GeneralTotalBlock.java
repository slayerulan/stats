package com.savik.result_block.hockey.match.general.total;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.bets.general.total.over.PeriodHomeOver;
import com.savik.bets.general.total.under.PeriodGuestUnder;
import com.savik.bets.general.total.under.PeriodHomeUnder;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


public class GeneralTotalBlock extends GeneralBetContainer {

    public GeneralTotalBlock(MatchData matchData) {
        super(Arrays.asList(
                new GeneralTotalOverBlock(),
                new GeneralTotalUnderBlock(),
                new GeneralPeriodTotalOverBlock(HockeyMatch.FIRST_PERIOD, FIRST_PERIOD_TOTAL_OVER),
                new GeneralPeriodTotalOverBlock(HockeyMatch.SECOND_PERIOD, SECOND_PERIOD_TOTAL_OVER),
                new GeneralPeriodTotalOverBlock(HockeyMatch.THIRD_PERIOD, THIRD_PERIOD_TOTAL_OVER),
                new GeneralBothTeamsTotalOverBlock(HockeyMatch.FIRST_PERIOD, BOTH_TEAMS_TOTAL_OVER_FIRST_PERIOD),
                new GeneralBothTeamsTotalOverBlock(HockeyMatch.SECOND_PERIOD, BOTH_TEAMS_TOTAL_OVER_SECOND_PERIOD),
                new GeneralBothTeamsTotalOverBlock(HockeyMatch.THIRD_PERIOD, BOTH_TEAMS_TOTAL_OVER_THIRD_PERIOD),
                new GeneralTeamTotalOverBlock(matchData),
                new GeneralTeamTotalUnderBlock(matchData)
        ), ContainerType.TOTAL);
    }
}
