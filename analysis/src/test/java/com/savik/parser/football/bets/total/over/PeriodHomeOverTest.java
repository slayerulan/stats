package com.savik.parser.football.bets.total.over;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.general.bets.total.over.PeriodHomeOver;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodHomeOverTest extends AbstractBetTest {

    private static final Double TOTAL_MORE = 1.5;

    @Test
    public void shouldReturnTrueIfHomeScoredMore1() {
        PeriodHomeOver periodHomeOver = new PeriodHomeOver(TOTAL_MORE);
        assertTrue(periodHomeOver.check(
                createPeriodWithHomeScore(2)
        ));
    }

    @Test
    public void shouldReturnFalseIfHomeScoredLess2() {
        PeriodHomeOver periodHomeOver = new PeriodHomeOver(TOTAL_MORE);
        assertFalse(periodHomeOver.check(
                createPeriodWithHomeScore(0)
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnTrueIfHomeScoreExists() {
        PeriodHomeOver periodHomeOver = new PeriodHomeOver(TOTAL_MORE);
        assertTrue(periodHomeOver.canAnalyze(
                createPeriodWhereOnlyHomeScored()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfHomeScoreNotExists() {
        PeriodHomeOver periodHomeOver = new PeriodHomeOver(TOTAL_MORE);
        assertFalse(periodHomeOver.canAnalyze(
                createPeriodWithoutHomeScore()
        ));
    }
}
