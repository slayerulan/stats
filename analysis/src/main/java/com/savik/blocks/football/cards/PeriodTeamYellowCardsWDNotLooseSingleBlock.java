package com.savik.blocks.football.cards;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.football.cards.PeriodGuestYellowCardsWDNotLoose;
import com.savik.bets.football.cards.PeriodHomeYellowCardsWDNotLoose;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;


public class PeriodTeamYellowCardsWDNotLooseSingleBlock extends PeriodTeamBetContainer<FootballMatch> {

    public PeriodTeamYellowCardsWDNotLooseSingleBlock(ContainerType type) {
        super(
                new PeriodHomeYellowCardsWDNotLoose(),
                new PeriodGuestYellowCardsWDNotLoose(),
                type
        );
    }

    public PeriodTeamYellowCardsWDNotLooseSingleBlock(Function<FootballMatch, Period> function, MatchData matchData) {
        super(
                new PeriodHomeYellowCardsWDNotLoose(),
                new PeriodGuestYellowCardsWDNotLoose(),
                function, matchData
        );
    }


}
