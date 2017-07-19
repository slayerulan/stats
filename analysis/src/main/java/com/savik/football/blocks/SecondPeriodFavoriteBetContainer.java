package com.savik.football.blocks;

import java.util.List;

import com.savik.football.bets.PeriodFavoriteBet;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.Period;

/**
 * @author Savushkin Yauheni
 * @since 19.07.2017
 */
public class SecondPeriodFavoriteBetContainer extends PeriodFavoriteBetContainer {

    public SecondPeriodFavoriteBetContainer(List<PeriodFavoriteBetContainer> childrenBetBlocks) {
        super(childrenBetBlocks);
    }

    public SecondPeriodFavoriteBetContainer(PeriodFavoriteBet bet) {
        super(bet);
    }

    @Override
    public Period getPeriod(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getSecondPeriod();
    }
}
