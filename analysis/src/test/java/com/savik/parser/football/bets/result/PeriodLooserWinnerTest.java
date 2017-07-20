package com.savik.parser.football.bets.result;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.football.bets.result.PeriodLooserWinner;
import com.savik.football.model.Who;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodLooserWinnerTest extends AbstractBetTest {

    @Test
    public void shouldReturnTrueIfHomeLooserAndWonPeriod() {
        PeriodLooserWinner periodLooserWinner = new PeriodLooserWinner();
        assertTrue(periodLooserWinner.check(
                Who.GUEST,
                createPeriodHomeWonWithDifference(1)
        ));
    }

    @Test
    public void shouldReturnFalseIfPeriodResultIsDraw() {
        PeriodLooserWinner periodLooserWinner = new PeriodLooserWinner();
        assertFalse(periodLooserWinner.check(
                Who.HOME,
                createPeriodHomeWonWithDifference(0)
        ));
    }

    @Test
    public void shouldReturnFalseIfHomeFavoriteAndHomeWonPeriod() {
        PeriodLooserWinner periodLooserWinner = new PeriodLooserWinner();
        assertFalse(periodLooserWinner.check(
                Who.HOME,
                createPeriodHomeWonWithDifference(1)
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnTrueIfHomeAndGuestScoreExist() {
        PeriodLooserWinner periodLooserWinner = new PeriodLooserWinner();
        assertTrue(periodLooserWinner.canAnalyze(
                Who.HOME,
                createPeriodWithAnyGuestAndHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfHomeScoreNotExists() {
        PeriodLooserWinner periodLooserWinner = new PeriodLooserWinner();
        assertFalse(periodLooserWinner.canAnalyze(
                Who.HOME,
                createPeriodWithoutHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfGuestScoreNotExists() {
        PeriodLooserWinner periodLooserWinner = new PeriodLooserWinner();
        assertFalse(periodLooserWinner.canAnalyze(
                Who.HOME,
                createPeriodWithoutGuestScore()
        ));
    }
}
