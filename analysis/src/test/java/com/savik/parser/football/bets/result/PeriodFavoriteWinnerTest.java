package com.savik.parser.football.bets.result;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.bets.general.result.PeriodFavoriteWinner;
import com.savik.Who;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodFavoriteWinnerTest extends AbstractBetTest {

    @Test
    public void shouldReturnTrueIfHomeFavoriteAndWonPeriod() {
        PeriodFavoriteWinner periodFavoriteWinner = new PeriodFavoriteWinner();
        assertTrue(periodFavoriteWinner.check(
                Who.HOME,
                createPeriodHomeWonWithDifference(1)
        ));
    }

    @Test
    public void shouldReturnFalseIfPeriodResultIsDraw() {
        PeriodFavoriteWinner periodFavoriteWinner = new PeriodFavoriteWinner();
        assertFalse(periodFavoriteWinner.check(
                Who.HOME,
                createPeriodHomeWonWithDifference(0)
        ));
    }

    @Test
    public void shouldReturnFalseIfHomeFavoriteAndGuestWonPeriod() {
        PeriodFavoriteWinner periodFavoriteWinner = new PeriodFavoriteWinner();
        assertFalse(periodFavoriteWinner.check(
                Who.HOME,
                createPeriodGuestWonWithDifference(1)
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnTrueIfHomeAndGuestScoreExist() {
        PeriodFavoriteWinner periodFavoriteWinner = new PeriodFavoriteWinner();
        assertTrue(periodFavoriteWinner.canAnalyze(
                Who.HOME,
                createPeriodWithAnyGuestAndHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfHomeScoreNotExists() {
        PeriodFavoriteWinner periodFavoriteWinner = new PeriodFavoriteWinner();
        assertFalse(periodFavoriteWinner.canAnalyze(
                Who.HOME,
                createPeriodWithoutHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfGuestScoreNotExists() {
        PeriodFavoriteWinner periodFavoriteWinner = new PeriodFavoriteWinner();
        assertFalse(periodFavoriteWinner.canAnalyze(
                Who.HOME,
                createPeriodWithoutGuestScore()
        ));
    }
}
