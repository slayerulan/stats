package com.savik.parser.football.bets.total.over;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.general.bets.total.over.PeriodOver;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodOverTest extends AbstractBetTest {

    private static final Double TOTAL_MORE = 1.5;

    @Test
    public void shouldReturnTrueIfTotalScoreIsMore1() {
        PeriodOver periodOver = new PeriodOver(TOTAL_MORE);
        assertTrue(periodOver.check(
                createPeriodWithTotalScore(2)
        ));
    }

    @Test
    public void shouldReturnFalseIfTotalScoreIsLess2() {
        PeriodOver periodOver = new PeriodOver(TOTAL_MORE);
        assertFalse(periodOver.check(
                createPeriodWithTotalScore(0)
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnTrueIfHomeAndGuestScoreExist() {
        PeriodOver periodOver = new PeriodOver(TOTAL_MORE);
        assertTrue(periodOver.canAnalyze(
                createPeriodWithAnyTotalScore()
        ));
    }
}
