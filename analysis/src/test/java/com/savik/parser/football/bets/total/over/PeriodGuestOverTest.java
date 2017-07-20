package com.savik.parser.football.bets.total.over;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.football.bets.total.over.PeriodGuestOver;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodGuestOverTest extends AbstractBetTest {

    private static final Double TOTAL_MORE = 1.5;

    @Test
    public void shouldReturnTrueIfGuestScoredMore1() {
        PeriodGuestOver periodGuestOver = new PeriodGuestOver(TOTAL_MORE);
        assertTrue(periodGuestOver.check(
                createPeriodWithGuestScore(2)
        ));
    }

    @Test
    public void shouldReturnFalseIfGuestScoredLess2() {
        PeriodGuestOver periodGuestOver = new PeriodGuestOver(TOTAL_MORE);
        assertFalse(periodGuestOver.check(
                createPeriodWithGuestScore(0)
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnTrueIfGuestScoreExists() {
        PeriodGuestOver periodGuestOver = new PeriodGuestOver(TOTAL_MORE);
        assertTrue(periodGuestOver.canAnalyze(
                createPeriodWhereOnlyGuestScored()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfGuestScoreNotExists() {
        PeriodGuestOver periodGuestOver = new PeriodGuestOver(TOTAL_MORE);
        assertFalse(periodGuestOver.canAnalyze(
                createPeriodWithoutGuestScore()
        ));
    }
}
