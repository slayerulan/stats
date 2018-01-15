package com.savik.result_block.football.match.cards;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.blocks.football.cards.PeriodYellowCardsWDTotalOverSingleBlock;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


public class GeneralCardsTotalOverBlock extends PeriodBetContainer {

    public GeneralCardsTotalOverBlock() {
        super(
                Arrays.asList(
                        new PeriodYellowCardsWDTotalOverSingleBlock(2.5, OVER_2_5),
                        new PeriodYellowCardsWDTotalOverSingleBlock(3.5, OVER_3_5),
                        new PeriodYellowCardsWDTotalOverSingleBlock(4.5, OVER_4_5),
                        new PeriodYellowCardsWDTotalOverSingleBlock(5.5, OVER_5_5)
                ), FootballMatch.MATCH, ContainerType.TOTAL_OVER)
        ;
    }
}
