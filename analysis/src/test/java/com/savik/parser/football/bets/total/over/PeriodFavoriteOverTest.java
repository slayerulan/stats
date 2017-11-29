package com.savik.parser.football.bets.total.over;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.general.bets.total.over.PeriodFavoriteOver;
import com.savik.Who;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodFavoriteOverTest extends AbstractBetTest {

    private static final Double TOTAL_MORE = 1.5;

    @Test
    public void shouldReturnTrueIfFavoriteScoredMore1() {
        PeriodFavoriteOver periodFavoriteOver = new PeriodFavoriteOver(TOTAL_MORE);
        assertTrue(periodFavoriteOver.check(
                Who.HOME,
                createPeriodWithHomeScore(2)
        ));
    }

    @Test
    public void shouldReturnFalseIfFavoriteScoredLess2() {
        PeriodFavoriteOver periodFavoriteOver = new PeriodFavoriteOver(TOTAL_MORE);
        assertFalse(periodFavoriteOver.check(
                Who.HOME,
                createPeriodWithHomeScore(1)
        ));
    }
    

    @Test
    public void shouldCanAnalyzeReturnTrueIfFavoriteScoreExists() {
        PeriodFavoriteOver periodFavoriteOver = new PeriodFavoriteOver(TOTAL_MORE);
        assertTrue(periodFavoriteOver.canAnalyze(
                Who.HOME,
                createPeriodWithoutGuestScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfFavoriteScoreNotExists() {
        PeriodFavoriteOver periodFavoriteOver = new PeriodFavoriteOver(TOTAL_MORE);
        assertFalse(periodFavoriteOver.canAnalyze(
                Who.HOME,
                createPeriodWithoutHomeScore()
        ));
    }
}
