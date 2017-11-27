package com.savik.football.blocks;

import java.util.List;

import com.savik.football.bets.PeriodBet;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

/**
 * @author Savushkin Yauheni
 * @since 19.07.2017
 */
public class SecondPeriodBetContainer extends PeriodBetContainer {

    public SecondPeriodBetContainer(List<PeriodBetContainer> childrenBetBlocks) {
        super(childrenBetBlocks);
    }

    public SecondPeriodBetContainer(PeriodBet bet) {
        super(bet);
    }

    @Override
    public FootballPeriod getPeriod(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getSecondPeriod();
    }
}
