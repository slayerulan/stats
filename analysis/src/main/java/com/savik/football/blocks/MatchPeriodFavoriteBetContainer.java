package com.savik.football.blocks;

import java.util.List;

import com.savik.football.bets.PeriodFavoriteBet;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.Period;

/**
 * @author Savushkin Yauheni
 * @since 19.07.2017
 */
public class MatchPeriodFavoriteBetContainer extends PeriodFavoriteBetContainer {

    public MatchPeriodFavoriteBetContainer(List<PeriodFavoriteBetContainer> childrenBetBlocks) {
        super(childrenBetBlocks);
    }

    public MatchPeriodFavoriteBetContainer(PeriodFavoriteBet bet) {
        super(bet);
    }

    @Override
    public Period getPeriod(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getMatch();
    }
}
