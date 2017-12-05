package com.savik.result_block.hockey.match.general.periods;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;
import java.util.function.Function;

import static com.savik.ContainerType.*;


public class GeneralPeriodBlock extends GeneralBetContainer {

    public GeneralPeriodBlock(MatchData matchData, Function<HockeyMatch, Period> function, ContainerType type) {
        super(Arrays.asList(
                new GeneralPeriodAnyWinnerBlock(function, ANY_WIN),
                new GeneralTeamNotLoosePeriodBlock(matchData, function, TEAM_NOT_LOOSE),
                new GeneralPeriodTotalOverBlock(function, TOTAL_OVER),
                new GeneralPeriodBothTeamsTotalOverBlock(function, BOTH_TEAMS_TOTAL_OVER)
        ), type);
    }
}
