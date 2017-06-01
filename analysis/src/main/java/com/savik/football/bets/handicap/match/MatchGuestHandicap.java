package com.savik.football.bets.handicap.match;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.Period;
import lombok.*;

/**
 * @author Savushkin Yauheni
 * @since 17.05.2017
 */
@Getter
public class MatchGuestHandicap extends GeneralBet {

    private double amount;

    public MatchGuestHandicap(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean canAnalyze(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getMatch().getHomeScore() != null &&
               footballMatch.getMatchInfo().getMatch().getGuestScore() != null;
    }

    @Override
    public boolean check(FootballMatch footballMatch) {
        Period matchInfo = footballMatch.getMatchInfo().getMatch();
        if (amount <= 0) {
            return matchInfo.getGuestScore() - matchInfo.getHomeScore() > Math.abs(amount);
        }
        return matchInfo.getHomeScore() - matchInfo.getGuestScore() < amount;
    }
}
