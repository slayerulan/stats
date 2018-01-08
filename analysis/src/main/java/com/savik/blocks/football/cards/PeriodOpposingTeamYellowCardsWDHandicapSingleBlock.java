package com.savik.blocks.football.cards;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.football.cards.PeriodGuestYellowCardsWDHandicap;
import com.savik.bets.football.cards.PeriodHomeYellowCardsWDHandicap;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodOpposingTeamYellowCardsWDHandicapSingleBlock extends PeriodTeamBetContainer<FootballMatch> {

    public PeriodOpposingTeamYellowCardsWDHandicapSingleBlock(double total, ContainerType type) {
        super(
                new PeriodGuestYellowCardsWDHandicap(total),
                new PeriodHomeYellowCardsWDHandicap(total),
                type
        );
    }

    public PeriodOpposingTeamYellowCardsWDHandicapSingleBlock(double total, Function<FootballMatch, Period> function, MatchData matchData) {
        super(
                new PeriodGuestYellowCardsWDHandicap(total),
                new PeriodHomeYellowCardsWDHandicap(total),
                function, matchData
        );
    }


}
