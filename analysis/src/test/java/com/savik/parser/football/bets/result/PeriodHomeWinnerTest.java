package com.savik.parser.football.bets.result;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.bets.general.result.PeriodHomeWinner;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodHomeWinnerTest extends AbstractBetTest {

    @Test
    public void shouldReturnTrueIfHomeWonPeriod() {
        PeriodHomeWinner periodHomeWinner = new PeriodHomeWinner();
        assertTrue(periodHomeWinner.check(
                createPeriodHomeWonWithDifference(1)
        ));
    }

    @Test
    public void shouldReturnFalseIfPeriodResultIsDraw() {
        PeriodHomeWinner periodHomeWinner = new PeriodHomeWinner();
        assertFalse(periodHomeWinner.check(
                createPeriodHomeWonWithDifference(0)
        ));
    }

    @Test
    public void shouldReturnFalseIfGuestWonPeriod() {
        PeriodHomeWinner periodHomeWinner = new PeriodHomeWinner();
        assertFalse(periodHomeWinner.check(
                createPeriodGuestWonWithDifference(1)
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnTrueIfHomeAndGuestScoreExist() {
        PeriodHomeWinner periodHomeWinner = new PeriodHomeWinner();
        assertTrue(periodHomeWinner.canAnalyze(
                createPeriodWithAnyGuestAndHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfHomeScoreNotExists() {
        PeriodHomeWinner periodHomeWinner = new PeriodHomeWinner();
        assertFalse(periodHomeWinner.canAnalyze(
                createPeriodWithoutHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfGuestScoreNotExists() {
        PeriodHomeWinner periodHomeWinner = new PeriodHomeWinner();
        assertFalse(periodHomeWinner.canAnalyze(
                createPeriodWithoutGuestScore()
        ));
    }
}
