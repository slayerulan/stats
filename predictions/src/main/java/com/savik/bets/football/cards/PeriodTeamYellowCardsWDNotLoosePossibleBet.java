package com.savik.bets.football.cards;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.cards.PeriodOpposingTeamYellowCardsWDNotLooseSingleBlock;
import com.savik.blocks.football.cards.PeriodTeamYellowCardsWDNotLooseSingleBlock;
import com.savik.blocks.football.corners.PeriodOpposingTeamCornersNotLooseSingleBlock;
import com.savik.blocks.football.corners.PeriodTeamCornersNotLooseSingleBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodTeamYellowCardsWDNotLoosePossibleBet extends PossibleBet<FootballMatch> {
    public PeriodTeamYellowCardsWDNotLoosePossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                      Function<FootballMatch, Period> function) {
        super(
                new PeriodTeamYellowCardsWDNotLooseSingleBlock(function, homeMatchData),
                new PeriodOpposingTeamYellowCardsWDNotLooseSingleBlock(function, guestMatchData)
        );
    }
}
