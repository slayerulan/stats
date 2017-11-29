package com.savik.parser.football.bets.total.under;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.general.bets.total.under.PeriodFavoriteUnder;
import com.savik.Who;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodFavoriteUnderTest extends AbstractBetTest {

    private static final Double TOTAL_LESS = 1.5;

    @Test
    public void shouldReturnTrueIfFavoriteScoredLess2() {
        PeriodFavoriteUnder periodFavoriteUnder = new PeriodFavoriteUnder(TOTAL_LESS);
        assertTrue(periodFavoriteUnder.check(
                Who.HOME,
                createPeriodWithHomeScore(1)
        ));
    }

    @Test
    public void shouldReturnFalseIfFavoriteScoredMore1() {
        PeriodFavoriteUnder periodFavoriteUnder = new PeriodFavoriteUnder(TOTAL_LESS);
        assertFalse(periodFavoriteUnder.check(
                Who.HOME,
                createPeriodWithHomeScore(2)
        ));
    }
    

    @Test
    public void shouldCanAnalyzeReturnTrueIfFavoriteScoreExists() {
        PeriodFavoriteUnder periodFavoriteUnder = new PeriodFavoriteUnder(TOTAL_LESS);
        assertTrue(periodFavoriteUnder.canAnalyze(
                Who.HOME,
                createPeriodWithoutGuestScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfFavoriteScoreNotExists() {
        PeriodFavoriteUnder periodFavoriteUnder = new PeriodFavoriteUnder(TOTAL_LESS);
        assertFalse(periodFavoriteUnder.canAnalyze(
                Who.HOME,
                createPeriodWithoutHomeScore()
        ));
    }
}
