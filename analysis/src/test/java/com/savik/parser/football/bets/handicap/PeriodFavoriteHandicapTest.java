package com.savik.parser.football.bets.handicap;

import static org.junit.Assert.assertTrue;

import com.savik.football.bets.handicap.PeriodFavoriteHandicap;
import com.savik.football.model.Who;
import com.savik.parser.football.bets.AbstractBetTest;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Savushkin Yauheni
 * @since 19.07.2017
 */
public class PeriodFavoriteHandicapTest extends AbstractBetTest {

    public static final Double HANDICAP = -1.5;

    private PeriodFavoriteHandicap periodFavoriteHandicap;

    @Before
    public void createRule() {
        periodFavoriteHandicap = new PeriodFavoriteHandicap(HANDICAP);
    }

    @Test
    public void testSuccessfulChecking() throws Exception {
        assertTrue(periodFavoriteHandicap.check(
                Who.HOME,
                createPeriodHomeWonWithDifference(Math.abs(HANDICAP.intValue()) + 1)
        ));
    }
}
