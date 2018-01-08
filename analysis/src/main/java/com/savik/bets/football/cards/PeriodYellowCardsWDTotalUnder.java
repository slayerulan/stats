package com.savik.bets.football.cards;

import com.savik.PeriodBet;
import com.savik.football.model.FootballCard;
import com.savik.football.model.FootballPeriod;
import lombok.Getter;

@Getter
public class PeriodYellowCardsWDTotalUnder extends PeriodBet<FootballPeriod> {

    private double amount;

    public PeriodYellowCardsWDTotalUnder(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballPeriod period) {
        return period.getCards() != null;
    }

    @Override
    public boolean check(FootballPeriod period) {
        return period.getCards().stream().filter(c -> c.getType() == FootballCard.Type.YELLOW).count() < amount;
    }
}
