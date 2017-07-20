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

    private static final Integer RANDOM_GOAL_AMOUNT = RANDOM.nextInt(1, MAX_GOALS);

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

    public Period createPeriodWithAnyTotalScore() {
        return Period.builder()
                     .totalScore(RANDOM_GOAL_AMOUNT)
                     .build();
    }

    public Period createPeriodWhereOnlyHomeScored() {
        return Period.builder()
                     .guestScore(0)
                     .homeScore(RANDOM_GOAL_AMOUNT)
                     .build();
    }

    public Period createPeriodWhereOnlyGuestScored() {
        return Period.builder()
                     .guestScore(RANDOM_GOAL_AMOUNT)
                     .homeScore(0)
                     .build();
    }

    public Period createPeriodWithoutGuestScore() {
        return Period.builder()
                     .homeScore(RANDOM_GOAL_AMOUNT)
                     .build();
    }

    public Period createPeriodWithoutHomeScore() {
        return Period.builder()
                     .guestScore(RANDOM_GOAL_AMOUNT)
                     .build();
    }

    public Period createPeriodWithHomeScore(int score) {
        return Period.builder()
                     .guestScore(RANDOM_GOAL_AMOUNT)
                     .homeScore(score)
                     .build();
    }

    public Period createPeriodWithGuestScore(int score) {
        return Period.builder()
                     .homeScore(RANDOM_GOAL_AMOUNT)
                     .guestScore(score)
                     .build();
    }

    public Period createPeriodWithTotalScore(int score) {
        return Period.builder()
                     .totalScore(score)
                     .build();
    }

}
