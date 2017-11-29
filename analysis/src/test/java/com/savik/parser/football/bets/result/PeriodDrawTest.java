package com.savik.parser.football.bets.result;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.general.bets.result.PeriodDraw;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodDrawTest extends AbstractBetTest {

    @Test
    public void shouldReturnTrueIfPeriodResultIsDraw() {
        PeriodDraw periodDraw = new PeriodDraw();
        assertTrue(periodDraw.check(
                createPeriodHomeWonWithDifference(0)
        ));
    }

    @Test
    public void shouldReturnFalseIfPeriodResultIsNotDraw() {
        PeriodDraw periodDraw = new PeriodDraw();
        assertFalse(periodDraw.check(
                createPeriodHomeWonWithDifference(1)
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnTrueIfHomeAndGuestScoreExist() {
        PeriodDraw periodDraw = new PeriodDraw();
        assertTrue(periodDraw.canAnalyze(
                createPeriodWithAnyGuestAndHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfHomeScoreNotExists() {
        PeriodDraw periodDraw = new PeriodDraw();
        assertFalse(periodDraw.canAnalyze(
                createPeriodWithoutHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfGuestScoreNotExists() {
        PeriodDraw periodDraw = new PeriodDraw();
        assertFalse(periodDraw.canAnalyze(
                createPeriodWithoutGuestScore()
        ));
    }
}
