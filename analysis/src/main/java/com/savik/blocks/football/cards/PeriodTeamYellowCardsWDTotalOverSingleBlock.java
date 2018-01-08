package com.savik.blocks.football.cards;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.football.cards.PeriodGuestYellowCardsWDTotalOver;
import com.savik.bets.football.cards.PeriodHomeYellowCardsWDTotalOver;
import com.savik.bets.football.corners.PeriodGuestCornersTotalOver;
import com.savik.bets.football.corners.PeriodHomeCornersTotalOver;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodTeamYellowCardsWDTotalOverSingleBlock extends PeriodTeamBetContainer<FootballMatch> {

    public PeriodTeamYellowCardsWDTotalOverSingleBlock(double total, ContainerType type) {
        super(
                new PeriodHomeYellowCardsWDTotalOver(total),
                new PeriodGuestYellowCardsWDTotalOver(total),
                type
        );
    }

    public PeriodTeamYellowCardsWDTotalOverSingleBlock(double total, Function<FootballMatch, Period> function, MatchData matchData) {
        super(
                new PeriodHomeYellowCardsWDTotalOver(total),
                new PeriodGuestYellowCardsWDTotalOver(total),
                function, matchData
        );
    }


}
