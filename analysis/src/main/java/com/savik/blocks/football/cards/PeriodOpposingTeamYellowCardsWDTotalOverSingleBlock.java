package com.savik.blocks.football.cards;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.football.cards.PeriodGuestYellowCardsWDTotalOver;
import com.savik.bets.football.cards.PeriodHomeYellowCardsWDTotalOver;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodOpposingTeamYellowCardsWDTotalOverSingleBlock extends PeriodTeamBetContainer<FootballMatch> {

    public PeriodOpposingTeamYellowCardsWDTotalOverSingleBlock(double total, ContainerType type) {
        super(
                new PeriodGuestYellowCardsWDTotalOver(total),
                new PeriodHomeYellowCardsWDTotalOver(total),
                type
        );
    }

    public PeriodOpposingTeamYellowCardsWDTotalOverSingleBlock(double total, Function<FootballMatch, Period> function, MatchData matchData) {
        super(
                new PeriodGuestYellowCardsWDTotalOver(total),
                new PeriodHomeYellowCardsWDTotalOver(total),
                function, matchData
        );
    }


}
