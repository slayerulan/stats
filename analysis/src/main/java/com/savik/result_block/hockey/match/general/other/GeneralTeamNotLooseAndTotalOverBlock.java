package com.savik.result_block.hockey.match.general.other;

import com.savik.BiPeriodBet;
import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.result.PeriodGuestNotLoose;
import com.savik.bets.general.result.PeriodGuestWinner;
import com.savik.bets.general.result.PeriodHomeNotLoose;
import com.savik.bets.general.result.PeriodHomeWinner;
import com.savik.bets.general.total.over.PeriodOver;
import com.savik.blocks.general.result.PeriodTeamWinAndTotalOverBlock;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyPeriod;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralTeamNotLooseAndTotalOverBlock extends PeriodTeamBetContainer {

    public GeneralTeamNotLooseAndTotalOverBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new PeriodTeamWinAndTotalOverBlock(4.5, OVER_4_5),
                        new PeriodTeamWinAndTotalOverBlock(5.5, OVER_5_5)
                ), HockeyMatch.MATCH, matchData, TEAM_NOT_LOOSE_AND_TOTAL_OVER
        );
    }
}
