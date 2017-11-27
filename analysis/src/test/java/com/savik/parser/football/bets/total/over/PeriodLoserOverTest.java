package com.savik.parser.football.bets.total.over;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.football.bets.total.over.PeriodLoserOver;
import com.savik.Who;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodLoserOverTest extends AbstractBetTest {

    private static final Double TOTAL_MORE = 1.5;

    @Test
    public void shouldReturnTrueIfLoserScoredMore1() {
        PeriodLoserOver periodLoserOver = new PeriodLoserOver(TOTAL_MORE);
        assertTrue(periodLoserOver.check(
                Who.HOME,
                createPeriodWithGuestScore(2)
        ));
    }

    @Test
    public void shouldReturnFalseIfLoserScoredLess2() {
        PeriodLoserOver periodLoserOver = new PeriodLoserOver(TOTAL_MORE);
        assertFalse(periodLoserOver.check(
                Who.HOME,
                createPeriodWithGuestScore(1)
        ));
    }
    

    @Test
    public void shouldCanAnalyzeReturnTrueIfLoserScoreExists() {
        PeriodLoserOver periodLoserOver = new PeriodLoserOver(TOTAL_MORE);
        assertTrue(periodLoserOver.canAnalyze(
                Who.HOME,
                createPeriodWithoutHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfLoserScoreNotExists() {
        PeriodLoserOver periodLoserOver = new PeriodLoserOver(TOTAL_MORE);
        assertFalse(periodLoserOver.canAnalyze(
                Who.HOME,
                createPeriodWithoutGuestScore()
        ));
    }
}
