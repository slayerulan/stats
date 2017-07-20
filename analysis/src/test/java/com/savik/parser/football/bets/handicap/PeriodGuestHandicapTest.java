package com.savik.parser.football.bets.handicap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.football.bets.handicap.PeriodGuestHandicap;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodGuestHandicapTest extends AbstractBetTest {

    private static final Double WINNING_HANDICAP = -1.5;

    private static final Double LOOSING_HANDICAP = 1.5;

    @Test
    public void testSuccessfulHomeWinningHandicap() {
        PeriodGuestHandicap periodGuestHandicap = new PeriodGuestHandicap(WINNING_HANDICAP);
        assertTrue(periodGuestHandicap.check(
                createPeriodGuestWonWithDifference(Math.abs(WINNING_HANDICAP.intValue()) + 1)
        ));
    }

    @Test
    public void testUnsuccessfulHomeWinningHandicap() {
        PeriodGuestHandicap periodGuestHandicap = new PeriodGuestHandicap(WINNING_HANDICAP);
        assertFalse(periodGuestHandicap.check(
                createPeriodGuestWonWithDifference(Math.abs(WINNING_HANDICAP.intValue()))
        ));
    }

    @Test
    public void testSuccessfulHomeLoosingHandicap() {
        PeriodGuestHandicap periodGuestHandicap = new PeriodGuestHandicap(LOOSING_HANDICAP);
        assertTrue(periodGuestHandicap.check(
                createPeriodHomeWonWithDifference(Math.abs(LOOSING_HANDICAP.intValue()))
        ));
    }

    @Test
    public void testUnsuccessfulFavoriteLoosingHandicap() {
        PeriodGuestHandicap periodGuestHandicap = new PeriodGuestHandicap(LOOSING_HANDICAP);
        assertFalse(periodGuestHandicap.check(
                createPeriodHomeWonWithDifference(Math.abs(LOOSING_HANDICAP.intValue()) + 1)
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnTrueIfHomeAndGuestScoreExist() {
        PeriodGuestHandicap periodGuestHandicap = new PeriodGuestHandicap(LOOSING_HANDICAP);
        assertTrue(periodGuestHandicap.canAnalyze(
                createPeriodWithAnyGuestAndHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfHomeScoreNotExists() {
        PeriodGuestHandicap periodGuestHandicap = new PeriodGuestHandicap(LOOSING_HANDICAP);
        assertFalse(periodGuestHandicap.canAnalyze(
                createPeriodWithoutHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfGuestScoreNotExists() {
        PeriodGuestHandicap periodGuestHandicap = new PeriodGuestHandicap(LOOSING_HANDICAP);
        assertFalse(periodGuestHandicap.canAnalyze(
                createPeriodWithoutGuestScore()
        ));
    }
}
