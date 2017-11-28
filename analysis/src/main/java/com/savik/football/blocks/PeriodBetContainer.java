package com.savik.football.blocks;

import com.savik.football.bets.PeriodBet;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class PeriodBetContainer extends BetContainer<FootballMatch> {

    private PeriodBet bet;

    public PeriodBetContainer(List<? extends BetContainer> childrenBetBlocks) {
        super(childrenBetBlocks);
    }

    public PeriodBetContainer(PeriodBet bet) {
        super();
        this.bet = bet;
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        FootballPeriod period = getPeriod(footballMatch);
        return bet.canAnalyze(period);
    }

    @Override
    public boolean checkMatch(FootballMatch footballMatch) {
        FootballPeriod period = getPeriod(footballMatch);
        return bet.check(period);
    }

    public abstract FootballPeriod getPeriod(FootballMatch footballMatch);
}
