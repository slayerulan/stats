package com.savik.football.blocks;

import com.savik.football.bets.PeriodBet;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;
import lombok.Getter;

import java.util.List;
import java.util.function.Function;

@Getter
public abstract class PeriodBetContainer extends BetContainer<FootballMatch> {

    private PeriodBet bet;

    private Function<FootballMatch, FootballPeriod> function;

    public PeriodBetContainer(List<? extends BetContainer> childrenBetBlocks, Function<FootballMatch, FootballPeriod> function) {
        super(childrenBetBlocks);
        this.function = function;
    }

    public PeriodBetContainer(PeriodBet bet) {
        super();
        this.bet = bet;
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        FootballPeriod period = function.apply(footballMatch);
        return bet.canAnalyze(period);
    }

    @Override
    public boolean checkMatch(FootballMatch footballMatch) {
        FootballPeriod period = function.apply(footballMatch);
        return bet.check(period);
    }

}
