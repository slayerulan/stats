package com.savik.result_block.hockey.match.general.total;

import com.savik.GeneralBetContainer;
import com.savik.MatchData;

import java.util.Arrays;

import static com.savik.ContainerType.TOTAL;


public class GeneralTotalBlock extends GeneralBetContainer {

    public GeneralTotalBlock(MatchData matchData) {
        super(Arrays.asList(
                new GeneralTotalOverBlock(),
                new GeneralTotalUnderBlock(),
                new GeneralTeamTotalOverBlock(matchData),
                new GeneralTeamTotalUnderBlock(matchData),
                new GeneralOtherTeamTotalOverBlock(matchData),
                new GeneralOtherTeamTotalUnderBlock(matchData)
        ), TOTAL);
    }
}
