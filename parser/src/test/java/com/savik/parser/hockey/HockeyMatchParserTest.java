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
                HockeyGoal.builder().minute(7).whoScored(Who.GUEST).seconds(54).team(guest).build()
        ))));
        assertEquals(firstPeriod.getHomeShotsOnTarget().intValue(), 4);
        assertEquals(firstPeriod.getGuestShotsOnTarget().intValue(), 11);
        assertEquals(firstPeriod.getHomePenaltiesTime().intValue(), 2);
        assertEquals(firstPeriod.getGuestPenaltiesTime().intValue(), 2);
        assertEquals(firstPeriod.getHomeShotHandedGoals().intValue(), 0);
        assertEquals(firstPeriod.getGuestShotHandedGoals().intValue(), 0);
        assertEquals(firstPeriod.getHomePowerplayGoals().intValue(), 0);
        assertEquals(firstPeriod.getGuestPowerplayGoals().intValue(), 0);



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
                HockeyGoal.builder().minute(27).whoScored(Who.GUEST).seconds(21).team(guest).build(),
                HockeyGoal.builder().minute(37).whoScored(Who.HOME).seconds(40).team(home).build()
        ))));
        assertEquals(secondPeriod.getHomeShotsOnTarget().intValue(), 7);
        assertEquals(secondPeriod.getGuestShotsOnTarget().intValue(), 7);
        assertEquals(secondPeriod.getHomePenaltiesTime().intValue(), 0);
        assertEquals(secondPeriod.getGuestPenaltiesTime().intValue(), 2);
        assertEquals(secondPeriod.getHomeShotHandedGoals().intValue(), 0);
        assertEquals(secondPeriod.getGuestShotHandedGoals().intValue(), 0);
        assertEquals(secondPeriod.getHomePowerplayGoals().intValue(), 0);
        assertEquals(secondPeriod.getGuestPowerplayGoals().intValue(), 0);


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
                HockeyGoal.builder().minute(40).whoScored(Who.HOME).seconds(19).team(home).build(),
                HockeyGoal.builder().minute(41).whoScored(Who.GUEST).seconds(0).team(guest).build(),
                HockeyGoal.builder().minute(45).whoScored(Who.HOME).seconds(5).team(home).build()
        ))));
        assertEquals(thirdPeriod.getHomeShotsOnTarget().intValue(), 9);
        assertEquals(thirdPeriod.getGuestShotsOnTarget().intValue(), 11);
        assertEquals(thirdPeriod.getHomePenaltiesTime().intValue(), 0);
        assertEquals(thirdPeriod.getGuestPenaltiesTime().intValue(), 0);
        assertEquals(thirdPeriod.getHomeShotHandedGoals().intValue(), 0);
        assertEquals(thirdPeriod.getGuestShotHandedGoals().intValue(), 0);
        assertEquals(thirdPeriod.getHomePowerplayGoals().intValue(), 0);
        assertEquals(thirdPeriod.getGuestPowerplayGoals().intValue(), 0);


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
        assertEquals(matchPeriod.getHomeShotsOnTarget().intValue(), 20);
        assertEquals(matchPeriod.getGuestShotsOnTarget().intValue(), 32);
        assertEquals(matchPeriod.getHomePenaltiesTime().intValue(), 2);
        assertEquals(matchPeriod.getGuestPenaltiesTime().intValue(), 4);
        assertEquals(matchPeriod.getHomeShotHandedGoals().intValue(), 0);
        assertEquals(matchPeriod.getGuestShotHandedGoals().intValue(), 0);
        assertEquals(matchPeriod.getHomePowerplayGoals().intValue(), 0);
        assertEquals(matchPeriod.getGuestPowerplayGoals().intValue(), 0);

    }


    @Test
    public void testMatchWithGoalsOnSameMinute() {
        HockeyMatch match = matchParser.parse("6gw94qut", HockeyChampionship.NHL, Season.S2017);
        match = hockeyMatchRepository.save(match);

        HockeyTeam home = hockeyTeamRepository.findOneByNameAndChampionship("Вегас", HockeyChampionship.NHL);
        HockeyTeam guest = hockeyTeamRepository.findOneByNameAndChampionship("Даллас", HockeyChampionship.NHL);

        assertEquals(match.getSeason(), Season.S2017);
        assertEquals(match.getMyscoreCode(), "6gw94qut");
        assertEquals(match.getChampionship(), HockeyChampionship.NHL);
        assertEquals(match.getHomeTeam(), home);
        assertEquals(match.getGuestTeam(), guest);
        assertEquals(match.getBookieStats().getHomeRate(), Double.valueOf(2.40));
        assertEquals(match.getBookieStats().getDrawRate(), Double.valueOf(4.00));
        assertEquals(match.getBookieStats().getGuestRate(), Double.valueOf(2.55));
        assertEquals(match.getDate(), LocalDateTime.of(2017, 11, 29, 06, 00));


        HockeyMatchInfo hockeyMatchInfo = match.getMatchInfo();

        /*
         1 период 0-1
        * */
        HockeyPeriod firstPeriod = hockeyMatchInfo.getFirstPeriod();
        assertEquals(firstPeriod.getHomeScore().intValue(), 0);
        assertEquals(firstPeriod.getGuestScore().intValue(), 0);
        assertEquals(firstPeriod.getTotalScore().intValue(), 0);
        assertEquals(firstPeriod.getWinner(), Winner.DRAW);
        assertEquals(firstPeriod.getPeriodStatus(), HockeyPeriod.PeriodStatus.FIRST);
        assertEquals(firstPeriod.getGoals().size(), 0);
        assertEquals(firstPeriod.getHomeShotsOnTarget().intValue(), 15);
        assertEquals(firstPeriod.getGuestShotsOnTarget().intValue(), 10);
        assertEquals(firstPeriod.getHomePenaltiesTime().intValue(), 2);
        assertEquals(firstPeriod.getGuestPenaltiesTime().intValue(), 2);
        assertEquals(firstPeriod.getHomeShotHandedGoals().intValue(), 0);
        assertEquals(firstPeriod.getGuestShotHandedGoals().intValue(), 0);
        assertEquals(firstPeriod.getHomePowerplayGoals().intValue(), 0);
        assertEquals(firstPeriod.getGuestPowerplayGoals().intValue(), 0);



        /*
         2 период 1-1
        * */
        HockeyPeriod secondPeriod = hockeyMatchInfo.getSecondPeriod();

        assertEquals(secondPeriod.getHomeScore().intValue(), 0);
        assertEquals(secondPeriod.getGuestScore().intValue(), 3);
        assertEquals(secondPeriod.getTotalScore().intValue(), 3);
        assertEquals(secondPeriod.getWinner(), Winner.GUEST);
        assertEquals(secondPeriod.getPeriodStatus(), HockeyPeriod.PeriodStatus.SECOND);
        assertEquals(secondPeriod.getGoals().size(), 3);
        assertTrue(secondPeriod.getGoals().containsAll(new HashSet<>(Arrays.asList(
                HockeyGoal.builder().minute(32).whoScored(Who.GUEST).seconds(55).team(guest).build(),
                HockeyGoal.builder().minute(39).whoScored(Who.GUEST).seconds(34).team(guest).build(),
                HockeyGoal.builder().minute(39).whoScored(Who.GUEST).seconds(41).team(guest).build()
        ))));
        assertEquals(secondPeriod.getHomeShotsOnTarget().intValue(), 8);
        assertEquals(secondPeriod.getGuestShotsOnTarget().intValue(), 11);
        assertEquals(secondPeriod.getHomePenaltiesTime().intValue(), 4);
        assertEquals(secondPeriod.getGuestPenaltiesTime().intValue(), 2);
        assertEquals(secondPeriod.getHomeShotHandedGoals().intValue(), 0);
        assertEquals(secondPeriod.getGuestShotHandedGoals().intValue(), 0);
        assertEquals(secondPeriod.getHomePowerplayGoals().intValue(), 0);
        assertEquals(secondPeriod.getGuestPowerplayGoals().intValue(), 0);


        /*
         3 период 0-0
        * */
        HockeyPeriod thirdPeriod = hockeyMatchInfo.getThirdPeriod();

        assertEquals(thirdPeriod.getHomeScore().intValue(), 0);
        assertEquals(thirdPeriod.getGuestScore().intValue(), 0);
        assertEquals(thirdPeriod.getTotalScore().intValue(), 0);
        assertEquals(thirdPeriod.getWinner(), Winner.DRAW);
        assertEquals(thirdPeriod.getPeriodStatus(), HockeyPeriod.PeriodStatus.THIRD);
        assertEquals(thirdPeriod.getGoals().size(), 0);
        assertEquals(thirdPeriod.getHomeShotsOnTarget().intValue(), 11);
        assertEquals(thirdPeriod.getGuestShotsOnTarget().intValue(), 9);
        assertEquals(thirdPeriod.getHomePenaltiesTime().intValue(), 2);
        assertEquals(thirdPeriod.getGuestPenaltiesTime().intValue(), 2);
        assertEquals(thirdPeriod.getHomeShotHandedGoals().intValue(), 0);
        assertEquals(thirdPeriod.getGuestShotHandedGoals().intValue(), 0);
        assertEquals(thirdPeriod.getHomePowerplayGoals().intValue(), 0);
        assertEquals(thirdPeriod.getGuestPowerplayGoals().intValue(), 0);


         /*
          матч
        * */
        HockeyPeriod matchPeriod = hockeyMatchInfo.getMatch();

        assertEquals(matchPeriod.getHomeScore().intValue(), 0);
        assertEquals(matchPeriod.getGuestScore().intValue(), 3);
        assertEquals(matchPeriod.getTotalScore().intValue(), 3);
        assertEquals(matchPeriod.getWinner(), Winner.GUEST);
        assertEquals(matchPeriod.getPeriodStatus(), HockeyPeriod.PeriodStatus.MATCH);
        assertNull(matchPeriod.getGoals());
        assertEquals(matchPeriod.getHomeShotsOnTarget().intValue(), 34);
        assertEquals(matchPeriod.getGuestShotsOnTarget().intValue(), 30);
        assertEquals(matchPeriod.getHomePenaltiesTime().intValue(), 8);
        assertEquals(matchPeriod.getGuestPenaltiesTime().intValue(), 6);
        assertEquals(matchPeriod.getHomeShotHandedGoals().intValue(), 0);
        assertEquals(matchPeriod.getGuestShotHandedGoals().intValue(), 0);
        assertEquals(matchPeriod.getHomePowerplayGoals().intValue(), 0);
        assertEquals(matchPeriod.getGuestPowerplayGoals().intValue(), 0);

    }


}
