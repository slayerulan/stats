package com.savik.parser.football.bets.total.under;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.general.bets.total.under.PeriodUnder;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodUnderTest extends AbstractBetTest {

    private static final Double TOTAL_LESS = 1.5;

    @Test
    public void shouldReturnTrueIfTotalScoreIsMore1() {
        PeriodUnder periodUnder = new PeriodUnder(TOTAL_LESS);
        assertTrue(periodUnder.check(
                createPeriodWithTotalScore(1)
        ));
    }

    @Test
    public void shouldReturnFalseIfTotalScoreIsLess2() {
        PeriodUnder periodUnder = new PeriodUnder(TOTAL_LESS);
        assertFalse(periodUnder.check(
                createPeriodWithTotalScore(2)
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnTrueIfHomeAndGuestScoreExist() {
        PeriodUnder periodUnder = new PeriodUnder(TOTAL_LESS);
        assertTrue(periodUnder.canAnalyze(
                createPeriodWithAnyTotalScore()
        ));
    }
}
