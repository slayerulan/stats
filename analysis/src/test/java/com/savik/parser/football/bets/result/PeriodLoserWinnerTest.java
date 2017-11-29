package com.savik.parser.football.bets.result;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.bets.general.result.PeriodLoserWinner;
import com.savik.Who;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodLoserWinnerTest extends AbstractBetTest {

    @Test
    public void shouldReturnTrueIfHomeLooserAndWonPeriod() {
        PeriodLoserWinner periodLoserWinner = new PeriodLoserWinner();
        assertTrue(periodLoserWinner.check(
                Who.GUEST,
                createPeriodHomeWonWithDifference(1)
        ));
    }

    @Test
    public void shouldReturnFalseIfPeriodResultIsDraw() {
        PeriodLoserWinner periodLoserWinner = new PeriodLoserWinner();
        assertFalse(periodLoserWinner.check(
                Who.HOME,
                createPeriodHomeWonWithDifference(0)
        ));
    }

    @Test
    public void shouldReturnFalseIfHomeFavoriteAndHomeWonPeriod() {
        PeriodLoserWinner periodLoserWinner = new PeriodLoserWinner();
        assertFalse(periodLoserWinner.check(
                Who.HOME,
                createPeriodHomeWonWithDifference(1)
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnTrueIfHomeAndGuestScoreExist() {
        PeriodLoserWinner periodLoserWinner = new PeriodLoserWinner();
        assertTrue(periodLoserWinner.canAnalyze(
                Who.HOME,
                createPeriodWithAnyGuestAndHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfHomeScoreNotExists() {
        PeriodLoserWinner periodLoserWinner = new PeriodLoserWinner();
        assertFalse(periodLoserWinner.canAnalyze(
                Who.HOME,
                createPeriodWithoutHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfGuestScoreNotExists() {
        PeriodLoserWinner periodLoserWinner = new PeriodLoserWinner();
        assertFalse(periodLoserWinner.canAnalyze(
                Who.HOME,
                createPeriodWithoutGuestScore()
        ));
    }
}
