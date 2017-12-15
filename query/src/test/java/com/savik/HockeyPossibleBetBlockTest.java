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
    public void testAnyComebackMatchPossible() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(ANY_COMEBACK);
        assertEquals(0, block.getFirstTeamPercentage());
        assertEquals(0, block.getSecondTeamPercentage());
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
    public void testPenaltiesTimeTotalOverTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(PENALTIES_TIME_OVER);

        PossibleBetContainer over13AndHalf = block.findByType(OVER_13_5);
        assertEquals(60, over13AndHalf.getFirstTeamPercentage());
        assertEquals(100, over13AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over14AndHalf = block.findByType(OVER_14_5);
        assertEquals(40, over14AndHalf.getFirstTeamPercentage());
        assertEquals(100, over14AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over15AndHalf = block.findByType(OVER_15_5);
        assertEquals(40, over15AndHalf.getFirstTeamPercentage());
        assertEquals(100, over15AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testTeamPenaltiesTimeTotalOverTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(TEAM_PENALTIES_TIME_OVER);

        PossibleBetContainer over6AndHalf = block.findByType(OVER_6_5);
        assertEquals(60, over6AndHalf.getFirstTeamPercentage());
        assertEquals(100, over6AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over7AndHalf = block.findByType(OVER_7_5);
        assertEquals(60, over7AndHalf.getFirstTeamPercentage());
        assertEquals(100, over7AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over8AndHalf = block.findByType(OVER_8_5);
        assertEquals(40, over8AndHalf.getFirstTeamPercentage());
        assertEquals(100, over8AndHalf.getSecondTeamPercentage());
    }

    @Test
    public void testOpposingTeamPenaltiesTimeTotalOverTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(OPPOSING_TEAM_PENALTIES_TIME_OVER);

        PossibleBetContainer over6AndHalf = block.findByType(OVER_6_5);
        assertEquals(20, over6AndHalf.getFirstTeamPercentage());
        assertEquals(80, over6AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over7AndHalf = block.findByType(OVER_7_5);
        assertEquals(20, over7AndHalf.getFirstTeamPercentage());
        assertEquals(80, over7AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over8AndHalf = block.findByType(OVER_8_5);
        assertEquals(20, over8AndHalf.getFirstTeamPercentage());
        assertEquals(60, over8AndHalf.getSecondTeamPercentage());
    }


    @Test
    public void testTeamPenaltiesTimeWin() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(TEAM_PENALTIES_TIME_WIN);
        assertEquals(40, block.getFirstTeamPercentage());
        assertEquals(80, block.getSecondTeamPercentage());
    }

    @Test
    public void testOpposingTeamPenaltiesTimeWin() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(OPPOSING_TEAM_PENALTIES_TIME_WIN);
        assertEquals(60, block.getFirstTeamPercentage());
        assertEquals(0, block.getSecondTeamPercentage());
    }

    @Test
    public void testPowerplayGoalsOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(POWERPLAY_GOALS_OVER);

        PossibleBetContainer over1AndHalf = block.findByType(OVER_1_5);
        assertEquals(60, over1AndHalf.getFirstTeamPercentage());
        assertEquals(100, over1AndHalf.getSecondTeamPercentage());

    }
/*  










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
