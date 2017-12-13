package com.savik;

import com.savik.blocks.hockey.match.general.PossibleBetsBlock;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyTeam;
import com.savik.hockey.repository.HockeyMatchRepository;
import com.savik.hockey.repository.HockeyTeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static com.savik.ContainerType.*;
import static com.savik.hockey.specifications.HockeyMatchSpec.hasTeam;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@ActiveProfiles("test")
@Transactional
@Rollback
@Sql(scripts = {
        "classpath:db/possible_bets/matches_AqombNzc.sql", "classpath:db/possible_bets/matches_CIGVL5B6.sql",
        "classpath:db/possible_bets/matches_j5qIp46c.sql", "classpath:db/possible_bets/matches_rwPEPmCs.sql",
        "classpath:db/possible_bets/matches_xn1B4zMd.sql",


        // real matches but Colorado replaced by Buffalo
        "classpath:db/possible_bets/matches_Ai5wex7j.sql", "classpath:db/possible_bets/matches_QTEL7Fjd.sql",
        "classpath:db/possible_bets/matches_vJ50rp5f.sql", "classpath:db/possible_bets/matches_YVeCUxb9.sql",
        "classpath:db/possible_bets/matches_I39zqxpU.sql"
})
public class HockeyPossibleBetBlockTest {

    public static final long COLORADO_TEAM_ID = 1L;
    public static final long BUFFALO_TEAM_ID = 21L;

    @Autowired
    HockeyTeamRepository hockeyTeamRepository;

    @Autowired
    HockeyMatchRepository hockeyMatchRepository;


    @Test
    public void testTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer totalOverBlock = PossibleBetContainer.findByType(TOTAL).findByType(TOTAL_OVER);

        PossibleBetContainer over4AndHalf = totalOverBlock.findByType(OVER_4_5);
        assertEquals(40, over4AndHalf.getFirstTeamPercentage());
        assertEquals(100, over4AndHalf.getSecondTeamPercentage());


        PossibleBetContainer over5AndHalf = totalOverBlock.findByType(OVER_5_5);
        assertEquals(20, over5AndHalf.getFirstTeamPercentage());
        assertEquals(100, over5AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testTotalUnder() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer totalUnderBlock = PossibleBetContainer.findByType(TOTAL).findByType(TOTAL_UNDER);

        PossibleBetContainer under5AndHalf = totalUnderBlock.findByType(UNDER_5_5);
        assertEquals(80, under5AndHalf.getFirstTeamPercentage());
        assertEquals(0, under5AndHalf.getSecondTeamPercentage());


        PossibleBetContainer under6AndHalf = totalUnderBlock.findByType(UNDER_6_5);
        assertEquals(80, under6AndHalf.getFirstTeamPercentage());
        assertEquals(20, under6AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testBothTeamsTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer totalOverBlock = PossibleBetContainer.findByType(TOTAL).findByType(BOTH_TEAMS_TOTAL_OVER);

        PossibleBetContainer over1AndHalf = totalOverBlock.findByType(OVER_1_5);
        assertEquals(80, over1AndHalf.getFirstTeamPercentage());
        assertEquals(100, over1AndHalf.getSecondTeamPercentage());


        PossibleBetContainer over2AndHalf = totalOverBlock.findByType(OVER_2_5);
        assertEquals(20, over2AndHalf.getFirstTeamPercentage());
        assertEquals(60, over2AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testBothTeamsTotalUnder() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer totalUnderBlock = PossibleBetContainer.findByType(TOTAL).findByType(BOTH_TEAMS_TOTAL_UNDER);

        PossibleBetContainer under2AndHalf = totalUnderBlock.findByType(UNDER_2_5);
        assertEquals(40, under2AndHalf.getFirstTeamPercentage());
        assertEquals(0, under2AndHalf.getSecondTeamPercentage());


        PossibleBetContainer under3AndHalf = totalUnderBlock.findByType(UNDER_3_5);
        assertEquals(80, under3AndHalf.getFirstTeamPercentage());
        assertEquals(20, under3AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testTeamTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer totalOverBlock = PossibleBetContainer.findByType(TOTAL).findByType(TEAM_TOTAL_OVER);

        PossibleBetContainer over2AndHalf = totalOverBlock.findByType(OVER_2_5);
        assertEquals(40, over2AndHalf.getFirstTeamPercentage());
        assertEquals(80, over2AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over3AndHalf = totalOverBlock.findByType(OVER_3_5);
        assertEquals(20, over3AndHalf.getFirstTeamPercentage());
        assertEquals(40, over3AndHalf.getSecondTeamPercentage());


    }

    @Test
    public void testTeamTotalUnder() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer totalUnderBlock = PossibleBetContainer.findByType(TOTAL).findByType(TEAM_TOTAL_UNDER);

        PossibleBetContainer under2AndHalf = totalUnderBlock.findByType(UNDER_2_5);
        assertEquals(60, under2AndHalf.getFirstTeamPercentage());
        assertEquals(20, under2AndHalf.getSecondTeamPercentage());


        PossibleBetContainer under3AndHalf = totalUnderBlock.findByType(UNDER_3_5);
        assertEquals(80, under3AndHalf.getFirstTeamPercentage());
        assertEquals(60, under3AndHalf.getSecondTeamPercentage());

    }
/*  





    @Test
    public void testOtherTeamTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer totalOverBlock = PossibleBetContainer.findByType(TOTAL).findByType(OPPOSING_TEAM_TOTAL_OVER);

        PossibleBetContainer over1AndHalf = totalOverBlock.findByType(OVER_1_5);
        assertEquals(12, over1AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(11, over1AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over1AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(91, over1AndHalf.getPercentage().intValue());

        PossibleBetContainer over2AndHalf = totalOverBlock.findByType(OVER_2_5);
        assertEquals(12, over2AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(8, over2AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over2AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(66, over2AndHalf.getPercentage().intValue());


        PossibleBetContainer over3AndHalf = totalOverBlock.findByType(OVER_3_5);
        assertEquals(12, over3AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(4, over3AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over3AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(33, over3AndHalf.getPercentage().intValue());

        PossibleBetContainer over4AndHalf = totalOverBlock.findByType(OVER_4_5);
        assertEquals(12, over4AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(3, over4AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over4AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(25, over4AndHalf.getPercentage().intValue());

    }

    @Test
    public void testOtherTeamTotalUnder() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer totalUnderBlock = PossibleBetContainer.findByType(TOTAL).findByType(OPPOSING_TEAM_TOTAL_UNDER);

        PossibleBetContainer under2AndHalf = totalUnderBlock.findByType(UNDER_2_5);
        assertEquals(12, under2AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(4, under2AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under2AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(33, under2AndHalf.getPercentage().intValue());


        PossibleBetContainer under3AndHalf = totalUnderBlock.findByType(UNDER_3_5);
        assertEquals(12, under3AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(8, under3AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under3AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(66, under3AndHalf.getPercentage().intValue());


        PossibleBetContainer under4AndHalf = totalUnderBlock.findByType(UNDER_4_5);
        assertEquals(12, under4AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(9, under4AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under4AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(75, under4AndHalf.getPercentage().intValue());

    }


    @Test
    public void testFirstPeriodAnyWinner() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(FIRST_PERIOD).findByType(ANY_WIN);

        assertEquals(12, block.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, block.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, block.getSkippedMatchesAmount().intValue());
        assertEquals(58, block.getPercentage().intValue());

    }

    @Test
    public void testFirstPeriodTeamNot() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer firstPeriod = PossibleBetContainer.findByType(FIRST_PERIOD)
                .findByType(TEAM_NOT_LOOSE);
        assertEquals(12, firstPeriod.getAnalyzedMatchesAmount().intValue());
        assertEquals(9, firstPeriod.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, firstPeriod.getSkippedMatchesAmount().intValue());
        assertEquals(75, firstPeriod.getPercentage().intValue());

    }

    @Test
    public void testFirstPeriodTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer firstPeriodTotalOver = PossibleBetContainer.findByType(FIRST_PERIOD).findByType(TOTAL_OVER);

        PossibleBetContainer over0AndHalf = firstPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(10, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(83, over0AndHalf.getPercentage().intValue());

        PossibleBetContainer over1AndHalf = firstPeriodTotalOver.findByType(OVER_1_5);
        assertEquals(12, over1AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, over1AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over1AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(58, over1AndHalf.getPercentage().intValue());

    }

    @Test
    public void testBothTeamsFirstPeriodTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer container = PossibleBetContainer.findByType(FIRST_PERIOD)
                .findByType(BOTH_TEAMS_TOTAL_OVER);

        PossibleBetContainer over0AndHalf = container.findByType(OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(4, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(33, over0AndHalf.getPercentage().intValue());

    }

    @Test
    public void testFirstPeriodTeamTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer firstPeriodTotalOver = PossibleBetContainer.findByType(FIRST_PERIOD)
                .findByType(TEAM_TOTAL_OVER);

        PossibleBetContainer over0AndHalf = firstPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(58, over0AndHalf.getPercentage().intValue());

        PossibleBetContainer over1AndHalf = firstPeriodTotalOver.findByType(OVER_1_5);
        assertEquals(12, over1AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(4, over1AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over1AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(33, over1AndHalf.getPercentage().intValue());

    }

    @Test
    public void testFirstPeriodOpposingTeamTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer firstPeriodTotalOver = PossibleBetContainer.findByType(FIRST_PERIOD)
                .findByType(OPPOSING_TEAM_TOTAL_OVER);

        PossibleBetContainer over0AndHalf = firstPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(58, over0AndHalf.getPercentage().intValue());

        PossibleBetContainer over1AndHalf = firstPeriodTotalOver.findByType(OVER_1_5);
        assertEquals(12, over1AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(2, over1AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over1AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(16, over1AndHalf.getPercentage().intValue());

    }

    @Test
    public void testSecondPeriodAnyWinner() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(SECOND_PERIOD);
        block = block.findByType(ANY_WIN);

        assertEquals(12, block.getAnalyzedMatchesAmount().intValue());
        assertEquals(8, block.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, block.getSkippedMatchesAmount().intValue());
        assertEquals(66, block.getPercentage().intValue());

    }

    @Test
    public void testSecondPeriodTeamNotLoose() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(SECOND_PERIOD)
                .findByType(TEAM_NOT_LOOSE);
        assertEquals(12, block.getAnalyzedMatchesAmount().intValue());
        assertEquals(6, block.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, block.getSkippedMatchesAmount().intValue());
        assertEquals(50, block.getPercentage().intValue());
    }

    @Test
    public void testSecondPeriodTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer secondPeriodTotalOver = PossibleBetContainer.findByType(SECOND_PERIOD)
                .findByType(TOTAL_OVER);

        PossibleBetContainer over0AndHalf = secondPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(11, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(91, over0AndHalf.getPercentage().intValue());

        PossibleBetContainer over1AndHalf = secondPeriodTotalOver.findByType(OVER_1_5);
        assertEquals(12, over1AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(9, over1AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over1AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(75, over1AndHalf.getPercentage().intValue());

    }


    @Test
    public void testBothTeamsSecondPeriodTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer container = PossibleBetContainer.findByType(SECOND_PERIOD)
                .findByType(BOTH_TEAMS_TOTAL_OVER);

        PossibleBetContainer over0AndHalf = container.findByType(OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(6, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(50, over0AndHalf.getPercentage().intValue());

    }

    @Test
    public void testSecondPeriodTeamTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer secondPeriodTotalOver = PossibleBetContainer.findByType(SECOND_PERIOD)
                .findByType(TEAM_TOTAL_OVER);

        PossibleBetContainer over0AndHalf = secondPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(58, over0AndHalf.getPercentage().intValue());

        PossibleBetContainer over1AndHalf = secondPeriodTotalOver.findByType(OVER_1_5);
        assertEquals(12, over1AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(5, over1AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over1AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(41, over1AndHalf.getPercentage().intValue());

    }


    @Test
    public void testSecondPeriodOpposingTeamTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer secondPeriodTotalOver = PossibleBetContainer.findByType(SECOND_PERIOD)
                .findByType(OPPOSING_TEAM_TOTAL_OVER);

        PossibleBetContainer over0AndHalf = secondPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(10, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(83, over0AndHalf.getPercentage().intValue());

        PossibleBetContainer over1AndHalf = secondPeriodTotalOver.findByType(OVER_1_5);
        assertEquals(12, over1AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(6, over1AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over1AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(50, over1AndHalf.getPercentage().intValue());

    }

    @Test
    public void testThirdPeriodAnyWinner() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(THIRD_PERIOD);
        block = block.findByType(ANY_WIN);

        assertEquals(12, block.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, block.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, block.getSkippedMatchesAmount().intValue());
        assertEquals(58, block.getPercentage().intValue());

    }


    @Test
    public void testThirdPeriodTeamNotLoose() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer thirdPeriod = PossibleBetContainer.findByType(THIRD_PERIOD)
                .findByType(TEAM_NOT_LOOSE);
        assertEquals(12, thirdPeriod.getAnalyzedMatchesAmount().intValue());
        assertEquals(10, thirdPeriod.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, thirdPeriod.getSkippedMatchesAmount().intValue());
        assertEquals(83, thirdPeriod.getPercentage().intValue());
    }

    @Test
    public void testThirdPeriodTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer thirdPeriodTotalOver = PossibleBetContainer.findByType(THIRD_PERIOD).findByType(TOTAL_OVER);

        PossibleBetContainer over0AndHalf = thirdPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(10, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(83, over0AndHalf.getPercentage().intValue());

        PossibleBetContainer over1AndHalf = thirdPeriodTotalOver.findByType(OVER_1_5);
        assertEquals(12, over1AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(8, over1AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over1AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(66, over1AndHalf.getPercentage().intValue());

    }

    @Test
    public void testBothTeamsThirdPeriodTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer container = PossibleBetContainer.findByType(THIRD_PERIOD)
                .findByType(BOTH_TEAMS_TOTAL_OVER);

        PossibleBetContainer over0AndHalf = container.findByType(OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(58, over0AndHalf.getPercentage().intValue());

    }


    @Test
    public void testThirdPeriodTeamTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer thirdPeriodTotalOver = PossibleBetContainer.findByType(THIRD_PERIOD)
                .findByType(TEAM_TOTAL_OVER);

        PossibleBetContainer over0AndHalf = thirdPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(9, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(75, over0AndHalf.getPercentage().intValue());

        PossibleBetContainer over1AndHalf = thirdPeriodTotalOver.findByType(OVER_1_5);
        assertEquals(12, over1AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(4, over1AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over1AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(33, over1AndHalf.getPercentage().intValue());

    }


    @Test
    public void testThirdPeriodOpposingTeamTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer thirdPeriodTotalOver = PossibleBetContainer.findByType(THIRD_PERIOD)
                .findByType(OPPOSING_TEAM_TOTAL_OVER);

        PossibleBetContainer over0AndHalf = thirdPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(8, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(66, over0AndHalf.getPercentage().intValue());

        PossibleBetContainer over1AndHalf = thirdPeriodTotalOver.findByType(OVER_1_5);
        assertEquals(12, over1AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(3, over1AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over1AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(25, over1AndHalf.getPercentage().intValue());

    }


    @Test
    public void testTotalOverInAllPeriods() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer totalOverBlock = PossibleBetContainer.findByType(TOTAL_OVER_ALL_PERIODS);

        PossibleBetContainer over0AndHalf = totalOverBlock.findByType(OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(58, over0AndHalf.getPercentage().intValue());

    }

    @Test
    public void testTotalUnderInAllPeriods() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer totalUnderBlock = PossibleBetContainer.findByType(TOTAL_UNDER_ALL_PERIODS);

        PossibleBetContainer under2AndHalf = totalUnderBlock.findByType(UNDER_2_5);
        assertEquals(12, under2AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(2, under2AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under2AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(16, under2AndHalf.getPercentage().intValue());

        PossibleBetContainer under3AndHalf = totalUnderBlock.findByType(UNDER_3_5);
        assertEquals(12, under3AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(5, under3AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under3AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(41, under3AndHalf.getPercentage().intValue());

    }

    @Test
    public void testAnyWinAndTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(ANY_WIN_AND_TOTAL_OVER);

        PossibleBetContainer over4AndHalf = block.findByType(OVER_4_5);
        assertEquals(12, over4AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, over4AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over4AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(58, over4AndHalf.getPercentage().intValue());

        PossibleBetContainer over5AndHalf = block.findByType(OVER_5_5);
        assertEquals(12, over5AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(6, over5AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over5AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(50, over5AndHalf.getPercentage().intValue());

    }

    @Test
    public void testAnyWinAndTotalUnder() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(ANY_WIN_AND_TOTAL_UNDER);

        PossibleBetContainer under4AndHalf = block.findByType(UNDER_4_5);
        assertEquals(12, under4AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(1, under4AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under4AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(8, under4AndHalf.getPercentage().intValue());

        PossibleBetContainer under5AndHalf = block.findByType(UNDER_5_5);
        assertEquals(12, under5AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(2, under5AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under5AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(16, under5AndHalf.getPercentage().intValue());

    }

    @Test
    public void testAnyWinAndDiff() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(ANY_WIN_AND_DIFFERENCE_EQUALS);

        PossibleBetContainer diff1 = block.findByType(DIFF_1);
        assertEquals(12, diff1.getAnalyzedMatchesAmount().intValue());
        assertEquals(1, diff1.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, diff1.getSkippedMatchesAmount().intValue());
        assertEquals(8, diff1.getPercentage().intValue());

        PossibleBetContainer diff2 = block.findByType(DIFF_2);
        assertEquals(12, diff2.getAnalyzedMatchesAmount().intValue());
        assertEquals(2, diff2.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, diff2.getSkippedMatchesAmount().intValue());
        assertEquals(16, diff2.getPercentage().intValue());

    }

    @Test
    public void testFirstGoalBefore() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(FIRST_GOAL_BEFORE);

        PossibleBetContainer under9 = block.findByType(UNDER_9);
        assertEquals(12, under9.getAnalyzedMatchesAmount().intValue());
        assertEquals(6, under9.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under9.getSkippedMatchesAmount().intValue());
        assertEquals(50, under9.getPercentage().intValue());

        PossibleBetContainer under10 = block.findByType(UNDER_10);
        assertEquals(12, under10.getAnalyzedMatchesAmount().intValue());
        assertEquals(6, under10.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under10.getSkippedMatchesAmount().intValue());
        assertEquals(50, under10.getPercentage().intValue());

    }

    @Test
    public void testLastGoalAfter() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(LAST_GOAL_AFTER);

        PossibleBetContainer after54 = block.findByType(OVER_54);
        assertEquals(12, after54.getAnalyzedMatchesAmount().intValue());
        assertEquals(6, after54.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, after54.getSkippedMatchesAmount().intValue());
        assertEquals(50, after54.getPercentage().intValue());

    }

    @Test
    public void testTeamWinAndTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(TEAM_WIN_AND_TOTAL_OVER);

        PossibleBetContainer over4AndHalf = block.findByType(OVER_4_5);
        assertEquals(12, over4AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(3, over4AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over4AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(25, over4AndHalf.getPercentage().intValue());

        PossibleBetContainer over5AndHalf = block.findByType(OVER_5_5);
        assertEquals(12, over5AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(3, over5AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over5AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(25, over5AndHalf.getPercentage().intValue());

    }

    @Test
    public void testTeamNotLooseAndTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(TEAM_NOT_LOOSE_AND_TOTAL_OVER);

        PossibleBetContainer over4AndHalf = block.findByType(OVER_4_5);
        assertEquals(12, over4AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(5, over4AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over4AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(41, over4AndHalf.getPercentage().intValue());

        PossibleBetContainer over5AndHalf = block.findByType(OVER_5_5);
        assertEquals(12, over5AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(5, over5AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over5AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(41, over5AndHalf.getPercentage().intValue());

    }

    @Test
    public void testOpposingTeamWinAndTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(OPPOSING_TEAM_WIN_AND_TOTAL_OVER);

        PossibleBetContainer over4AndHalf = block.findByType(OVER_4_5);
        assertEquals(12, over4AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(4, over4AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over4AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(33, over4AndHalf.getPercentage().intValue());

        PossibleBetContainer over5AndHalf = block.findByType(OVER_5_5);
        assertEquals(12, over5AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(3, over5AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over5AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(25, over5AndHalf.getPercentage().intValue());

    }

    @Test
    public void testOpposingTeamNotLooseAndTotalOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_OVER);

        PossibleBetContainer over4AndHalf = block.findByType(OVER_4_5);
        assertEquals(12, over4AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(6, over4AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over4AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(50, over4AndHalf.getPercentage().intValue());

        PossibleBetContainer over5AndHalf = block.findByType(OVER_5_5);
        assertEquals(12, over5AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(5, over5AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over5AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(41, over5AndHalf.getPercentage().intValue());

    }

    @Test
    public void testTeamWinAndTotalUnder() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(TEAM_WIN_AND_TOTAL_UNDER);

        PossibleBetContainer under5AndHalf = block.findByType(UNDER_5_5);
        assertEquals(12, under5AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(1, under5AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under5AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(8, under5AndHalf.getPercentage().intValue());

    }

    @Test
    public void testTeamWinAtLeastNPeriods() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(TEAM_WIN_AT_LEAST_N_PERIODS);

        PossibleBetContainer atLeast1 = block.findByType(NUMBER_1);
        assertEquals(12, atLeast1.getAnalyzedMatchesAmount().intValue());
        assertEquals(9, atLeast1.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, atLeast1.getSkippedMatchesAmount().intValue());
        assertEquals(75, atLeast1.getPercentage().intValue());

        PossibleBetContainer atLeast2 = block.findByType(NUMBER_2);
        assertEquals(12, atLeast2.getAnalyzedMatchesAmount().intValue());
        assertEquals(2, atLeast2.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, atLeast2.getSkippedMatchesAmount().intValue());
        assertEquals(16, atLeast2.getPercentage().intValue());

    }

    @Test
    public void testOpposingTeamWinAtLeastNPeriods() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(OPPOSING_TEAM_WIN_AT_LEAST_N_PERIODS);

        PossibleBetContainer atLeast1 = block.findByType(NUMBER_1);
        assertEquals(12, atLeast1.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, atLeast1.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, atLeast1.getSkippedMatchesAmount().intValue());
        assertEquals(58, atLeast1.getPercentage().intValue());

        PossibleBetContainer atLeast2 = block.findByType(NUMBER_2);
        assertEquals(12, atLeast2.getAnalyzedMatchesAmount().intValue());
        assertEquals(4, atLeast2.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, atLeast2.getSkippedMatchesAmount().intValue());
        assertEquals(33, atLeast2.getPercentage().intValue());

    }

    @Test
    public void testDrawAtLeastNPeriods() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(DRAW_AT_LEAST_N_PERIODS);

        PossibleBetContainer atLeast1 = block.findByType(NUMBER_1);
        assertEquals(12, atLeast1.getAnalyzedMatchesAmount().intValue());
        assertEquals(10, atLeast1.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, atLeast1.getSkippedMatchesAmount().intValue());
        assertEquals(83, atLeast1.getPercentage().intValue());

        PossibleBetContainer atLeast2 = block.findByType(NUMBER_2);
        assertEquals(12, atLeast2.getAnalyzedMatchesAmount().intValue());
        assertEquals(3, atLeast2.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, atLeast2.getSkippedMatchesAmount().intValue());
        assertEquals(25, atLeast2.getPercentage().intValue());

    }

    @Test
    public void testShotsOnTargetOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(SHOTS_ON_TARGET_OVER);

        PossibleBetContainer over60AndHalf = block.findByType(OVER_60_5);
        assertEquals(12, over60AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(5, over60AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over60AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(41, over60AndHalf.getPercentage().intValue());

        PossibleBetContainer over61AndHalf = block.findByType(OVER_61_5);
        assertEquals(12, over61AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(4, over61AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over61AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(33, over61AndHalf.getPercentage().intValue());

        PossibleBetContainer over62AndHalf = block.findByType(OVER_62_5);
        assertEquals(12, over62AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(4, over62AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over62AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(33, over62AndHalf.getPercentage().intValue());

        PossibleBetContainer over63AndHalf = block.findByType(OVER_63_5);
        assertEquals(12, over63AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(3, over63AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over63AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(25, over63AndHalf.getPercentage().intValue());

    }

    @Test
    public void testPenalTimeOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(PENALTIES_TIME_OVER);

        PossibleBetContainer over14AndHalf = block.findByType(OVER_14_5);
        assertEquals(12, over14AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(8, over14AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over14AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(66, over14AndHalf.getPercentage().intValue());

        PossibleBetContainer over16AndHalf = block.findByType(OVER_16_5);
        assertEquals(12, over16AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(8, over16AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over16AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(66, over16AndHalf.getPercentage().intValue());

        PossibleBetContainer over18AndHalf = block.findByType(OVER_18_5);
        assertEquals(12, over18AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(6, over18AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over18AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(50, over18AndHalf.getPercentage().intValue());

    }

    @Test
    public void testPowerplayGoalsOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(POWERPLAY_GOALS_OVER);

        PossibleBetContainer over0AndHalf = block.findByType(OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(11, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(91, over0AndHalf.getPercentage().intValue());

        PossibleBetContainer over1AndHalf = block.findByType(OVER_1_5);
        assertEquals(12, over1AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(8, over1AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over1AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(66, over1AndHalf.getPercentage().intValue());

    }

    @Test
    public void testTeamShotsOnTargetOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(TEAM_SHOTS_ON_TARGET_OVER);

        PossibleBetContainer over28AndHalf = block.findByType(OVER_28_5);
        assertEquals(12, over28AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(6, over28AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over28AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(50, over28AndHalf.getPercentage().intValue());

        PossibleBetContainer over30AndHalf = block.findByType(OVER_30_5);
        assertEquals(12, over30AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(5, over30AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over30AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(41, over30AndHalf.getPercentage().intValue());
    }

    @Test
    public void testOpposingTeamShotsOnTargetOver() {
        PossibleBetContainer PossibleBetContainer = getPossibleBetsBlock();

        PossibleBetContainer block = PossibleBetContainer.findByType(OPPOSING_TEAM_SHOTS_ON_TARGET_OVER);

        PossibleBetContainer over28AndHalf = block.findByType(OVER_28_5);
        assertEquals(12, over28AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(5, over28AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over28AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(41, over28AndHalf.getPercentage().intValue());

        PossibleBetContainer over30AndHalf = block.findByType(OVER_30_5);
        assertEquals(12, over30AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(4, over30AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over30AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(33, over30AndHalf.getPercentage().intValue());
    }*/


    private PossibleBetContainer getPossibleBetsBlock() {

        HockeyTeam homeTeam = hockeyTeamRepository.findOne(COLORADO_TEAM_ID);
        MatchData homeMatchData = new MatchData(homeTeam);
        List<HockeyMatch> homeTeamMatches = hockeyMatchRepository.findAll(
                hasTeam(COLORADO_TEAM_ID)
        );


        HockeyTeam guestTeam = hockeyTeamRepository.findOne(BUFFALO_TEAM_ID);
        MatchData guestMatchData = new MatchData(guestTeam);
        List<HockeyMatch> guestTeamMatches = hockeyMatchRepository.findAll(
                hasTeam(BUFFALO_TEAM_ID)
        );

        PossibleBetsBlock possibleBetsBlock = new PossibleBetsBlock(homeMatchData, guestMatchData);
        possibleBetsBlock.check(homeTeamMatches, guestTeamMatches);


        return possibleBetsBlock;
    }

}
