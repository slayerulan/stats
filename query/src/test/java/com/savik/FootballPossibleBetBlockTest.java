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

import static com.savik.ContainerType.CORNERS;
import static com.savik.ContainerType.TOTAL_OVER;
import static com.savik.football.specifications.FootballMatchSpec.hasTeam;

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

})
public class FootballPossibleBetBlockTest {

    public static final long BARCELONA_TEAM_ID = 8L;
    public static final long ESPANYOL_TEAM_ID = 20L;

    @Autowired
    FootballTeamRepository footballTeamRepository;

    @Autowired
    FootballMatchRepository footballMatchRepository;


    @Test
    public void testTotalOver() {
        PossibleBetContainer possibleBetsBlock = getPossibleBetsBlock();

        PossibleBetContainer totalOverBlock = possibleBetsBlock.findByType(CORNERS).findByType(TOTAL_OVER);

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
