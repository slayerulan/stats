package com.savik.parser.football.bets.total.under;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.bets.general.total.under.PeriodLoserUnder;
import com.savik.Who;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodLoserUnderTest extends AbstractBetTest {

    private static final Double TOTAL_LESS = 1.5;

    @Test
    public void shouldReturnTrueIfLoserScoredLess2() {
        PeriodLoserUnder periodLoserUnder = new PeriodLoserUnder(TOTAL_LESS);
        assertTrue(periodLoserUnder.check(
                Who.HOME,
                createPeriodWithGuestScore(1)
        ));
    }

    @Test
    public void shouldReturnFalseIfLoserScoredMore1() {
        PeriodLoserUnder periodLoserUnder = new PeriodLoserUnder(TOTAL_LESS);
        assertFalse(periodLoserUnder.check(
                Who.HOME,
                createPeriodWithGuestScore(2)
        ));
    }
    

    @Test
    public void shouldCanAnalyzeReturnTrueIfLoserScoreExists() {
        PeriodLoserUnder periodLoserUnder = new PeriodLoserUnder(TOTAL_LESS);
        assertTrue(periodLoserUnder.canAnalyze(
                Who.HOME,
                createPeriodWithoutHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfLoserScoreNotExists() {
        PeriodLoserUnder periodLoserUnder = new PeriodLoserUnder(TOTAL_LESS);
        assertFalse(periodLoserUnder.canAnalyze(
                Who.HOME,
                createPeriodWithoutGuestScore()
        ));
    }
}
