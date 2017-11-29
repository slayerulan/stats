package com.savik.parser.football.bets.total.under;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.bets.general.total.under.PeriodHomeUnder;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodHomeUnderTest extends AbstractBetTest {

    private static final Double TOTAL_LESS = 1.5;

    @Test
    public void shouldReturnTrueIfHomeScoredLess2() {
        PeriodHomeUnder periodHomeUnder = new PeriodHomeUnder(TOTAL_LESS);
        assertTrue(periodHomeUnder.check(
                createPeriodWithHomeScore(1)
        ));
    }

    @Test
    public void shouldReturnFalseIfHomeScoredMore1() {
        PeriodHomeUnder periodHomeUnder = new PeriodHomeUnder(TOTAL_LESS);
        assertFalse(periodHomeUnder.check(
                createPeriodWithHomeScore(2)
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnTrueIfHomeScoreExists() {
        PeriodHomeUnder periodHomeUnder = new PeriodHomeUnder(TOTAL_LESS);
        assertTrue(periodHomeUnder.canAnalyze(
                createPeriodWhereOnlyHomeScored()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfHomeScoreNotExists() {
        PeriodHomeUnder periodHomeUnder = new PeriodHomeUnder(TOTAL_LESS);
        assertFalse(periodHomeUnder.canAnalyze(
                createPeriodWithoutHomeScore()
        ));
    }
}
