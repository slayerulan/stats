package com.savik;

import com.savik.blocks.hockey.match.general.HockeyPossibleBetsBlock;
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
        "classpath:db/possible_bets/hockey/matches_AqombNzc.sql", "classpath:db/possible_bets/hockey/matches_CIGVL5B6.sql",
        "classpath:db/possible_bets/hockey/matches_j5qIp46c.sql", "classpath:db/possible_bets/hockey/matches_rwPEPmCs.sql",
        "classpath:db/possible_bets/hockey/matches_xn1B4zMd.sql",


        // real matches but Colorado replaced by Buffalo
        "classpath:db/possible_bets/hockey/matches_Ai5wex7j.sql", "classpath:db/possible_bets/hockey/matches_QTEL7Fjd.sql",
        "classpath:db/possible_bets/hockey/matches_vJ50rp5f.sql", "classpath:db/possible_bets/hockey/matches_YVeCUxb9.sql",
        "classpath:db/possible_bets/hockey/matches_I39zqxpU.sql"
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
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer totalOverBlock = possibleBetsBlock.findByType(TOTAL).findByType(TOTAL_OVER);

        PossibleBetContainer over4AndHalf = totalOverBlock.findByType(OVER_4_5);
        assertEquals(40, over4AndHalf.getFirstTeamPercentage());
        assertEquals(100, over4AndHalf.getSecondTeamPercentage());


        PossibleBetContainer over5AndHalf = totalOverBlock.findByType(OVER_5_5);
        assertEquals(20, over5AndHalf.getFirstTeamPercentage());
        assertEquals(100, over5AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testTotalUnder() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer totalUnderBlock = possibleBetsBlock.findByType(TOTAL).findByType(TOTAL_UNDER);

        PossibleBetContainer under4AndHalf = totalUnderBlock.findByType(UNDER_4_5);
        assertEquals(60, under4AndHalf.getFirstTeamPercentage());
        assertEquals(0, under4AndHalf.getSecondTeamPercentage());

        PossibleBetContainer under5AndHalf = totalUnderBlock.findByType(UNDER_5_5);
        assertEquals(80, under5AndHalf.getFirstTeamPercentage());
        assertEquals(0, under5AndHalf.getSecondTeamPercentage());


        PossibleBetContainer under6AndHalf = totalUnderBlock.findByType(UNDER_6_5);
        assertEquals(80, under6AndHalf.getFirstTeamPercentage());
        assertEquals(20, under6AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testBothTeamsTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer totalOverBlock = possibleBetsBlock.findByType(TOTAL).findByType(BOTH_TEAMS_TOTAL_OVER);

        PossibleBetContainer over1AndHalf = totalOverBlock.findByType(OVER_1_5);
        assertEquals(80, over1AndHalf.getFirstTeamPercentage());
        assertEquals(100, over1AndHalf.getSecondTeamPercentage());


        PossibleBetContainer over2AndHalf = totalOverBlock.findByType(OVER_2_5);
        assertEquals(20, over2AndHalf.getFirstTeamPercentage());
        assertEquals(60, over2AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testBothTeamsTotalUnder() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer totalUnderBlock = possibleBetsBlock.findByType(TOTAL).findByType(BOTH_TEAMS_TOTAL_UNDER);

        PossibleBetContainer under2AndHalf = totalUnderBlock.findByType(UNDER_2_5);
        assertEquals(40, under2AndHalf.getFirstTeamPercentage());
        assertEquals(0, under2AndHalf.getSecondTeamPercentage());


        PossibleBetContainer under3AndHalf = totalUnderBlock.findByType(UNDER_3_5);
        assertEquals(80, under3AndHalf.getFirstTeamPercentage());
        assertEquals(20, under3AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testTeamTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer totalOverBlock = possibleBetsBlock.findByType(TOTAL).findByType(TEAM_TOTAL_OVER);

        PossibleBetContainer over1AndHalf = totalOverBlock.findByType(OVER_1_5);
        assertEquals(100, over1AndHalf.getFirstTeamPercentage());
        assertEquals(100, over1AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over2AndHalf = totalOverBlock.findByType(OVER_2_5);
        assertEquals(40, over2AndHalf.getFirstTeamPercentage());
        assertEquals(80, over2AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over3AndHalf = totalOverBlock.findByType(OVER_3_5);
        assertEquals(20, over3AndHalf.getFirstTeamPercentage());
        assertEquals(40, over3AndHalf.getSecondTeamPercentage());


    }

    @Test
    public void testTeamTotalUnder() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer totalUnderBlock = possibleBetsBlock.findByType(TOTAL).findByType(TEAM_TOTAL_UNDER);

        PossibleBetContainer under1AndHalf = totalUnderBlock.findByType(UNDER_1_5);
        assertEquals(0, under1AndHalf.getFirstTeamPercentage());
        assertEquals(0, under1AndHalf.getSecondTeamPercentage());

        PossibleBetContainer under2AndHalf = totalUnderBlock.findByType(UNDER_2_5);
        assertEquals(60, under2AndHalf.getFirstTeamPercentage());
        assertEquals(20, under2AndHalf.getSecondTeamPercentage());


        PossibleBetContainer under3AndHalf = totalUnderBlock.findByType(UNDER_3_5);
        assertEquals(80, under3AndHalf.getFirstTeamPercentage());
        assertEquals(60, under3AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testOpposingTeamTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer totalOverBlock = possibleBetsBlock.findByType(TOTAL).findByType(OPPOSING_TEAM_TOTAL_OVER);

        PossibleBetContainer over1AndHalf = totalOverBlock.findByType(OVER_1_5);
        assertEquals(80, over1AndHalf.getFirstTeamPercentage());
        assertEquals(100, over1AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over2AndHalf = totalOverBlock.findByType(OVER_2_5);
        assertEquals(40, over2AndHalf.getFirstTeamPercentage());
        assertEquals(80, over2AndHalf.getSecondTeamPercentage());


        PossibleBetContainer over3AndHalf = totalOverBlock.findByType(OVER_3_5);
        assertEquals(20, over3AndHalf.getFirstTeamPercentage());
        assertEquals(60, over3AndHalf.getSecondTeamPercentage());


    }

    @Test
    public void testOpposingTeamTotalUnder() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer totalUnderBlock = possibleBetsBlock.findByType(TOTAL).findByType(OPPOSING_TEAM_TOTAL_UNDER);

        PossibleBetContainer under1AndHalf = totalUnderBlock.findByType(UNDER_1_5);
        assertEquals(20, under1AndHalf.getFirstTeamPercentage());
        assertEquals(0, under1AndHalf.getSecondTeamPercentage());

        PossibleBetContainer under2AndHalf = totalUnderBlock.findByType(UNDER_2_5);
        assertEquals(60, under2AndHalf.getFirstTeamPercentage());
        assertEquals(20, under2AndHalf.getSecondTeamPercentage());


        PossibleBetContainer under3AndHalf = totalUnderBlock.findByType(UNDER_3_5);
        assertEquals(80, under3AndHalf.getFirstTeamPercentage());
        assertEquals(40, under3AndHalf.getSecondTeamPercentage());

    }


    @Test
    public void testTotalOverInAllPeriods() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer totalOverBlock = possibleBetsBlock.findByType(TOTAL_OVER_ALL_PERIODS);

        PossibleBetContainer over0AndHalf = totalOverBlock.findByType(OVER_0_5);
        assertEquals(40, over0AndHalf.getFirstTeamPercentage());
        assertEquals(100, over0AndHalf.getSecondTeamPercentage());


    }

    @Test
    public void testTotalUnderInAllPeriods() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer totalUnderBlock = possibleBetsBlock.findByType(TOTAL_UNDER_ALL_PERIODS);

        PossibleBetContainer under2AndHalf = totalUnderBlock.findByType(UNDER_2_5);
        assertEquals(40, under2AndHalf.getFirstTeamPercentage());
        assertEquals(0, under2AndHalf.getSecondTeamPercentage());

        PossibleBetContainer under3AndHalf = totalUnderBlock.findByType(UNDER_3_5);
        assertEquals(80, under3AndHalf.getFirstTeamPercentage());
        assertEquals(20, under3AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testAnyWinAndTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(ANY_WIN_AND_TOTAL_OVER);

        PossibleBetContainer over5AndHalf = block.findByType(OVER_5_5);
        assertEquals(0, over5AndHalf.getFirstTeamPercentage());
        assertEquals(80, over5AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testAnyWinAndTotalUnder() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(ANY_WIN_AND_TOTAL_UNDER);

        PossibleBetContainer under5AndHalf = block.findByType(UNDER_5_5);
        assertEquals(40, under5AndHalf.getFirstTeamPercentage());
        assertEquals(0, under5AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testAnyWinAndDiff() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(ANY_WIN_AND_DIFFERENCE_EQUALS);

        PossibleBetContainer diff1 = block.findByType(DIFF_1);
        assertEquals(20, diff1.getFirstTeamPercentage());
        assertEquals(0, diff1.getSecondTeamPercentage());

        PossibleBetContainer diff2 = block.findByType(DIFF_2);
        assertEquals(0, diff2.getFirstTeamPercentage());
        assertEquals(20, diff2.getSecondTeamPercentage());

        PossibleBetContainer diff3OrMore = block.findByType(DIFF_3_OR_MORE);
        assertEquals(20, diff3OrMore.getFirstTeamPercentage());
        assertEquals(60, diff3OrMore.getSecondTeamPercentage());

    }


    @Test
    public void testFirstGoalBefore() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(FIRST_GOAL_BEFORE);

        PossibleBetContainer under9 = block.findByType(UNDER_9);
        assertEquals(40, under9.getFirstTeamPercentage());
        assertEquals(60, under9.getSecondTeamPercentage());

        PossibleBetContainer under10 = block.findByType(UNDER_10);
        assertEquals(40, under10.getFirstTeamPercentage());
        assertEquals(60, under10.getSecondTeamPercentage());

        PossibleBetContainer under11 = block.findByType(UNDER_11);
        assertEquals(40, under11.getFirstTeamPercentage());
        assertEquals(60, under11.getSecondTeamPercentage());

        PossibleBetContainer under12 = block.findByType(UNDER_12);
        assertEquals(40, under12.getFirstTeamPercentage());
        assertEquals(60, under12.getSecondTeamPercentage());

    }


    @Test
    public void testLastGoalAfter() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(LAST_GOAL_AFTER);

        PossibleBetContainer after54 = block.findByType(OVER_54);
        assertEquals(20, after54.getFirstTeamPercentage());
        assertEquals(100, after54.getSecondTeamPercentage());

        PossibleBetContainer after55 = block.findByType(OVER_55);
        assertEquals(20, after55.getFirstTeamPercentage());
        assertEquals(80, after55.getSecondTeamPercentage());

    }


    @Test
    public void testTeamWinAndTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(TEAM_WIN_AND_TOTAL_OVER);

        PossibleBetContainer over4AndHalf = block.findByType(OVER_4_5);
        assertEquals(0, over4AndHalf.getFirstTeamPercentage());
        assertEquals(40, over4AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over5AndHalf = block.findByType(OVER_5_5);
        assertEquals(0, over5AndHalf.getFirstTeamPercentage());
        assertEquals(40, over5AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testTeamWinAndTotalUnder() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(TEAM_WIN_AND_TOTAL_UNDER);

        PossibleBetContainer under4AndHalf = block.findByType(UNDER_4_5);
        assertEquals(20, under4AndHalf.getFirstTeamPercentage());
        assertEquals(0, under4AndHalf.getSecondTeamPercentage());

        PossibleBetContainer under5AndHalf = block.findByType(UNDER_5_5);
        assertEquals(20, under5AndHalf.getFirstTeamPercentage());
        assertEquals(0, under5AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testTeamNotLooseAndTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(TEAM_NOT_LOOSE_AND_TOTAL_OVER);

        PossibleBetContainer over4AndHalf = block.findByType(OVER_4_5);
        assertEquals(20, over4AndHalf.getFirstTeamPercentage());
        assertEquals(60, over4AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over5AndHalf = block.findByType(OVER_5_5);
        assertEquals(20, over5AndHalf.getFirstTeamPercentage());
        assertEquals(60, over5AndHalf.getSecondTeamPercentage());

    }


    @Test
    public void testTeamNotLooseAndTotalUnder() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();


        PossibleBetContainer block = possibleBetsBlock.findByType(TEAM_NOT_LOOSE_AND_TOTAL_UNDER);

        PossibleBetContainer under4AndHalf = block.findByType(UNDER_4_5);
        assertEquals(60, under4AndHalf.getFirstTeamPercentage());
        assertEquals(0, under4AndHalf.getSecondTeamPercentage());

        PossibleBetContainer under5AndHalf = block.findByType(UNDER_5_5);
        assertEquals(60, under5AndHalf.getFirstTeamPercentage());
        assertEquals(0, under5AndHalf.getSecondTeamPercentage());

    }


    @Test
    public void testOpposingTeamWinAndTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(OPPOSING_TEAM_WIN_AND_TOTAL_OVER);

        PossibleBetContainer over4AndHalf = block.findByType(OVER_4_5);
        assertEquals(20, over4AndHalf.getFirstTeamPercentage());
        assertEquals(40, over4AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over5AndHalf = block.findByType(OVER_5_5);
        assertEquals(0, over5AndHalf.getFirstTeamPercentage());
        assertEquals(40, over5AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testOpposingTeamWinAndTotalUnder() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(OPPOSING_TEAM_WIN_AND_TOTAL_UNDER);

        PossibleBetContainer under4AndHalf = block.findByType(UNDER_4_5);
        assertEquals(0, under4AndHalf.getFirstTeamPercentage());
        assertEquals(0, under4AndHalf.getSecondTeamPercentage());

        PossibleBetContainer under5AndHalf = block.findByType(UNDER_5_5);
        assertEquals(20, under5AndHalf.getFirstTeamPercentage());
        assertEquals(0, under5AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testOpposingTeamNotLooseAndTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_OVER);

        PossibleBetContainer over4AndHalf = block.findByType(OVER_4_5);
        assertEquals(40, over4AndHalf.getFirstTeamPercentage());
        assertEquals(60, over4AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over5AndHalf = block.findByType(OVER_5_5);
        assertEquals(20, over5AndHalf.getFirstTeamPercentage());
        assertEquals(60, over5AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testOpposingTeamNotLooseAndTotalUnder() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_UNDER);

        PossibleBetContainer under4AndHalf = block.findByType(UNDER_4_5);
        assertEquals(40, under4AndHalf.getFirstTeamPercentage());
        assertEquals(0, under4AndHalf.getSecondTeamPercentage());

        PossibleBetContainer under5AndHalf = block.findByType(UNDER_5_5);
        assertEquals(60, under5AndHalf.getFirstTeamPercentage());
        assertEquals(0, under5AndHalf.getSecondTeamPercentage());

    }


    @Test
    public void testTeamTotalOverAllPeriods() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(TEAM_TOTAL_OVER_ALL_PERIODS);

        PossibleBetContainer over0AndHalf = block.findByType(OVER_0_5);
        assertEquals(20, over0AndHalf.getFirstTeamPercentage());
        assertEquals(60, over0AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testOpposingTeamTotalOverAllPeriods() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(OPPOSING_TEAM_TOTAL_OVER_ALL_PERIODS);

        PossibleBetContainer over0AndHalf = block.findByType(OVER_0_5);
        assertEquals(0, over0AndHalf.getFirstTeamPercentage());
        assertEquals(40, over0AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testTeamWinAtLeastNPeriods() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(TEAM_WIN_AT_LEAST_N_PERIODS);

        PossibleBetContainer atLeast1 = block.findByType(NUMBER_1);
        assertEquals(80, atLeast1.getFirstTeamPercentage());
        assertEquals(60, atLeast1.getSecondTeamPercentage());

        PossibleBetContainer atLeast2 = block.findByType(NUMBER_2);
        assertEquals(20, atLeast2.getFirstTeamPercentage());
        assertEquals(40, atLeast2.getSecondTeamPercentage());

    }

    @Test
    public void testOpposingTeamWinAtLeastNPeriods() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(OPPOSING_TEAM_WIN_AT_LEAST_N_PERIODS);

        PossibleBetContainer atLeast1 = block.findByType(NUMBER_1);
        assertEquals(60, atLeast1.getFirstTeamPercentage());
        assertEquals(80, atLeast1.getSecondTeamPercentage());

        PossibleBetContainer atLeast2 = block.findByType(NUMBER_2);
        assertEquals(20, atLeast2.getFirstTeamPercentage());
        assertEquals(20, atLeast2.getSecondTeamPercentage());

    }


    @Test
    public void testDrawAtLeastNPeriods() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(DRAW_AT_LEAST_N_PERIODS);

        PossibleBetContainer atLeast1 = block.findByType(NUMBER_1);
        assertEquals(80, atLeast1.getFirstTeamPercentage());
        assertEquals(80, atLeast1.getSecondTeamPercentage());

        PossibleBetContainer atLeast2 = block.findByType(NUMBER_2);
        assertEquals(20, atLeast2.getFirstTeamPercentage());
        assertEquals(20, atLeast2.getSecondTeamPercentage());

    }

    @Test
    public void testMostEffectivePeriodTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(MOST_EFFECTIVE_PERIOD_TOTAL_OVER);

        PossibleBetContainer over2AndHalf = block.findByType(OVER_2_5);
        assertEquals(60, over2AndHalf.getFirstTeamPercentage());
        assertEquals(100, over2AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over3AndHalf = block.findByType(OVER_3_5);
        assertEquals(20, over3AndHalf.getFirstTeamPercentage());
        assertEquals(80, over3AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testTeamFirstScoredAndWin() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(TEAM_FIRST_SCORED_AND_WIN);
        assertEquals(20, block.getFirstTeamPercentage());
        assertEquals(40, block.getSecondTeamPercentage());
    }

    @Test
    public void testOpposingTeamFirstScoredAndWin() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(OPPOSING_TEAM_FIRST_SCORED_AND_WIN);
        assertEquals(20, block.getFirstTeamPercentage());
        assertEquals(40, block.getSecondTeamPercentage());
    }

    @Test
    public void testAnyComebackMatch() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(ANY_COMEBACK);
        assertEquals(0, block.getFirstTeamPercentage());
        assertEquals(0, block.getSecondTeamPercentage());
    }

    @Test
    public void testTeamScoredNInRow() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(TEAM_SCORED_N_IN_ROW);

        PossibleBetContainer number2 = block.findByType(NUMBER_2);
        assertEquals(60, number2.getFirstTeamPercentage());
        assertEquals(80, number2.getSecondTeamPercentage());

        PossibleBetContainer number3 = block.findByType(NUMBER_3);
        assertEquals(20, number3.getFirstTeamPercentage());
        assertEquals(40, number3.getSecondTeamPercentage());

    }

    @Test
    public void testOpposingTeamScoredNInRow() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(OPPOSING_TEAM_SCORED_N_IN_ROW);

        PossibleBetContainer number2 = block.findByType(NUMBER_2);
        assertEquals(40, number2.getFirstTeamPercentage());
        assertEquals(100, number2.getSecondTeamPercentage());

        PossibleBetContainer number3 = block.findByType(NUMBER_3);
        assertEquals(0, number3.getFirstTeamPercentage());
        assertEquals(40, number3.getSecondTeamPercentage());

    }

    @Test
    public void testPeriodXMoreEffectiveThanY() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(PERIOD_X_MORE_EFFECTIVE_THAN_Y);

        PossibleBetContainer p2MoreP1 = block.findByType(P2_MORE_P1);
        assertEquals(60, p2MoreP1.getFirstTeamPercentage());
        assertEquals(60, p2MoreP1.getSecondTeamPercentage());

        PossibleBetContainer p3MoreP2 = block.findByType(P3_MORE_P2);
        assertEquals(20, p3MoreP2.getFirstTeamPercentage());
        assertEquals(60, p3MoreP2.getSecondTeamPercentage());

        PossibleBetContainer p3MoreP1 = block.findByType(P3_MORE_P1);
        assertEquals(40, p3MoreP1.getFirstTeamPercentage());
        assertEquals(80, p3MoreP1.getSecondTeamPercentage());

    }


    /*
    * Handicap
    * */


    @Test
    public void testTeamHandicap() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(TEAM_HANDICAP);

        PossibleBetContainer minus2AndHalf = block.findByType(MINUS_2_5);
        assertEquals(20, minus2AndHalf.getFirstTeamPercentage());
        assertEquals(20, minus2AndHalf.getSecondTeamPercentage());

        PossibleBetContainer minus1AndHalf = block.findByType(MINUS_1_5);
        assertEquals(20, minus1AndHalf.getFirstTeamPercentage());
        assertEquals(40, minus1AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus1AndHalf = block.findByType(PLUS_1_5);
        assertEquals(100, plus1AndHalf.getFirstTeamPercentage());
        assertEquals(60, plus1AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus2AndHalf = block.findByType(PLUS_2_5);
        assertEquals(100, plus2AndHalf.getFirstTeamPercentage());
        assertEquals(60, plus2AndHalf.getSecondTeamPercentage());
    }


    @Test
    public void testOpposingTeamHandicap() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(OPPOSING_TEAM_HANDICAP);

        PossibleBetContainer minus2AndHalf = block.findByType(MINUS_2_5);
        assertEquals(0, minus2AndHalf.getFirstTeamPercentage());
        assertEquals(40, minus2AndHalf.getSecondTeamPercentage());

        PossibleBetContainer minus1AndHalf = block.findByType(MINUS_1_5);
        assertEquals(0, minus1AndHalf.getFirstTeamPercentage());
        assertEquals(40, minus1AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus1AndHalf = block.findByType(PLUS_1_5);
        assertEquals(80, plus1AndHalf.getFirstTeamPercentage());
        assertEquals(60, plus1AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus2AndHalf = block.findByType(PLUS_2_5);
        assertEquals(80, plus2AndHalf.getFirstTeamPercentage());
        assertEquals(80, plus2AndHalf.getSecondTeamPercentage());
    }


    /*
    * Periods
    * */

    @Test
    public void testFirstPeriodAnyWinner() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(FIRST_PERIOD).findByType(ANY_WIN);
        assertEquals(60, block.getFirstTeamPercentage());
        assertEquals(80, block.getSecondTeamPercentage());
    }

    @Test
    public void testFirstPeriodDraw() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(FIRST_PERIOD).findByType(DRAW);
        assertEquals(40, block.getFirstTeamPercentage());
        assertEquals(20, block.getSecondTeamPercentage());
    }

    @Test
    public void testFirstPeriodTeamNotLoose() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(FIRST_PERIOD).findByType(TEAM_NOT_LOOSE);
        assertEquals(80, block.getFirstTeamPercentage());
        assertEquals(60, block.getSecondTeamPercentage());
    }

    @Test
    public void testFirstPeriodOpposingTeamNotLoose() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(FIRST_PERIOD).findByType(OPPOSING_TEAM_NOT_LOOSE);
        assertEquals(60, block.getFirstTeamPercentage());
        assertEquals(60, block.getSecondTeamPercentage());
    }

    @Test
    public void testFirstPeriodGoalBetween() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(FIRST_PERIOD).findByType(GOAL_BETWEEN);

        PossibleBetContainer between1_7 = block.findByType(BETWEEN_1_7);
        assertEquals(20, between1_7.getFirstTeamPercentage());
        assertEquals(60, between1_7.getSecondTeamPercentage());

        PossibleBetContainer between8_15 = block.findByType(BETWEEN_8_15);
        assertEquals(40, between8_15.getFirstTeamPercentage());
        assertEquals(40, between8_15.getSecondTeamPercentage());

        PossibleBetContainer between16_20 = block.findByType(BETWEEN_16_20);
        assertEquals(60, between16_20.getFirstTeamPercentage());
        assertEquals(80, between16_20.getSecondTeamPercentage());
    }

    @Test
    public void testFirstPeriodTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer firstPeriodTotalOver = possibleBetsBlock.findByType(FIRST_PERIOD).findByType(TOTAL_OVER);

        PossibleBetContainer over0AndHalf = firstPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(80, over0AndHalf.getFirstTeamPercentage());
        assertEquals(100, over0AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over1AndHalf = firstPeriodTotalOver.findByType(OVER_1_5);
        assertEquals(40, over1AndHalf.getFirstTeamPercentage());
        assertEquals(80, over1AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testFirstPeriodTotalUnder() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer firstPeriodTotalOver = possibleBetsBlock.findByType(FIRST_PERIOD).findByType(TOTAL_UNDER);

        PossibleBetContainer under1AndHalf = firstPeriodTotalOver.findByType(UNDER_1_5);
        assertEquals(60, under1AndHalf.getFirstTeamPercentage());
        assertEquals(20, under1AndHalf.getSecondTeamPercentage());

        PossibleBetContainer under2AndHalf = firstPeriodTotalOver.findByType(UNDER_2_5);
        assertEquals(80, under2AndHalf.getFirstTeamPercentage());
        assertEquals(80, under2AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testFirstPeriodTeamTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer firstPeriodTotalOver = possibleBetsBlock.findByType(FIRST_PERIOD).findByType(TEAM_TOTAL_OVER);

        PossibleBetContainer over0AndHalf = firstPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(60, over0AndHalf.getFirstTeamPercentage());
        assertEquals(60, over0AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over1AndHalf = firstPeriodTotalOver.findByType(OVER_1_5);
        assertEquals(20, over1AndHalf.getFirstTeamPercentage());
        assertEquals(20, over1AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testFirstPeriodOpposingTeamTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer firstPeriodTotalOver = possibleBetsBlock.findByType(FIRST_PERIOD).findByType(OPPOSING_TEAM_TOTAL_OVER);

        PossibleBetContainer over0AndHalf = firstPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(60, over0AndHalf.getFirstTeamPercentage());
        assertEquals(60, over0AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over1AndHalf = firstPeriodTotalOver.findByType(OVER_1_5);
        assertEquals(0, over1AndHalf.getFirstTeamPercentage());
        assertEquals(40, over1AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testFirstPeriodBothTeamsTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer firstPeriodTotalOver = possibleBetsBlock.findByType(FIRST_PERIOD).findByType(BOTH_TEAMS_TOTAL_OVER);

        PossibleBetContainer over0AndHalf = firstPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(40, over0AndHalf.getFirstTeamPercentage());
        assertEquals(20, over0AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testSecondPeriodAnyWinner() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(SECOND_PERIOD).findByType(ANY_WIN);
        assertEquals(60, block.getFirstTeamPercentage());
        assertEquals(60, block.getSecondTeamPercentage());
    }

    @Test
    public void testSecondPeriodDraw() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(SECOND_PERIOD).findByType(DRAW);
        assertEquals(40, block.getFirstTeamPercentage());
        assertEquals(40, block.getSecondTeamPercentage());
    }

    @Test
    public void testSecondPeriodTeamNotLoose() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(SECOND_PERIOD).findByType(TEAM_NOT_LOOSE);
        assertEquals(60, block.getFirstTeamPercentage());
        assertEquals(100, block.getSecondTeamPercentage());
    }

    @Test
    public void testSecondPeriodOpposingTeamNotLoose() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(SECOND_PERIOD).findByType(OPPOSING_TEAM_NOT_LOOSE);
        assertEquals(80, block.getFirstTeamPercentage());
        assertEquals(40, block.getSecondTeamPercentage());
    }

    @Test
    public void testSecondPeriodGoalBetween() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(SECOND_PERIOD).findByType(GOAL_BETWEEN);

        PossibleBetContainer between1_7 = block.findByType(BETWEEN_1_7);
        assertEquals(60, between1_7.getFirstTeamPercentage());
        assertEquals(40, between1_7.getSecondTeamPercentage());

        PossibleBetContainer between8_15 = block.findByType(BETWEEN_8_15);
        assertEquals(20, between8_15.getFirstTeamPercentage());
        assertEquals(80, between8_15.getSecondTeamPercentage());

        PossibleBetContainer between16_20 = block.findByType(BETWEEN_16_20);
        assertEquals(60, between16_20.getFirstTeamPercentage());
        assertEquals(40, between16_20.getSecondTeamPercentage());
    }

    @Test
    public void testSecondPeriodTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer firstPeriodTotalOver = possibleBetsBlock.findByType(SECOND_PERIOD).findByType(TOTAL_OVER);

        PossibleBetContainer over0AndHalf = firstPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(80, over0AndHalf.getFirstTeamPercentage());
        assertEquals(100, over0AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over1AndHalf = firstPeriodTotalOver.findByType(OVER_1_5);
        assertEquals(60, over1AndHalf.getFirstTeamPercentage());
        assertEquals(80, over1AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testSecondPeriodTotalUnder() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer firstPeriodTotalOver = possibleBetsBlock.findByType(SECOND_PERIOD).findByType(TOTAL_UNDER);

        PossibleBetContainer under1AndHalf = firstPeriodTotalOver.findByType(UNDER_1_5);
        assertEquals(40, under1AndHalf.getFirstTeamPercentage());
        assertEquals(20, under1AndHalf.getSecondTeamPercentage());

        PossibleBetContainer under2AndHalf = firstPeriodTotalOver.findByType(UNDER_2_5);
        assertEquals(60, under2AndHalf.getFirstTeamPercentage());
        assertEquals(60, under2AndHalf.getSecondTeamPercentage());

    }


    @Test
    public void testSecondPeriodTeamTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer firstPeriodTotalOver = possibleBetsBlock.findByType(SECOND_PERIOD).findByType(TEAM_TOTAL_OVER);

        PossibleBetContainer over0AndHalf = firstPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(60, over0AndHalf.getFirstTeamPercentage());
        assertEquals(100, over0AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over1AndHalf = firstPeriodTotalOver.findByType(OVER_1_5);
        assertEquals(40, over1AndHalf.getFirstTeamPercentage());
        assertEquals(60, over1AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testSecondPeriodOpposingTeamTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer firstPeriodTotalOver = possibleBetsBlock.findByType(SECOND_PERIOD).findByType(OPPOSING_TEAM_TOTAL_OVER);

        PossibleBetContainer over0AndHalf = firstPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(60, over0AndHalf.getFirstTeamPercentage());
        assertEquals(60, over0AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over1AndHalf = firstPeriodTotalOver.findByType(OVER_1_5);
        assertEquals(40, over1AndHalf.getFirstTeamPercentage());
        assertEquals(40, over1AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testSecondPeriodBothTeamsTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer firstPeriodTotalOver = possibleBetsBlock.findByType(SECOND_PERIOD).findByType(BOTH_TEAMS_TOTAL_OVER);

        PossibleBetContainer over0AndHalf = firstPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(40, over0AndHalf.getFirstTeamPercentage());
        assertEquals(60, over0AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testThirdPeriodAnyWinner() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(THIRD_PERIOD).findByType(ANY_WIN);
        assertEquals(60, block.getFirstTeamPercentage());
        assertEquals(60, block.getSecondTeamPercentage());
    }

    @Test
    public void testThirdPeriodDraw() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(THIRD_PERIOD).findByType(DRAW);
        assertEquals(40, block.getFirstTeamPercentage());
        assertEquals(40, block.getSecondTeamPercentage());
    }

    @Test
    public void testThirdPeriodTeamNotLoose() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(THIRD_PERIOD).findByType(TEAM_NOT_LOOSE);
        assertEquals(80, block.getFirstTeamPercentage());
        assertEquals(40, block.getSecondTeamPercentage());
    }

    @Test
    public void testThirdPeriodOpposingTeamNotLoose() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(THIRD_PERIOD).findByType(OPPOSING_TEAM_NOT_LOOSE);
        assertEquals(60, block.getFirstTeamPercentage());
        assertEquals(100, block.getSecondTeamPercentage());
    }

    @Test
    public void testThirdPeriodGoalBetween() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(THIRD_PERIOD).findByType(GOAL_BETWEEN);

        PossibleBetContainer between1_7 = block.findByType(BETWEEN_1_7);
        assertEquals(60, between1_7.getFirstTeamPercentage());
        assertEquals(40, between1_7.getSecondTeamPercentage());

        PossibleBetContainer between8_15 = block.findByType(BETWEEN_8_15);
        assertEquals(20, between8_15.getFirstTeamPercentage());
        assertEquals(80, between8_15.getSecondTeamPercentage());

        PossibleBetContainer between16_20 = block.findByType(BETWEEN_16_20);
        assertEquals(20, between16_20.getFirstTeamPercentage());
        assertEquals(100, between16_20.getSecondTeamPercentage());
    }

    @Test
    public void testThirdPeriodTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer firstPeriodTotalOver = possibleBetsBlock.findByType(THIRD_PERIOD).findByType(TOTAL_OVER);

        PossibleBetContainer over0AndHalf = firstPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(80, over0AndHalf.getFirstTeamPercentage());
        assertEquals(100, over0AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over1AndHalf = firstPeriodTotalOver.findByType(OVER_1_5);
        assertEquals(40, over1AndHalf.getFirstTeamPercentage());
        assertEquals(100, over1AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testThirdPeriodTotalUnder() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer firstPeriodTotalOver = possibleBetsBlock.findByType(THIRD_PERIOD).findByType(TOTAL_UNDER);

        PossibleBetContainer under1AndHalf = firstPeriodTotalOver.findByType(UNDER_1_5);
        assertEquals(60, under1AndHalf.getFirstTeamPercentage());
        assertEquals(0, under1AndHalf.getSecondTeamPercentage());

        PossibleBetContainer under2AndHalf = firstPeriodTotalOver.findByType(UNDER_2_5);
        assertEquals(80, under2AndHalf.getFirstTeamPercentage());
        assertEquals(20, under2AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testThirdPeriodTeamTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer firstPeriodTotalOver = possibleBetsBlock.findByType(THIRD_PERIOD).findByType(TEAM_TOTAL_OVER);

        PossibleBetContainer over0AndHalf = firstPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(80, over0AndHalf.getFirstTeamPercentage());
        assertEquals(100, over0AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over1AndHalf = firstPeriodTotalOver.findByType(OVER_1_5);
        assertEquals(0, over1AndHalf.getFirstTeamPercentage());
        assertEquals(20, over1AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testThirdPeriodOpposingTeamTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer firstPeriodTotalOver = possibleBetsBlock.findByType(THIRD_PERIOD).findByType(OPPOSING_TEAM_TOTAL_OVER);

        PossibleBetContainer over0AndHalf = firstPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(40, over0AndHalf.getFirstTeamPercentage());
        assertEquals(100, over0AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over1AndHalf = firstPeriodTotalOver.findByType(OVER_1_5);
        assertEquals(20, over1AndHalf.getFirstTeamPercentage());
        assertEquals(80, over1AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testThirdPeriodBothTeamsTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer firstPeriodTotalOver = possibleBetsBlock.findByType(THIRD_PERIOD).findByType(BOTH_TEAMS_TOTAL_OVER);

        PossibleBetContainer over0AndHalf = firstPeriodTotalOver.findByType(OVER_0_5);
        assertEquals(40, over0AndHalf.getFirstTeamPercentage());
        assertEquals(100, over0AndHalf.getSecondTeamPercentage());
    }

    /*
    * STATS
    * */

    @Test
    public void testShotsOnTargetTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(SHOTS_ON_TARGET_OVER);

        PossibleBetContainer over59AndHalf = block.findByType(OVER_59_5);
        assertEquals(40, over59AndHalf.getFirstTeamPercentage());
        assertEquals(60, over59AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over60AndHalf = block.findByType(OVER_60_5);
        assertEquals(20, over60AndHalf.getFirstTeamPercentage());
        assertEquals(60, over60AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over61AndHalf = block.findByType(OVER_61_5);
        assertEquals(20, over61AndHalf.getFirstTeamPercentage());
        assertEquals(40, over61AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over62AndHalf = block.findByType(OVER_62_5);
        assertEquals(20, over62AndHalf.getFirstTeamPercentage());
        assertEquals(40, over62AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over63AndHalf = block.findByType(OVER_63_5);
        assertEquals(20, over63AndHalf.getFirstTeamPercentage());
        assertEquals(20, over63AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testTeamShotsOnTargetTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(TEAM_SHOTS_ON_TARGET_OVER);

        PossibleBetContainer over28AndHalf = block.findByType(OVER_28_5);
        assertEquals(40, over28AndHalf.getFirstTeamPercentage());
        assertEquals(40, over28AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over30AndHalf = block.findByType(OVER_30_5);
        assertEquals(20, over30AndHalf.getFirstTeamPercentage());
        assertEquals(20, over30AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over32AndHalf = block.findByType(OVER_32_5);
        assertEquals(0, over32AndHalf.getFirstTeamPercentage());
        assertEquals(20, over32AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testOpposingTeamShotsOnTargetTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(OPPOSING_TEAM_SHOTS_ON_TARGET_OVER);

        PossibleBetContainer over28AndHalf = block.findByType(OVER_28_5);
        assertEquals(40, over28AndHalf.getFirstTeamPercentage());
        assertEquals(60, over28AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over30AndHalf = block.findByType(OVER_30_5);
        assertEquals(40, over30AndHalf.getFirstTeamPercentage());
        assertEquals(60, over30AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over32AndHalf = block.findByType(OVER_32_5);
        assertEquals(40, over32AndHalf.getFirstTeamPercentage());
        assertEquals(40, over32AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testTeamShotsOnTargetHandicap() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(TEAM_SHOTS_ON_TARGET_HANDICAP);

        PossibleBetContainer minus3AndHalf = block.findByType(MINUS_3_5);
        assertEquals(20, minus3AndHalf.getFirstTeamPercentage());
        assertEquals(20, minus3AndHalf.getSecondTeamPercentage());

        PossibleBetContainer minus2AndHalf = block.findByType(MINUS_2_5);
        assertEquals(40, minus2AndHalf.getFirstTeamPercentage());
        assertEquals(20, minus2AndHalf.getSecondTeamPercentage());

        PossibleBetContainer minus1AndHalf = block.findByType(MINUS_1_5);
        assertEquals(40, minus1AndHalf.getFirstTeamPercentage());
        assertEquals(40, minus1AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus1AndHalf = block.findByType(PLUS_1_5);
        assertEquals(40, plus1AndHalf.getFirstTeamPercentage());
        assertEquals(40, plus1AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus2AndHalf = block.findByType(PLUS_2_5);
        assertEquals(60, plus2AndHalf.getFirstTeamPercentage());
        assertEquals(40, plus2AndHalf.getSecondTeamPercentage());


        PossibleBetContainer plus3AndHalf = block.findByType(PLUS_3_5);
        assertEquals(60, plus3AndHalf.getFirstTeamPercentage());
        assertEquals(40, plus3AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testOpposingTeamShotsOnTargetHandicap() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(OPPOSING_TEAM_SHOTS_ON_TARGET_HANDICAP);

        PossibleBetContainer minus3AndHalf = block.findByType(MINUS_3_5);
        assertEquals(40, minus3AndHalf.getFirstTeamPercentage());
        assertEquals(60, minus3AndHalf.getSecondTeamPercentage());

        PossibleBetContainer minus2AndHalf = block.findByType(MINUS_2_5);
        assertEquals(40, minus2AndHalf.getFirstTeamPercentage());
        assertEquals(60, minus2AndHalf.getSecondTeamPercentage());

        PossibleBetContainer minus1AndHalf = block.findByType(MINUS_1_5);
        assertEquals(60, minus1AndHalf.getFirstTeamPercentage());
        assertEquals(60, minus1AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus1AndHalf = block.findByType(PLUS_1_5);
        assertEquals(60, plus1AndHalf.getFirstTeamPercentage());
        assertEquals(60, plus1AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus2AndHalf = block.findByType(PLUS_2_5);
        assertEquals(60, plus2AndHalf.getFirstTeamPercentage());
        assertEquals(80, plus2AndHalf.getSecondTeamPercentage());


        PossibleBetContainer plus3AndHalf = block.findByType(PLUS_3_5);
        assertEquals(80, plus3AndHalf.getFirstTeamPercentage());
        assertEquals(80, plus3AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testTeamShotsOnTargetWin() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(TEAM_SHOTS_ON_TARGET_WIN);
        assertEquals(40, block.getFirstTeamPercentage());
        assertEquals(40, block.getSecondTeamPercentage());
    }

    @Test
    public void testOpposingTeamShotsOnTargetWin() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(OPPOSING_TEAM_SHOTS_ON_TARGET_WIN);
        assertEquals(60, block.getFirstTeamPercentage());
        assertEquals(60, block.getSecondTeamPercentage());
    }


    @Test
    public void testMatchMinorPenaltiesTimeTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(STATS).findByType(MATCH).findByType(MINOR_PENALTIES_TIME_OVER);

        PossibleBetContainer over12AndHalf = block.findByType(OVER_12_5);
        assertEquals(60, over12AndHalf.getFirstTeamPercentage());
        assertEquals(80, over12AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over14AndHalf = block.findByType(OVER_14_5);
        assertEquals(40, over14AndHalf.getFirstTeamPercentage());
        assertEquals(80, over14AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over15AndHalf = block.findByType(OVER_15_5);
        assertEquals(40, over15AndHalf.getFirstTeamPercentage());
        assertEquals(80, over15AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over16AndHalf = block.findByType(OVER_16_5);
        assertEquals(40, over16AndHalf.getFirstTeamPercentage());
        assertEquals(80, over16AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over18AndHalf = block.findByType(OVER_18_5);
        assertEquals(20, over18AndHalf.getFirstTeamPercentage());
        assertEquals(60, over18AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over20AndHalf = block.findByType(OVER_20_5);
        assertEquals(20, over20AndHalf.getFirstTeamPercentage());
        assertEquals(20, over20AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over22AndHalf = block.findByType(OVER_22_5);
        assertEquals(20, over22AndHalf.getFirstTeamPercentage());
        assertEquals(20, over22AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testMatchTeamMinorPenaltiesTimeTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(STATS).findByType(MATCH).findByType(TEAM_MINOR_PENALTIES_TIME_OVER);

        PossibleBetContainer over6AndHalf = block.findByType(OVER_6_5);
        assertEquals(60, over6AndHalf.getFirstTeamPercentage());
        assertEquals(100, over6AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over8AndHalf = block.findByType(OVER_8_5);
        assertEquals(40, over8AndHalf.getFirstTeamPercentage());
        assertEquals(60, over8AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testMatchOpposingTeamMinorPenaltiesTimeTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(STATS).findByType(MATCH).findByType(OPPOSING_TEAM_MINOR_PENALTIES_TIME_OVER);

        PossibleBetContainer over6AndHalf = block.findByType(OVER_6_5);
        assertEquals(20, over6AndHalf.getFirstTeamPercentage());
        assertEquals(60, over6AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over8AndHalf = block.findByType(OVER_8_5);
        assertEquals(20, over8AndHalf.getFirstTeamPercentage());
        assertEquals(40, over8AndHalf.getSecondTeamPercentage());
    }


    @Test
    public void testMatchTeamMinorPenaltiesTimeNotLoose() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(STATS).findByType(MATCH).findByType(TEAM_MINOR_PENALTIES_TIME_NOT_LOOSE);
        assertEquals(40, block.getFirstTeamPercentage());
        assertEquals(80, block.getSecondTeamPercentage());
    }

    @Test
    public void testMatchOpposingTeamMinorPenaltiesTimeNotLoose() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(STATS).findByType(MATCH).findByType(OPPOSING_TEAM_MINOR_PENALTIES_TIME_NOT_LOOSE);
        assertEquals(60, block.getFirstTeamPercentage());
        assertEquals(20, block.getSecondTeamPercentage());
    }

    @Test
    public void testMatchTeamMinorPenaltiesTimeHandicap() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(STATS).findByType(MATCH).findByType(TEAM_MINOR_PENALTIES_TIME_HANDICAP);

        PossibleBetContainer plus4AndHalf = block.findByType(PLUS_4_5);
        assertEquals(100, plus4AndHalf.getFirstTeamPercentage());
        assertEquals(100, plus4AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus2AndHalf = block.findByType(PLUS_2_5);
        assertEquals(100, plus2AndHalf.getFirstTeamPercentage());
        assertEquals(80, plus2AndHalf.getSecondTeamPercentage());

        PossibleBetContainer minus2AndHalf = block.findByType(MINUS_2_5);
        assertEquals(20, minus2AndHalf.getFirstTeamPercentage());
        assertEquals(60, minus2AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testMatchOpposingTeamMinorPenaltiesTimeHandicap() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(STATS).findByType(MATCH).findByType(OPPOSING_TEAM_MINOR_PENALTIES_TIME_HANDICAP);

        PossibleBetContainer plus4AndHalf = block.findByType(PLUS_4_5);
        assertEquals(80, plus4AndHalf.getFirstTeamPercentage());
        assertEquals(80, plus4AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus2AndHalf = block.findByType(PLUS_2_5);
        assertEquals(80, plus2AndHalf.getFirstTeamPercentage());
        assertEquals(40, plus2AndHalf.getSecondTeamPercentage());

        PossibleBetContainer minus2AndHalf = block.findByType(MINUS_2_5);
        assertEquals(0, minus2AndHalf.getFirstTeamPercentage());
        assertEquals(20, minus2AndHalf.getSecondTeamPercentage());
    }




    @Test
    public void testFirstPeriodMinorPenaltiesTimeTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(STATS).findByType(FIRST_PERIOD).findByType(MINOR_PENALTIES_TIME_OVER);

        PossibleBetContainer over2AndHalf = block.findByType(OVER_2_5);
        assertEquals(60, over2AndHalf.getFirstTeamPercentage());
        assertEquals(40, over2AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over4AndHalf = block.findByType(OVER_4_5);
        assertEquals(40, over4AndHalf.getFirstTeamPercentage());
        assertEquals(40, over4AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over6AndHalf = block.findByType(OVER_6_5);
        assertEquals(20, over6AndHalf.getFirstTeamPercentage());
        assertEquals(40, over6AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testFirstPeriodTeamMinorPenaltiesTimeTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(STATS).findByType(FIRST_PERIOD).findByType(TEAM_MINOR_PENALTIES_TIME_OVER);

        PossibleBetContainer over0AndHalf = block.findByType(OVER_0_5);
        assertEquals(80, over0AndHalf.getFirstTeamPercentage());
        assertEquals(80, over0AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over2AndHalf = block.findByType(OVER_2_5);
        assertEquals(40, over2AndHalf.getFirstTeamPercentage());
        assertEquals(40, over2AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testFirstPeriodOpposingTeamMinorPenaltiesTimeTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(STATS).findByType(FIRST_PERIOD).findByType(OPPOSING_TEAM_MINOR_PENALTIES_TIME_OVER);

        PossibleBetContainer over0AndHalf = block.findByType(OVER_0_5);
        assertEquals(60, over0AndHalf.getFirstTeamPercentage());
        assertEquals(60, over0AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over2AndHalf = block.findByType(OVER_2_5);
        assertEquals(40, over2AndHalf.getFirstTeamPercentage());
        assertEquals(20, over2AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testFirstPeriodTeamMinorPenaltiesTimeNotLoose() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(STATS).findByType(FIRST_PERIOD).findByType(TEAM_MINOR_PENALTIES_TIME_NOT_LOOSE);
        assertEquals(60, block.getFirstTeamPercentage());
        assertEquals(80, block.getSecondTeamPercentage());
    }

    @Test
    public void testFirstPeriodOpposingTeamMinorPenaltiesTimeNotLoose() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(STATS).findByType(FIRST_PERIOD).findByType(OPPOSING_TEAM_MINOR_PENALTIES_TIME_NOT_LOOSE);
        assertEquals(60, block.getFirstTeamPercentage());
        assertEquals(40, block.getSecondTeamPercentage());
    }

    @Test
    public void testFirstPeriodTeamMinorPenaltiesTimeHandicap() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(STATS).findByType(FIRST_PERIOD).findByType(TEAM_MINOR_PENALTIES_TIME_HANDICAP);

        PossibleBetContainer plus4AndHalf = block.findByType(PLUS_4_5);
        assertEquals(100, plus4AndHalf.getFirstTeamPercentage());
        assertEquals(100, plus4AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus2AndHalf = block.findByType(PLUS_2_5);
        assertEquals(100, plus2AndHalf.getFirstTeamPercentage());
        assertEquals(100, plus2AndHalf.getSecondTeamPercentage());

        PossibleBetContainer minus2AndHalf = block.findByType(MINUS_2_5);
        assertEquals(20, minus2AndHalf.getFirstTeamPercentage());
        assertEquals(20, minus2AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testFirstPeriodOpposingTeamMinorPenaltiesTimeHandicap() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(STATS).findByType(FIRST_PERIOD).findByType(OPPOSING_TEAM_MINOR_PENALTIES_TIME_HANDICAP);

        PossibleBetContainer plus4AndHalf = block.findByType(PLUS_4_5);
        assertEquals(100, plus4AndHalf.getFirstTeamPercentage());
        assertEquals(100, plus4AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus2AndHalf = block.findByType(PLUS_2_5);
        assertEquals(80, plus2AndHalf.getFirstTeamPercentage());
        assertEquals(80, plus2AndHalf.getSecondTeamPercentage());

        PossibleBetContainer minus2AndHalf = block.findByType(MINUS_2_5);
        assertEquals(0, minus2AndHalf.getFirstTeamPercentage());
        assertEquals(0, minus2AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testPowerplayGoalsOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(POWERPLAY_GOALS_OVER);

        PossibleBetContainer over1AndHalf = block.findByType(OVER_1_5);
        assertEquals(60, over1AndHalf.getFirstTeamPercentage());
        assertEquals(100, over1AndHalf.getSecondTeamPercentage());

    }

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

        HockeyPossibleBetsBlock hockeyPossibleBetsBlock = new HockeyPossibleBetsBlock(homeMatchData, guestMatchData);
        hockeyPossibleBetsBlock.check(homeTeamMatches, guestTeamMatches);


        return hockeyPossibleBetsBlock;
    }

}
