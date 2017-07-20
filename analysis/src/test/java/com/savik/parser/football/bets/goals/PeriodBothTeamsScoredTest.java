package com.savik.parser.football.bets.goals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.football.bets.goals.PeriodBothTeamsScored;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class PeriodBothTeamsScoredTest extends AbstractBetTest {

    @Test
    public void shouldReturnTrueIfHomeAndGuestScoredInPeriod() {
        PeriodBothTeamsScored periodBothTeamsScored = new PeriodBothTeamsScored();
        assertTrue(periodBothTeamsScored.check(
                createPeriodWithAnyGuestAndHomeScore()
        ));
    }

    @Test
    public void shouldReturnFalseIfOnlyHomeScored() {
        PeriodBothTeamsScored periodBothTeamsScored = new PeriodBothTeamsScored();
        assertFalse(periodBothTeamsScored.check(
                createPeriodWhereOnlyHomeScored()
        ));
    }

    @Test
    public void shouldReturnFalseIfOnlyGuestScored() {
        PeriodBothTeamsScored periodBothTeamsScored = new PeriodBothTeamsScored();
        assertFalse(periodBothTeamsScored.check(
                createPeriodWhereOnlyGuestScored()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnTrueIfHomeScoreAndGuestExist() {
        PeriodBothTeamsScored periodBothTeamsScored = new PeriodBothTeamsScored();
        assertTrue(periodBothTeamsScored.canAnalyze(
                createPeriodWithAnyGuestAndHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfHomeScoreNotExists() {
        PeriodBothTeamsScored periodBothTeamsScored = new PeriodBothTeamsScored();
        assertFalse(periodBothTeamsScored.canAnalyze(
                createPeriodWithoutHomeScore()
        ));
    }

    @Test
    public void shouldCanAnalyzeReturnFalseIfGuestScoreNotExists() {
        PeriodBothTeamsScored periodBothTeamsScored = new PeriodBothTeamsScored();
        assertFalse(periodBothTeamsScored.canAnalyze(
                createPeriodWithoutGuestScore()
        ));
    }
}
