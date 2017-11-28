package com.savik.football.blocks;

import com.savik.Who;
import com.savik.football.bets.PeriodFavoriteBet;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class PeriodFavoriteBetContainer extends BetContainer<FootballMatch> {

    private PeriodFavoriteBet bet;

    public PeriodFavoriteBetContainer(List<? extends BetContainer> childrenBetBlocks) {
        super(childrenBetBlocks);
    }

    public PeriodFavoriteBetContainer(PeriodFavoriteBet bet) {
        super();
        this.bet = bet;
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        Who favorite = footballMatch.getBookieStats().getFavorite();
        FootballPeriod period = getPeriod(footballMatch);
        return bet.canAnalyze(favorite, period);
    }

    @Override
    public boolean checkMatch(FootballMatch footballMatch) {
        Who favorite = footballMatch.getBookieStats().getFavorite();
        FootballPeriod period = getPeriod(footballMatch);
        return bet.check(favorite, period);
    }

    public abstract FootballPeriod getPeriod(FootballMatch footballMatch);
}
