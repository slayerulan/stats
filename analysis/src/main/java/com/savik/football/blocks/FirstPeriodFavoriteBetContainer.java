package com.savik.football.blocks;

import java.util.List;

import com.savik.football.bets.PeriodFavoriteBet;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

/**
 * @author Savushkin Yauheni
 * @since 19.07.2017
 */
public class FirstPeriodFavoriteBetContainer extends PeriodFavoriteBetContainer {

    public FirstPeriodFavoriteBetContainer(List<PeriodFavoriteBetContainer> childrenBetBlocks) {
        super(childrenBetBlocks);
    }

    public FirstPeriodFavoriteBetContainer(PeriodFavoriteBet bet) {
        super(bet);
    }

    @Override
    public FootballPeriod getPeriod(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getFirstPeriod();
    }
}
