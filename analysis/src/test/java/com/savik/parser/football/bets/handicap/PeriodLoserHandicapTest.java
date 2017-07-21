package com.savik.parser.football.bets.handicap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.football.bets.handicap.PeriodLoserHandicap;
import com.savik.football.model.Who;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodLoserHandicapTest extends AbstractBetTest {

    private static final Double WINNING_HANDICAP = -1.5;

    private static final Double LOOSING_HANDICAP = 1.5;

    @Test
    public void testSuccessfulLooserWinningHandicap() {
        PeriodLoserHandicap periodLoserHandicap = new PeriodLoserHandicap(WINNING_HANDICAP);
        assertTrue(periodLoserHandicap.check(
                Who.HOME,
                createPeriodGuestWonWithDifference(Math.abs(WINNING_HANDICAP.intValue()) + 1)
        ));
    }

    @Test
    public void testUnsuccessfulLooserWinningHandicap() {
        PeriodLoserHandicap periodLoserHandicap = new PeriodLoserHandicap(WINNING_HANDICAP);
        assertFalse(periodLoserHandicap.check(
                Who.HOME,
                createPeriodGuestWonWithDifference(Math.abs(WINNING_HANDICAP.intValue()))
        ));
    }

    @Test
    public void testSuccessfulLooserLoosingHandicap() {
        PeriodLoserHandicap periodLoserHandicap = new PeriodLoserHandicap(LOOSING_HANDICAP);
        assertTrue(periodLoserHandicap.check(
                Who.HOME,
                createPeriodHomeWonWithDifference(Math.abs(LOOSING_HANDICAP.intValue()))
        ));
    }

    @Test
    public void testUnsuccessfulFavoriteLoosingHandicap() {
        PeriodLoserHandicap periodLoserHandicap = new PeriodLoserHandicap(LOOSING_HANDICAP);
        assertFalse(periodLoserHandicap.check(
                Who.HOME,
                createPeriodHomeWonWithDifference(Math.abs(LOOSING_HANDICAP.intValue()) + 1)
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnTrueIfFavoriteIsTeamAndHomeAndGuestScoreExist() {
        PeriodLoserHandicap periodLoserHandicap = new PeriodLoserHandicap(LOOSING_HANDICAP);
        Who favorite = Who.HOME;
        assertTrue(periodLoserHandicap.canAnalyze(
                favorite,
                createPeriodWithAnyGuestAndHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfFavoriteUnknown() {
        PeriodLoserHandicap periodLoserHandicap = new PeriodLoserHandicap(LOOSING_HANDICAP);
        Who unknownFavorite = Who.UNKNOWN;
        assertFalse(periodLoserHandicap.canAnalyze(
                unknownFavorite,
                createPeriodWithAnyGuestAndHomeScore()
        ));
    }
}
