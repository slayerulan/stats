package com.savik.parser.hockey;

import com.savik.*;
import com.savik.football.model.*;
import com.savik.hockey.model.*;
import com.savik.hockey.repository.HockeyMatchRepository;
import com.savik.hockey.repository.HockeyTeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

import static com.savik.football.model.FootballCard.Type.RED;
import static com.savik.football.model.FootballCard.Type.YELLOW;
import static org.junit.Assert.*;

/**
 * @author Savushkin Yauheni
 * @since 05.05.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@ActiveProfiles("test")
public class HockeyMatchParserTest {

    @Autowired
    HockeySingleMatchParser matchParser;

    @Autowired
    HockeyTeamRepository hockeyTeamRepository;

    @Autowired
    HockeyMatchRepository hockeyMatchRepository;

    @Test
    public void testMatchWithOvertimeAndBulletsAndStats() {
        HockeyMatch match = matchParser.parse("KvlMqOL3", HockeyChampionship.NHL, Season.S2017);
        match = hockeyMatchRepository.save(match);

        HockeyTeam home = hockeyTeamRepository.findOneByNameAndChampionship("Рейнджерс", HockeyChampionship.NHL);
        HockeyTeam guest = hockeyTeamRepository.findOneByNameAndChampionship("Ванкувер", HockeyChampionship.NHL);

        assertEquals(match.getSeason(), Season.S2017);
        assertEquals(match.getMyscoreCode(), "KvlMqOL3");
        assertEquals(match.getChampionship(), HockeyChampionship.NHL);
        assertEquals(match.getHomeTeam(), home);
        assertEquals(match.getGuestTeam(), guest);
        assertEquals(match.getBookieStats().getHomeRate(), Double.valueOf(2.05));
        assertEquals(match.getBookieStats().getDrawRate(), Double.valueOf(4.00));
        assertEquals(match.getBookieStats().getGuestRate(), Double.valueOf(3.1));
        assertEquals(match.getDate(), LocalDateTime.of(2017, 11, 26, 22, 00));


        HockeyMatchInfo hockeyMatchInfo = match.getMatchInfo();

        /*
         1 период 0-1
        * */
        HockeyPeriod firstPeriod = hockeyMatchInfo.getFirstPeriod();
        assertEquals(firstPeriod.getHomeScore().intValue(), 0);
        assertEquals(firstPeriod.getGuestScore().intValue(), 1);
        assertEquals(firstPeriod.getTotalScore().intValue(), 1);
        assertEquals(firstPeriod.getWinner(), Winner.GUEST);
        assertEquals(firstPeriod.getPeriodStatus(), HockeyPeriod.PeriodStatus.FIRST);
        assertEquals(firstPeriod.getGoals().size(), 1);
        assertTrue(firstPeriod.getGoals().containsAll(new HashSet<>(Arrays.asList(
                HockeyGoal.builder().minute(7).whoScored(Who.GUEST).team(guest).build()
        ))));



        /*
         2 период 1-1
        * */
        HockeyPeriod secondPeriod = hockeyMatchInfo.getSecondPeriod();

        assertEquals(secondPeriod.getHomeScore().intValue(), 1);
        assertEquals(secondPeriod.getGuestScore().intValue(), 1);
        assertEquals(secondPeriod.getTotalScore().intValue(), 2);
        assertEquals(secondPeriod.getWinner(), Winner.DRAW);
        assertEquals(secondPeriod.getPeriodStatus(), HockeyPeriod.PeriodStatus.SECOND);
        assertEquals(secondPeriod.getGoals().size(), 2);
        assertTrue(secondPeriod.getGoals().containsAll(new HashSet<>(Arrays.asList(
                HockeyGoal.builder().minute(27).whoScored(Who.GUEST).team(guest).build(),
                HockeyGoal.builder().minute(37).whoScored(Who.HOME).team(home).build()
        ))));


        /*
         3 период 2-1
        * */
        HockeyPeriod thirdPeriod = hockeyMatchInfo.getThirdPeriod();

        assertEquals(thirdPeriod.getHomeScore().intValue(), 2);
        assertEquals(thirdPeriod.getGuestScore().intValue(), 1);
        assertEquals(thirdPeriod.getTotalScore().intValue(), 3);
        assertEquals(thirdPeriod.getWinner(), Winner.HOME);
        assertEquals(thirdPeriod.getPeriodStatus(), HockeyPeriod.PeriodStatus.THIRD);
        assertEquals(thirdPeriod.getGoals().size(), 3);
        assertTrue(thirdPeriod.getGoals().containsAll(new HashSet<>(Arrays.asList(
                HockeyGoal.builder().minute(40).whoScored(Who.HOME).team(home).build(),
                HockeyGoal.builder().minute(41).whoScored(Who.GUEST).team(guest).build(),
                HockeyGoal.builder().minute(45).whoScored(Who.HOME).team(home).build()
        ))));




         /*
          матч
        * */
        HockeyPeriod matchPeriod = hockeyMatchInfo.getMatch();

        assertEquals(matchPeriod.getHomeScore().intValue(), 3);
        assertEquals(matchPeriod.getGuestScore().intValue(), 3);
        assertEquals(matchPeriod.getTotalScore().intValue(), 6);
        assertEquals(matchPeriod.getWinner(), Winner.DRAW);
        assertEquals(matchPeriod.getPeriodStatus(), HockeyPeriod.PeriodStatus.MATCH);
        assertNull(matchPeriod.getGoals());
/*        assertNull(matchPeriod.getCards());
        assertEquals(matchPeriod.getHomeCorners().intValue(), 4);
        assertEquals(matchPeriod.getGuestCorners().intValue(), 4);
        assertEquals(matchPeriod.getHomeHits().intValue(), 8);
        assertEquals(matchPeriod.getGuestHits().intValue(), 10);
        assertEquals(secondPeriod.getHomeHitsOnTarget().intValue(), 5);
        assertEquals(secondPeriod.getGuestHitsOnTarget().intValue(), 3);
        assertEquals(matchPeriod.getHomePossession().intValue(), 49);
        assertEquals(matchPeriod.getGuestPossession().intValue(), 51);
        assertEquals(matchPeriod.getHomeOffsides().intValue(), 2);
        assertEquals(matchPeriod.getGuestOffsides().intValue(), 1);
        assertEquals(matchPeriod.getHomeFouls().intValue(), 16);
        assertEquals(matchPeriod.getGuestFouls().intValue(), 14);*/

    }


}
