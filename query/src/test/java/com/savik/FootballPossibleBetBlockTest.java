package com.savik;


import com.savik.blocks.football.match.FootballPossibleBetsBlock;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballTeam;
import com.savik.football.repository.FootballMatchRepository;
import com.savik.football.repository.FootballTeamRepository;
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
import static com.savik.football.specifications.FootballMatchSpec.hasTeam;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@ActiveProfiles("test")
@Transactional
@Rollback
@Sql(scripts = {
        "classpath:db/possible_bets/football/matches_lbS7cBXA.sql",
        "classpath:db/possible_bets/football/matches_AoGZZeIk.sql",
        "classpath:db/possible_bets/football/matches_fFudm6h6.sql",
        "classpath:db/possible_bets/football/matches_n94Z0PM5.sql",
        "classpath:db/possible_bets/football/matches_tU6FzT80.sql",

        // real matches but Barcelona replaced by Espanyol ( id = 20 )

        "classpath:db/possible_bets/football/matches_OEPaNIYq.sql",
        "classpath:db/possible_bets/football/matches_vT8fEudT.sql",
        "classpath:db/possible_bets/football/matches_0Io92rcH.sql",
        "classpath:db/possible_bets/football/matches_vVJX2ii0.sql",
        "classpath:db/possible_bets/football/matches_82s4vH8r.sql"

})
public class FootballPossibleBetBlockTest {

    public static final long BARCELONA_TEAM_ID = 8L;
    public static final long ESPANYOL_TEAM_ID = 20L;

    @Autowired
    FootballTeamRepository footballTeamRepository;

    @Autowired
    FootballMatchRepository footballMatchRepository;


    @Test
    public void testMatchCornersTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer totalOverBlock = possibleBetsBlock.findByType(CORNERS).findByType(MATCH).findByType(TOTAL_OVER);

        PossibleBetContainer over6AndHalf = totalOverBlock.findByType(OVER_6_5);
        assertEquals(60, over6AndHalf.getFirstTeamPercentage());
        assertEquals(60, over6AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over7AndHalf = totalOverBlock.findByType(OVER_7_5);
        assertEquals(60, over7AndHalf.getFirstTeamPercentage());
        assertEquals(60, over7AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over8AndHalf = totalOverBlock.findByType(OVER_8_5);
        assertEquals(60, over8AndHalf.getFirstTeamPercentage());
        assertEquals(60, over8AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over9AndHalf = totalOverBlock.findByType(OVER_9_5);
        assertEquals(20, over9AndHalf.getFirstTeamPercentage());
        assertEquals(40, over9AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over10AndHalf = totalOverBlock.findByType(OVER_10_5);
        assertEquals(20, over10AndHalf.getFirstTeamPercentage());
        assertEquals(20, over10AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over11AndHalf = totalOverBlock.findByType(OVER_11_5);
        assertEquals(20, over11AndHalf.getFirstTeamPercentage());
        assertEquals(20, over11AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over12AndHalf = totalOverBlock.findByType(OVER_12_5);
        assertEquals(20, over12AndHalf.getFirstTeamPercentage());
        assertEquals(0, over12AndHalf.getSecondTeamPercentage());

    }

    @Test
    public void testMatchCornersTotalUnder() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer totalOverBlock = possibleBetsBlock.findByType(CORNERS).findByType(MATCH).findByType(TOTAL_UNDER);

        PossibleBetContainer under6AndHalf = totalOverBlock.findByType(UNDER_6_5);
        assertEquals(40, under6AndHalf.getFirstTeamPercentage());
        assertEquals(40, under6AndHalf.getSecondTeamPercentage());

        PossibleBetContainer under7AndHalf = totalOverBlock.findByType(UNDER_7_5);
        assertEquals(40, under7AndHalf.getFirstTeamPercentage());
        assertEquals(40, under7AndHalf.getSecondTeamPercentage());

        PossibleBetContainer under8AndHalf = totalOverBlock.findByType(UNDER_8_5);
        assertEquals(40, under8AndHalf.getFirstTeamPercentage());
        assertEquals(40, under8AndHalf.getSecondTeamPercentage());

        PossibleBetContainer under9AndHalf = totalOverBlock.findByType(UNDER_9_5);
        assertEquals(80, under9AndHalf.getFirstTeamPercentage());
        assertEquals(60, under9AndHalf.getSecondTeamPercentage());

        PossibleBetContainer under10AndHalf = totalOverBlock.findByType(UNDER_10_5);
        assertEquals(80, under10AndHalf.getFirstTeamPercentage());
        assertEquals(80, under10AndHalf.getSecondTeamPercentage());

        PossibleBetContainer under11AndHalf = totalOverBlock.findByType(UNDER_11_5);
        assertEquals(80, under11AndHalf.getFirstTeamPercentage());
        assertEquals(80, under11AndHalf.getSecondTeamPercentage());

        PossibleBetContainer under12AndHalf = totalOverBlock.findByType(UNDER_12_5);
        assertEquals(80, under12AndHalf.getFirstTeamPercentage());
        assertEquals(100, under12AndHalf.getSecondTeamPercentage());

    }


    @Test
    public void testMatchTeamCornersTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer totalOverBlock = possibleBetsBlock.findByType(CORNERS).findByType(MATCH).findByType(TEAM_TOTAL_OVER);

        PossibleBetContainer over2AndHalf = totalOverBlock.findByType(OVER_2_5);
        assertEquals(100, over2AndHalf.getFirstTeamPercentage());
        assertEquals(80, over2AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over3AndHalf = totalOverBlock.findByType(OVER_3_5);
        assertEquals(80, over3AndHalf.getFirstTeamPercentage());
        assertEquals(40, over3AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over4AndHalf = totalOverBlock.findByType(OVER_4_5);
        assertEquals(40, over4AndHalf.getFirstTeamPercentage());
        assertEquals(40, over4AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over5AndHalf = totalOverBlock.findByType(OVER_5_5);
        assertEquals(40, over5AndHalf.getFirstTeamPercentage());
        assertEquals(40, over5AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over6AndHalf = totalOverBlock.findByType(OVER_6_5);
        assertEquals(20, over6AndHalf.getFirstTeamPercentage());
        assertEquals(0, over6AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over7AndHalf = totalOverBlock.findByType(OVER_7_5);
        assertEquals(0, over7AndHalf.getFirstTeamPercentage());
        assertEquals(0, over7AndHalf.getSecondTeamPercentage());


    }


    @Test
    public void testMatchOpposingTeamCornersTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer totalOverBlock = possibleBetsBlock.findByType(CORNERS).findByType(MATCH).findByType(OPPOSING_TEAM_TOTAL_OVER);

        PossibleBetContainer over2AndHalf = totalOverBlock.findByType(OVER_2_5);
        assertEquals(60, over2AndHalf.getFirstTeamPercentage());
        assertEquals(80, over2AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over3AndHalf = totalOverBlock.findByType(OVER_3_5);
        assertEquals(40, over3AndHalf.getFirstTeamPercentage());
        assertEquals(40, over3AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over4AndHalf = totalOverBlock.findByType(OVER_4_5);
        assertEquals(40, over4AndHalf.getFirstTeamPercentage());
        assertEquals(20, over4AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over5AndHalf = totalOverBlock.findByType(OVER_5_5);
        assertEquals(40, over5AndHalf.getFirstTeamPercentage());
        assertEquals(20, over5AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over6AndHalf = totalOverBlock.findByType(OVER_6_5);
        assertEquals(20, over6AndHalf.getFirstTeamPercentage());
        assertEquals(20, over6AndHalf.getSecondTeamPercentage());

        PossibleBetContainer over7AndHalf = totalOverBlock.findByType(OVER_7_5);
        assertEquals(0, over7AndHalf.getFirstTeamPercentage());
        assertEquals(20, over7AndHalf.getSecondTeamPercentage());


    }


    @Test
    public void testMatchTeamCornersNotLoose() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(CORNERS).findByType(MATCH).findByType(TEAM_NOT_LOOSE);
        assertEquals(80, block.getFirstTeamPercentage());
        assertEquals(80, block.getSecondTeamPercentage());

    }


    @Test
    public void testMatchOpposingTeamCornersNotLoose() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer block = possibleBetsBlock.findByType(CORNERS).findByType(MATCH).findByType(OPPOSING_TEAM_NOT_LOOSE);
        assertEquals(40, block.getFirstTeamPercentage());
        assertEquals(40, block.getSecondTeamPercentage());

    }


    @Test
    public void testMatchTeamCornersHandicap() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer totalOverBlock = possibleBetsBlock.findByType(CORNERS).findByType(MATCH).findByType(TEAM_HANDICAP);

        PossibleBetContainer minus4AndHalf = totalOverBlock.findByType(MINUS_4_5);
        assertEquals(0, minus4AndHalf.getFirstTeamPercentage());
        assertEquals(0, minus4AndHalf.getSecondTeamPercentage());

        PossibleBetContainer minus3AndHalf = totalOverBlock.findByType(MINUS_3_5);
        assertEquals(0, minus3AndHalf.getFirstTeamPercentage());
        assertEquals(0, minus3AndHalf.getSecondTeamPercentage());

        PossibleBetContainer minus2AndHalf = totalOverBlock.findByType(MINUS_2_5);
        assertEquals(40, minus2AndHalf.getFirstTeamPercentage());
        assertEquals(20, minus2AndHalf.getSecondTeamPercentage());

        PossibleBetContainer minus1AndHalf = totalOverBlock.findByType(MINUS_1_5);
        assertEquals(60, minus1AndHalf.getFirstTeamPercentage());
        assertEquals(40, minus1AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus1AndHalf = totalOverBlock.findByType(PLUS_1_5);
        assertEquals(80, plus1AndHalf.getFirstTeamPercentage());
        assertEquals(80, plus1AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus2AndHalf = totalOverBlock.findByType(PLUS_2_5);
        assertEquals(80, plus2AndHalf.getFirstTeamPercentage());
        assertEquals(80, plus2AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus3AndHalf = totalOverBlock.findByType(PLUS_3_5);
        assertEquals(100, plus3AndHalf.getFirstTeamPercentage());
        assertEquals(80, plus3AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus4AndHalf = totalOverBlock.findByType(PLUS_4_5);
        assertEquals(100, plus4AndHalf.getFirstTeamPercentage());
        assertEquals(80, plus4AndHalf.getSecondTeamPercentage());

    }


    @Test
    public void testMatchOpposingTeamCornersHandicap() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer totalOverBlock = possibleBetsBlock.findByType(CORNERS).findByType(MATCH).findByType(OPPOSING_TEAM_HANDICAP);

        PossibleBetContainer minus4AndHalf = totalOverBlock.findByType(MINUS_4_5);
        assertEquals(0, minus4AndHalf.getFirstTeamPercentage());
        assertEquals(20, minus4AndHalf.getSecondTeamPercentage());

        PossibleBetContainer minus3AndHalf = totalOverBlock.findByType(MINUS_3_5);
        assertEquals(0, minus3AndHalf.getFirstTeamPercentage());
        assertEquals(20, minus3AndHalf.getSecondTeamPercentage());

        PossibleBetContainer minus2AndHalf = totalOverBlock.findByType(MINUS_2_5);
        assertEquals(20, minus2AndHalf.getFirstTeamPercentage());
        assertEquals(20, minus2AndHalf.getSecondTeamPercentage());

        PossibleBetContainer minus1AndHalf = totalOverBlock.findByType(MINUS_1_5);
        assertEquals(20, minus1AndHalf.getFirstTeamPercentage());
        assertEquals(20, minus1AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus1AndHalf = totalOverBlock.findByType(PLUS_1_5);
        assertEquals(40, plus1AndHalf.getFirstTeamPercentage());
        assertEquals(60, plus1AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus2AndHalf = totalOverBlock.findByType(PLUS_2_5);
        assertEquals(60, plus2AndHalf.getFirstTeamPercentage());
        assertEquals(80, plus2AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus3AndHalf = totalOverBlock.findByType(PLUS_3_5);
        assertEquals(100, plus3AndHalf.getFirstTeamPercentage());
        assertEquals(100, plus3AndHalf.getSecondTeamPercentage());

        PossibleBetContainer plus4AndHalf = totalOverBlock.findByType(PLUS_4_5);
        assertEquals(100, plus4AndHalf.getFirstTeamPercentage());
        assertEquals(100, plus4AndHalf.getSecondTeamPercentage());



    }


    private PossibleBetContainer getPossibleBetsBlock() {
        FootballTeam homeTeam = footballTeamRepository.findOne(BARCELONA_TEAM_ID);
        MatchData homeMatchData = new MatchData(homeTeam);
        List<FootballMatch> homeTeamMatches = footballMatchRepository.findAll(
                hasTeam(BARCELONA_TEAM_ID)
        );

        FootballTeam guestTeam = footballTeamRepository.findOne(ESPANYOL_TEAM_ID);
        MatchData guestMatchData = new MatchData(guestTeam);
        List<FootballMatch> guestTeamMatches = footballMatchRepository.findAll(
                hasTeam(ESPANYOL_TEAM_ID)
        );

        FootballPossibleBetsBlock footballPossibleBetsBlock = new FootballPossibleBetsBlock(homeMatchData, guestMatchData);
        footballPossibleBetsBlock.check(homeTeamMatches, guestTeamMatches);
        return footballPossibleBetsBlock;
    }
}
