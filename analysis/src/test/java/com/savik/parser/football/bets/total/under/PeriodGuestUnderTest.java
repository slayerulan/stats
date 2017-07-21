package com.savik.parser.football.bets.total.under;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.football.bets.total.under.PeriodGuestUnder;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodGuestUnderTest extends AbstractBetTest {

    private static final Double TOTAL_MORE = 1.5;

    @Test
    public void shouldReturnTrueIfGuestScoredLess2() {
        PeriodGuestUnder periodGuestUnder = new PeriodGuestUnder(TOTAL_MORE);
        assertTrue(periodGuestUnder.check(
                createPeriodWithGuestScore(1)
        ));
    }

    @Test
    public void shouldReturnFalseIfGuestScoredMore1() {
        PeriodGuestUnder periodGuestUnder = new PeriodGuestUnder(TOTAL_MORE);
        assertFalse(periodGuestUnder.check(
                createPeriodWithGuestScore(2)
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnTrueIfGuestScoreExists() {
        PeriodGuestUnder periodGuestUnder = new PeriodGuestUnder(TOTAL_MORE);
        assertTrue(periodGuestUnder.canAnalyze(
                createPeriodWhereOnlyGuestScored()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfGuestScoreNotExists() {
        PeriodGuestUnder periodGuestUnder = new PeriodGuestUnder(TOTAL_MORE);
        assertFalse(periodGuestUnder.canAnalyze(
                createPeriodWithoutGuestScore()
        ));
    }
}
