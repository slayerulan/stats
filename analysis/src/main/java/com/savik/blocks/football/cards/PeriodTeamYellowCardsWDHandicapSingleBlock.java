package com.savik.blocks.football.cards;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.football.cards.PeriodGuestYellowCardsWDHandicap;
import com.savik.bets.football.cards.PeriodHomeYellowCardsWDHandicap;
import com.savik.bets.football.corners.PeriodGuestCornersHandicap;
import com.savik.bets.football.corners.PeriodHomeCornersHandicap;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodTeamYellowCardsWDHandicapSingleBlock extends PeriodTeamBetContainer<FootballMatch> {

    public PeriodTeamYellowCardsWDHandicapSingleBlock(double total, ContainerType type) {
        super(
                new PeriodHomeYellowCardsWDHandicap(total),
                new PeriodGuestYellowCardsWDHandicap(total),
                type
        );
    }

    public PeriodTeamYellowCardsWDHandicapSingleBlock(double total, Function<FootballMatch, Period> function, MatchData matchData) {
        super(
                new PeriodHomeYellowCardsWDHandicap(total),
                new PeriodGuestYellowCardsWDHandicap(total),
                function, matchData
        );
    }


}
