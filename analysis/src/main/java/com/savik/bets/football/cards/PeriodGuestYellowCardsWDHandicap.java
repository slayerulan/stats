package com.savik.bets.football.cards;

import com.savik.PeriodBet;
import com.savik.Who;
import com.savik.football.model.FootballCard;
import com.savik.football.model.FootballPeriod;
import lombok.Getter;

@Getter
public class PeriodGuestYellowCardsWDHandicap extends PeriodBet<FootballPeriod> {

    private double amount;

    public PeriodGuestYellowCardsWDHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballPeriod period) {
        return period.getCards() != null;
    }

    @Override
    public boolean check(FootballPeriod period) {
        long homeAmount = period.getCards().stream()
                .filter(c -> c.getType() == FootballCard.Type.YELLOW && c.getWho() == Who.HOME).count();
        long guestAmount = period.getCards().stream()
                .filter(c -> c.getType() == FootballCard.Type.YELLOW && c.getWho() == Who.GUEST).count();
        if (amount <= 0) {
            return guestAmount - homeAmount > Math.abs(amount);
        }
        return homeAmount - guestAmount < amount;
    }
}
