package com.savik.parser.football.bets;

import java.util.concurrent.ThreadLocalRandom;

import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballMatchInfo;
import com.savik.football.model.FootballPeriod;
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

    public FootballPeriod createPeriodHomeWonWithDifference(int diff) {
        return FootballPeriod.builder()
                     .guestScore(RANDOM_GOAL_AMOUNT)
                     .homeScore(RANDOM_GOAL_AMOUNT + diff)
                     .build();
    }

    public FootballPeriod createPeriodGuestWonWithDifference(int diff) {
        return FootballPeriod.builder()
                     .guestScore(RANDOM_GOAL_AMOUNT + diff)
                     .homeScore(RANDOM_GOAL_AMOUNT)
                     .build();
    }

    public FootballPeriod createPeriodWithAnyGuestAndHomeScore() {
        return FootballPeriod.builder()
                     .guestScore(RANDOM_GOAL_AMOUNT)
                     .homeScore(RANDOM_GOAL_AMOUNT)
                     .build();
    }

    public FootballPeriod createPeriodWithAnyTotalScore() {
        return FootballPeriod.builder()
                     .totalScore(RANDOM_GOAL_AMOUNT)
                     .build();
    }

    public FootballPeriod createPeriodWhereOnlyHomeScored() {
        return FootballPeriod.builder()
                     .guestScore(0)
                     .homeScore(RANDOM_GOAL_AMOUNT)
                     .build();
    }

    public FootballPeriod createPeriodWhereOnlyGuestScored() {
        return FootballPeriod.builder()
                     .guestScore(RANDOM_GOAL_AMOUNT)
                     .homeScore(0)
                     .build();
    }

    public FootballPeriod createPeriodWithoutGuestScore() {
        return FootballPeriod.builder()
                     .homeScore(RANDOM_GOAL_AMOUNT)
                     .build();
    }

    public FootballPeriod createPeriodWithoutHomeScore() {
        return FootballPeriod.builder()
                     .guestScore(RANDOM_GOAL_AMOUNT)
                     .build();
    }

    public FootballPeriod createPeriodWithHomeScore(int score) {
        return FootballPeriod.builder()
                     .guestScore(RANDOM_GOAL_AMOUNT)
                     .homeScore(score)
                     .build();
    }

    public FootballPeriod createPeriodWithGuestScore(int score) {
        return FootballPeriod.builder()
                     .homeScore(RANDOM_GOAL_AMOUNT)
                     .guestScore(score)
                     .build();
    }

    public FootballPeriod createPeriodWithTotalScore(int score) {
        return FootballPeriod.builder()
                     .totalScore(score)
                     .build();
    }

    public FootballMatch createFootballMatch(FootballPeriod first, FootballPeriod second) {
        return FootballMatch.builder()
                .matchInfo(
                        FootballMatchInfo.builder()
                        .firstPeriod(first)
                        .secondPeriod(second)
                        .build()
                )
                .build();
    }

}
