package com.savik.parser.football.bets;

import java.util.concurrent.ThreadLocalRandom;

import com.savik.football.model.Period;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@SuppressWarnings("AbstractClassWithoutAbstractMethods")
@RunWith(SpringRunner.class)
public abstract class AbstractBetTest {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private static final Integer MAX_GOALS = 10;

    private static final Integer RANDOM_GOAL_AMOUNT = RANDOM.nextInt(0, MAX_GOALS);

    @Before
    public void init() {

    }

    public Period createPeriodHomeWonWithDifference(int diff) {
        return Period.builder()
                     .guestScore(RANDOM_GOAL_AMOUNT)
                     .homeScore(RANDOM_GOAL_AMOUNT + diff)
                     .build();
    }

    public Period createPeriodGuestWonWithDifference(int diff) {
        return Period.builder()
                     .guestScore(RANDOM_GOAL_AMOUNT + diff)
                     .homeScore(RANDOM_GOAL_AMOUNT)
                     .build();
    }

    public Period createPeriodWithAnyGuestAndHomeScore() {
        return Period.builder()
                     .guestScore(RANDOM_GOAL_AMOUNT)
                     .homeScore(RANDOM_GOAL_AMOUNT)
                     .build();
    }

}
