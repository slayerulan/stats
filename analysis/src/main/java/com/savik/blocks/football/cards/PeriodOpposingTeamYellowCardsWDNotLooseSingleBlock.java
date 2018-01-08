package com.savik.blocks.football.cards;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.football.cards.PeriodGuestYellowCardsWDNotLoose;
import com.savik.bets.football.cards.PeriodHomeYellowCardsWDNotLoose;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodOpposingTeamYellowCardsWDNotLooseSingleBlock extends PeriodTeamBetContainer<FootballMatch> {

    public PeriodOpposingTeamYellowCardsWDNotLooseSingleBlock(ContainerType type) {
        super(
                new PeriodGuestYellowCardsWDNotLoose(),
                new PeriodHomeYellowCardsWDNotLoose(),
                type
        );
    }

    public PeriodOpposingTeamYellowCardsWDNotLooseSingleBlock(Function<FootballMatch, Period> function, MatchData matchData) {
        super(
                new PeriodGuestYellowCardsWDNotLoose(),
                new PeriodHomeYellowCardsWDNotLoose(),
                function, matchData
        );
    }


}
