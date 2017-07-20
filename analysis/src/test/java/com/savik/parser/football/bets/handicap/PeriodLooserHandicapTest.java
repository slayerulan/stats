package com.savik.parser.football.bets.handicap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.football.bets.handicap.PeriodLooserHandicap;
import com.savik.football.model.Who;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodLooserHandicapTest extends AbstractBetTest {

    private static final Double WINNING_HANDICAP = -1.5;

    private static final Double LOOSING_HANDICAP = 1.5;

    @Test
    public void testSuccessfulLooserWinningHandicap() {
        PeriodLooserHandicap periodLooserHandicap = new PeriodLooserHandicap(WINNING_HANDICAP);
        assertTrue(periodLooserHandicap.check(
                Who.HOME,
                createPeriodGuestWonWithDifference(Math.abs(WINNING_HANDICAP.intValue()) + 1)
        ));
    }

    @Test
    public void testUnsuccessfulLooserWinningHandicap() {
        PeriodLooserHandicap periodLooserHandicap = new PeriodLooserHandicap(WINNING_HANDICAP);
        assertFalse(periodLooserHandicap.check(
                Who.HOME,
                createPeriodGuestWonWithDifference(Math.abs(WINNING_HANDICAP.intValue()))
        ));
    }

    @Test
    public void testSuccessfulLooserLoosingHandicap() {
        PeriodLooserHandicap periodLooserHandicap = new PeriodLooserHandicap(LOOSING_HANDICAP);
        assertTrue(periodLooserHandicap.check(
                Who.HOME,
                createPeriodHomeWonWithDifference(Math.abs(LOOSING_HANDICAP.intValue()))
        ));
    }

    @Test
    public void testUnsuccessfulFavoriteLoosingHandicap() {
        PeriodLooserHandicap periodLooserHandicap = new PeriodLooserHandicap(LOOSING_HANDICAP);
        assertFalse(periodLooserHandicap.check(
                Who.HOME,
                createPeriodHomeWonWithDifference(Math.abs(LOOSING_HANDICAP.intValue()) + 1)
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnTrueIfFavoriteIsTeamAndHomeAndGuestScoreExist() {
        PeriodLooserHandicap periodLooserHandicap = new PeriodLooserHandicap(LOOSING_HANDICAP);
        Who favorite = Who.HOME;
        assertTrue(periodLooserHandicap.canAnalyze(
                favorite,
                createPeriodWithAnyGuestAndHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfFavoriteUnknown() {
        PeriodLooserHandicap periodLooserHandicap = new PeriodLooserHandicap(LOOSING_HANDICAP);
        Who unknownFavorite = Who.UNKNOWN;
        assertFalse(periodLooserHandicap.canAnalyze(
                unknownFavorite,
                createPeriodWithAnyGuestAndHomeScore()
        ));
    }
}
