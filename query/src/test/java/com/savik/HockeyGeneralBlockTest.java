package com.savik;

import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyTeam;
import com.savik.hockey.repository.HockeyMatchRepository;
import com.savik.hockey.repository.HockeyTeamRepository;
import com.savik.result_block.hockey.match.general.GeneralBlock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

import static com.savik.hockey.specifications.HockeyMatchSpec.hasTeam;
import static org.junit.Assert.assertEquals;

/**
 * @author Savushkin Yauheni
 * @since 05.05.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@ActiveProfiles("test")
@Transactional
@Rollback
@Sql(scripts = {
        "classpath:db/matches_AqombNzc.sql", "classpath:db/matches_CIGVL5B6.sql",
        "classpath:db/matches_j5qIp46c.sql", "classpath:db/matches_rwPEPmCs.sql",
        "classpath:db/matches_Ai5wex7j.sql", "classpath:db/matches_QTEL7Fjd.sql",
        "classpath:db/matches_vJ50rp5f.sql", "classpath:db/matches_YVeCUxb9.sql",
        "classpath:db/matches_I39zqxpU.sql", "classpath:db/matches_lAtkXvoI.sql",
        "classpath:db/matches_xn1B4zMd.sql", "classpath:db/matches_YaFolFyG.sql",
        "classpath:db/matches_WAmcZ9Al.sql"
})
public class HockeyGeneralBlockTest {

    public static final long COLORADO_TEAM_ID = 1L;

    @Autowired
    HockeyTeamRepository hockeyTeamRepository;

    @Autowired
    HockeyMatchRepository hockeyMatchRepository;

    @Test
    public void testSize() {
        List<HockeyMatch> matches = hockeyMatchRepository.findAll();
        assertEquals(13, matches.size());
    }


    @Test
    public void testTotalOver() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer totalOverBlock = generalBlock.findByType(ContainerType.TOTAL_OVER);

        BetContainer over4AndHalf = totalOverBlock.findByType(ContainerType.OVER_4_5);
        assertEquals(12, over4AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(9, over4AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over4AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(75, over4AndHalf.getPercentage().intValue());

        BetContainer over5AndHalf = totalOverBlock.findByType(ContainerType.OVER_5_5);
        assertEquals(12, over5AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(8, over5AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over5AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(66, over5AndHalf.getPercentage().intValue());


        BetContainer over6AndHalf = totalOverBlock.findByType(ContainerType.OVER_6_5);
        assertEquals(12, over6AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, over6AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over6AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(58, over6AndHalf.getPercentage().intValue());

    }

    @Test
    public void testTotalUnder() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer totalUnderBlock = generalBlock.findByType(ContainerType.TOTAL_UNDER);

        BetContainer under4AndHalf = totalUnderBlock.findByType(ContainerType.UNDER_4_5);
        assertEquals(12, under4AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(3, under4AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under4AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(25, under4AndHalf.getPercentage().intValue());


        BetContainer under5AndHalf = totalUnderBlock.findByType(ContainerType.UNDER_5_5);
        assertEquals(12, under5AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(4, under5AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under5AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(33, under5AndHalf.getPercentage().intValue());


        BetContainer under6AndHalf = totalUnderBlock.findByType(ContainerType.UNDER_6_5);
        assertEquals(12, under6AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(5, under6AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under6AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(41, under6AndHalf.getPercentage().intValue());


        BetContainer under7AndHalf = totalUnderBlock.findByType(ContainerType.UNDER_7_5);
        assertEquals(12, under7AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, under7AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under7AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(58, under7AndHalf.getPercentage().intValue());

    }


    @Test
    public void testFirstPeriodTotalOver() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer firstPeriodTotalOver = generalBlock.findByType(ContainerType.FIRST_PERIOD_TOTAL_OVER);

        BetContainer over0AndHalf = firstPeriodTotalOver.findByType(ContainerType.OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(10, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(83, over0AndHalf.getPercentage().intValue());

        BetContainer over1AndHalf = firstPeriodTotalOver.findByType(ContainerType.OVER_1_5);
        assertEquals(12, over1AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, over1AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over1AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(58, over1AndHalf.getPercentage().intValue());

    }

    @Test
    public void testSecondPeriodTotalOver() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer secondPeriodTotalOver = generalBlock.findByType(ContainerType.SECOND_PERIOD_TOTAL_OVER);

        BetContainer over0AndHalf = secondPeriodTotalOver.findByType(ContainerType.OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(11, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(91, over0AndHalf.getPercentage().intValue());

        BetContainer over1AndHalf = secondPeriodTotalOver.findByType(ContainerType.OVER_1_5);
        assertEquals(12, over1AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(9, over1AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over1AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(75, over1AndHalf.getPercentage().intValue());

    }

    @Test
    public void testThirdPeriodTotalOver() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer thirdPeriodTotalOver = generalBlock.findByType(ContainerType.THIRD_PERIOD_TOTAL_OVER);

        BetContainer over0AndHalf = thirdPeriodTotalOver.findByType(ContainerType.OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(10, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(83, over0AndHalf.getPercentage().intValue());

        BetContainer over1AndHalf = thirdPeriodTotalOver.findByType(ContainerType.OVER_1_5);
        assertEquals(12, over1AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(8, over1AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over1AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(66, over1AndHalf.getPercentage().intValue());

    }

    @Test
    public void testBothTeamsFirstPeriodTotalOver() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer container = generalBlock.findByType(ContainerType.BOTH_TEAMS_TOTAL_OVER_FIRST_PERIOD);

        BetContainer over0AndHalf = container.findByType(ContainerType.OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(4, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(33, over0AndHalf.getPercentage().intValue());

    }

    @Test
    public void testBothTeamsSecondPeriodTotalOver() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer container = generalBlock.findByType(ContainerType.BOTH_TEAMS_TOTAL_OVER_SECOND_PERIOD);

        BetContainer over0AndHalf = container.findByType(ContainerType.OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(6, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(50, over0AndHalf.getPercentage().intValue());

    }

    @Test
    public void testBothTeamsThirdPeriodTotalOver() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer container = generalBlock.findByType(ContainerType.BOTH_TEAMS_TOTAL_OVER_THIRD_PERIOD);

        BetContainer over0AndHalf = container.findByType(ContainerType.OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(58, over0AndHalf.getPercentage().intValue());

    }


    @Test
    public void testTotalOverForColoradoTeam() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer totalOverBlock = generalBlock.findByType(ContainerType.TOTAL_OVER_FOR_TEAM);

        BetContainer over1AndHalf = totalOverBlock.findByType(ContainerType.OVER_1_5);
        assertEquals(12, over1AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(11, over1AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over1AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(91, over1AndHalf.getPercentage().intValue());

        BetContainer over2AndHalf = totalOverBlock.findByType(ContainerType.OVER_2_5);
        assertEquals(12, over2AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, over2AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over2AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(58, over2AndHalf.getPercentage().intValue());


        BetContainer over3AndHalf = totalOverBlock.findByType(ContainerType.OVER_3_5);
        assertEquals(12, over3AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(5, over3AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over3AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(41, over3AndHalf.getPercentage().intValue());

        BetContainer over4AndHalf = totalOverBlock.findByType(ContainerType.OVER_4_5);
        assertEquals(12, over4AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(3, over4AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over4AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(25, over4AndHalf.getPercentage().intValue());

    }

    @Test
    public void testTotalUnderForColoradoTeam() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer totalUnderBlock = generalBlock.findByType(ContainerType.TOTAL_UNDER_FOR_TEAM);

        BetContainer under2AndHalf = totalUnderBlock.findByType(ContainerType.UNDER_2_5);
        assertEquals(12, under2AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(5, under2AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under2AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(41, under2AndHalf.getPercentage().intValue());


        BetContainer under3AndHalf = totalUnderBlock.findByType(ContainerType.UNDER_3_5);
        assertEquals(12, under3AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, under3AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under3AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(58, under3AndHalf.getPercentage().intValue());


        BetContainer under4AndHalf = totalUnderBlock.findByType(ContainerType.UNDER_4_5);
        assertEquals(12, under4AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(9, under4AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under4AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(75, under4AndHalf.getPercentage().intValue());

    }

    @Test
    public void testTotalOverInAllPeriods() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer totalOverBlock = generalBlock.findByType(ContainerType.TOTAL_OVER_ALL_PERIODS);

        BetContainer over0AndHalf = totalOverBlock.findByType(ContainerType.OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(58, over0AndHalf.getPercentage().intValue());

    }

    @Test
    public void testTotalUnderInAllPeriods() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer totalUnderBlock = generalBlock.findByType(ContainerType.TOTAL_UNDER_ALL_PERIODS);

        BetContainer under2AndHalf = totalUnderBlock.findByType(ContainerType.UNDER_2_5);
        assertEquals(12, under2AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(2, under2AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under2AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(16, under2AndHalf.getPercentage().intValue());

        BetContainer under3AndHalf = totalUnderBlock.findByType(ContainerType.UNDER_3_5);
        assertEquals(12, under3AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(5, under3AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under3AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(41, under3AndHalf.getPercentage().intValue());

    }

    @Test
    public void testAnyWinAndTotalOver() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer block = generalBlock.findByType(ContainerType.ANY_WIN_AND_TOTAL_OVER);

        BetContainer over4AndHalf = block.findByType(ContainerType.OVER_4_5);
        assertEquals(12, over4AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, over4AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over4AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(58, over4AndHalf.getPercentage().intValue());

        BetContainer over5AndHalf = block.findByType(ContainerType.OVER_5_5);
        assertEquals(12, over5AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(6, over5AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over5AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(50, over5AndHalf.getPercentage().intValue());

    }

    @Test
    public void testAnyWinAndTotalUnder() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer block = generalBlock.findByType(ContainerType.ANY_WIN_AND_TOTAL_UNDER);

        BetContainer under4AndHalf = block.findByType(ContainerType.UNDER_4_5);
        assertEquals(12, under4AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(1, under4AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under4AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(8, under4AndHalf.getPercentage().intValue());

        BetContainer under5AndHalf = block.findByType(ContainerType.UNDER_5_5);
        assertEquals(12, under5AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(2, under5AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under5AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(16, under5AndHalf.getPercentage().intValue());

    }

    @Test
    public void testAnyWinAndDiff() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer block = generalBlock.findByType(ContainerType.ANY_WIN_AND_DIFFERENCE_EQUALS);

        BetContainer diff1 = block.findByType(ContainerType.DIFF_1);
        assertEquals(12, diff1.getAnalyzedMatchesAmount().intValue());
        assertEquals(1, diff1.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, diff1.getSkippedMatchesAmount().intValue());
        assertEquals(8, diff1.getPercentage().intValue());

        BetContainer diff2 = block.findByType(ContainerType.DIFF_2);
        assertEquals(12, diff2.getAnalyzedMatchesAmount().intValue());
        assertEquals(2, diff2.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, diff2.getSkippedMatchesAmount().intValue());
        assertEquals(16, diff2.getPercentage().intValue());

    }

    @Test
    public void testFirstGoalBefore() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer block = generalBlock.findByType(ContainerType.FIRST_GOAL_BEFORE);

        BetContainer under9 = block.findByType(ContainerType.UNDER_9);
        assertEquals(12, under9.getAnalyzedMatchesAmount().intValue());
        assertEquals(6, under9.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under9.getSkippedMatchesAmount().intValue());
        assertEquals(50, under9.getPercentage().intValue());

        BetContainer under10 = block.findByType(ContainerType.UNDER_10);
        assertEquals(12, under10.getAnalyzedMatchesAmount().intValue());
        assertEquals(6, under10.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, under10.getSkippedMatchesAmount().intValue());
        assertEquals(50, under10.getPercentage().intValue());

    }

    @Test
    public void testFirstPeriodAnyWinner() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer block = generalBlock.findByType(ContainerType.FIRST_PERIOD_ANY_WINNER);

        assertEquals(12, block.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, block.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, block.getSkippedMatchesAmount().intValue());
        assertEquals(58, block.getPercentage().intValue());

    }

    @Test
    public void testSecondPeriodAnyWinner() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer block = generalBlock.findByType(ContainerType.SECOND_PERIOD_ANY_WINNER);

        assertEquals(12, block.getAnalyzedMatchesAmount().intValue());
        assertEquals(8, block.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, block.getSkippedMatchesAmount().intValue());
        assertEquals(66, block.getPercentage().intValue());

    }

    @Test
    public void testThirdPeriodAnyWinner() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer block = generalBlock.findByType(ContainerType.THIRD_PERIOD_ANY_WINNER);

        assertEquals(12, block.getAnalyzedMatchesAmount().intValue());
        assertEquals(7, block.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, block.getSkippedMatchesAmount().intValue());
        assertEquals(58, block.getPercentage().intValue());

    }

    @Test
    public void testShotsOnTargetOver() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer block = generalBlock.findByType(ContainerType.SHOTS_ON_TARGET_OVER);

        BetContainer over60AndHalf = block.findByType(ContainerType.OVER_60_5);
        assertEquals(12, over60AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(5, over60AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over60AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(41, over60AndHalf.getPercentage().intValue());

        BetContainer over61AndHalf = block.findByType(ContainerType.OVER_61_5);
        assertEquals(12, over61AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(4, over61AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over61AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(33, over61AndHalf.getPercentage().intValue());

        BetContainer over62AndHalf = block.findByType(ContainerType.OVER_62_5);
        assertEquals(12, over62AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(4, over62AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over62AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(33, over62AndHalf.getPercentage().intValue());

        BetContainer over63AndHalf = block.findByType(ContainerType.OVER_63_5);
        assertEquals(12, over63AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(3, over63AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over63AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(25, over63AndHalf.getPercentage().intValue());

    }

    @Test
    public void testPenalTimeOver() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer block = generalBlock.findByType(ContainerType.PENALTIES_TIME_OVER);

        BetContainer over14AndHalf = block.findByType(ContainerType.OVER_14_5);
        assertEquals(12, over14AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(8, over14AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over14AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(66, over14AndHalf.getPercentage().intValue());

        BetContainer over16AndHalf = block.findByType(ContainerType.OVER_16_5);
        assertEquals(12, over16AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(8, over16AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over16AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(66, over16AndHalf.getPercentage().intValue());

        BetContainer over18AndHalf = block.findByType(ContainerType.OVER_18_5);
        assertEquals(12, over18AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(6, over18AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over18AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(50, over18AndHalf.getPercentage().intValue());

    }

    @Test
    public void testPowerplayGoalsOver() {
        GeneralBlock generalBlock = getGeneralBlock();

        BetContainer block = generalBlock.findByType(ContainerType.POWERPLAY_GOALS_OVER);

        BetContainer over0AndHalf = block.findByType(ContainerType.OVER_0_5);
        assertEquals(12, over0AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(11, over0AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over0AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(91, over0AndHalf.getPercentage().intValue());

        BetContainer over1AndHalf = block.findByType(ContainerType.OVER_1_5);
        assertEquals(12, over1AndHalf.getAnalyzedMatchesAmount().intValue());
        assertEquals(8, over1AndHalf.getSuccessfullyMatchesAmount().intValue());
        assertEquals(0, over1AndHalf.getSkippedMatchesAmount().intValue());
        assertEquals(66, over1AndHalf.getPercentage().intValue());

    }


    private GeneralBlock getGeneralBlock() {
        List<HockeyMatch> matches = hockeyMatchRepository.findAll(
                hasTeam(COLORADO_TEAM_ID)
        );
        matches.sort(Comparator.comparing(HockeyMatch::getDate));
        assertEquals(12, matches.size());


        HockeyTeam team = hockeyTeamRepository.findOne(COLORADO_TEAM_ID);
        MatchData matchData = new MatchData(team);

        GeneralBlock generalBlock = new GeneralBlock(ContainerType.GENERAL, matchData);
        matches.forEach(generalBlock::check);
        return generalBlock;
    }

}
