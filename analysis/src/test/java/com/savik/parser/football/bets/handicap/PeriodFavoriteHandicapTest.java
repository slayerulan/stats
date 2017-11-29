package com.savik.parser.football.bets.handicap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.bets.general.handicap.PeriodFavoriteHandicap;
import com.savik.Who;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodFavoriteHandicapTest extends AbstractBetTest {

    private static final Double WINNING_HANDICAP = -1.5;

    private static final Double LOOSING_HANDICAP = 1.5;

    @Test
    public void testSuccessfulFavoriteWinningHandicap() {
        PeriodFavoriteHandicap periodFavoriteHandicap = new PeriodFavoriteHandicap(WINNING_HANDICAP);
        assertTrue(periodFavoriteHandicap.check(
                Who.HOME,
                createPeriodHomeWonWithDifference(Math.abs(WINNING_HANDICAP.intValue()) + 1)
        ));
    }

    @Test
    public void testUnsuccessfulFavoriteWinningHandicap() {
        PeriodFavoriteHandicap periodFavoriteHandicap = new PeriodFavoriteHandicap(WINNING_HANDICAP);
        assertFalse(periodFavoriteHandicap.check(
                Who.HOME,
                createPeriodHomeWonWithDifference(Math.abs(WINNING_HANDICAP.intValue()))
        ));
    }

    @Test
    public void testSuccessfulFavoriteLoosingHandicap() {
        PeriodFavoriteHandicap periodFavoriteHandicap = new PeriodFavoriteHandicap(LOOSING_HANDICAP);
        assertTrue(periodFavoriteHandicap.check(
                Who.HOME,
                createPeriodGuestWonWithDifference(Math.abs(LOOSING_HANDICAP.intValue()))
        ));
    }

    @Test
    public void testUnsuccessfulFavoriteLoosingHandicap() {
        PeriodFavoriteHandicap periodFavoriteHandicap = new PeriodFavoriteHandicap(LOOSING_HANDICAP);
        assertFalse(periodFavoriteHandicap.check(
                Who.HOME,
                createPeriodGuestWonWithDifference(Math.abs(LOOSING_HANDICAP.intValue()) + 1)
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnTrueIfFavoriteIsTeamAndHomeAndGuestScoreExist() {
        PeriodFavoriteHandicap periodFavoriteHandicap = new PeriodFavoriteHandicap(LOOSING_HANDICAP);
        Who favorite = Who.HOME;
        assertTrue(periodFavoriteHandicap.canAnalyze(
                favorite,
                createPeriodWithAnyGuestAndHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfFavoriteUnknown() {
        PeriodFavoriteHandicap periodFavoriteHandicap = new PeriodFavoriteHandicap(LOOSING_HANDICAP);
        Who unknownFavorite = Who.UNKNOWN;
        assertFalse(periodFavoriteHandicap.canAnalyze(
                unknownFavorite,
                createPeriodWithAnyGuestAndHomeScore()
        ));
    }
}
