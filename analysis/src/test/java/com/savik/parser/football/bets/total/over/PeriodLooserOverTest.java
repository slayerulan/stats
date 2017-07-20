package com.savik.parser.football.bets.total.over;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.football.bets.total.over.PeriodLooserOver;
import com.savik.football.model.Who;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodLooserOverTest extends AbstractBetTest {

    private static final Double TOTAL_MORE = 1.5;

    @Test
    public void shouldReturnTrueIfFavoriteScoredMore1() {
        PeriodLooserOver periodLooserOver = new PeriodLooserOver(TOTAL_MORE);
        assertTrue(periodLooserOver.check(
                Who.HOME,
                createPeriodWithGuestScore(2)
        ));
    }

    @Test
    public void shouldReturnFalseIfFavoriteScoredLess2() {
        PeriodLooserOver periodLooserOver = new PeriodLooserOver(TOTAL_MORE);
        assertFalse(periodLooserOver.check(
                Who.HOME,
                createPeriodWithGuestScore(1)
        ));
    }
    

    @Test
    public void shouldCanAnalyzeReturnTrueIfFavoriteScoreExists() {
        PeriodLooserOver periodLooserOver = new PeriodLooserOver(TOTAL_MORE);
        assertTrue(periodLooserOver.canAnalyze(
                Who.HOME,
                createPeriodWithoutHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfFavoriteScoreNotExists() {
        PeriodLooserOver periodLooserOver = new PeriodLooserOver(TOTAL_MORE);
        assertFalse(periodLooserOver.canAnalyze(
                Who.HOME,
                createPeriodWithoutGuestScore()
        ));
    }
}
