package com.savik.result_block.hockey.general.other;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.other.PeriodEvenScore;
import com.savik.hockey.model.HockeyMatch;


class GeneralEvenScoreBlock extends PeriodBetContainer {

    public GeneralEvenScoreBlock() {
        super(
                new PeriodEvenScore(), HockeyMatch.MATCH, ContainerType.EVEN
        );
    }
}
