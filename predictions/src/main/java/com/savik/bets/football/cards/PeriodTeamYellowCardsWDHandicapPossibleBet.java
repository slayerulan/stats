package com.savik.bets.football.cards;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.football.cards.PeriodOpposingTeamYellowCardsWDHandicapSingleBlock;
import com.savik.blocks.football.cards.PeriodTeamYellowCardsWDHandicapSingleBlock;
import com.savik.blocks.football.corners.PeriodOpposingTeamCornersHandicapBlock;
import com.savik.blocks.football.corners.PeriodTeamCornersHandicapBlock;
import com.savik.football.model.FootballMatch;

import java.util.function.Function;

public class PeriodTeamYellowCardsWDHandicapPossibleBet extends PossibleBet<FootballMatch> {
    public PeriodTeamYellowCardsWDHandicapPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                      Function<FootballMatch, Period> function, double amount) {
        super(
                new PeriodTeamYellowCardsWDHandicapSingleBlock(amount, function, homeMatchData),
                new PeriodOpposingTeamYellowCardsWDHandicapSingleBlock(amount, function, guestMatchData)
        );
    }
}
