package com.savik.parser.football.bets.result;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.general.bets.result.PeriodGuestWinner;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodGuestWinnerTest extends AbstractBetTest {

    @Test
    public void shouldReturnTrueIfGuestWonPeriod() {
        PeriodGuestWinner periodGuestWinner = new PeriodGuestWinner();
        assertTrue(periodGuestWinner.check(
                createPeriodGuestWonWithDifference(1)
        ));
    }

    @Test
    public void shouldReturnFalseIfPeriodResultIsDraw() {
        PeriodGuestWinner periodGuestWinner = new PeriodGuestWinner();
        assertFalse(periodGuestWinner.check(
                createPeriodHomeWonWithDifference(0)
        ));
    }

    @Test
    public void shouldReturnFalseIfHomeWonPeriod() {
        PeriodGuestWinner periodGuestWinner = new PeriodGuestWinner();
        assertFalse(periodGuestWinner.check(
                createPeriodHomeWonWithDifference(1)
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnTrueIfHomeAndGuestScoreExist() {
        PeriodGuestWinner periodGuestWinner = new PeriodGuestWinner();
        assertTrue(periodGuestWinner.canAnalyze(
                createPeriodWithAnyGuestAndHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfHomeScoreNotExists() {
        PeriodGuestWinner periodGuestWinner = new PeriodGuestWinner();
        assertFalse(periodGuestWinner.canAnalyze(
                createPeriodWithoutHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfGuestScoreNotExists() {
        PeriodGuestWinner periodGuestWinner = new PeriodGuestWinner();
        assertFalse(periodGuestWinner.canAnalyze(
                createPeriodWithoutGuestScore()
        ));
    }
}
