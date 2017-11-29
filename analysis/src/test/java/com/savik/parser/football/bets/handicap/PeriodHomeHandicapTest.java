package com.savik.parser.football.bets.handicap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.general.bets.handicap.PeriodHomeHandicap;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodHomeHandicapTest extends AbstractBetTest {

    private static final Double WINNING_HANDICAP = -1.5;

    private static final Double LOOSING_HANDICAP = 1.5;

    @Test
    public void testSuccessfulHomeWinningHandicap() {
        PeriodHomeHandicap periodHomeHandicap = new PeriodHomeHandicap(WINNING_HANDICAP);
        assertTrue(periodHomeHandicap.check(
                createPeriodHomeWonWithDifference(Math.abs(WINNING_HANDICAP.intValue()) + 1)
        ));
    }

    @Test
    public void testUnsuccessfulHomeWinningHandicap() {
        PeriodHomeHandicap periodHomeHandicap = new PeriodHomeHandicap(WINNING_HANDICAP);
        assertFalse(periodHomeHandicap.check(
                createPeriodHomeWonWithDifference(Math.abs(WINNING_HANDICAP.intValue()))
        ));
    }

    @Test
    public void testSuccessfulHomeLoosingHandicap() {
        PeriodHomeHandicap periodHomeHandicap = new PeriodHomeHandicap(LOOSING_HANDICAP);
        assertTrue(periodHomeHandicap.check(
                createPeriodGuestWonWithDifference(Math.abs(LOOSING_HANDICAP.intValue()))
        ));
    }

    @Test
    public void testUnsuccessfulFavoriteLoosingHandicap() {
        PeriodHomeHandicap periodHomeHandicap = new PeriodHomeHandicap(LOOSING_HANDICAP);
        assertFalse(periodHomeHandicap.check(
                createPeriodGuestWonWithDifference(Math.abs(LOOSING_HANDICAP.intValue()) + 1)
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnTrueIfHomeAndGuestScoreExist() {
        PeriodHomeHandicap periodHomeHandicap = new PeriodHomeHandicap(LOOSING_HANDICAP);
        assertTrue(periodHomeHandicap.canAnalyze(
                createPeriodWithAnyGuestAndHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfHomeScoreNotExists() {
        PeriodHomeHandicap periodHomeHandicap = new PeriodHomeHandicap(LOOSING_HANDICAP);
        assertFalse(periodHomeHandicap.canAnalyze(
                createPeriodWithoutHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfGuestScoreNotExists() {
        PeriodHomeHandicap periodHomeHandicap = new PeriodHomeHandicap(LOOSING_HANDICAP);
        assertFalse(periodHomeHandicap.canAnalyze(
                createPeriodWithoutGuestScore()
        ));
    }
}
