package com.savik.parser.football.bets.total.over.periods;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.savik.general.bets.total.over.periods.EveryPeriodOver;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Test;

public class EveryPeriodOverTest extends AbstractBetTest {

    private static final Double TOTAL_MORE = 0.5;

    @Test
    public void shouldReturnTrueIfEachPeriodScoredMore0() {
        EveryPeriodOver everyPeriodOver = new EveryPeriodOver(TOTAL_MORE);
        assertTrue(everyPeriodOver.check(
                createFootballMatch(
                        createPeriodWithTotalScore(1),
                        createPeriodWithTotalScore(1)
                )
        ));
    }

    @Test
    public void shouldReturnFalseIfFirstPeriodLessThen1() {
        EveryPeriodOver everyPeriodOver = new EveryPeriodOver(TOTAL_MORE);
        assertFalse(everyPeriodOver.check(
                createFootballMatch(
                        createPeriodWithTotalScore(0),
                        createPeriodWithTotalScore(1)
                )
        ));
    }

    @Test
    public void shouldReturnFalseIfSecondPeriodLessThen1() {
        EveryPeriodOver everyPeriodOver = new EveryPeriodOver(TOTAL_MORE);
        assertFalse(everyPeriodOver.check(
                createFootballMatch(
                        createPeriodWithTotalScore(1),
                        createPeriodWithTotalScore(0)
                )
        ));
    }
}
