package com.savik;

import com.savik.football.bets.PeriodFavoriteBet;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;
import lombok.Getter;

import java.util.List;
import java.util.function.Function;

@Getter
public abstract class PeriodFavoriteBetContainer extends BetContainer<FootballMatch> {

    private PeriodFavoriteBet bet;

    private Function<FootballMatch, FootballPeriod> function;


    public PeriodFavoriteBetContainer(List<? extends BetContainer> childrenBetBlocks, Function<FootballMatch, FootballPeriod> function) {
        super(childrenBetBlocks);
        this.function = function;
    }

    public PeriodFavoriteBetContainer(PeriodFavoriteBet bet, Function<FootballMatch, FootballPeriod> function) {
        this(bet);
        this.function = function;
    }

    public PeriodFavoriteBetContainer(PeriodFavoriteBet bet) {
        super();
        this.bet = bet;
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        Who favorite = footballMatch.getBookieStats().getFavorite();
        FootballPeriod period = function.apply(footballMatch);
        return bet.canAnalyze(favorite, period);
    }

    @Override
    public boolean checkMatch(FootballMatch footballMatch) {
        Who favorite = footballMatch.getBookieStats().getFavorite();
        FootballPeriod period = function.apply(footballMatch);
        return bet.check(favorite, period);
    }

}
